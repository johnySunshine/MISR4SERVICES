<!doctype html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <%@include file="commonJsp/head.jsp" %>
</head>
<body data-type="index">
<script src="<%=IDEAPath%>assets/js/theme.js"></script>
<div class="am-g tpl-g">
    <%@include file="template/header.jsp" %>
    <%@include file="template/changeTheme.jsp" %>
    <%@include file="template/sliderNavBar.jsp" %>
    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">
        <div class="container-fluid am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-9">
                    <div class="page-header-heading"><span class="am-icon-bars page-header-heading-icon"></span> 菜单列表
                    </div>
                    <p class="page-header-description">管理菜单模块: subID 为0主菜单</p>
                </div>
                <div class="am-u-lg-3 tpl-index-settings-button">
                    <button type="button" class="page-header-button"><span class="am-icon-paint-brush"></span> 设置
                    </button>
                </div>
            </div>
        </div>
        <div class="row-content am-cf">
            <table id="example-r"
                   class="am-table am-table-compact am-table-bordered am-table-radius am-table-striped tpl-table-black ">
                <thead>
                <tr>
                    <th class="am-text-center am-text-middle ">序号</th>
                    <th class="am-text-center">id</th>
                    <th class="am-text-center">subId</th>
                    <th class="am-text-center">菜单标题</th>
                    <th class="am-text-center">菜单地址</th>
                    <th class="am-text-center">菜单目标</th>
                    <th class="am-text-center">菜单显示状态</th>
                    <th class="am-text-center">创建时间</th>
                    <th class="am-text-center">修改时间</th>
                    <th class="am-text-center">操作</th>
                </tr>
                </thead>
                <tbody data-bind="foreach:menuList">
                <tr>
                    <th class="am-text-center am-text-middle" data-bind="text:$index()+1"></th>
                    <th class="am-text-center" data-bind="text:$data.id"></th>
                    <th class="am-text-center" data-bind="text:$data.menuSubId"></th>
                    <th class="am-text-center" data-bind="text:$data.menuTitle"></th>
                    <th class="am-text-center" data-bind="text:$data.menuUrl"></th>
                    <th class="am-text-center" data-bind="text:$data.menuTarget"></th>
                    <th class="am-text-center" data-bind="text:$data.menuVisible"></th>
                    <th class="am-text-center" data-bind="text:$data.gmtCreate">创建时间</th>
                    <th class="am-text-center" data-bind="text:$data.gmtModified">修改时间</th>
                    <th class="am-text-center">
                        <div class="tpl-table-black-operation">
                            <a href="javascript:;" id="doc-confirm-toggle" data-bind="click:$root.editMenu">
                                <i class="am-icon-pencil"></i> 编辑
                            </a>
                            <a href="javascript:;" class="tpl-table-black-operation-del"
                               data-bind="click:$root.removeMenu">
                                <i class="am-icon-trash"></i> 删除
                            </a>
                        </div>
                    </th>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="am-modal am-modal-prompt" tabindex="-1" id="menu-prompt">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">菜单编辑</div>
        <div class="am-modal-bd">
            <form class="am-form tpl-form-line-form">

                <div class="am-form-group">
                    <label for="menu-title" class="am-u-sm-3 am-form-label">菜单标题 <span
                            class="tpl-form-line-small-title">Title</span></label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" data-bind="value:menuTitle" id="menu-title"
                               placeholder="请输入标题文字">
                        <small style="color:#ebebeb">请填写标题文字10-20字左右。</small>
                    </div>
                </div>

                <div class="am-form-group">
                    <label for="menu-url" class="am-u-sm-3 am-form-label">菜单地址 <span class="tpl-form-line-small-title">url</span></label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" data-bind="value:menuUrl" id="menu-url"
                               placeholder="请输入地址文字">
                        <small style="color:#ebebeb">请填写地址文字10-20字左右。</small>
                    </div>
                </div>

                <div class="am-form-group">
                    <label for="menu-target" class="am-u-sm-3 am-form-label">菜单目标 <span
                            class="tpl-form-line-small-title">target</span></label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" data-bind="value:menuTarget" id="menu-target"
                               placeholder="请输入目标文字">
                        <small style="color:#ebebeb">请填写目标文字10-20字左右。</small>
                    </div>
                </div>

                <div class="am-form-group">
                    <label for="menu-visible" class="am-u-sm-3 am-form-label">显示隐藏<span
                            class="tpl-form-line-small-title">visible</span></label>
                    <div class="am-u-sm-9">
                        <div class="tpl-switch">
                            <input id="menu-visible" data-bind="checked:menuVisible" type="checkbox"
                                   class="ios-switch bigswitch tpl-switch-btn" style="position:absolute;
                                   opacity: 0;width: 100%;height: 20px;left: 0">
                            <div class="tpl-switch-btn-view">
                                <div></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="am-form-group">
                    <label for="menu-subId" class="am-u-sm-3 am-form-label">子菜单ID<span
                            class="tpl-form-line-small-title">visible</span></label>
                    <div class="am-u-sm-9">
                        <div class="tpl-switch" data-bind="attr:{'id':$root.menuSubId()}">
                            <select id="menu-subId"
                                    data-bind="value:$root.menuSubId(),
                                    options:menuList,
                                    optionsText: 'menuTitle',
                                    optionsValue: 'id',
                                    optionsCaption:'主菜单'
                                    ">
                            </select>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <div class="am-modal-footer">
            <span class="am-modal-btn" data-am-modal-cancel>取消</span>
            <span class="am-modal-btn" data-am-modal-confirm>确定</span>
        </div>
    </div>
</div>
<script src="<%=IDEAPath%>assets/js/amazeui.min.js"></script>
<script src="<%=IDEAPath%>assets/js/amazeui.datatables.min.js"></script>
<script src="<%=IDEAPath%>assets/js/dataTables.responsive.min.js"></script>
<script src="<%=IDEAPath%>assets/js/knockout-3.4.2.js"></script>
<script src="<%=IDEAPath%>assets/js/app.js"></script>

</body>
</html>
