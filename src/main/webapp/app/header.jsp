<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <!-- logo -->
    <div class="am-fl tpl-header-logo">
        <a href="javascript:;"><img src="<%=basePath%>assets/img/logo.png" alt=""></a>
    </div>
    <!-- 右侧内容 -->
    <div class="tpl-header-fluid">
        <!-- 侧边切换 -->
        <div class="am-fl tpl-header-switch-button am-icon-list">
                    <span>

                </span>
        </div>
        <!-- 其它功能-->
        <div class="am-fr tpl-header-navbar">
            <ul>
                <!-- 欢迎语 -->
                <li class="am-text-sm tpl-header-navbar-welcome">
                    <a href="javascript:;">欢迎你, <span>Amaze UI</span> </a>
                </li>
                <!-- 退出 -->
                <li class="am-text-sm">
                    <a href="/User/logout">
                        <span class="am-icon-sign-out user-sign-out"></span> 退出
                    </a>
                </li>
            </ul>
        </div>
    </div>
</header>
