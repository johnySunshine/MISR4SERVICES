var UserLogin = function (vo) {
    this.vo = vo;
    this.init(vo);
};
UserLogin.prototype = {
    init: function (vo) {
        var _this = this;
        vo.userName = ko.observable();
        vo.userPassword = ko.observable();
        vo.userLogin = function () {
            _this.userLoginDfd({
                userLoginName: vo.userName(),
                userPassword: vo.userPassword()
            })
        }
    },
    userLoginDfd: function (userObj) {
        return $.ajax({
            url: '/menus/detail/',
            type: 'POST',
            data: userObj
        });
    }
};