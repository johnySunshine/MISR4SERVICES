<%--
  Created by IntelliJ IDEA.
  User: Fantasy
  Date: 2017/8/20
  Time: 2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>用户登录</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="<%=basePath%>/assets/i/favicon.ico">
    <link rel="apple-touch-icon-precomposed" href="<%=basePath%>/assets/i/favicon.ico">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="<%=basePath%>/assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="<%=basePath%>/assets/css/amazeui.datatables.min.css"/>
    <link rel="stylesheet" href="<%=basePath%>/assets/css/app.css">
    <script src="<%=basePath%>/assets/js/jquery.min.js"></script>
</head>
<body data-type="login">
<script src="<%=basePath%>/assets/js/theme.js"></script>
<div class="am-g tpl-g">
    <div class="tpl-login">
        <div class="tpl-skiner">
            <div class="tpl-skiner-toggle am-icon-cog">
            </div>
            <div class="tpl-skiner-content">
                <div class="tpl-skiner-content-title">
                    选择主题
                </div>
                <div class="tpl-skiner-content-bar">
                    <span class="skiner-color skiner-white" data-color="theme-white"></span>
                    <span class="skiner-color skiner-black" data-color="theme-black"></span>
                </div>
            </div>
        </div>
        <div class="tpl-login-content">
            <div class="tpl-login-logo">
            </div>
            <form class="am-form tpl-form-line-form" action="" method="post" id="sform">
                <div class="am-form-group">
                    <input type="text" name="userLoginName" class="tpl-form-input" id="user-name"
                           placeholder="请输入账号" data-bind="value:userLoginName">
                    <small class="am-danger" style="color: black"
                           data-bind="visible:!!$root.userNameLable(),text:userNameLable"></small>
                </div>
                <div class="am-form-group">
                    <input type="password" class="tpl-form-input" id="user-pwd"
                           placeholder="请输入密码" name="userPassword" data-bind="value:userPassword">
                    <small class="am-danger" style="color: black"
                           data-bind="visible:!!$root.userPasswordLable(),text:userPasswordLable"></small>
                </div>
                <div class="am-form-group">
                    <button type="button"
                            class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn"
                            data-bind="click:userLogin">提交
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="<%=basePath%>/assets/js/amazeui.min.js"></script>
<script src="<%=basePath%>/assets/js/ko.js"></script>
<script src="<%=basePath%>/app/BasePath.js"></script>
<script src="<%=basePath%>/app/userLogin/UserLogin.js"></script>
<script src="<%=basePath%>/assets/js/app.js"></script>
</body>
</html>
