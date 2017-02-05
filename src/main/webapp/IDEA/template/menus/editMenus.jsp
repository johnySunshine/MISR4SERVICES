<%--
  Created by IntelliJ IDEA.
  User: Fantasy
  Date: 2017/2/5
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../commonJsp/tag.jsp" %>
<!doctype html>
<html>
<head>
    <title>编辑菜单</title>
    <%@include file="../../commonJsp/head.jsp" %>
</head>
<body>
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
                        修改菜单
                        <small>M-STREAM</small>
                    </div>
                    <p class="page-header-description">此处添加菜单</p>
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

                            <form class="am-form tpl-form-line-form" action="<%=basePath%>Menus/updateMenu" method="POST">
                                <div class="am-form-group">
                                    <label for="user-id" class="am-u-sm-3 am-form-label">菜单标题 <span
                                            class="tpl-form-line-small-title">Menu Title</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" class="tpl-form-input" id="user-id" name="id"
                                               placeholder="请输入标题文字" value="${menuMain.id}" readonly>
                                        <small>请填写标题文字10-20字左右。</small>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">菜单标题 <span
                                            class="tpl-form-line-small-title">Menu Title</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" class="tpl-form-input" id="user-name" name="menuText"
                                               placeholder="请输入标题文字" value="${menuMain.menuText}">
                                        <small>请填写标题文字10-20字左右。</small>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="menuUrl" class="am-u-sm-3 am-form-label">菜单地址 <span
                                            class="tpl-form-line-small-title">Menu Path</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" id="menuUrl" class="am-form-field tpl-form-no-bg"
                                               name="menuUrl" placeholder="请输入菜单地址" value="${menuMain.menuUrl}">
                                        <small>菜单地址</small>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="menu-target" class="am-u-sm-3 am-form-label">菜单目标 <span
                                            class="tpl-form-line-small-title">Menu target</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" id="menu-target" class="am-form-field tpl-form-no-bg"
                                               name="target" placeholder="请输入菜单目标" value="${menuMain.target}">
                                        <small>菜单目标</small>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="menu-main" class="am-u-sm-3 am-form-label">属于哪一个主菜单 <span
                                            class="tpl-form-line-small-title">is belong to menu</span></label>
                                    <div class="am-u-sm-9">
                                        <select data-am-selected="{searchBox: 1}" name="subid" style="display: none;"
                                                id="menu-main">
                                            <option value="0" ${(menuMain.subid == '0')?'selected' : ''}>默认主菜单</option>
                                            <c:forEach items="${getMenuBySubIdList}" var="menu">
                                                <option value="${menu.id}" ${(menuMain.subid == menu.id)?'selected' : ''}>
                                                        ${menu.menuText}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label class="am-u-sm-3 am-form-label">显示状态 <span
                                            class="tpl-form-line-small-title">Menu status</span></label>
                                    <div class="am-u-sm-9">
                                        <div class="am-btn-group" data-am-button>
                                            <label class="am-btn am-btn-default am-btn-xs">
                                                <input type="radio" name="hubIsVisible" value="show"
                                                ${(menuMain.hubIsVisible=='show')?'checked' : ''}> 显示
                                            </label>
                                            <label class="am-btn am-btn-default am-btn-xs">
                                                <input type="radio" name="hubIsVisible" value="hidden"
                                                ${(menuMain.hubIsVisible=='hidden')?'checked' : ''}> 隐藏
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <button type="submit" class="am-btn am-btn-primary am-btn-xs">提交保存</button>
                                <a type="button" class="am-btn am-btn-primary am-btn-xs"
                                   href="<%=basePath%>Menus/getMenuMain">放弃保存</a>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
