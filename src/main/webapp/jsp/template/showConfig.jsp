<%--
  Created by IntelliJ IDEA.
  User: Fantasy
  Date: 2017/1/15
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<html>
<head>
    <title>配置显示</title>
    <%@include file="../common/head.jsp" %>
</head>
<body>
<%@include file="header.jsp" %>
<div class="am-cf admin-main">
    <%@include file="controlPanel.jsp" %>
    <c:forEach items="${getConfigListById}" var="config">
        <div>${config.userType}</div>
    </c:forEach>
</div>
</body>
</html>
