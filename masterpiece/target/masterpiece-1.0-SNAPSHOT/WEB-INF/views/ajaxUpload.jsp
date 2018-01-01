<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/2.2.0/jquery.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/jqueryui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery.form/4.2.1/jquery.form.js"></script>
<script>
    $(function() {

        $("#doSave").on('click', function() {

            var options = {
                type : 'post',
                dataType:'json',
                contentType:"application/x-www-form-urlencoded",
                url : '${pageContext.request.contextPath}/tmpInfo/method2',

                success: function(data) {
                    //接受到的data还只是一个字符串，需要转成json对象
                    var obj = JSON.parse(data);
                    console.log(obj);
                    if(obj.flag==true){
                        alert("上传成功");
                    }else{
                        alert("error");
                    }
                },
                error: function (data)//服务器响应失败处理函数
                {
                    alert("出错");
                }

            }
                $("#uploadForm").ajaxSubmit(options,$(this).resetForm());

            }
		);
    });  
</script>
</head>
<body>

	<form id="uploadForm" name="uploadForm"  enctype="multipart/form-data">
		<input name="messageContent" value="多个参数的情况下"> <label>文件</label>
		<input type="file" name="file">
		<button class="btn" type="button" id="doSave">提交</button>
	</form>
</body>
</html>