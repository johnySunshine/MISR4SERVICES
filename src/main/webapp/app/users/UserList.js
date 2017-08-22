/**
 * Created by Fantasy on 2017/8/22.
 */
var UserList = function (vo) {
    this.vo = vo;
    this.init(vo);
};
UserList.prototype = {
    init: function (vo) {
        var self = this;
        vo.updateStatus = ko.observable();
        vo.userList = ko.observableArray([]);
        vo.readyUserTitle = ko.observable();
        vo.userName = ko.observable();
        vo.userLoginName = ko.observable();
        vo.permissions = ko.observable();
        vo.userRoles = ko.observable();
        vo.userType = ko.observable();
        vo.userPassword = ko.observable();
        vo.readyMenuTitle = ko.observable();
        vo.userId = ko.observable();
        vo.readyUserId = ko.observable();
        vo.addUsers = function () {
            vo.userLoginName('');
            vo.userName('');
            vo.userType('');
            vo.permissions('');
            vo.userRoles('');
            self.openMenuModal($('#menu-prompt'));
        };
        vo.reFreshTable = function () {
            this.dataTableTemp.ajax.reload();
        };
        vo.editUser = function (User) {
            self.openMenuModal($('#menu-prompt'));
            vo.userLoginName(User.userLoginName);
            vo.userName(User.userName);
            vo.userType(User.userType);
            vo.permissions(User.permissions);
            vo.userRoles(User.userRoles);
            vo.userPassword(User.userPassword);
            vo.userId(User.id);
        };
        vo.removeUser = function (user) {
            vo.readyMenuTitle(user.userName);
            vo.readyUserId(user.id);
            self.openMenuModal($('#menu-delete'));
        };
        this.userList();
        this.modalFunc();
    },

    deleteUserDfd: function (userId) {
        return $.ajax({
            url: '/Users/delUser?userId=' + userId,
            type: 'GET',
            dataType: 'json'
        });
    },
    openMenuModal: function ($ele) {
        $ele.modal({
            relatedTarget: this
        });
    },
    userListDfd: function () {
        return $.ajax({
            url: '/Users/listUser',
            type: 'GET',
            contentType: 'application/json',
            dataType: 'json'
        });
    },
    updateUserDfd: function () {
        var vo = this.vo;
        var _this = this;
        var userOptions = {
            'id': _this.vo.userId(),
            'userLoginName': _this.vo.userLoginName(),
            'userName': _this.vo.userName(),
            'userType': _this.vo.userType(),
            'permissions': _this.vo.permissions(),
            'userRoles': _this.vo.userRoles(),
            'userPassword': _this.vo.userPassword()
        };
        return $.ajax({
            url: '/Users/updateUser',
            type: 'PUT',
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(userOptions)
        });
    },
    userList: function () {
        var self = this;
        this.userListDfd().done(function (resp) {
            var userList = resp.result;
            _.each(userList, function (item) {
                item.gmtCreate = moment(+item.gmtCreate).format('YYYY-MM-DD HH:mm');
                item.gmtModified = moment(+item.gmtModified).format('YYYY-MM-DD HH:mm');
            });
            self.vo.userList(userList);
            this.dataTableTemp = $('#example-r').DataTable({
                responsive: true
            });
        });
    },
    saveUserDfd: function (addUser) {
        return $.ajax({
            url: '/Users/saveUser',
            type: 'POST',
            dataType: 'json',
            data: addUser
        });
    },
    modalFuncProcess: function ($ele, conFirmFunc, cancelFunc) {
        var $confirmBtn = $ele.find('[data-am-modal-confirm]');
        var $cancelBtn = $ele.find('[data-am-modal-cancel]');
        $confirmBtn.off('click.confirm.modal.amui').on('click', conFirmFunc || $.noop);
        $cancelBtn.off('click.cancel.modal.amui').on('click', cancelFunc || $.noop);
    },
    modalFunc: function () {
        var _this = this;
        this.modalFuncProcess($('#menu-prompt'), function () {
            if (_this.vo.userId()) {
                _this.updateUserDfd().done(function (resp) {
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
            this.modalFuncProcess($('#menu-delete'), function () {
                _this.deleteUserDfd(_this.vo.readyUserId()).done(function (resp) {
                    _this.vo.updateStatus(resp && resp.messages);
                    _this.openMenuModal($('#menu-alert'));
                });
            });
        });
        this.modalFuncProcess($('#menu-delete'), function () {
            _this.deleteUserDfd(_this.vo.readyUserId()).done(function (resp) {
                _this.vo.updateStatus(resp && resp.messages);
                _this.openMenuModal($('#menu-alert'));
            });
        });
    }
};