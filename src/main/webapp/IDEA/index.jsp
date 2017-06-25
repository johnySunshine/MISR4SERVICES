<!doctype html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <%@include file="commonJsp/head.jsp" %>
</head>
<body data-type="index">
<script src="<%=IDEAPath%>assets/js/theme.js"></script>
<div class="am-g tpl-g">
    <%@include file="template/header.jsp" %>
    <%@include file="template/changeTheme.jsp" %>
    <%@include file="template/sliderNavBar.jsp" %>
    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">
        <div class="container-fluid am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-9">
                    <div class="page-header-heading"><span class="am-icon-bars page-header-heading-icon"></span> 菜单列表
                    </div>
                    <p class="page-header-description">管理菜单模块: subID 为0主菜单</p>
                </div>
                <div class="am-u-lg-3 tpl-index-settings-button">
                    <button type="button" class="page-header-button" data-bind="click:addMenu"><span
                            class="am-icon-paint-brush"></span>新增
                    </button>
                </div>
            </div>
        </div>
        <div class="row-content am-cf">
            index
        </div>
    </div>
</div>
<script src="<%=IDEAPath%>assets/js/amazeui.min.js"></script>
<script src="<%=IDEAPath%>assets/js/amazeui.datatables.min.js"></script>
<script src="<%=IDEAPath%>assets/js/dataTables.responsive.min.js"></script>
<script src="<%=IDEAPath%>assets/js/knockout-3.4.2.js"></script>
<script src="<%=IDEAPath%>assets/js/app.js"></script>
</body>
</html>
