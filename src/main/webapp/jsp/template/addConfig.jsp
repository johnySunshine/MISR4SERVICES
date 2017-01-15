<%--
  Created by IntelliJ IDEA.
  User: Fantasy
  Date: 2017/1/15
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<html>
<head>
    <title>添加数据</title>
    <%@include file="../common/head.jsp" %>
</head>
<body>
<%@include file="header.jsp" %>
<!-- content start -->
<div class="am-cf admin-main">
    <%@include file="controlPanel.jsp" %>
    <div class="admin-content">
        <div class="admin-content-body">
            <div class="am-cf am-padding am-padding-bottom-0">
                <div class="am-fl am-cf">
                    <strong class="am-text-primary am-text-lg">新增配置项</strong> /
                </div>
            </div>
            <hr>
            <div class="am-tabs am-margin" data-am-tabs>
                <div class="am-tab-panel">
                    <form modelAttribute="account" class="am-form" action="<%=basePath%>CustomConfig/addCusConfig"
                          method="POST"
                          id="addMenu">
                        <div class="am-g am-margin-top">
                            <div class="am-u-sm-4 am-u-md-2 am-text-right">
                                配置的KEY值
                            </div>
                            <div class="am-u-sm-8 am-u-md-4">
                                <input type="text" class="am-input-sm" name="key">
                            </div>
                            <div class="am-hide-sm-only am-u-md-6">*必填，不可重复</div>
                        </div>

                        <div class="am-g am-margin-top">
                            <div class="am-u-sm-4 am-u-md-2 am-text-right">
                                配置的Value值
                            </div>
                            <div class="am-u-sm-8 am-u-md-4 am-u-end col-end">
                                <input type="text" class="am-input-sm" name="value">
                            </div>
                        </div>

                        <div class="am-g am-margin-top">
                            <div class="am-u-sm-4 am-u-md-2 am-text-right">
                                用户类型：
                            </div>
                            <div class="am-u-sm-8 am-u-md-10">
                                <select data-am-selected="{btnSize: 'sm'}" name="userType">
                                    <option value="0" selected="selected">默认主菜单</option>
                                    <c:forEach items="${allConfigList}" var="config">
                                        <option value="${config.userType}">${config.userType}</option>
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
</div>
<!-- content end -->
</body>
</html>
