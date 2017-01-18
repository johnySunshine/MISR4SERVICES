<%--
  Created by IntelliJ IDEA.
  User: HSH
  Date: 2017/1/18
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${contextPath}/user/login.do" method="post" id="loginFrom">
        <table>
            <tr>
                <td>用户名</td>
                <td><input name="userName" id="userName" type="text"/></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input name="password" id="password" type="password"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="submit"/></td>
            </tr>
        </table>

    </form>
</body>
</html>
