<%--
  Created by IntelliJ IDEA.
  User: Fantasy
  Date: 2017/1/15
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<html>
<head>
    <title>更新配置项</title>
    <%@include file="../common/head.jsp" %>
</head>
<body>
<%@include file="header.jsp" %>
<div class="am-cf admin-main">
    <%@include file="controlPanel.jsp" %>
    <!-- content start -->
    <div class="admin-content">
        <div class="admin-content-body">
            <div class="am-cf am-padding am-padding-bottom-0">
                <div class="am-fl am-cf">
                    <strong class="am-text-primary am-text-lg">更新配置项</strong> /
                </div>
            </div>
            <hr>
            <div class="am-tabs am-margin" data-am-tabs>
                <div class="am-tab-panel">
                    <form modelAttribute="account" class="am-form" action="<%=basePath%>CustomConfig/UpdateConfig"
                          method="POST"
                          id="addMenu">
                        <div class="am-g am-margin-top">
                            <div class="am-u-sm-4 am-u-md-2 am-text-right">
                                菜单ID
                            </div>
                            <div class="am-u-sm-8 am-u-md-4">
                                <input type="text" class="am-input-sm" name="id" value="${cusConfig.id}" readonly>
                            </div>
                            <div class="am-hide-sm-only am-u-md-6">*必填，不可重复</div>
                        </div>
                        <div class="am-g am-margin-top">
                            <div class="am-u-sm-4 am-u-md-2 am-text-right">
                                配置项的key
                            </div>
                            <div class="am-u-sm-8 am-u-md-4">
                                <input type="text" class="am-input-sm" name="key" value="${cusConfig.key}">
                            </div>
                            <div class="am-hide-sm-only am-u-md-6">*必填，不可重复</div>
                        </div>

                        <div class="am-g am-margin-top">
                            <div class="am-u-sm-4 am-u-md-2 am-text-right">
                                配置项的value
                            </div>
                            <div class="am-u-sm-8 am-u-md-4 am-u-end col-end">
                                <input type="text" class="am-input-sm" name="value" value="${cusConfig.value}">
                            </div>
                        </div>
                        <div class="am-g am-margin-top">
                            <div class="am-u-sm-4 am-u-md-2 am-text-right">
                                属于哪一个主菜单：
                            </div>
                            <div class="am-u-sm-8 am-u-md-10">
                                <select data-am-selected="{btnSize: 'sm'}" name="userType">
                                    <c:forEach items="${allConfigList}" var="config">
                                        <option value="${config.id}" ${(cusConfig.userType == config.userType)?'selected' : ''}>
                                                ${config.userType}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <button type="submit" class="am-btn am-btn-primary am-btn-xs">提交保存</button>
                        <a type="button" class="am-btn am-btn-primary am-btn-xs"
                           href="<%=basePath%>CustomConfig/getAllCusConfig">放弃保存</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- content end -->
</div>
</body>
</html>
