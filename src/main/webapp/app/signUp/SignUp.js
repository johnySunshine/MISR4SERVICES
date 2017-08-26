/**
 * Created by Fantasy on 2017/8/23.
 */
var SignUp = function (vo) {
    this.vo = vo;
    vo.password = ko.observable();
    vo.Ocolor = ko.observable();
    vo.reCheckPassword = ko.observable();
    vo.userName = ko.observable();
    vo.userLoginName = ko.observable();
    this.init(vo);
};
SignUp.prototype = {
    init: function (vo) {
        var self = this;
        this.vo.passwordLevel = ko.dependentObservable(function () {
            return self.passwordLevel(self.vo.password() || '');
        }, vo);

        vo.Lcolor = ko.dependentObservable(function () {
            //根据密码强度判断第一个格显示的背景色
            var passwordLevel = self.passwordLevel(self.vo.password() || '');
            return passwordLevel === 0 ? self.vo.Ocolor : (passwordLevel === 1 ? "#FF0000" : (passwordLevel === 2 ? "#FF9900" : "#33CC00"))
        }, vo);

        vo.Mcolor = ko.dependentObservable(function () {
            //根据密码强度判断第二个格显示的背景色
            var passwordLevel = self.passwordLevel(self.vo.password() || '');
            return passwordLevel < 2 ? self.vo.Ocolor : (passwordLevel === 2 ? "#FF9900" : "#33CC00")
        }, vo);
        vo.Hcolor = ko.dependentObservable(function () {
            //根据密码强度判断第三个格显示的背景色
            var passwordLevel = self.passwordLevel(self.vo.password() || '');
            return passwordLevel < 3 ? self.vo.Ocolor : "#33CC00"
        }, vo);
        vo.checkPassword = ko.dependentObservable(function () {
            return self.vo.password() !== self.vo.reCheckPassword();
        }, vo);
        vo.registerSubmit = function () {
            if (_.isEmpty(self.vo.userName()) || _.isEmpty(self.vo.userLoginName())) {
                return;
            }
            if (self.vo.password() !== self.vo.reCheckPassword()) {
                return;
            }
            self.userRegisterDfd().done(function (resp) {
                if (resp.retCode === 107111) {
                    alert('用户注册成功');
                    return;
                }
                if (resp.retCode === 107122) {
                    alert(resp.result);
                }
            });
        };
    },
    userRegisterDfd: function () {
        var _this = this;
        return $.ajax({
            url: BathPath() + '/Users/userRegister',
            type: 'POST',
            dataType: 'json',
            data: {
                'userLoginName': _this.vo.userLoginName(),
                'userName': _this.vo.userName(),
                'userPassword': _this.vo.password()
            }
        });
    },
    passwordLevel: function (password) {
        if (password === null || password === '') {
            return 0;
        }
        if (password && password.length <= 4) {
            return 0;
        }
        var Modes = 0;
        for (var i = 0; i < password.length; i++) {
            Modes |= this.charModel(this.vo.password().charCodeAt(i));
        }
        return this.bitTotal(Modes);

    },
    charModel: function (singleWordNumber) {
        if (singleWordNumber >= 48 && singleWordNumber <= 57) {
            return 1;
        } else if (singleWordNumber >= 65 && singleWordNumber <= 90) {
            return 2;
        } else if (singleWordNumber >= 97 && singleWordNumber <= 122) {
            return 4;
        } else {
            return 8;
        }

    },
    bitTotal: function (num) {
        var modes = 0;
        for (var i = 0; i < 4; i++) {
            if (num & 1) modes++;
            num >>>= 1;
        }
        return modes;
    }
};