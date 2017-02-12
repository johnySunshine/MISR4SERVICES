<%--
  Created by IntelliJ IDEA.
  User: Fantasy
  Date: 2017/2/5
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../commonJsp/tag.jsp" %>
<!doctype html>
<html>
<head>
    <title>电影列表</title>
    <%@include file="../../commonJsp/head.jsp" %>
</head>
<body data-type="widgets">
<script src="<%=IDEAPath%>assets/js/theme.js"></script>
<div class="am-g tpl-g animated fadeInRight">
    <%@include file="../header.jsp" %>
    <%@include file="../changeTheme.jsp" %>
    <%@include file="../sliderNavBar.jsp" %>
    <div class="tpl-content-wrapper">
        <div class="container-fluid am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-9">
                    <div class="page-header-heading"><span class="am-icon-th-large page-header-heading-icon"></span>
                        电影配置模块
                        <small><c:if
                                test="${!empty code_msg}">状态信息：${code_msg}</c:if></small>
                    </div>
                    <p class="page-header-description">此处配置前端页面的菜单基本模块</p>
                </div>
                <div class="am-u-lg-3 tpl-index-settings-button">
                    <a type="button" class="page-header-button am-btn-success"
                       href="<%=IDEAPath%>template/movies/showMovieDetail.jsp"><span class="am-icon-plus"></span> 添加
                    </a>
                </div>
            </div>
        </div>
        <div class="row-content am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title am-fl">所有的影片的显示</div>
                            <div class="widget-function am-fr">
                                <a href="javascript:;" class="am-icon-cog"></a>
                            </div>
                        </div>

                        <div class="widget-body  widget-body-lg am-fr">
                            <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black "
                                   id="example-r">
                                <thead>
                                <tr>
                                    <th class="table-id">ID</th>
                                    <th class="table-title">影片标题</th>
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
                                        <td>${movie.movieId}</td>
                                        <td>${movie.title}</td>
                                        <td>${movie.runtime}</td>
                                        <td class="am-hide-sm-only">${movie.childProtectionLevel}</td>
                                        <td class="am-hide-sm-only">${movie.category}</td>
                                        <td class="am-hide-sm-only">${movie.creationDate}</td>

                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a href="<%=basePath%>Movie/toMovieDetail?movieId=${movie.movieId}&curPagesIndex=${currentPages}">
                                                    <i class="am-icon-pencil"></i> 编辑
                                                </a>
                                                <a href="<%=basePath%>Movie/delMovie?movieId=${movie.movieId}"
                                                   class="tpl-table-black-operation-del">
                                                    <i class="am-icon-trash"></i> 删除
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="am-u-lg-12 am-cf">
                            <a>第${currentPages}页</a>
                            <a>共${countMovies}页</a>
                            <div class="am-fr">
                                <ul class="am-pagination tpl-pagination">
                                    <c:if test="${currentPages!=1}">
                                        <li><a href="<%=basePath%>Movie/ShowMovies/${currentPages-1}">上一页</a></li>
                                    </c:if>
                                    <c:forEach items="${paginationList}" varStatus="status">
                                        <li <c:if test="${(status.index+1) == currentPages}"> class="am-active" </c:if>>
                                            <a href="<%=basePath%>Movie/ShowMovies/${status.index+1}">${status.index+1}</a>
                                        </li>
                                    </c:forEach>
                                    <c:if test="${currentPages != countMovies}">
                                        <li><a href="<%=basePath%>Movie/ShowMovies/${currentPages+1}">下一页</a></li>
                                    </c:if>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<%=IDEAPath%>assets/js/amazeui.min.js"></script>
<script src="<%=IDEAPath%>assets/js/amazeui.datatables.min.js"></script>
<script src="<%=IDEAPath%>assets/js/dataTables.responsive.min.js"></script>
<script src="<%=IDEAPath%>assets/js/app.js"></script>
</body>
</html>
