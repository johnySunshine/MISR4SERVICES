<%--
  Created by IntelliJ IDEA.
  User: Fantasy
  Date: 2017/2/19
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="commonJsp/head.jsp" %>
    <title>Title</title>
    <script type="text/javascript" src="<%=IDEAPath%>/ajaxfileupload.js"></script>
    <script type="text/javascript">
        function ajaxFileUpload() {
            $.ajaxFileUpload({
                url : window.location.protocol + '//' + window.location.host + '/Images/ImagesUpload',
                secureuri : false,
                fileElementId : 'fileToUpload',
                dataType : 'json',
                data : {username : $("#username").val()},
                success : function(data, status) {

                },
                error : function(data, status, e) {
                }
            }).done(function(){
                alert();
            });

            return false;

        }
    </script>
</head>
<body>
<h1>选择图片后,点击按钮上传</h1>
<input id="fileToUpload" type="file" size="45" name="fileToUpload"
       class="input">
<button class="button" onclick="ajaxFileUpload()">上传</button>
<br>
<img id="viewImg" src="http://localhost/UPLOAD_ALL_IMAGES_FOLDER/6febc1d6-3a37-4b12-bbca-97b8d7569f1d.jpg.jpg">
</body>
</html>
