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
                        编辑菜单
                        <small>M-STREAM</small>
                    </div>
                    <p class="page-header-description">编辑菜单</p>
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
                            <form class="am-form tpl-form-line-form" action="<%=basePath%>Movie/editMovie"
                                  method="POST">
                                <!-- film title-->

                                <div class="am-form-group">
                                    <label for="film-id" class="am-u-sm-3 am-form-label">电影ID<span
                                            class="tpl-form-line-small-title">film Title</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" class="tpl-form-input" id="film-id" name="movieId"
                                               placeholder="请输入电影标题" readonly value="${Movie.movieId}">
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="film-name" class="am-u-sm-3 am-form-label">电影标题<span
                                            class="tpl-form-line-small-title">film Title</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" class="tpl-form-input" id="film-name" name="title"
                                               placeholder="请输入电影标题" value="${Movie.title}">
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="film-runtime" class="am-u-sm-3 am-form-label">电影的时长<span
                                            class="tpl-form-line-small-title">film runtime</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" id="film-runtime" class="am-form-field tpl-form-no-bg"
                                               name="runtime" placeholder="请输入电影的国家" value="${Movie.runtime}">
                                    </div>
                                </div>

                                <!-- film originalTitle-->
                                <div class="am-form-group">
                                    <label for="film-originalTitle" class="am-u-sm-3 am-form-label">电影原标题 <span
                                            class="tpl-form-line-small-title">film originalTitle</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" id="film-originalTitle" class="am-form-field tpl-form-no-bg"
                                               name="originalTitle" placeholder="请输入电影原标题"
                                               value="${Movie.originalTitle}">
                                    </div>
                                </div>


                                <div class="am-form-group">
                                    <label for="film-countries" class="am-u-sm-3 am-form-label">电影的国家<span
                                            class="tpl-form-line-small-title">film countries</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" id="film-countries" class="am-form-field tpl-form-no-bg"
                                               name="countries" placeholder="请输入电影的国家" value="${Movie.countries}">
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="film-mainGenre" class="am-u-sm-3 am-form-label">主要类别<span
                                            class="tpl-form-line-small-title">main genres</span></label>
                                    <div class="am-u-sm-9">
                                        <select data-am-selected="{searchBox: 1}" name="mainGenre"
                                                style="display: none;"
                                                id="film-mainGenre" class="chosen-select genres-select" multiple
                                                tabindex="4">${Movie.mainGenre}
                                            <option value="">请选择影片类型</option>
                                            <option value="剧情"
                                                    <c:if test="${Movie.mainGenre.split(',')[0] == '剧情' || Movie.mainGenre.split(',')[1] == '剧情' || Movie.mainGenre.split(',')[2] == '剧情'}">selected</c:if>>
                                                剧情
                                            </option>
                                            <option value="喜剧"
                                                    <c:if test="${Movie.mainGenre.split(',')[0] == '喜剧' || Movie.mainGenre.split(',')[1] == '喜剧' || Movie.mainGenre.split(',')[2] == '喜剧'}">selected</c:if>>
                                                喜剧
                                            </option>
                                            <option value="爱情"
                                                    <c:if test="${Movie.mainGenre.split(',')[0] == '爱情' || Movie.mainGenre.split(',')[1] == '爱情' || Movie.mainGenre.split(',')[2] == '爱情'}">selected</c:if>>
                                                爱情
                                            </option>
                                            <option value="动作"
                                                    <c:if test="${Movie.mainGenre.split(',')[0] == '动作' || Movie.mainGenre.split(',')[1] == '动作' || Movie.mainGenre.split(',')[2] == '动作'}">selected</c:if>>
                                                动作
                                            </option>
                                            <option value="惊悚"
                                                    <c:if test="${Movie.mainGenre.split(',')[0] == '惊悚' || Movie.mainGenre.split(',')[1] == '惊悚' || Movie.mainGenre.split(',')[2] == '惊悚'}">selected</c:if>>
                                                惊悚
                                            </option>
                                            <option value="犯罪"
                                                    <c:if test="${Movie.mainGenre.split(',')[0] == '犯罪' || Movie.mainGenre.split(',')[1] == '犯罪' || Movie.mainGenre.split(',')[2] == '犯罪'}">selected</c:if>>
                                                犯罪
                                            </option>
                                            <option value="恐怖"
                                                    <c:if test="${Movie.mainGenre.split(',')[0] == '恐怖' || Movie.mainGenre.split(',')[1] == '恐怖' || Movie.mainGenre.split(',')[2] == '恐怖'}">selected</c:if>>
                                                恐怖
                                            </option>
                                            <option value="冒险"
                                                    <c:if test="${Movie.mainGenre.split(',')[0] == '冒险' || Movie.mainGenre.split(',')[1] == '冒险' || Movie.mainGenre.split(',')[2] == '冒险'}">selected</c:if>>
                                                冒险
                                            </option>
                                            <option value="家庭"
                                                    <c:if test="${Movie.mainGenre.split(',')[0] == '家庭' || Movie.mainGenre.split(',')[1] == '家庭' || Movie.mainGenre.split(',')[2] == '家庭'}">selected</c:if>>
                                                家庭
                                            </option>
                                            <option value="纪录片"
                                                    <c:if test="${Movie.mainGenre.split(',')[0] == '纪录片' || Movie.mainGenre.split(',')[1] == '纪录片' || Movie.mainGenre.split(',')[2] == '纪录片'}">selected</c:if>>
                                                纪录片
                                            </option>
                                            <option value="动画"
                                                    <c:if test="${Movie.mainGenre.split(',')[0] == '动画' || Movie.mainGenre.split(',')[1] == '动画' || Movie.mainGenre.split(',')[2] == '动画'}">selected</c:if>>
                                                动画
                                            </option>
                                            <option value="奇幻"
                                                    <c:if test="${Movie.mainGenre.split(',')[0] == '奇幻' || Movie.mainGenre.split(',')[1] == '奇幻' || Movie.mainGenre.split(',')[2] == '奇幻'}">selected</c:if>>
                                                奇幻
                                            </option>
                                            <option value="科幻"
                                                    <c:if test="${Movie.mainGenre.split(',')[0] == '科幻' || Movie.mainGenre.split(',')[1] == '科幻' || Movie.mainGenre.split(',')[2] == '科幻'}">selected</c:if>>
                                                科幻
                                            </option>
                                            <option value="战争"
                                                    <c:if test="${Movie.mainGenre.split(',')[0] == '战争' || Movie.mainGenre.split(',')[1] == '战争' || Movie.mainGenre.split(',')[2] == '战争'}">selected</c:if>>
                                                战争
                                            </option>
                                            <option value="短片"
                                                    <c:if test="${Movie.mainGenre.split(',')[0] == '短片' || Movie.mainGenre.split(',')[1] == '短片' || Movie.mainGenre.split(',')[2] == '短片'}">selected</c:if>>
                                                短片
                                            </option>
                                            <option value="歌舞"
                                                    <c:if test="${Movie.mainGenre.split(',')[0] == '歌舞' || Movie.mainGenre.split(',')[1] == '歌舞' || Movie.mainGenre.split(',')[2] == '歌舞'}">selected</c:if>>
                                                歌舞
                                            </option>
                                            <option value="西部"
                                                    <c:if test="${Movie.mainGenre.split(',')[0] == '西部' || Movie.mainGenre.split(',')[1] == '西部' || Movie.mainGenre.split(',')[2] == '西部'}">selected</c:if>>
                                                西部
                                            </option>
                                            <option value="音乐"
                                                    <c:if test="${Movie.mainGenre.split(',')[0] == '音乐' || Movie.mainGenre.split(',')[1] == '音乐' || Movie.mainGenre.split(',')[2] == '音乐'}">selected</c:if>>
                                                音乐
                                            </option>
                                            <option value="古装"
                                                    <c:if test="${Movie.mainGenre.split(',')[0] == '古装' || Movie.mainGenre.split(',')[1] == '古装' || Movie.mainGenre.split(',')[2] == '古装'}">selected</c:if>>
                                                古装
                                            </option>
                                            <option value="武侠"
                                                    <c:if test="${Movie.mainGenre.split(',')[0] == '武侠' || Movie.mainGenre.split(',')[1] == '武侠' || Movie.mainGenre.split(',')[2] == '武侠'}">selected</c:if>>
                                                武侠
                                            </option>
                                            <option value="脱口秀"
                                                    <c:if test="${Movie.mainGenre.split(',')[0] == '脱口秀' || Movie.mainGenre.split(',')[1] == '脱口秀' || Movie.mainGenre.split(',')[2] == '脱口秀'}">selected</c:if>>
                                                脱口秀
                                            </option>
                                            <option value="黑色电影"
                                                    <c:if test="${Movie.mainGenre.split(',')[0] == '黑色电影' || Movie.mainGenre.split(',')[1] == '黑色电影' || Movie.mainGenre.split(',')[2] == '黑色电影'}">selected</c:if>>
                                                黑色电影
                                            </option>
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
                                            <option value="NR"
                                                    <c:if test="${Movie.childProtectionId == 'NR'}">selected</c:if>>
                                                无年龄级别
                                            </option>
                                            <option value="G"
                                                    <c:if test="${Movie.childProtectionId == 'G'}">selected</c:if>>G级
                                            </option>
                                            <option value="PG"
                                                    <c:if test="${Movie.childProtectionId == 'PG'}">selected</c:if>>PG级别
                                            </option>
                                            <option value="PG-13"
                                                    <c:if test="${Movie.childProtectionId == 'PG-13'}">selected</c:if>>
                                                PG-13级别
                                            </option>
                                            <option value="R"
                                                    <c:if test="${Movie.childProtectionId == 'R'}">selected</c:if>>R级别
                                            </option>
                                            <option value="NC-17"
                                                    <c:if test="${Movie.childProtectionId == 'NC-'}">selected</c:if>>
                                                NC-17级别
                                            </option>
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
                                               placeholder="儿童等级显示" readonly=""
                                               value="${Movie.childProtectionDisplayName}">
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="film-childProtectionLevel" class="am-u-sm-3 am-form-label">儿童等级显示 <span
                                            class="tpl-form-line-small-title">childProtectionLevel</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" id="film-childProtectionLevel"
                                               name="childProtectionLevel"
                                               class="am-form-field tpl-form-no-bg"
                                               placeholder="儿童等级显示" readonly="" value="${Movie.childProtectionLevel}">
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="film-year" class="am-u-sm-3 am-form-label">发布时间 <span
                                            class="tpl-form-line-small-title">Time</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" id="film-year" name="year"
                                               class="am-form-field tpl-form-no-bg"
                                               placeholder="发布时间" data-am-datepicker="" readonly=""
                                               value="${Movie.year}">
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="film-desc" class="am-u-sm-3 am-form-label">文章内容</label>
                                    <div class="am-u-sm-9">
                                    <textarea class="" rows="10" id="film-desc" name="longDescription"
                                              placeholder="请输入文章内容">${Movie.longDescription}</textarea>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="film-category" class="am-u-sm-3 am-form-label">视频类型<span
                                            class="tpl-form-line-small-title">main category</span></label>
                                    <div class="am-u-sm-9">
                                        <select data-am-selected="{searchBox: 1}" name="category" style="display: none;"
                                                id="film-category">
                                            <option value=""
                                                    <c:if test="${empty Movie.category}">selected</c:if> >默认
                                            </option>
                                            <option value="film"
                                                    <c:if test="${Movie.category == 'film'}">selected</c:if>>电影
                                            </option>
                                            <option value="tvShow"
                                                    <c:if test="${Movie.category == 'tvShow'}">selected</c:if>>电视剧
                                            </option>
                                        </select>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="film-creationDate" class="am-u-sm-3 am-form-label">创建时间<span
                                            class="tpl-form-line-small-title">creationDate</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" id="film-creationDate" name="creationDate"
                                               class="am-form-field tpl-form-no-bg"
                                               placeholder="发布时间" data-am-datepicker="" readonly=""
                                               value="${Movie.creationDate}">
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
    });
</script>
<script src="<%=IDEAPath%>assets/js/chosen.jquery.js"></script>
<script src="<%=IDEAPath%>assets/js/amazeui.min.js"></script>
<script src="<%=IDEAPath%>assets/js/amazeui.datatables.min.js"></script>
<script src="<%=IDEAPath%>assets/js/dataTables.responsive.min.js"></script>
<script src="<%=IDEAPath%>assets/js/app.js"></script>
</body>
</html>
