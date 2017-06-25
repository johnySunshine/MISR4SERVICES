<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <%@include file="../commonJsp/head.jsp" %>
</head>
<body data-type="customIndex">
<script src="<%=IDEAPath%>assets/js/theme.js"></script>
<div class="am-g tpl-g">
    <%@include file="./header.jsp" %>
    <%@include file="./changeTheme.jsp" %>
    <%@include file="./sliderNavBar.jsp" %>
    <div class="tpl-content-wrapper">
        <div class="container-fluid am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-9">
                    <div class="page-header-heading"><span class="am-icon-bars page-header-heading-icon"></span> 通用模块
                    </div>
                    <p class="page-header-description">管理通用模块</p>
                </div>
                <div class="am-u-lg-3 tpl-index-settings-button">
                    <button type="button" class="page-header-button" data-bind="click:addConfig"><span
                            class="am-icon-paint-brush"></span>新增
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
                    <th class="am-text-center">配置项的key</th>
                    <th class="am-text-center">配置项的value</th>
                    <th class="am-text-center">配置项描述</th>
                    <th class="am-text-center">创建时间</th>
                    <th class="am-text-center">修改时间</th>
                    <th class="am-text-center">操作</th>
                </tr>
                </thead>
                <tbody data-bind="foreach:configList">
                <tr>
                    <th class="am-text-center am-text-middle" data-bind="text:$index()+1"></th>
                    <th class="am-text-center" data-bind="text:$data.id"></th>
                    <th class="am-text-center" data-bind="text:$data.configKey"></th>
                    <th class="am-text-center" data-bind="text:$data.configValue"></th>
                    <th class="am-text-center" data-bind="text:$data.configDesc"></th>
                    <th class="am-text-center" data-bind="text:$data.gmtCreate">创建时间</th>
                    <th class="am-text-center" data-bind="text:$data.gmtModified">修改时间</th>
                    <th class="am-text-center">
                        <div class="tpl-table-black-operation">
                            <a href="javascript:;" id="doc-confirm-toggle" data-bind="click:$root.editConfig">
                                <i class="am-icon-pencil"></i> 编辑
                            </a>
                            <a href="javascript:;" class="tpl-table-black-operation-del"
                               data-bind="click:$root.removeConfig">
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
<div id="menu-alert" class="am-modal am-modal-alert" tabindex="-1">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">状态!!</div>
        <div class="am-modal-bd" data-bind="text:updateStatus" style="color: white">
        </div>
        <div class="am-modal-footer">
            <span class="am-modal-btn">确定</span>
        </div>
    </div>
</div>
<div class="am-modal am-modal-prompt" tabindex="-1" id="menu-delete">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">是否删除？</div>
        <div class="am-modal-bd" style="color: white" data-bind="text:readyConfigKey"></div>
        <div class="am-modal-footer">
            <span class="am-modal-btn" data-am-modal-cancel>取消</span>
            <span class="am-modal-btn" data-am-modal-confirm>确定</span>
        </div>
    </div>
</div>
<div class="am-modal am-modal-prompt" tabindex="-1" id="menu-prompt">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">配置</div>
        <div class="am-modal-bd">
            <form class="am-form tpl-form-line-form">

                <div class="am-form-group">
                    <label for="menu-title" class="am-u-sm-3 am-form-label">配置config <span
                            class="tpl-form-line-small-title">Title</span></label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" data-bind="value:configKey" id="menu-title"
                               placeholder="请输入标题文字">
                        <small style="color:#ebebeb">请填写标题文字10-20字左右。</small>
                    </div>
                </div>

                <div class="am-form-group">
                    <label for="menu-url" class="am-u-sm-3 am-form-label">配置value <span class="tpl-form-line-small-title">url</span></label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" data-bind="value:configValue" id="menu-url"
                               placeholder="请输入地址文字">
                        <small style="color:#ebebeb">请填写地址文字10-20字左右。</small>
                    </div>
                </div>

                <div class="am-form-group">
                    <label for="menu-target" class="am-u-sm-3 am-form-label">配置描述 <span
                            class="tpl-form-line-small-title">target</span></label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" data-bind="value:configDesc" id="menu-target"
                               placeholder="请输入目标文字">
                        <small style="color:#ebebeb">请填写目标文字10-20字左右。</small>
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
<script src="<%=IDEAPath%>assets/block/customConfig.js"></script>
<script src="<%=IDEAPath%>assets/js/app.js"></script>
</body>
</html>
