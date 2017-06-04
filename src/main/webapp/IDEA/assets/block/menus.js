/**
 * Created by Fantasy on 2017/6/4.
 */
var MenuService = function (vo) {
    this.vo = vo;
    this.menuInit(vo);
};
MenuService.prototype = {
    menuInit: function (vo) {
        var _this = this;
        vo.menuList = ko.observableArray([]);
        vo.menuTitle = ko.observable();
        vo.menuUrl = ko.observable();
        vo.menuTarget = ko.observable();
        vo.menuSubId = ko.observable();
        vo.menuVisible = ko.observable();
        vo.menuId = ko.observable();
        vo.updateStatus = ko.observable();
        vo.readyMenuTitle = ko.observable();
        vo.readyMenuId = ko.observable();
        vo.selectOptions = ko.observable();
        vo.menuMainList = ko.observableArray([]);
        vo.editMenu = function (menuKo) {
            _this.openMenuModal($('#menu-prompt'));
            vo.menuTitle(menuKo.menuTitle);
            vo.menuUrl(menuKo.menuUrl);
            vo.menuTarget(menuKo.menuTarget);
            vo.menuSubId(menuKo.menuSubId);
            vo.menuVisible(menuKo.menuVisible);
            vo.menuId(menuKo.id);
        };
        vo.removeMenu = function (menuKo) {
            _this.vo.readyMenuTitle(menuKo.menuTitle);
            _this.vo.readyMenuId(menuKo.id);
            _this.openMenuModal($('#menu-delete'));
        };
        vo.addMenu = function () {
            vo.menuTitle();
            vo.menuUrl();
            vo.menuTarget();
            vo.menuSubId();
            vo.menuVisible();
            vo.menuId();
            _this.openMenuModal($('#menu-prompt'));
        };
        _.delay(function () {
            $('#menu-subId').children().css('background', '#282d2f');
        }, 500);
        this.modalFunc();
        this.menuListKo();
    },
    openMenuModal: function ($ele) {
        $ele.modal({
            relatedTarget: this
        });
    },
    ListMenuDfd: function () {
        return $.get('/menus/listMeta');
    },
    menuListKo: function () {
        var vo = this.vo;
        this.ListMenuDfd().done(function (resp) {
            var listMenu = resp && resp.result;
            _.each(listMenu, function (item) {
                item.gmtCreate = moment(+item.gmtCreate).format('YYYY/MM/DD,HH:mm:ss');
                item.gmtModified = moment(+item.gmtModified).format('YYYY/MM/DD,HH:mm:ss');
            });
            vo.menuList(listMenu);
            var menuMainList = _.filter(vo.menuList(), function (resp) {
                return resp.menuSubId === 0;
            });
            vo.menuMainList(menuMainList);
            $('#example-r').DataTable();
        });
    },
    updateMenuDfd: function () {
        var vo = this.vo;
        vo.selectOptions();
        var menuOptions = {
            id: vo.menuId(),
            menuTitle: vo.menuTitle(),
            menuUrl: vo.menuUrl(),
            menuTarget: vo.menuTarget(),
            menuSubId: vo.menuSubId(),
            menuVisible: vo.menuVisible()
        };
        console.log(menuOptions);
        return $.ajax({
            url: '/menus/detail',
            type: 'PUT',
            'contentType': 'application/json',
            dataType: 'json',
            data: JSON.stringify(menuOptions)
        });
    },
    deleteMenuDfd: function (menuId) {
        return $.ajax({
            url: '/menus/detail/' + menuId,
            type: 'DELETE',
            dataType: 'json'
        });
    },
    addMenuDfd: function (addMenu) {
        return $.ajax({
            url: '/menus/detail/',
            type: 'POST',
            dataType: 'json',
            data: addMenu
        });
    },
    modalFunc: function () {
        var _this = this;
        this.modalFuncProcess($('#menu-prompt'), function () {
            if (_this.vo.menuId()) {
                _this.updateMenuDfd().done(function (resp) {
                    _this.vo.updateStatus(resp && resp.messages);
                    _this.openMenuModal($('#menu-alert'));
                });
            } else {
                _this.addMenuDfd({
                    menuTitle: _this.vo.menuTitle(),
                    menuUrl: _this.vo.menuUrl(),
                    menuTarget: _this.vo.menuTarget(),
                    menuSubId: _this.vo.menuSubId(),
                    menuVisible: _this.vo.menuVisible()
                }).done(function (resp) {
                    _this.vo.updateStatus(resp && resp.messages);
                    _this.openMenuModal($('#menu-alert'));
                });
            }

        });
        this.modalFuncProcess($('#menu-delete'), function () {
            _this.deleteMenuDfd(_this.vo.readyMenuId()).done(function (resp) {
                _this.vo.updateStatus(resp && resp.messages);
                _this.openMenuModal($('#menu-alert'));
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