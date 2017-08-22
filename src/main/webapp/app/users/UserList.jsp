<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>用户管理列表</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="<%=basePath%>/assets/i/favicon.ico">
    <link rel="apple-touch-icon-precomposed" href="<%=basePath%>/assets/i/favicon.ico">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="<%=basePath%>/assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="<%=basePath%>/assets/css/amazeui.datatables.min.css"/>
    <link rel="stylesheet" href="<%=basePath%>/assets/css/app.css">
    <link rel="stylesheet" href="<%=basePath%>/app/all.css">
    <script src="<%=basePath%>/assets/js/jquery.min.js"></script>

</head>

<body data-type="userList">
<script src="<%=basePath%>/assets/js/theme.js"></script>
<div class="am-g tpl-g menus-block">
    <!-- 头部 -->
    <%@include file="../header.jsp" %>
    <!-- 风格切换 -->
    <div class="tpl-skiner">
        <div class="tpl-skiner-toggle am-icon-cog">
        </div>
        <div class="tpl-skiner-content">
            <div class="tpl-skiner-content-title">
                选择主题
            </div>
            <div class="tpl-skiner-content-bar">
                <span class="skiner-color skiner-white" data-color="theme-white"></span>
                <span class="skiner-color skiner-black" data-color="theme-black"></span>
            </div>
        </div>
    </div>
    <!-- 侧边导航栏 -->
    <div class="left-sidebar">
        <!-- 用户信息 -->
        <div class="tpl-sidebar-user-panel">
            <div class="tpl-user-panel-slide-toggleable">
                <div class="tpl-user-panel-profile-picture">
                    <img src="<%=basePath%>/assets/img/user04.png" alt="">
                </div>
                <span class="user-panel-logged-in-text">
              <i class="am-icon-circle-o am-text-success tpl-user-panel-status-icon"></i>
              禁言小张
          </span>
                <a href="javascript:;" class="tpl-user-panel-action-link"> <span class="am-icon-pencil"></span> 账号设置</a>
            </div>
        </div>

        <!-- 菜单 -->
        <ul class="sidebar-nav">
            <li class="sidebar-nav-heading">Components <span class="sidebar-nav-heading-info"> 附加组件</span></li>
            <li class="sidebar-nav-link">
                <a href="index.html">
                    <i class="am-icon-home sidebar-nav-link-logo"></i> 首页
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="tables.html">
                    <i class="am-icon-table sidebar-nav-link-logo"></i> 表格
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="calendar.html">
                    <i class="am-icon-calendar sidebar-nav-link-logo"></i> 日历
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="form.html">
                    <i class="am-icon-wpforms sidebar-nav-link-logo"></i> 表单

                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="chart.html">
                    <i class="am-icon-bar-chart sidebar-nav-link-logo"></i> 图表

                </a>
            </li>

            <li class="sidebar-nav-heading">Datas<span class="sidebar-nav-heading-info"> 常用数据管理</span></li>
            <li class="sidebar-nav-link">
                <a href="javascript:;" class="sidebar-nav-sub-title active">
                    <i class="am-icon-table sidebar-nav-link-logo"></i> 数据列表
                    <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico sidebar-nav-sub-ico-rotate"></span>
                </a>
                <ul class="sidebar-nav sidebar-nav-sub" style="display: block;">
                    <li class="sidebar-nav-link">
                        <a href="<%=basePath%>/app/menus/Menus.jsp">
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 用户菜单管理
                        </a>
                    </li>

                    <li class="sidebar-nav-link">
                        <a href="<%=basePath%>/app/users/UserList.jsp" class="sub-active">
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 用户管理
                        </a>
                    </li>
                </ul>
            </li>
            <li class="sidebar-nav-link">
                <a href="sign-up.html">
                    <i class="am-icon-clone sidebar-nav-link-logo"></i> 注册
                    <span class="am-badge am-badge-secondary sidebar-nav-link-logo-ico am-round am-fr am-margin-right-sm">6</span>
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="login.html">
                    <i class="am-icon-key sidebar-nav-link-logo"></i> 登录
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="404.html">
                    <i class="am-icon-tv sidebar-nav-link-logo"></i> 404错误
                </a>
            </li>

        </ul>
    </div>


    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">
        <div class="row-content am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title  am-cf">用户列表管理</div>
                        </div>
                        <div class="widget-body  am-fr">

                            <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                                <div class="am-form-group">
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs">
                                            <button type="button" class="am-btn am-btn-default am-btn-success"
                                                    data-bind="click:addUsers"><span
                                                    class="am-icon-plus"></span> 新增
                                            </button>
                                            <button type="button" class="am-btn am-btn-default am-btn-secondary"
                                                    data-bind="click:reFreshTable"><span
                                                    class="am-icon-save"></span> 刷新
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="am-u-sm-12">
                                <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black "
                                       id="example-r">
                                    <thead>
                                    <tr>
                                        <th class="am-text-center">序号</th>
                                        <th class="am-text-center">id</th>
                                        <th class="am-text-center">用户名</th>
                                        <th class="am-text-center">用户登录名</th>
                                        <th class="am-text-center">用户权限</th>
                                        <th class="am-text-center">用户角色</th>
                                        <th class="am-text-center">用户类别</th>
                                        <th class="am-text-center">创建时间</th>
                                        <th class="am-text-center">修改时间</th>
                                        <th class="am-text-center">操作</th>
                                    </tr>
                                    </thead>
                                    <tbody data-bind="foreach:userList">
                                    <tr class="gradeX">
                                        <td class="am-text-center" data-bind="text:$index()+1"></td>
                                        <td class="am-text-center" data-bind="text:$data.id"></td>
                                        <td class="am-text-center" data-bind="text:$data.userName"></td>
                                        <td class="am-text-center" data-bind="text:$data.userLoginName"></td>
                                        <td class="am-text-center" data-bind="text:$data.permissions"></td>
                                        <td class="am-text-center" data-bind="text:$data.userRoles"></td>
                                        <td class="am-text-center" data-bind="text:$data.userType"></td>
                                        <td class="am-text-center" data-bind="text:$data.gmtCreate"></td>
                                        <td class="am-text-center" data-bind="text:$data.gmtModified"></td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a href="javascript:;"
                                                   data-bind="click:$root.editUser"
                                                >
                                                    <i class="am-icon-pencil"></i> 编辑
                                                </a>
                                                <a href="javascript:;" class="tpl-table-black-operation-del"
                                                   data-bind="click:$root.removeUser">
                                                    <i class="am-icon-trash"></i> 删除
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                    <!-- more data -->
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<div id="menu-alert" class="am-modal am-modal-alert" tabindex="-1">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">状态!!</div>
        <div class="am-modal-bd" data-bind="text:updateStatus">
        </div>
        <div class="am-modal-footer">
            <span class="am-modal-btn">确定</span>
        </div>
    </div>
