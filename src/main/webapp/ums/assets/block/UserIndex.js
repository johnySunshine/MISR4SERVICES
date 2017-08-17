/**
 * Created by Fantasy on 2017/8/15.
 */
var UserIndex = function (vo) {
    this.vo = vo;
    this.init(vo);
};
UserIndex.prototype = {
    init: function (vo) {
        var _this = this;
        vo.userList = ko.observableArray([]);
        vo.readyUserTitle = ko.observable();
        vo.updateStatus = ko.observable();
        vo.userLoginName = ko.observable();
        vo.userName = ko.observable();
        vo.userPassword = ko.observable();
        vo.userType = ko.observable();
        vo.permissions = ko.observable();
        vo.userRoles = ko.observable();
        vo.userId = ko.observable();
        vo.readyUserId = ko.observable();
        vo.addUser = function () {
            vo.userLoginName();
            vo.userName();
            vo.userPassword();
            vo.userType();
            vo.permissions();
            vo.userRoles();
            _this.openMenuModal($('#menu-prompt'));
        };
        vo.removeUser = function (user) {
            vo.readyUserTitle(user.userName);
            vo.readyUserId(user.id);
            _this.openMenuModal($('#menu-delete'));
        };
        this.initUserList();
        this.modalFunc();
    },
    userListDfd: function () {
        return $.ajax({
            url: basePath + 'Users/listUser',
            type: 'GET',
            'contentType': 'application/json',
            dataType: 'json'
        });
    },
    saveUserDfd: function (addUser) {
        return $.ajax({
            url: basePath + 'Users/saveUser',
            type: 'POST',
            dataType: 'json',
            data: addUser
        });
    },
    initUserList: function () {
        var _this = this;
        this.userListDfd().done(function (resp) {
            var userList = resp.result;
            _.each(userList, function (item) {
                item.gmtCreate = moment(+item.gmtCreate).format('YYYY/MM/DD,HH:mm:ss');
                item.gmtModified = moment(+item.gmtModified).format('YYYY/MM/DD,HH:mm:ss');
            });
            _this.vo.userList(userList);
        });
    },
    modalFuncProcess: function ($ele, conFirmFunc, cancelFunc) {
        var $confirmBtn = $ele.find('[data-am-modal-confirm]');
        var $cancelBtn = $ele.find('[data-am-modal-cancel]');
        $confirmBtn.off('click.confirm.modal.amui').on('click', conFirmFunc || $.noop);
        $cancelBtn.off('click.cancel.modal.amui').on('click', cancelFunc || $.noop);
    },
    openMenuModal: function ($ele) {
        $ele.modal({
            relatedTarget: this
        });
    },
    deleteUserDfd: function (userId) {
        return $.ajax({
            url: basePath + 'Users/delUser?userId=' + userId,
            type: 'GET',
            dataType: 'json'
        });
    },
    modalFunc: function () {
        var _this = this;
        this.modalFuncProcess($('#menu-prompt'), function () {
            if (_this.vo.userId()) {
                _this.updateMenuDfd().done(function (resp) {
                    _this.vo.updateStatus(resp && resp.messages);
                    _this.openMenuModal($('#menu-alert'));
                });
            } else {
                _this.saveUserDfd({
                    'userLoginName': _this.vo.userLoginName(),
                    'userName': _this.vo.userName(),
                    'userPassword': _this.vo.userPassword(),
                    'userType': _this.vo.userType(),
                    'permissions': _this.vo.permissions(),
                    'userRoles': _this.vo.userRoles()
                }).done(function (resp) {
                    _this.vo.updateStatus(resp && resp.messages);
                    _this.openMenuModal($('#menu-alert'));
                });
            }

        });
        this.modalFuncProcess($('#menu-delete'), function () {
            _this.deleteUserDfd(_this.vo.readyUserId()).done(function (resp) {
                _this.vo.updateStatus(resp && resp.messages);
                _this.openMenuModal($('#menu-alert'));
            });
        });
    }
};