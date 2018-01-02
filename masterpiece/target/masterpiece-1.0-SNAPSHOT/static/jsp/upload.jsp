<%--
  Created by IntelliJ IDEA.
  User: LANMINGYONG
  Date: 2017/12/8
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/jsp/upload" method="post" enctype="multipart/form-data" style="text-align: center;">
<table>
        <tr>
            <td>请选择要上传的文件:</td>
            <td><input type="file" name="file1" size="40"></td>
        </tr>
        <tr>
            <td>请输入文件的描述:</td>
            <td><input type="text" name="desc1" size="40"></td>
        </tr>
        <tr>
            <td>请选择要上传的文件:</td>
            <td><input type="file" name="file2" size="40"></td>
        </tr>
        <tr>
            <td>请输入文件的描述:</td>
            <td><input type="text" name="desc2" size="40"></td>
        </tr>
        <tr>
            <td><input type="reset" value="重填"></td>
            <td><input type="submit" value="上传"></td>
        </tr>
    </table>
</form>
</body>
</html>
