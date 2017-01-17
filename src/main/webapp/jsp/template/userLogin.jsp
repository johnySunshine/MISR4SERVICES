<%--
  Created by IntelliJ IDEA.
  User: Fantasy
  Date: 2017/1/17
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<html>
<head>
    <title>登录页面</title>
    <%@include file="../common/head.jsp" %>
    <link rel="stylesheet" href="<%=basePath%>/css/userLogin.css">
</head>
<body>
<div class="header">
    <div class="am-g">
        <h1>管理员登录</h1>
        <p>管理员登录</p>
    </div>
    <hr/>
</div>
<div class="am-g">
    <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
        <h3>登录</h3>
        <form method="post" class="am-form">
            <label for="email">用户名:</label>
            <input type="text" name="" id="email" value="" placeholder="请输入用户名">
            <br>
            <label for="password">密码:</label>
            <input type="password" name="" id="password" value="" placeholder="请输入用户密码">
            <br>
            <label for="remember-me">
                <input id="remember-me" type="checkbox">
                记住密码
            </label>
            <br/>
            <div class="am-cf">
                <input type="submit" name="" value="登 录" class="am-btn am-btn-primary am-btn-sm am-fl">
                <input type="submit" name="" value="忘记密码 ^_^? " class="am-btn am-btn-default am-btn-sm am-fr">
            </div>
        </form>
        <hr>
        <p>© 2014 AllMobilize, Inc. Licensed under MIT license.</p>
    </div>
</div>
</body>
</html>
