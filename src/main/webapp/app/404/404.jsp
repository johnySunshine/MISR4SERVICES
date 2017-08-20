<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common.jsp" %>
<html>
<head>
    <title>页面没有找到</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="<%=basePath%>assets/i/favicon.ico">
    <link rel="apple-touch-icon-precomposed" href="<%=basePath%>assets/i/favicon.ico">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="<%=basePath%>assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="<%=basePath%>assets/css/amazeui.datatables.min.css"/>
    <link rel="stylesheet" href="<%=basePath%>assets/css/app.css">
    <script src="<%=basePath%>assets/js/jquery.min.js"></script>
    <script src="<%=basePath%>assets/js/ko.js"></script>
</head>
<body>
<script src="<%=basePath%>assets/js/theme.js"></script>
<div class="row-content am-cf">
    <div class="widget am-cf">
        <div class="widget-body">
            <div class="tpl-page-state">
                <div class="tpl-page-state-title am-text-center tpl-error-title">404</div>
                <div class="tpl-error-title-info">Page Not Found</div>
                <div class="tpl-page-state-content tpl-error-content">
                    <p>对不起,没有找到您所需要的页面,可能是URL不确定,或者页面已被移除。</p>
                    <button type="button" class="am-btn am-btn-secondary am-radius tpl-error-btn" data-bind="click:reBackHome">返回首页</button>
                </div>

            </div>
        </div>
    </div>
</div>
<script src="<%=basePath%>assets/js/amazeui.min.js"></script>
<script src="<%=basePath%>app/404/404.js"></script>
<script src="<%=basePath%>assets/js/app.js"></script>
</body>
</html>
