<%--
  Created by IntelliJ IDEA.
  User: LANMINGYONG
  Date: 2017/12/8
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>uploadInfo</title>
    <style type="text/css">
        th{
            background-color: #6F6F13
        }
    </style>
</head>
<body>
<table border="1px" align="center">

    <c:if test="${not empty sessionScope.uploadInfos}">
        <caption style="background-color: grey">上传文件信息列表</caption>
        
        <th>文件上传后保存的路径</th>
        <th>文件上传后保存的文件名</th>
        <th>文件的原名</th>
        <th>文件的大小(单位:MB)</th>

    <c:forEach items="${sessionScope.uploadInfos}" var="info" varStatus="i">
    <c:if test="${i.index%2==0}"> <tr bgcolor="#21E121"></c:if>
        <c:if test="${i.index%2==1}"><tr bgcolor="#E1DF21"></c:if>

            
            <td>${info.uploadSavePath}</td>
            <td>${info.uploadSaveFileName}</td>
            <td>${info.fileName}</td>
            <td>${info.fileSize}</td>
        </tr>

    </c:forEach>
    </c:if>

</table>
</body>
</html>
