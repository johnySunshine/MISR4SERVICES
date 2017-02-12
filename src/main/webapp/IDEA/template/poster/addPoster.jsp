<%--
  Created by IntelliJ IDEA.
  User: Fantasy
  Date: 2017/2/12
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>添加海报</title>
    <%@include file="../../commonJsp/head.jsp" %>
    <link rel="stylesheet" href="<%=IDEAPath%>assets/css/cropper.min.css">
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
                    <div class="page-header-heading"><span class="am-icon-image page-header-heading-icon"></span>
                        添加海报
                        <small>M-STREAM</small>
                    </div>
                    <p class="page-header-description">${code_msg}</p>
                </div>
            </div>
        </div>
        <div class="row-content am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title am-fl">添加海报主体</div>
                            <div class="widget-function am-fr">
                                <a href="javascript:;" class="am-icon-cog"></a>
                            </div>
                        </div>
                    </div>
                    <div class="widget-body am-fr">1231231231</div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<%=IDEAPath%>assets/js/chosen.jquery.js"></script>
<script src="<%=IDEAPath%>assets/js/amazeui.min.js"></script>
<script src="<%=IDEAPath%>assets/js/app.js"></script>
<script src="<%=IDEAPath%>assets/js/cropper.min.js"></script>
</body>
</html>
