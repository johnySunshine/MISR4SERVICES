/**
 * Created by Fantasy on 2017/8/27.
 */
var Config = function (vo) {
    this.vo = vo;
    vo.id = ko.observable();
    vo.configList = ko.observableArray([]);
    vo.configKey = ko.observable();
    vo.configValue = ko.observable();
    vo.configDesc = ko.observable();
    vo.updateStatus = ko.observable();
    vo.readyMenuTitle = ko.observable();
    vo.readyMenuId = ko.observable();
    vo.selectOptions = ko.observable();
    vo.menuMainList = ko.observableArray([]);
    this.init(vo);
    this.modalFunc();
};
Config.prototype = {
    init: function (vo) {
        var self = this;
        var dataTableTemp = null;
        this.listConfig().done(function (resp) {
            var configList = resp && resp.result;
            _.each(configList, function (item) {
                item.gmtCreate = moment(+item.gmtCreate).format('YYYY/MM/DD,HH:mm:ss');
                item.gmtModified = moment(+item.gmtModified).format('YYYY/MM/DD,HH:mm:ss');
            });
            vo.configList(configList);
            dataTableTemp = $('#example-r').DataTable({
                responsive: true
            });
        });
        vo.addConfig = function () {
            vo.configKey('');
            vo.configValue('');
            vo.configDesc('');
            self.openMenuModal($('#menu-prompt'));
        };
        vo.editConfig = function (config) {
            self.openMenuModal($('#menu-prompt'));
            vo.configKey(config.configKey);
            vo.configValue(config.configValue);
            vo.configDesc(config.configDesc);
            vo.id(config.id);
        };
        vo.removeConfig = function (menuKo) {
            self.vo.readyMenuTitle(menuKo.menuTitle);
            self.vo.readyMenuId(menuKo.id);
            self.openMenuModal($('#menu-delete'));
        };
        vo.reFreshTable = function () {
            dataTableTemp.ajax.reload();
        };
    },
    listConfig: function () {
        return $.ajax({
            url: BathPath() + '/CustomConfig/configList',
            type: 'GET',
            dataType: 'json'
        });
    },
    openMenuModal: function ($ele) {
        $ele.modal({
            relatedTarget: this
        });
    },
    updateMenuDfd: function () {
        var vo = this.vo;
        vo.selectOptions();
        var menuOptions = {
            id: vo.id(),
            configKey: vo.configKey(),
            configValue: vo.configValue(),
            configDesc: vo.configDesc()
        };
        console.log(menuOptions);
        return $.ajax({
            url: BathPath() + '/CustomConfig/detail',
            type: 'PUT',
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(menuOptions)
        });
    },
    deleteMenuDfd: function (id) {
        return $.ajax({
            url: BathPath() + '/CustomConfig/detail/' + id,
            type: 'DELETE',
            dataType: 'json'
        });
    },
    addMenuDfd: function (addMenu) {
        var addDfd = new $.Deferred();
        if (!addMenu) {
            addDfd.reject();
            return addDfd;
        }
        if (addMenu.configKey === '' || addMenu.configValue === '' || addMenu.configDesc === '') {
            addDfd.reject();
            alert('三者属性不能缺失一项');
            return addDfd;
        }
        $.ajax({
            url: BathPath() + '/CustomConfig/detail/',
            type: 'POST',
            dataType: 'json',
            data: addMenu
        }).done(addDfd.resolve);
        return addDfd;
    },
    modalFunc: function () {
        var _this = this;
        this.modalFuncProcess($('#menu-prompt'), function () {
            if (_this.vo.id()) {
                _this.updateMenuDfd().done(function (resp) {
                    _this.vo.updateStatus(resp && resp.messages);
                    _this.openMenuModal($('#menu-alert'));
                    location.reload();
                });
            } else {
                _this.addMenuDfd({
                    configKey: _this.vo.configKey(),
                    configValue: _this.vo.configValue(),
                    configDesc: _this.vo.configDesc(),
                }).done(function (resp) {
                    _this.vo.updateStatus(resp && resp.messages);
                    _this.openMenuModal($('#menu-alert'));
                    location.reload();
                });
            }

        });
        this.modalFuncProcess($('#menu-delete'), function () {
            _this.deleteMenuDfd(_this.vo.readyMenuId()).done(function (resp) {
                _this.vo.updateStatus(resp && resp.messages);
                _this.openMenuModal($('#menu-alert'));
                location.reload();
            });
        });
    },

    modalFuncProcess: function ($ele, conFirmFunc, cancelFunc) {
        var $confirmBtn = $ele.find('[data-am-modal-confirm]');
        var $cancelBtn = $ele.find('[data-am-modal-cancel]');
        $confirmBtn.off('click.confirm.modal.amui').on('click', conFirmFunc || $.noop);
        $cancelBtn.off('click.cancel.modal.amui').on('click', cancelFunc || $.noop);
    }
};
