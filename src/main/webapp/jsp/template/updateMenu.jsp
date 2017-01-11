<%--
  Created by IntelliJ IDEA.
  User: Fantasy
  Date: 2017/1/11
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<html>
<head>
    <title>更新菜单</title>
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
                    <strong class="am-text-primary am-text-lg">更新菜单</strong> /
                </div>
            </div>
            <hr>
            <div class="am-tabs am-margin" data-am-tabs>
                <div class="am-tab-panel">
                    <form modelAttribute="account" class="am-form" action="<%=basePath%>Menus/updateMenu" method="POST"
                          id="addMenu">
                        <div class="am-g am-margin-top">
                            <div class="am-u-sm-4 am-u-md-2 am-text-right">
                                菜单ID
                            </div>
                            <div class="am-u-sm-8 am-u-md-4">
                                <input type="text" class="am-input-sm" name="id" value="${menuMain.id}" readonly>
                            </div>
                            <div class="am-hide-sm-only am-u-md-6">*必填，不可重复</div>
                        </div>
                        <div class="am-g am-margin-top">
                            <div class="am-u-sm-4 am-u-md-2 am-text-right">
                                菜单标题
                            </div>
                            <div class="am-u-sm-8 am-u-md-4">
                                <input type="text" class="am-input-sm" name="menuText" value="${menuMain.menuText}">
                            </div>
                            <div class="am-hide-sm-only am-u-md-6">*必填，不可重复</div>
                        </div>

                        <div class="am-g am-margin-top">
                            <div class="am-u-sm-4 am-u-md-2 am-text-right">
                                菜单地址
                            </div>
                            <div class="am-u-sm-8 am-u-md-4 am-u-end col-end">
                                <input type="text" class="am-input-sm" name="menuUrl" value="${menuMain.menuUrl}">
                            </div>
                        </div>

                        <div class="am-g am-margin-top">
                            <div class="am-u-sm-4 am-u-md-2 am-text-right">
                                菜单目标：
                            </div>
                            <div class="am-u-sm-8 am-u-md-4">
                                <input type="text" class="am-input-sm" name="target" value="${menuMain.target}">
                            </div>
                            <div class="am-hide-sm-only am-u-md-6">选填</div>
                        </div>
                        <div class="am-g am-margin-top">
                            <div class="am-u-sm-4 am-u-md-2 am-text-right">
                                属于哪一个主菜单：
                            </div>
                            <div class="am-u-sm-8 am-u-md-10">
                                <select data-am-selected="{btnSize: 'sm'}" name="subid">
                                    <option value="0" ${(menuMain.subid == '0')?'selected' : ''}>默认主菜单</option>
                                    <c:forEach items="${getMenuBySubIdList}" var="menu">
                                        <option value="${menu.id}" ${(menuMain.subid == menu.id)?'selected' : ''}>
                                                ${menu.menuText}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="am-g am-margin-top">
                            <div class="am-u-sm-4 am-u-md-2 am-text-right">
                                显示状态
                            </div>
                            <div class="am-u-sm-8 am-u-md-10">
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
                            <div class="am-u-sm-12 am-u-md-6">默认为显示</div>
                        </div>
                        <button type="submit" class="am-btn am-btn-primary am-btn-xs">提交保存</button>
                        <a type="button" class="am-btn am-btn-primary am-btn-xs"
                           href="<%=basePath%>Menus/getMenuMain">放弃保存</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- content end -->
</div>
</body>
</html>
