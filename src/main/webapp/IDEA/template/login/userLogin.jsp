<%--
  Created by IntelliJ IDEA.
  User: Fantasy
  Date: 2017/2/5
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../commonJsp/tag.jsp" %>
<!doctype html>
<html>
<head>
    <title>用户登录</title>
    <%@include file="../../commonJsp/head.jsp" %>
</head>
<body data-type="login">
<script src="<%=IDEAPath%>assets/js/theme.js"></script>
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
            <div class="tpl-login-logo">

            </div>

            <form class="am-form tpl-form-line-form">
                <div class="am-form-group">
                    <input type="text" class="tpl-form-input" id="user-name" placeholder="请输入账号">

                </div>

                <div class="am-form-group">
                    <input type="password" class="tpl-form-input" id="user-pwd" placeholder="请输入密码">

                </div>
                <div class="am-form-group tpl-login-remember-me">
                    <input id="remember-me" type="checkbox">
                    <label for="remember-me">

                        记住密码
                    </label>

                </div>

                <div class="am-form-group">

                    <button type="button"
                            class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn">提交
                    </button>

                </div>
            </form>
        </div>
    </div>
</div>
<script src="<%=IDEAPath%>assets/js/amazeui.min.js"></script>
<script src="<%=IDEAPath%>assets/js/app.js"></script>
</body>
</html>
