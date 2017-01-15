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
    <div class="admin-content">
        <div class="admin-content-body">
            <div class="am-cf am-padding am-padding-bottom-0">
                <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">配置表格</strong> /
                    <small>MenuTable</small>
                </div>
            </div>
            <hr>
            <div class="am-g">
                <div class="am-u-sm-12 am-u-md-6">
                    <div class="am-btn-toolbar">
                        <div class="am-btn-group am-btn-group-xs">
                            <a type="button" class="am-btn am-btn-default"
                               href="<%=basePath%>CustomConfig/addCusConfigPage"><span
                                    class="am-icon-plus"></span>
                                新增
                            </a>
                            <a type="button" class="am-btn am-btn-default" href="#">
                                <span class="am-icon-save"></span>
                                刷新
                            </a>
                            <div class="am-badge am-badge-warning am-text-lg">状态信息：${code_msg}</div>
                        </div>
                    </div>
                </div>
                <div class="am-u-sm-12 am-u-md-3">
                    <div class="am-form-group">
                        <select data-am-selected="{btnSize: 'sm'}">
                            <option value="option1" selected="selected">用户类型</option>
                            <option value="option2">IT业界</option>
                            <option value="option3">数码产品</option>
                            <option value="option3">笔记本电脑</option>
                            <option value="option3">平板电脑</option>
                            <option value="option3">只能手机</option>
                            <option value="option3">超极本</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="am-g">
                <div class="am-u-sm-12">
                    <form class="am-form">
                        <table class="am-table am-table-striped am-table-hover table-main">
                            <thead>
                            <tr>
                                <th class="table-check"><input type="checkbox"/></th>
                                <th class="table-id">ID</th>
                                <th class="table-title">配置KEY</th>
                                <th class="table-type">配置value</th>
                                <th class="table-title">用户类型</th>
                                <th class="table-set">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${getConfigListById}" var="cusConfig">
                                <tr>
                                    <td><input type="checkbox"/></td>
                                    <td>${cusConfig.id}</td>
                                    <td>${cusConfig.key}</td>
                                    <td>${cusConfig.value}</td>
                                    <td>${cusConfig.userType}</td>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <a class="am-btn am-btn-default am-btn-xs am-text-secondary"
                                                   href="<%=basePath%>CustomConfig/updateCusConfigPage?configId=${cusConfig.id}"><span
                                                        class="am-icon-pencil-square-o"></span> 编辑
                                                </a>
                                                <a class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"
                                                   href="<%=basePath%>CustomConfig/DelConfigById?t=${cusConfig.id}">
                                                    <span class="am-icon-trash-o"></span>
                                                    删除
                                                </a>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="am-cf">
                            共 ${getConfigListById.size()}条记录
                        </div>
                        <hr/>
                        <p>注：通用配置项</p>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
