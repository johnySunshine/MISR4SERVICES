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
                    <p class="page-header-description">管理菜单模块</p>
                </div>
                <div class="am-u-lg-3 tpl-index-settings-button">
                    <button type="button" class="page-header-button"><span class="am-icon-paint-brush"></span> 设置
                    </button>
                </div>
            </div>

        </div>

        <div class="row-content am-cf">
            <table id="example-r"
                   class="am-table am-table-striped am-table-bordered am-table-compact">
                <thead>
                <tr>
                    <th>Column 1</th>
                    <th>Column 2</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>Row 1 Data 1</td>
                    <td>Row 1 Data 2</td>
                </tr>
                <tr>
                    <td>Row 2 Data 1</td>
                    <td>Row 2 Data 2</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

</div>
<script src="<%=IDEAPath%>assets/js/amazeui.min.js"></script>
<script src="<%=IDEAPath%>assets/js/amazeui.datatables.min.js"></script>
<script src="<%=IDEAPath%>assets/js/dataTables.responsive.min.js"></script>
<script src="<%=IDEAPath%>assets/js/app.js"></script>
</body>
</html>
