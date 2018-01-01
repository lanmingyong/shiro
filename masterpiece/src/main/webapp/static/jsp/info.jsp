<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Info Page</title>
</head>
<body>

<center>
    <table border="1px" align="center">
        <caption>Servlet 接收到的HTTP消息报头的信息</caption>
        <tr bgcolor="#999999">
            <th>消息报头的名字</th>
            <th>消息报头的值</th>
        </tr>

        <c:forEach items="${requestScope.headNameMap}" varStatus="i" var="headName">
            <c:if test="${i.index%2==0}">
                <tr style="background-color: crimson">
            </c:if>
            <c:if test="${i.index%2==1}">
                <tr style="background-color: aqua">
            </c:if>
            <td>${headName.key}</td><td>${headName.value}</td>
            </tr>
        </c:forEach>

    </table><br>
    <table border="1px" align="center" bgcolor="#999999">
        <caption>其他访问信息</caption>
        <tr>
            <td>客户端的IP地址</td>
            <td>${requestScope.remoteAddr}</td>
        </tr>
        <tr>
            <td>客户端的端口号</td>
            <td>${requestScope.remotePort}</td>
        </tr>
        <tr>
            <td>服务端的IP地址</td>
            <td>${requestScope.localAddr}</td>
        </tr>
        <tr>
            <td>服务端的端口号</td>
            <td>${requestScope.localPort}</td>
        </tr>
    </table>
</center>
</body>
</html>
