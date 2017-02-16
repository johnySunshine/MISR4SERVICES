<%--
  Created by IntelliJ IDEA.
  User: Fantasy
  Date: 2017/2/12
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>添加海报</title>
    <%@include file="../../commonJsp/head.jsp" %>
    <link rel="stylesheet" href="<%=IDEAPath%>assets/css/cropper.min.css">
    <link rel="stylesheet" href="<%=IDEAPath%>assets/css/addPoster.css">
</head>
<body data-type="widgets">
<script src="<%=IDEAPath%>assets/js/theme.js"></script>
<div class="am-g tpl-g animated fadeInRight">
    <%@include file="../header.jsp" %>
    <%@include file="../changeTheme.jsp" %>
    <%@include file="../sliderNavBar.jsp" %>
    <div class="tpl-content-wrapper">
        <div class="container-fluid am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-9">
                    <div class="page-header-heading"><span class="am-icon-image page-header-heading-icon"></span>
                        添加海报
                        <small>M-STREAM</small>
                    </div>
                    <p class="page-header-description">${code_msg}</p>
                </div>
            </div>
        </div>
        <div class="row-content am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title am-fl">添加海报主体</div>
                            <div class="widget-function am-fr">
                                <a href="javascript:;" class="am-icon-cog"></a>
                            </div>
                        </div>

                        <div class="widget-body am-fr" id="crop-avatar">
                            <!-- Current avatar -->
                            <form class="am-form tpl-form-line-form avatar-form" action="#"
                                  enctype="multipart/form-data" method="post">
                                <!-- Upload image and data -->
                                <div class="avatar-body">
                                    <div class="avatar-wrapper am-u-sm-9">
                                        请添加图片
                                    </div>
                                    <div class="docs-preview am-u-sm-3">
                                        <div class="img-preview preview-lg"></div>
                                        <div class="img-preview preview-md"></div>
                                        <div class="img-preview preview-sm"></div>
                                        <div class="img-preview preview-xs"></div>
                                    </div>
                                    <div class="am-form-group avatar-upload am-u-sm-12">
                                        <div class="am-form-group am-form-file btn-list">
                                            <button type="button" class="am-btn am-btn-danger am-btn-sm">
                                                <i class="am-icon-cloud-upload"></i> 添加图片
                                            </button>
                                            <button type="button" class="am-btn am-btn-primary am-btn-sm 16x9">
                                                <i class="am-icon-crop"></i> 16x9
                                            </button>
                                            <button type="button" class="am-btn am-btn-primary am-btn-sm 5x7">
                                                <i class="am-icon-crop"></i> 5x7
                                            </button>
                                            <button type="button" class="am-btn am-btn-primary am-btn-sm 1x1">
                                                <i class="am-icon-crop"></i> 1x1
                                            </button>
                                            <button type="button" class="am-btn am-btn-primary am-btn-sm any">
                                                <i class="am-icon-crop"></i> any
                                            </button>
                                            <button type="button" class="am-btn am-btn-warning am-btn-sm">
                                                <i class="am-icon-cloud-upload"></i> 添加图片
                                            </button>
                                            <button type="button" class="am-btn am-btn-success am-btn-sm">
                                                <i class="am-icon-cloud-upload"></i> 提交图片
                                            </button>
                                            <input type="hidden" class="avatar-src" name="avatar_src">
                                            <input type="hidden" class="avatar-data" name="avatar_data">
                                            <input class="avatar-input" id="avatarInput" type="file" name="avatar_file">
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<%=IDEAPath%>assets/js/chosen.jquery.js"></script>
<script src="<%=IDEAPath%>assets/js/amazeui.min.js"></script>
<script src="<%=IDEAPath%>assets/js/app.js"></script>
<script src="<%=IDEAPath%>assets/js/cropper.min.js"></script>
<script src="<%=IDEAPath%>assets/js/cropper.main.js"></script>
</body>
</html>
