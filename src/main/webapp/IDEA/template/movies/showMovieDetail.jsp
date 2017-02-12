<%--
  Created by IntelliJ IDEA.
  User: Fantasy
  Date: 2017/2/5
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../commonJsp/tag.jsp" %>
<!doctype html>
<html>
<head>
    <title>影片详情的添加</title>
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
                        添加菜单
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
                            <div class="widget-title am-fl">添加影片</div>
                            <div class="widget-function am-fr">
                                <a href="javascript:;" class="am-icon-cog"></a>
                            </div>
                        </div>
                        <div class="widget-body am-fr">
                            <form class="am-form tpl-form-line-form" action="<%=basePath%>Movie/insertMovie"
                                  method="POST">
                                <!-- film title-->
                                <div class="am-form-group">
                                    <label for="film-name" class="am-u-sm-3 am-form-label">电影标题<span
                                            class="tpl-form-line-small-title">film Title</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" class="tpl-form-input" id="film-name" name="title"
                                               placeholder="请输入电影标题">
                                        <small>请填写标题文字10-20字左右。</small>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="film-runtime" class="am-u-sm-3 am-form-label">电影的时长<span
                                            class="tpl-form-line-small-title">film runtime</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" id="film-runtime" class="am-form-field tpl-form-no-bg"
                                               name="runtime" placeholder="请输入电影的国家">
                                        <small>电影的时长</small>
                                    </div>
                                </div>

                                <!-- film originalTitle-->
                                <div class="am-form-group">
                                    <label for="film-originalTitle" class="am-u-sm-3 am-form-label">电影原标题 <span
                                            class="tpl-form-line-small-title">film originalTitle</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" id="film-originalTitle" class="am-form-field tpl-form-no-bg"
                                               name="originalTitle" placeholder="请输入电影原标题">
                                        <small>电影原标题</small>
                                    </div>
                                </div>


                                <div class="am-form-group">
                                    <label for="film-countries" class="am-u-sm-3 am-form-label">电影的国家<span
                                            class="tpl-form-line-small-title">film countries</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" id="film-countries" class="am-form-field tpl-form-no-bg"
                                               name="countries" placeholder="请输入电影的国家">
                                        <small>电影的国家</small>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="menu-main" class="am-u-sm-3 am-form-label">主要类别<span
                                            class="tpl-form-line-small-title">main genres</span></label>
                                    <div class="am-u-sm-9">
                                        <select data-am-selected="{searchBox: 1}" name="mainGenre"
                                                style="display: none;"
                                                id="menu-main" class="chosen-select genres-select" multiple required
                                                tabindex="4">
                                            <option value="">请选择影片类型</option>
                                            <option value="剧情">剧情</option>
                                            <option value="喜剧">喜剧</option>
                                            <option value="爱情">爱情</option>
                                            <option value="动作">动作</option>
                                            <option value="惊悚">惊悚</option>
                                            <option value="犯罪">犯罪</option>
                                            <option value="恐怖">恐怖</option>
                                            <option value="冒险">冒险</option>
                                            <option value="家庭">家庭</option>
                                            <option value="纪录片">纪录片</option>
                                            <option value="动画">动画</option>
                                            <option value="奇幻">奇幻</option>
                                            <option value="科幻">科幻</option>
                                            <option value="战争">战争</option>
                                            <option value="短片">短片</option>
                                            <option value="歌舞">歌舞</option>
                                            <option value="西部">西部</option>
                                            <option value="音乐">音乐</option>
                                            <option value="古装">古装</option>
                                            <option value="武侠">武侠</option>
                                            <option value="脱口秀">脱口秀</option>
                                            <option value="黑色电影">黑色电影</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="film-category" class="am-u-sm-3 am-form-label">影片年龄级别<span
                                            class="tpl-form-line-small-title">main childProtectionId</span></label>
                                    <div class="am-u-sm-9">
                                        <select data-am-selected="{searchBox: 1}" name="childProtectionId"
                                                style="display: none;"
                                                id="film-childProtectionId">
                                            <option value="NR">无年龄级别</option>
                                            <option value="G">G级</option>
                                            <option value="PG">PG级别</option>
                                            <option value="PG-13">PG-13级别</option>
                                            <option value="R">R级别</option>
                                            <option value="NC-17">NC-17级别</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="film-childProtectionDisplayName" class="am-u-sm-3 am-form-label">儿童等级显示 <span
                                            class="tpl-form-line-small-title">childProtectionDisplayName</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" id="film-childProtectionDisplayName"
                                               name="childProtectionDisplayName"
                                               class="am-form-field tpl-form-no-bg"
                                               placeholder="发布时间" readonly="">
                                        <small>发布时间为必填</small>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="film-childProtectionLevel" class="am-u-sm-3 am-form-label">儿童等级显示 <span
                                            class="tpl-form-line-small-title">childProtectionDisplayName</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" id="film-childProtectionLevel"
                                               name="childProtectionLevel"
                                               class="am-form-field tpl-form-no-bg"
                                               placeholder="发布时间" readonly="">
                                        <small>发布时间为必填</small>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="film-year" class="am-u-sm-3 am-form-label">发布时间 <span
                                            class="tpl-form-line-small-title">Time</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" id="film-year" name="year"
                                               class="am-form-field tpl-form-no-bg"
                                               placeholder="发布时间" data-am-datepicker="" readonly="">
                                        <small>发布时间为必填</small>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="film-desc" class="am-u-sm-3 am-form-label">文章内容</label>
                                    <div class="am-u-sm-9">
                                    <textarea class="" rows="10" id="film-desc" name="longDescription"
                                              placeholder="请输入文章内容"></textarea>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="film-category" class="am-u-sm-3 am-form-label">视频类型<span
                                            class="tpl-form-line-small-title">main category</span></label>
                                    <div class="am-u-sm-9">
                                        <select data-am-selected="{searchBox: 1}" name="category" style="display: none;"
                                                id="film-category">
                                            <option value="" selected="selected">默认</option>
                                            <option value="film">电影</option>
                                            <option value="tvShow">电视剧</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="film-creationDate" class="am-u-sm-3 am-form-label">创建时间<span
                                            class="tpl-form-line-small-title">creationDate</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" id="film-creationDate" name="creationDate"
                                               class="am-form-field tpl-form-no-bg"
                                               placeholder="发布时间" data-am-datepicker="" readonly="">
                                        <small>创建时间</small>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="film-parMovieId" class="am-u-sm-3 am-form-label">父级字段<span
                                            class="tpl-form-line-small-title">parMovieId</span></label>
                                    <div class="am-u-sm-9">
                                        <select data-am-selected="{searchBox: 1}" name="parMovieId"
                                                style="display: none;"
                                                id="film-parMovieId">
                                            <option value="" selected="selected">默认</option>
                                            <option value="12000">父级</option>
                                            <option value="13000">子级</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="am-form-group film-subMovieId" style="display: none;">
                                    <label for="film-subMovieId" class="am-u-sm-3 am-form-label">属于哪一个vod的子集<span
                                            class="tpl-form-line-small-title">subMovieId</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" id="film-subMovieId"
                                               class="am-form-field tpl-form-no-bg"
                                               placeholder="属于哪一个vod的子集">
                                    </div>
                                </div>

                                <div class="am-form-group film-subMovieId" style="display: none;">
                                    <label for="film-subBelong" class="am-u-sm-3 am-form-label">选择属于哪一个vod的子集<span
                                            class="tpl-form-line-small-title">subMovieId</span></label>
                                    <div id="film-subBelong">
                                    </div>
                                </div>

                                <div class="am-form-group film-curEpisode" style="display: none;">
                                    <label for="film-curEpisode" class="am-u-sm-3 am-form-label">当前集数<span
                                            class="tpl-form-line-small-title">curEpisode</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" id="film-curEpisode" name="curEpisode"
                                               class="am-form-field tpl-form-no-bg"
                                               placeholder="当前集数">
                                    </div>
                                </div>

                                <button type="submit" class="am-btn am-btn-primary am-btn-xs">提交保存</button>
                                <a type="button" class="am-btn am-btn-primary am-btn-xs"
                                   href="<%=basePath%>Movie/ShowMovies/default">放弃保存</a>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(function () {
        $("#film-childProtectionId").change(function () {
            var selectText = $("#film-childProtectionId option:selected").text();
            var proLevel = '';
            $('#film-childProtectionDisplayName').val(selectText);
            switch (selectText) {
                case '无年龄级别':
                    proLevel = '-1';
                    break;
                case 'G级':
                    proLevel = '4';
                    break;
                case 'PG级别':
                    proLevel = '8';
                    break;
                case 'PG-13级别':
                    proLevel = '12';
                    break;
                case 'R级别':
                    proLevel = '16';
                    break;
                default:
                    proLevel = '18';
            }
            $('#film-childProtectionLevel').val(proLevel);
        });
        $('#film-parMovieId').change(function () {
            var selectText = $("#film-parMovieId option:selected").text();
            if (selectText === '子级') {
                $('.film-subMovieId').show();
                $('.film-curEpisode').show();
            } else {
                $('.film-subMovieId').hide();
                $('.film-curEpisode').hide();
            }
        });
        var domRadio = function (resp) {
            var $subBelong = $('#film-subBelong');
            var domStr = '';
            for (var i = 0; i < resp.length; i++) {
                var item = resp[i];
                domStr += '<input type="radio" class="am-radio-inline" name="subMovieId" value="' + item.movieId + '"/>' + item.title;
            }
            $subBelong.append(domStr);
        };
        var keyUpTimer = null;

        $('#film-subMovieId').keyup(function () {
            var curInputVal = $(this).val();
            if (curInputVal === '') {
                return false
            }
            clearTimeout(keyUpTimer);
            keyUpTimer = setTimeout(function () {
                $.get('Movie/getMovieByTitle', {movieTitle: curInputVal}).done(function (resp) {
                    domRadio(JSON.parse(resp));
                });
            }, 1500);
        });
    });
</script>
<script src="<%=IDEAPath%>assets/js/chosen.jquery.js"></script>
<script src="<%=IDEAPath%>assets/js/amazeui.min.js"></script>
<script src="<%=IDEAPath%>assets/js/amazeui.datatables.min.js"></script>
<script src="<%=IDEAPath%>assets/js/dataTables.responsive.min.js"></script>
<script src="<%=IDEAPath%>assets/js/app.js"></script>
</body>
</html>
