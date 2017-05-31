<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String IDEAPath = basePath + "IDEA/";
%>
<%@include file="bootstrap.jsp" %>
