<%--
  Created by IntelliJ IDEA.
  User: Fantasy
  Date: 2017/2/5
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../commonJsp/tag.jsp" %>
<!doctype html>
<html>
<head>
    <title>添加配置</title>
    <%@include file="../../commonJsp/head.jsp" %>
</head>
<body data-type="widgets">
<script src="<%=IDEAPath%>assets/js/theme.js"></script>
<div class="am-g tpl-g">
    <%@include file="../header.jsp" %>
    <%@include file="../changeTheme.jsp" %>
    <%@include file="../sliderNavBar.jsp" %>
    <div class="tpl-content-wrapper">
        <div class="container-fluid am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-9">
                    <div class="page-header-heading"><span class="am-icon-th-large page-header-heading-icon"></span>
                        添加通用配置
                        <small>M-STREAM</small>
                    </div>
                    <p class="page-header-description">添加通用配置</p>
                </div>
            </div>
        </div>
        <div class="row-content am-cf">
            <div class="row">

                <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title am-fl">线条表单</div>
                            <div class="widget-function am-fr">
                                <a href="javascript:;" class="am-icon-cog"></a>
                            </div>
                        </div>
                        <div class="widget-body am-fr">

                            <form class="am-form tpl-form-line-form" action="<%=basePath%>CustomConfig/addCusConfig"
                                  method="POST">
                                <div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">配置的KEY值 <span
                                            class="tpl-form-line-small-title">KEY</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" class="tpl-form-input" id="user-name" name="key"
                                               placeholder="请输入KEY">
                                        <small>请输入KEY大写字母。</small>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="menuUrl" class="am-u-sm-3 am-form-label">配置的Value值 <span
                                            class="tpl-form-line-small-title">Value</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" id="menuUrl" class="am-form-field tpl-form-no-bg"
                                               name="value" placeholder="请输入Value值">
                                        <small>Value值</small>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="user-type" class="am-u-sm-3 am-form-label">用户类型 <span
                                            class="tpl-form-line-small-title">Menu target</span></label>
                                    <div class="am-u-sm-9">
                                        <select data-am-selected="{btnSize: 'sm'}" name="userType" id="user-type">
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
    </div>
</div>
<script src="<%=IDEAPath%>assets/js/amazeui.min.js"></script>
<script src="<%=IDEAPath%>assets/js/amazeui.datatables.min.js"></script>
<script src="<%=IDEAPath%>assets/js/dataTables.responsive.min.js"></script>
<script src="<%=IDEAPath%>assets/js/app.js"></script>
</body>
</html>