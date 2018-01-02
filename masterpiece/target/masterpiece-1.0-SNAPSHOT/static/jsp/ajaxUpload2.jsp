<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <head>
        <script type="text/javascript" src="https://cdn.bootcss.com/jquery/2.2.0/jquery.js"></script>
        <script>
            function compareStr(str1,str2){
                if(str1.toLowerCase() == str2.toLowerCase()){
                    return true;
                }else{
                    return false;
                }
            }
            $(function () {
                $("#upload").click(function () {
                    $("#imgWait").show();
                    var formData = new FormData();
                    formData.append("uploadFile", $("#uploadFile").get(0).files[0]);
                    formData.append("messageContent",$("#message").val());
                    $.ajax({
                        url: "${pageContext.request.contextPath}/tmpInfo/method2",
                        type: "POST",
                        data: formData,
                        /**
                         *必须false才会自动加上正确的Content-Type
                         */
                        contentType: false,
                        /**
                         * 必须false才会避开jQuery对 formdata 的默认处理
                         * XMLHttpRequest会对 formdata 进行正确的处理
                         */
                        processData: false,
                        success: function (data) {
                            //接受到的data还只是一个字符串，需要转成json对象
                            var obj = JSON.parse(data);
                            console.log(obj);
                            if(obj.flag==true){
                                alert("上传成功");
                               var ext= obj.ext;
                                if(compareStr(ext,"jpeg")){
                                    $("#imgWait").attr("src",obj.url);
                                }
                            }else{
                                alert("error");
                            }
                            $("#imgWait").hide();
                        },
                        error: function () {
                            alert("上传失败！");
                            $("#imgWait").hide();
                        }
                    });
                });
            });
        </script>
    </head>
<body>
<form  id="fileForm" method="post" enctype="multipart/form-data">
<input name="messageContent" value="文件的描述信息" id="message"> <label>文件</label>
<input type="file" id="uploadFile" name="uploadFile"/>
<input type="button" id="upload" value="上传" /><br>
    <div style="width: 161px;margin: 0px auto;">
        <img src="${pageContext.request.contextPath}/images/wait.gif"  id="imgWait"/></div>
</form>
</body>
