<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>list Page</h4>
WELCOME <shiro:principal></shiro:principal><br>
<shiro:hasRole name="admin">
<a href="admin.jsp">admin Page</a><br>
</shiro:hasRole>
<shiro:hasRole name="user">
    <a href="user.jsp">user Page</a><br>
</shiro:hasRole>
<a href="shiro/testShiroAnnotation"></a>
<a href="/shiro/logout">注销</a>
</body>
</html>
