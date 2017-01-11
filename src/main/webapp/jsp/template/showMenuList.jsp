<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<html>
<head>
    <title>显示所有的菜单</title>
    <%@include file="../common/head.jsp" %>
</head>
<body>
<%@include file="header.jsp" %>
<div class="am-cf admin-main">
    <%@include file="controlPanel.jsp" %>
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
                            <a type="button" class="am-btn am-btn-default"
                               href="<%=basePath%>Menus/getMenuSubId?menuSubId=0"><span
                                    class="am-icon-plus"></span>
                                新增
                            </a>
                            <a type="button" class="am-btn am-btn-default" href="#">
                                <span class="am-icon-save"></span>
                                刷新
                            </a>
                            <div class="am-badge am-badge-warning am-text-lg">状态信息：${code_msg}</div>
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
                                <th class="table-date am-hide-sm-only">主页是否显示</th>
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
                                    <th class="am-hide-sm-only">${menu.hubIsVisible}</th>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <a class="am-btn am-btn-default am-btn-xs am-text-secondary"
                                                   href="<%=basePath%>Menus/getMenuId?menuId=${menu.id}"><span
                                                        class="am-icon-pencil-square-o"></span> 编辑
                                                </a>
                                                <a class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"
                                                   href="<%=basePath%>Menus/delMenuById?menuId=${menu.id}">
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
</body>
</html>
