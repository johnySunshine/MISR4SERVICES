<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commonJsp/tag.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <%@include file="../commonJsp/bootstrap.jsp" %>
</head>
<body>
<script src="<%=basePath%>ums/assets/js/theme.js"></script>
<script src="<%=basePath%>ums/assets/js/app.js"></script>
<div class="am-g tpl-g animated fadeInRight">
    <div class="tpl-login">
        <div class="tpl-login-content">
            <div class="tpl-login-logo">

            </div>

            <form class="am-form tpl-form-line-form" action="<%=basePath%>Users/login" method="post" id="sform">
                <div class="am-form-group">
                    <input type="text" name="userLoginName" class="tpl-form-input" id="user-name"
                           placeholder="请输入账号">
                </div>

                <div class="am-form-group">
                    <input type="password" class="tpl-form-input" id="user-pwd"
                           placeholder="请输入密码" name="userPassword">
                </div>
                <div class="am-form-group tpl-login-remember-me">
                    <c:if test="${error_msg!=null}">
                        <label for="remember-me">
                                ${error_msg}
                        </label>
                    </c:if>
                </div>
                <div class="am-form-group tpl-login-remember-me">
                    <input id="remember-me" type="checkbox">
                    <label for="remember-me">
                        记住密码
                    </label>
                </div>
                <div class="am-form-group">
                    <button type="submit"
                            class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn">提交
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>