<%--
  Created by IntelliJ IDEA.
  User: Fantasy
  Date: 2017/1/9
  Time: 0:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<html>
<head>
    <title>显示所有的菜单</title>
    <%@include file="../common/head.jsp" %>
</head>
<body>
<div class="container">
    <ul>
        <!-- JSPL ‘标签’-->
        <c:forEach items="${menuMainList}" var="menu">
            <li>${menu.id}</li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
