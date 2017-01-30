<%--
  Created by IntelliJ IDEA.
  User: Fantasy
  Date: 2017/1/29
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<html>
<head>
    <title>显示所有的Vod</title>
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
                               href="<%=basePath%>Movie/showDetail"><span
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
                                <th class="table-type">时长</th>
                                <th class="table-author am-hide-sm-only">儿童保护等级</th>
                                <th class="table-date am-hide-sm-only">影片类别</th>
                                <th class="table-date am-hide-sm-only">创建时间</th>
                                <th class="table-set">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${getMoviesWithTabs}" var="movie">
                                <tr>
                                    <td><input type="checkbox"/></td>
                                    <td>${movie.movieId}</td>
                                    <td>${movie.title}</td>
                                    <td>${movie.runtime}</td>
                                    <td class="am-hide-sm-only">${movie.childProtectionLevel}</td>
                                    <td class="am-hide-sm-only">${movie.category}</td>
                                    <th class="am-hide-sm-only">${movie.creationDate}</th>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <a class="am-btn am-btn-default am-btn-xs am-text-secondary"
                                                   href="<%=basePath%>Menus/getMenuId?menuId=${movie.movieId}"><span
                                                        class="am-icon-pencil-square-o"></span> 编辑
                                                </a>
                                                <a class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"
                                                   href="<%=basePath%>Menus/delMenuById?menuId=${movie.movieId}">
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
                            共 ${getMoviesWithTabs.size()}条记录
                            <div class="am-fr">
                                <ul class="am-pagination">
                                    <li><a class="prev" href="<%=basePath%>Movie/ShowMovies/prev">«上一页</a>
                                    </li>
                                    <li><a class="next" href="<%=basePath%>Movie/ShowMovies/next">下一页»</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <hr/>
                        <p>注：此处为菜单的全局显示页面，主菜单子subId为零，子菜单的subId指向主菜单id</p>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
