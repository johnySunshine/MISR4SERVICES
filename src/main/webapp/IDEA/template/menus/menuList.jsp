<%--
  Created by IntelliJ IDEA.
  User: Fantasy
  Date: 2017/2/5
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../commonJsp/tag.jsp" %>
<!doctype html>
<html>
<head>
    <title>菜单配置</title>
    <%@include file="../../commonJsp/head.jsp" %>
</head>
<body data-type="widgets">
<script src="<%=IDEAPath%>assets/js/theme.js"></script>
<div class="am-g tpl-g animated fadeInRight">
    <%@include file="../header.jsp" %>
    <%@include file="../changeTheme.jsp" %>
    <%@include file="../sliderNavBar.jsp" %>
    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">
        <div class="container-fluid am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-9">
                    <div class="page-header-heading"><span class="am-icon-th-large page-header-heading-icon"></span>
                        菜单配置模块
                        <small><c:if
                                test="${!empty code_msg}">状态信息：${code_msg}</c:if></small>
                    </div>
                    <p class="page-header-description">此处配置前端页面的菜单基本模块</p>
                </div>
                <div class="am-u-lg-3 tpl-index-settings-button">
                    <a type="button" class="page-header-button am-btn-success"
                       href="<%=basePath%>Menus/getMenuSubId?menuSubId=0"><span class="am-icon-plus"></span> 添加
                    </a>
                </div>
            </div>
        </div>
        <div class="row-content am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title am-fl">所有的菜单的显示</div>
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
                                        <td>${menu.id}</td>
                                        <td>${menu.menuText}</td>
                                        <td>${menu.menuUrl}</td>
                                        <td class="am-hide-sm-only">${menu.target}</td>
                                        <td class="am-hide-sm-only">${menu.subid}</td>
                                        <td class="am-hide-sm-only">${menu.hubIsVisible}</td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a href="<%=basePath%>Menus/getMenuId?menuId=${menu.id}">
                                                    <i class="am-icon-pencil"></i> 编辑
                                                </a>
                                                <a href="<%=basePath%>Menus/delMenuById?menuId=${menu.id}"
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