</div>
<div class="am-modal am-modal-prompt" tabindex="-1" id="menu-delete">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">是否删除？</div>
        <div class="am-modal-bd" data-bind="text:readyMenuTitle"></div>
        <div class="am-modal-footer">
            <span class="am-modal-btn" data-am-modal-cancel>取消</span>
            <span class="am-modal-btn" data-am-modal-confirm>确定</span>
        </div>
    </div>
</div>
<div class="am-modal am-modal-prompt" tabindex="-1" id="menu-prompt">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">用户编辑编辑</div>
        <div class="am-modal-bd">
            <form class="am-form tpl-form-line-form">

                <div class="am-form-group">
                    <label for="menu-title" class="am-u-sm-3 am-form-label">用户名 <span
                            class="tpl-form-line-small-title">userName</span></label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" data-bind="value:userName" id="menu-title"
                               placeholder="请输入用户名">
                        <small>请填写用户名文字10-20字左右。</small>
                    </div>
                </div>

                <div class="am-form-group">
                    <label for="menu-url" class="am-u-sm-3 am-form-label">用户登录名 <span class="tpl-form-line-small-title">userLoginName</span></label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" data-bind="value:userLoginName" id="menu-url"
                               placeholder="请输入用户登录名">
                        <small>请填写用户登录名文字10-20字左右。</small>
                    </div>
                </div>

                <div class="am-form-group">
                    <label for="menu-target" class="am-u-sm-3 am-form-label">用户权限 <span
                            class="tpl-form-line-small-title">permissions</span></label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" data-bind="value:permissions" id="menu-target"
                               placeholder="请输入用户权限">
                        <small>请填写用户权限10-20字左右。</small>
                    </div>
                </div>

                <div class="am-form-group">
                    <label for="menu-target" class="am-u-sm-3 am-form-label">用户角色<span
                            class="tpl-form-line-small-title">userRoles</span></label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" data-bind="value:userRoles"
                               placeholder="请输入用户角色">
                        <small>请填写用户角色10-20字左右。</small>
                    </div>
                </div>

                <div class="am-form-group">
                    <label for="menu-target" class="am-u-sm-3 am-form-label">用户密码<span
                            class="tpl-form-line-small-title">userPassword</span></label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" data-bind="value:userPassword"
                               placeholder="请输入用户密码">
                        <small>请填写用户密码10-20字左右。</small>
                    </div>
                </div>

                <div class="am-form-group">
                    <label for="menu-target" class="am-u-sm-3 am-form-label">用户类别<span
                            class="tpl-form-line-small-title">menuTarget</span></label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" data-bind="value:userType"
                               placeholder="请输入用户类别">
                        <small>请填写用户类别10-20字左右。</small>
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
<script src="<%=basePath%>/assets/js/lodash.js"></script>
<script src="<%=basePath%>/assets/js/amazeui.min.js"></script>
<script src="<%=basePath%>/assets/js/amazeui.datatables.min.js"></script>
<script src="<%=basePath%>/assets/js/dataTables.responsive.min.js"></script>
<script src="<%=basePath%>/assets/js/moment.js"></script>
<script src="<%=basePath%>/assets/js/ko.js"></script>
<script src="<%=basePath%>/app/users/UserList.js"></script>
<script src="<%=basePath%>/assets/js/app.js"></script>
</body>
</html>
