<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>用户注册</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="<%=basePath%>/assets/i/favicon.ico">
    <link rel="apple-touch-icon-precomposed" href="<%=basePath%>/assets/i/favicon.ico">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="<%=basePath%>/assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="<%=basePath%>/assets/css/amazeui.datatables.min.css"/>
    <link rel="stylesheet" href="<%=basePath%>/assets/css/app.css">
    <script src="<%=basePath%>/assets/js/jquery.min.js"></script>

</head>

<body data-type="SignUp">
<script src="<%=basePath%>/assets/js/theme.js"></script>
<div class="am-g tpl-g">
    <!-- 风格切换 -->
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
    <div class="tpl-login">
        <div class="tpl-login-content">
            <div class="tpl-login-title">注册用户</div>
            <span class="tpl-login-content-info">
                  创建一个新的用户
              </span>
            <form class="am-form tpl-form-line-form">
                <div class="am-form-group">
                    <input type="text" class="tpl-form-input" data-bind="value:userName" placeholder="用户名">
                </div>
                <div class="am-form-group">
                    <input type="text" class="tpl-form-input" data-bind="value:userLoginName" placeholder="用户登录名">
                </div>
                <div class="am-form-group">
                    <input type="password" data-bind="value:password,valueUpdate: 'afterkeydown'" class="tpl-form-input"
                           placeholder="请输入密码">
                    <span>
                        密码强度
                    </span>
                    <span style="display: inline-block;width: 10px;height: 10px"
                          data-bind="style:{backgroundColor:Lcolor}"> </span>
                    <span style="display: inline-block;width: 10px;height: 10px"
                          data-bind="style:{backgroundColor:Mcolor}"> </span>
                    <span style="display: inline-block;width: 10px;height: 10px"
                          data-bind="style:{backgroundColor:Hcolor}"> </span>
                </div>
                <div class="am-form-group">
                    <input type="password" data-bind="value:reCheckPassword,valueUpdate: 'afterkeydown'"
                           class="tpl-form-input"
                           placeholder="再次输入密码">
                    <span data-bind="visible:checkPassword">
                        密码不一致
                    </span>
                </div>
                <div class="am-form-group">
                    <button type="button"
                            class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn"
                            data-bind="click:registerSubmit">提交
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="<%=basePath%>/assets/js/amazeui.min.js"></script>
<script src="<%=basePath%>/assets/js/lodash.js"></script>
<script src="<%=basePath%>/assets/js/ko.js"></script>
<script src="<%=basePath%>/app/signUp/SignUp.js"></script>
<script src="<%=basePath%>/assets/js/app.js"></script>
</body>
</html>
