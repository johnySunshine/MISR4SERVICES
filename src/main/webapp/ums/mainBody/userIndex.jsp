<!doctype html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <%@include file="../commonJsp/bootstrap.jsp" %>
</head>
<body data-type="userIndex">
<script src="<%=basePath%>ums/assets/js/theme.js"></script>
<div class="am-g tpl-g">
    <%@include file="header.jsp" %>
    <%@include file="changeTheme.jsp" %>
    <%@include file="sliderNavBar.jsp" %>
    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">
        <div class="container-fluid am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-9">
                    <div class="page-header-heading"><span class="am-icon-bars page-header-heading-icon"></span> 用户列表
                    </div>
                    <p class="page-header-description">管理用户</p>
                </div>
                <div class="am-u-lg-3 tpl-index-settings-button">
                    <button type="button" class="page-header-button" data-bind="click:addUser"><span
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
                    <th class="am-text-center">用户登录名</th>
                    <th class="am-text-center">用户名</th>
                    <th class="am-text-center">用户类型</th>
                    <th class="am-text-center">用户角色</th>
                    <th class="am-text-center">用户权限</th>
                    <th class="am-text-center">创建时间</th>
                    <th class="am-text-center">修改时间</th>
                    <th class="am-text-center">操作</th>
                </tr>
                </thead>
                <tbody data-bind="foreach:userList">
                <tr>
                    <th class="am-text-center am-text-middle" data-bind="text:$index()+1"></th>
                    <th class="am-text-center" data-bind="text:$data.id"></th>
                    <th class="am-text-center" data-bind="text:$data.userLoginName"></th>
                    <th class="am-text-center" data-bind="text:$data.userName"></th>
                    <th class="am-text-center" data-bind="text:$data.userType"></th>
                    <th class="am-text-center" data-bind="text:$data.userRoles"></th>
                    <th class="am-text-center" data-bind="text:$data.permissions"></th>
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
        <div class="am-modal-bd" style="color: white" data-bind="text:readyUserTitle"></div>
        <div class="am-modal-footer">
            <span class="am-modal-btn" data-am-modal-cancel>取消</span>
            <span class="am-modal-btn" data-am-modal-confirm>确定</span>
        </div>
    </div>
</div>
<div class="am-modal am-modal-prompt" tabindex="-1" id="menu-prompt">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">用户编辑</div>
        <div class="am-modal-bd">
            <form class="am-form tpl-form-line-form">

                <div class="am-form-group">
                    <label for="menu-title" class="am-u-sm-3 am-form-label">用户登录名 <span
                            class="tpl-form-line-small-title">userLoginName</span></label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" data-bind="value:userLoginName" id="menu-title"
                               placeholder="请输入标题文字">
                        <small style="color:#ebebeb">请填写标题文字10-20字左右。</small>
                    </div>
                </div>

                <div class="am-form-group">
                    <label for="menu-url" class="am-u-sm-3 am-form-label">用户名 <span class="tpl-form-line-small-title">userName</span></label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" data-bind="value:userName" id="menu-url"
                               placeholder="请输入地址文字">
                        <small style="color:#ebebeb">请填写地址文字10-20字左右。</small>
                    </div>
                </div>

                <div class="am-form-group">
                    <label for="menu-target" class="am-u-sm-3 am-form-label">用户密码 <span
                            class="tpl-form-line-small-title">userPassword</span></label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" data-bind="value:userPassword" id="menu-target"
                               placeholder="请输入目标文字">
                        <small style="color:#ebebeb">请填写目标文字10-20字左右。</small>
                    </div>
                </div>

                <div class="am-form-group">
                    <label for="menu-target" class="am-u-sm-3 am-form-label">用户类型 <span
                            class="tpl-form-line-small-title">userType</span></label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" data-bind="value:userType"
                               placeholder="请输入目标文字">
                        <small style="color:#ebebeb">请填写目标文字10-20字左右。</small>
                    </div>
                </div>
                <div class="am-form-group">
                    <label for="menu-target" class="am-u-sm-3 am-form-label">用户权限 <span
                            class="tpl-form-line-small-title">permissions</span></label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" data-bind="value:permissions"
                               placeholder="请输入目标文字">
                        <small style="color:#ebebeb">请填写目标文字10-20字左右。</small>
                    </div>
                </div>

                <div class="am-form-group">
                    <label for="menu-subId" class="am-u-sm-3 am-form-label">用户角色<span
                            class="tpl-form-line-small-title">userRoles</span></label>
                    <div class="am-u-sm-9">
                        <div class="tpl-switch">
                            <select id="menu-subId"
                                    data-bind="value:
                                    userRoles">
                                <option value="admin">管理者</option>
                                <option value="normalUser">普通用户</option>
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
<script src="<%=basePath%>ums/assets/js/amazeui.min.js"></script>
<script src="<%=basePath%>ums/assets/js/amazeui.datatables.min.js"></script>
<script src="<%=basePath%>ums/assets/js/dataTables.responsive.min.js"></script>
<script src="<%=basePath%>ums/assets/js/knockout-3.4.2.js"></script>
<script src="<%=basePath%>ums/assets/js/app.js"></script>
<script src="<%=basePath%>ums/assets/block/UserIndex.js"></script>
</body>
</html>