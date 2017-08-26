var MenusList = function (vo) {
    this.vo = vo;
    vo.menusList = ko.observableArray([]);
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
    this.init(vo);
};
MenusList.prototype = {
    init: function (vo) {
        var self = this;
        var dataTableTemp;
        this.ListMenuDfd().done(function (menus) {
            var menusList = menus && menus.result;
            _.each(menusList, function (item) {
                item.gmtCreate = moment(+item.gmtCreate).format('YYYY/MM/DD,HH:mm:ss');
                item.gmtModified = moment(+item.gmtModified).format('YYYY/MM/DD,HH:mm:ss');
            });
            vo.menusList(menusList);
            var menuMainList = _.filter(vo.menusList(), function (resp) {
                return resp.menuSubId === 0;
            });
            vo.menuMainList(menuMainList);
            dataTableTemp = $('#example-r').DataTable({
                responsive: true
            });
        });
        vo.reFreshTable = function () {
            dataTableTemp.ajax.reload();
        };
        vo.addMenus = function () {
            vo.menuTitle('');
            vo.menuUrl('');
            vo.menuTarget('');
            vo.menuSubId('');
            vo.menuVisible(false);
            vo.menuId('');
            self.openMenuModal($('#menu-prompt'));
        };
        vo.editMenu = function (menuKo) {
            self.openMenuModal($('#menu-prompt'));
            vo.menuTitle(menuKo.menuTitle);
            vo.menuUrl(menuKo.menuUrl);
            vo.menuTarget(menuKo.menuTarget);
            vo.menuSubId(menuKo.menuSubId);
            vo.menuVisible(menuKo.menuVisible);
            vo.menuId(menuKo.id);
        };
        vo.removeMenu = function (menuKo) {
            self.vo.readyMenuTitle(menuKo.menuTitle);
            self.vo.readyMenuId(menuKo.id);
            self.openMenuModal($('#menu-delete'));
        };
        this.modalFunc();
    },
    ListMenuDfd: function () {
        return $.ajax({
            url: BathPath() + '/Menus/listMeta',
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
            id: vo.menuId(),
            menuTitle: vo.menuTitle(),
            menuUrl: vo.menuUrl(),
            menuTarget: vo.menuTarget(),
            menuSubId: vo.menuSubId(),
            menuVisible: vo.menuVisible()
        };
        console.log(menuOptions);
        return $.ajax({
            url: BathPath() + '/Menus/detail',
            type: 'PUT',
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(menuOptions)
        });
    },
    deleteMenuDfd: function (menuId) {
        return $.ajax({
            url: BathPath() + '/Menus/detail/' + menuId,
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
        if (addMenu.menuTitle === '' || addMenu.menuTarget === '' || addMenu.menuUrl === '') {
            addDfd.reject();
            alert('三者属性不能缺失一项');
            return addDfd;
        }
        $.ajax({
            url: BathPath() + '/Menus/detail/',
            type: 'POST',
            dataType: 'json',
            data: addMenu
        }).done(addDfd.resolve);
        return addDfd;
    },
    modalFunc: function () {
        var _this = this;
        this.modalFuncProcess($('#menu-prompt'), function () {
            if (_this.vo.menuId()) {
                _this.updateMenuDfd().done(function (resp) {
                    _this.vo.updateStatus(resp && resp.messages);
                    _this.openMenuModal($('#menu-alert'));
                    location.href = BathPath() + "/app/menus/Menus.jsp"
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
                    location.href = BathPath() + "/app/menus/Menus.jsp"
                });
            }

        });
        this.modalFuncProcess($('#menu-delete'), function () {
            _this.deleteMenuDfd(_this.vo.readyMenuId()).done(function (resp) {
                _this.vo.updateStatus(resp && resp.messages);
                _this.openMenuModal($('#menu-alert'));
                location.href = BathPath() + "/app/menus/Menus.jsp"
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
