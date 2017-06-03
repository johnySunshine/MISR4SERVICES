$(function () {
    // 读取body data-type 判断是哪个页面然后执行相应页面方法，方法在下面。
    var dataType = $('body').attr('data-type');
    for (key in pageData) {
        if (key == dataType) {
            pageData[key]();
        }
    }
    //     // 判断用户是否已有自己选择的模板风格
    //    if(storageLoad('SelcetColor')){
    //      $('body').attr('class',storageLoad('SelcetColor').Color)
    //    }else{
    //        storageSave(saveSelectColor);
    //        $('body').attr('class','theme-black')
    //    }

    autoLeftNav();
    $(window).resize(function () {
        autoLeftNav();
    });
});

var closeModalDom = function ($element) {
    $element.on('closed.modal.amui', function () {
        $(this).removeData('amui.modal');
    });
};
var openMenuModalDom = function ($element) {
    $element.modal({
        relatedTarget: this,
        onConfirm: function (options) {
            var $link = $(this.relatedTarget).prev('a');
            var msg = $link.length ? '你要删除的链接 ID 为 ' + $link.data('id') :
                '确定了，但不知道要整哪样';
            console.log(options);
            closeModalDom($('#menu-prompt'));
        },
        // closeOnConfirm: false,
        onCancel: function () {
            closeModalDom($('#menu-prompt'));
        }
    });
};

var addSelectCss = function () {
    $('#menu-subId').children().css('background', '#282d2f');
};
// 页面数据
var pageData = {
    'index': function () {
        var viewModel = {};
        viewModel.menuList = ko.observableArray([]);
        viewModel.menuTitle = ko.observable();
        viewModel.menuUrl = ko.observable();
        viewModel.menuTarget = ko.observable();
        viewModel.menuSubId = ko.observable();
        viewModel.menuVisible = ko.observable();
        viewModel.editMenu = function (menuKo) {
            openMenuModalDom($('#menu-prompt'));
            viewModel.menuTitle(menuKo.menuTitle);
            viewModel.menuUrl(menuKo.menuUrl);
            viewModel.menuTarget(menuKo.menuTarget);
            viewModel.menuSubId(menuKo.menuSubId);
            viewModel.menuVisible(menuKo.menuVisible);
            console.log(menuKo);
        };
        viewModel.removeMenu = function (menuKo) {
            console.log(menuKo);
        };
        $.get('/menus/listMeta').done(function (resp) {
            var listMenu = resp && resp.result;
            _.each(listMenu, function (item) {
                item.gmtCreate = moment(+item.gmtCreate).format('YYYY/MM/DD,h:mm:ss');
                item.gmtModified = moment(+item.gmtModified).format('YYYY/MM/DD,h:mm:ss');
            });
            viewModel.menuList(listMenu);
            $('#example-r').DataTable();

        });
        _.delay(function () {
            addSelectCss();
        }, 500);
        ko.applyBindings(viewModel);
    }
};


// 风格切换

$('.tpl-skiner-toggle').on('click', function () {
    $('.tpl-skiner').toggleClass('active');
});

$('.tpl-skiner-content-bar').find('span').on('click', function () {
    $('body').attr('class', $(this).attr('data-color'));
    saveSelectColor.Color = $(this).attr('data-color');
    // 保存选择项
    storageSave(saveSelectColor);

});


// 侧边菜单开关


function autoLeftNav() {
    $('.tpl-header-switch-button').on('click', function () {
        if ($('.left-sidebar').is('.active')) {
            if ($(window).width() > 1024) {
                $('.tpl-content-wrapper').removeClass('active');
            }
            $('.left-sidebar').removeClass('active');
        } else {

            $('.left-sidebar').addClass('active');
            if ($(window).width() > 1024) {
                $('.tpl-content-wrapper').addClass('active');
            }
        }
    });

    if ($(window).width() < 1024) {
        $('.left-sidebar').addClass('active');
    } else {
        $('.left-sidebar').removeClass('active');
    }
}


// 侧边菜单
$('.sidebar-nav-sub-title').on('click', function () {
    $(this).siblings('.sidebar-nav-sub').slideToggle(80)
        .end()
        .find('.sidebar-nav-sub-ico').toggleClass('sidebar-nav-sub-ico-rotate');
});