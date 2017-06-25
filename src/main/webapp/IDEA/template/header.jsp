<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>控制栏头部</title>
</head>
<body>
<header>
    <!-- logo -->
    <div class="am-fl tpl-header-logo">
        <a href="javascript:;"><img src="<%=IDEAPath%>assets/img/h7.ico" alt=""
                                    style="display: inline-block;width: 50px;"></a>
    </div>
    <!-- 右侧内容 -->
    <div class="tpl-header-fluid">
        <!-- 侧边切换 -->
        <div class="am-fl tpl-header-switch-button am-icon-list">
                    <span>

                </span>
        </div>
        <!-- 搜索 -->
        <div class="am-fl tpl-header-search">
            <form class="tpl-header-search-form" action="javascript:;">
                <button class="tpl-header-search-btn am-icon-search"></button>
                <input class="tpl-header-search-box" type="text" placeholder="搜索内容...">
            </form>
        </div>
        <!-- 其它功能-->
        <div class="am-fr tpl-header-navbar">
            <ul>
                <!-- 欢迎语 -->
                <li class="am-text-sm tpl-header-navbar-welcome">
                    <a href="javascript:;">欢迎你, <span>Amaze UI</span> </a>
                </li>

                <!-- 新邮件 -->
                <li class="am-dropdown tpl-dropdown" data-am-dropdown>
                    <a href="javascript:;" class="am-dropdown-toggle tpl-dropdown-toggle" data-am-dropdown-toggle>
                        <i class="am-icon-envelope"></i>
                        <span class="am-badge am-badge-success am-round item-feed-badge">4</span>
                    </a>
                    <!-- 弹出列表 -->
                    <ul class="am-dropdown-content tpl-dropdown-content">
                        <li class="tpl-dropdown-menu-messages">
                            <a href="javascript:;" class="tpl-dropdown-menu-messages-item am-cf">
                                <div class="menu-messages-ico">
                                    <img src="assets/img/user04.png" alt="">
                                </div>
                                <div class="menu-messages-time">
                                    3小时前
                                </div>
                                <div class="menu-messages-content">
                                    <div class="menu-messages-content-title">
                                        <i class="am-icon-circle-o am-text-success"></i>
                                        <span>夕风色</span>
                                    </div>
                                    <div class="am-text-truncate"> Amaze UI 的诞生，依托于 GitHub 及其他技术社区上一些优秀的资源；Amaze UI
                                        的成长，则离不开用户的支持。
                                    </div>
                                    <div class="menu-messages-content-time">2016-09-21 下午 16:40</div>
                                </div>
                            </a>
                        </li>

                        <li class="tpl-dropdown-menu-messages">
                            <a href="javascript:;" class="tpl-dropdown-menu-messages-item am-cf">
                                <div class="menu-messages-ico">
                                    <img src="assets/img/user02.png" alt="">
                                </div>
                                <div class="menu-messages-time">
                                    5天前
                                </div>
                                <div class="menu-messages-content">
                                    <div class="menu-messages-content-title">
                                        <i class="am-icon-circle-o am-text-warning"></i>
                                        <span>禁言小张</span>
                                    </div>
                                    <div class="am-text-truncate"> 为了能最准确的传达所描述的问题， 建议你在反馈时附上演示，方便我们理解。</div>
                                    <div class="menu-messages-content-time">2016-09-16 上午 09:23</div>
                                </div>
                            </a>
                        </li>
                        <li class="tpl-dropdown-menu-messages">
                            <a href="javascript:;" class="tpl-dropdown-menu-messages-item am-cf">
                                <i class="am-icon-circle-o"></i> 进入列表…
                            </a>
                        </li>
                    </ul>
                </li>

                <!-- 新提示 -->
                <li class="am-dropdown" data-am-dropdown>
                    <a href="javascript:;" class="am-dropdown-toggle" data-am-dropdown-toggle>
                        <i class="am-icon-bell"></i>
                        <span class="am-badge am-badge-warning am-round item-feed-badge">5</span>
                    </a>

                    <!-- 弹出列表 -->
                    <ul class="am-dropdown-content tpl-dropdown-content">
                        <li class="tpl-dropdown-menu-notifications">
                            <a href="javascript:;" class="tpl-dropdown-menu-notifications-item am-cf">
                                <div class="tpl-dropdown-menu-notifications-title">
                                    <i class="am-icon-line-chart"></i>
                                    <span> 有6笔新的销售订单</span>
                                </div>
                                <div class="tpl-dropdown-menu-notifications-time">
                                    12分钟前
                                </div>
                            </a>
                        </li>
                        <li class="tpl-dropdown-menu-notifications">
                            <a href="javascript:;" class="tpl-dropdown-menu-notifications-item am-cf">
                                <div class="tpl-dropdown-menu-notifications-title">
                                    <i class="am-icon-star"></i>
                                    <span> 有3个来自人事部的消息</span>
                                </div>
                                <div class="tpl-dropdown-menu-notifications-time">
                                    30分钟前
                                </div>
                            </a>
                        </li>
                        <li class="tpl-dropdown-menu-notifications">
                            <a href="javascript:;" class="tpl-dropdown-menu-notifications-item am-cf">
                                <div class="tpl-dropdown-menu-notifications-title">
                                    <i class="am-icon-folder-o"></i>
                                    <span> 上午开会记录存档</span>
                                </div>
                                <div class="tpl-dropdown-menu-notifications-time">
                                    1天前
                                </div>
                            </a>
                        </li>


                        <li class="tpl-dropdown-menu-notifications">
                            <a href="javascript:;" class="tpl-dropdown-menu-notifications-item am-cf">
                                <i class="am-icon-bell"></i> 进入列表…
                            </a>
                        </li>
                    </ul>
                </li>

                <!-- 退出 -->
                <li class="am-text-sm">
                    <div class="user-sign-out" style="line-height: 56px;
                                                      display: block;
                                                      padding: 0 16px;
                                                      position: relative;
">
                        <span class="am-icon-sign-out"></span> 退出
                    </div>
                </li>
            </ul>
        </div>
    </div>
</header>
<script>
    $(function () {
        $('.user-sign-out').on('click.signOut', function () {
            $.ajax({
                headers: {
                    'access-token': sessionStorage.getItem('accessToken') || ''
                },
                url: '/auth/invalidateToken',
                type: 'GET',
                dataType: 'json'
            }).always(function (resp) {
                var result = resp.result;
                sessionStorage.removeItem('accessToken');
                sessionStorage.setItem('accessToken', result);
                location.href = '/IDEA/template/login/userLogin.jsp';
            });
            //sessionStorage.removeItem('accessToken');

        });
    });
</script>
</body>
</html>
