<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>侧边导航栏</title>
</head>
<body>
<!-- 侧边导航栏 -->
<div class="left-sidebar">
    <!-- 用户信息 -->
    <div class="tpl-sidebar-user-panel">
        <div class="tpl-user-panel-slide-toggleable">
            <span class="user-panel-logged-in-text">
              <i class="am-icon-circle-o am-text-success tpl-user-panel-status-icon"></i><shiro:principal/>
          </span>
            <a href="javascript:;" class="tpl-user-panel-action-link"> <span class="am-icon-pencil"></span> 账号设置</a>
        </div>
    </div>

    <!-- 菜单 -->
    <ul class="sidebar-nav">
        <%--<shiro:hasRole name="admin">--%>
        <li class="sidebar-nav-heading">Data<span class="sidebar-nav-heading-info">常用数据配置</span></li>
        <li class="sidebar-nav-link">
            <a href="<%=basePath%>ums/mainBody/menuIndex.jsp">
                <i class="am-icon-clone sidebar-nav-link-logo"></i> 菜单配置
            </a>
        </li>
        <li class="sidebar-nav-link">
            <a href="<%=basePath%>ums/mainBody/userIndex.jsp">
                <i class="am-icon-clone sidebar-nav-link-logo"></i> 用户管理
            </a>
        </li>
        <%--</shiro:hasRole>--%>
        <%--        <li class="sidebar-nav-link">
                    <a href="javascript:;" class="sidebar-nav-sub-title" id="module-config">
                        <i class="am-icon-clone sidebar-nav-link-logo"></i> 模块数据配置
                        <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                    </a>
                    <ul class="sidebar-nav sidebar-nav-sub">
                        <li class="sidebar-nav-link">
                        </li>

                        <li class="sidebar-nav-link">
                            <a href="<%=basePath%>CustomConfig/getAllCusConfig">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 通用设置
                            </a>
                        </li>

                        <li class="sidebar-nav-link">
                            <a href="<%=basePath%>Movie/ShowMovies/1">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 影片设置
                            </a>
                        </li>

                        <li class="sidebar-nav-link">
                            <a href="<%=basePath%>Images/toAddImgSide">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 海报设置
                            </a>
                        </li>

                    </ul>
                </li>--%>

        <li class="sidebar-nav-link">
            <a href="sign-up.html">
                <i class="am-icon-clone sidebar-nav-link-logo"></i> 注册
            </a>
        </li>
        <li class="sidebar-nav-link">
            <a href="login.html">
                <i class="am-icon-key sidebar-nav-link-logo"></i> 登录
            </a>
        </li>
        <li class="sidebar-nav-link">
            <a href="404.html">
                <i class="am-icon-tv sidebar-nav-link-logo"></i> 404错误
            </a>
        </li>
    </ul>
</div>
<script>
    $(function () {
        if (location.pathname.split('/')[1] === 'Movie' || location.pathname.split('/')[1] === 'Menus' || location.pathname.split('/')[1] === 'CustomConfig') {
            $('#module-config').addClass('active');
        }
    });
</script>
</body>
</html>
