/**
 * Created by Fantasy on 2017/6/6.
 *
 */
var CustomConfig = function (vo) {
    this.vo = vo;
    this.init(vo);

};
CustomConfig.prototype = {
    init: function (vo) {
        var _this = this;
        vo.configList = ko.observableArray([]);
        vo.id = ko.observable();
        vo.configKey = ko.observable();
        vo.configValue = ko.observable();
        vo.configDesc = ko.observable();
        vo.readyConfigKey = ko.observable();
        vo.readyId = ko.observable();
        vo.updateStatus = ko.observable();
        this.modalFunc();
        this.listConfigDfd().done(function (resp) {
            var listConfig = resp && resp.result;

            _.each(listConfig, function (item) {
                item.gmtCreate = moment(+item.gmtCreate).format('YYYY/MM/DD,HH:mm:ss');
                item.gmtModified = moment(+item.gmtModified).format('YYYY/MM/DD,HH:mm:ss');
            });
            vo.configList(listConfig);
        });
        vo.editConfig = function (configKo) {
            _this.openMenuModal($('#menu-prompt'));
            vo.configKey(configKo.configKey);
            vo.configValue(configKo.configValue);
            vo.configDesc(configKo.configDesc);
            vo.id(configKo.id);
        };
        vo.removeConfig = function (configKo) {
            _this.vo.readyConfigKey(configKo.configKey);
            _this.vo.readyId(configKo.id);
            _this.openMenuModal($('#menu-delete'));
        };
        vo.addConfig = function () {
            vo.configKey();
            vo.configValue();
            vo.configDesc();
            vo.id();
            _this.openMenuModal($('#menu-prompt'));
        }
    },
    listConfigDfd: function () {
        return $.ajax({
            headers: {
                'access-token': sessionStorage.getItem('accessToken') || ''
            },
            url: '/configs/listConfig',
            type: 'GET',
            dataType: 'json'
        });
    },
    updateConfigDfd: function () {
        var vo = this.vo;
        var configOptions = {
            id: vo.id(),
            configKey: vo.configKey(),
            configValue: vo.configValue(),
            configDesc: vo.configDesc()
        };
        return $.ajax({
            headers: {
                'access-token': sessionStorage.getItem('accessToken') || ''
            },
            url: '/configs/detail',
            type: 'PUT',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(configOptions)
        });
    },
    addConfigDfd: function (ConfigOptions) {
        return $.ajax({
            headers: {
                'access-token': sessionStorage.getItem('accessToken') || ''
            },
            url: '/configs/detail',
            type: 'POST',
            dataType: 'json',
            data: ConfigOptions
        });
    },
    deleteConfigDfd: function (configId) {
        return $.ajax({
            headers: {
                'access-token': sessionStorage.getItem('accessToken') || ''
            },
            url: '/configs/detail/' + configId,
            type: 'DELETE',
            dataType: 'json'
        });
    },
    modalFunc: function () {
        var _this = this;
        this.modalFuncProcess($('#menu-prompt'), function () {
            if (_this.vo.id()) {
                _this.updateConfigDfd().done(function (resp) {
                    _this.vo.updateStatus(resp && resp.messages);
                    _this.openMenuModal($('#menu-alert'));
                });
            } else {
                _this.addConfigDfd({
                    configKey: _this.vo.configKey(),
                    configValue: _this.vo.configValue(),
                    configDesc: _this.vo.configDesc()
                }).done(function (resp) {
                    _this.vo.updateStatus(resp && resp.messages);
                    _this.openMenuModal($('#menu-alert'));
                });
            }

        });
        this.modalFuncProcess($('#menu-delete'), function () {
            _this.deleteConfigDfd(_this.vo.readyId()).done(function (resp) {
                _this.vo.updateStatus(resp && resp.messages);
                _this.openMenuModal($('#menu-alert'));
            });
        });
    },
    openMenuModal: function ($ele) {
        $ele.modal({
            relatedTarget: this
        });
    },
    modalFuncProcess: function ($ele, conFirmFunc, cancelFunc) {
        var $confirmBtn = $ele.find('[data-am-modal-confirm]');
        var $cancelBtn = $ele.find('[data-am-modal-cancel]');
        $confirmBtn.off('click.confirm.modal.amui').on('click', conFirmFunc || $.noop);
        $cancelBtn.off('click.cancel.modal.amui').on('click', cancelFunc || $.noop);
    }


};