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
                            <a href="javascript:;" id="doc-confirm-toggle">
                                <i class="am-icon-pencil"></i> 编辑
                            </a>
                            <a href="javascript:;" class="tpl-table-black-operation-del">
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
<div class="am-modal am-modal-confirm" tabindex="-1" id="my-confirm">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">Amaze UI</div>
        <div class="am-modal-bd">
            你，确定要删除这条记录吗？
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
