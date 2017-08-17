<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>后端管理</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp"/>
<link rel="icon" type="image/png" href="<%=basePath%>ums/assets/img/h7.ico">
<link rel="apple-touch-icon-precomposed" href="<%=basePath%>ums/assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="M-Stream 后端管理">
<%--<script src="<%=IDEAPath%>assets/js/echarts.min.js"></script>--%>
<link rel="stylesheet" href="<%=basePath%>ums/assets/css/animate.min.css">
<link rel="stylesheet" href="<%=basePath%>ums/assets/css/amazeui.min.css">
<link rel="stylesheet" href="<%=basePath%>ums/assets/css/amazeui.datatables.min.css">
<link rel="stylesheet" href="<%=basePath%>ums/assets/css/app.css">
<script src="<%=basePath%>ums/assets/js/jquery.min.js"></script>
<script src="<%=basePath%>ums/assets/js/lodash.js"></script>
<script src="<%=basePath%>ums/assets/js/moment.js"></script>
<script src="<%=basePath%>ums/assets/js/basePath.js"></script>
