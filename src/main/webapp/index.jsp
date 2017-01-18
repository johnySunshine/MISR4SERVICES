<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="jsp/common/tag.jsp" %>
<html>
<head>
    <title>后端管理</title>
    <%@include file="jsp/common/head.jsp" %>
</head>
<body>
<%@include file="jsp/template/header.jsp" %>
<div class="am-cf admin-main">
    <%@include file="jsp/template/controlPanel.jsp" %>
</div>
<script>
    $(function () {
        /* $.get('tv/getCategory');
         $.get('tv/getChannel', {'pId': 1});
         $.get('tv/getProgram', {'pCode': 'cctv'});
         $.get('Movie/video', {'q': '火影忍者'});
         $.get('Movie/pmovie', {'city': '南京'});
         $.get('boxOffice/Rank', {'area': 'CN'});
         $.get('boxOffice/WP');
         $.get('Menus/queryMenuMain');*/
    });
</script>
</body>
</html>
