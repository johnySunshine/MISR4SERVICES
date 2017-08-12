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
            }).done(function (resp) {
                if (resp && resp.retCode === '707010') {
                   // sessionStorage.removeItem('accessToken');
                    alert('用户名或者密码错误，请重新输入');
                    return;
                } else {
                    //sessionStorage.setItem('userName', resp.userLoginName || '');
                    //sessionStorage.setItem('accessToken', resp.token);
                    location.href =  '/IDEA/template/menuIndex.jsp';
                }
            })
        }
    },
    userLoginDfd: function (userObj) {
        return $.ajax({
            url: '/users/ajaxLogin',
            type: 'POST',
            data: userObj
        });
    }
};