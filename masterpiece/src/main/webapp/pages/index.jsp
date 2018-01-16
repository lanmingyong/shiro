<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>test</title>
    <script src="../common/js/md5.js"></script>
    <script>
        console.log(hex_md5("sdfsd321"))
    </script>
</head>
<body>
<h4>Test Page</h4>


<c:if test="${username!=null and username!=''}">
    <label>用户名</label>
    <label>${username}</label>
</c:if>
<br>
<c:if test="${password!=null and password!=''}">
    <label>密码</label>
    <label>${password}</label><br>
    <label>MD5加密后的密码</label>
    <label>${md5_password}</label>

</c:if>

</body>
</html>
