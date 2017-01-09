<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<html>
<head>
    <title>显示所有的菜单</title>
    <%@include file="../common/head.jsp" %>
</head>
<body>
<header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-topbar-brand">
        <strong>菜单</strong>
        <small>后台管理</small>
    </div>

    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
            data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span
            class="am-icon-bars"></span></button>

    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
            <li><a href="javascript:;"><span class="am-icon-envelope-o"></span> 收件箱 <span
                    class="am-badge am-badge-warning">5</span></a></li>
            <li class="am-dropdown" data-am-dropdown>
                <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
                    <span class="am-icon-users"></span> 管理员 <span class="am-icon-caret-down"></span>
                </a>
                <ul class="am-dropdown-content">
                    <li><a href="#"><span class="am-icon-user"></span> 资料</a></li>
                    <li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
                    <li><a href="#"><span class="am-icon-power-off"></span> 退出</a></li>
                </ul>
            </li>
            <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen"><span
                    class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
        </ul>
    </div>
</header>
<div class="am-cf admin-main">
    <div class="admin-content">
        <div class="admin-content-body">
            <div class="am-cf am-padding am-padding-bottom-0">
                <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">菜单表格</strong> /
                    <small>MenuTable</small>
                </div>
            </div>
            <hr>
            <div class="am-g">
                <div class="am-u-sm-12 am-u-md-6">
                    <div class="am-btn-toolbar">
                        <div class="am-btn-group am-btn-group-xs">
                            <button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 新增
                            </button>
                            <button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 保存
                            </button>
                            <button type="button" class="am-btn am-btn-default"><span class="am-icon-archive"></span> 审核
                            </button>
                            <button type="button" class="am-btn am-btn-default"><span class="am-icon-trash-o"></span> 删除
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="am-g">
                <div class="am-u-sm-12">
                    <form class="am-form">
                        <table class="am-table am-table-striped am-table-hover table-main">
                            <thead>
                            <tr>
                                <th class="table-check"><input type="checkbox"/></th>
                                <th class="table-id">ID</th>
                                <th class="table-title">菜单标题</th>
                                <th class="table-type">菜单地址</th>
                                <th class="table-author am-hide-sm-only">菜单目标</th>
                                <th class="table-date am-hide-sm-only">子菜单ID</th>
                                <th class="table-set">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${menuMainList}" var="menu">
                                <tr>
                                    <td><input type="checkbox"/></td>
                                    <td>${menu.id}</td>
                                    <td>${menu.menuText}</td>
                                    <td>${menu.menuUrl}</td>
                                    <td class="am-hide-sm-only">${menu.target}</td>
                                    <td class="am-hide-sm-only">${menu.subid}</td>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span
                                                        class="am-icon-pencil-square-o"></span> 编辑
                                                </button>
                                                <a class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"
                                                   href="/Menus/delMenuById?menuId=${menu.id}">
                                                    <span class="am-icon-trash-o"></span>
                                                    删除
                                                </a>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="am-cf">
                            共 ${menuMainList.size()}条记录
                        </div>
                        <hr/>
                        <p>注：此处为菜单的全局显示页面，主菜单子subId为零，子菜单的subId指向主菜单id</p>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="js/app.js"></script>
<script src="js/showMenuList.js"></script>
</body>
</html>
