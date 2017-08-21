var UserLogin = function (vo) {
    'use strict';
    this.init(vo);
};
UserLogin.prototype = {
    init: function (vo) {
        var self = this;
        this.vo = vo;
        vo.userLoginName = ko.observable();
        vo.userPassword = ko.observable();
        vo.userNameLable = ko.observable();
        vo.userPasswordLable = ko.observable();
        vo.userLogin = function () {
            self.userLoginIn();
        };
    },
    UserLoginDfd: function () {
        return $.post(
            '/Users/login',
            {
                userLoginName: this.vo.userLoginName(),
                userPassword: this.vo.userPassword()
            }
        );
    },
    userLoginIn: function () {
        var self = this;
        if (this.vo.userLoginName() === '') {
            this.vo.userNameLable('用户不能为空！');
            return;
        }
        if (this.vo.userPassword() === '') {
            this.vo.userPasswordLable('密码不能为空！');
            return;
        }
        this.UserLoginDfd().done(function (resp) {
            if (resp.retCode === 107022) {
                self.vo.userNameLable(resp.messages);
                return;
            }
            location.href = "/app/menus/Menus.jsp";
        });
    }
};