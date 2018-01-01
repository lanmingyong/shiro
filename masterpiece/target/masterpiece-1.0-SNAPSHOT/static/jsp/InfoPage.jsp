<%@ page import="java.util.Enumeration" %>
<%@ page import="javax.servlet.*"%>
<%--
  Created by IntelliJ IDEA.
  User: LANMINGYONG
  Date: 2017/12/7
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info Page</title>
</head>
<body>
<%
int localPort=request.getLocalPort();
String localAddr=request.getLocalAddr();
String remoteAddr=request.getRemoteAddr();
int remotePort=request.getRemotePort();
%>
<center>
    <table border="1px" align="center">
        <caption>Servlet 接收到的HTTP消息报头的信息</caption>
        <tr bgcolor="#999999">
            <th>消息报头的名字</th>
            <th>消息报头的值</th>
        </tr>
        <tr>
        <%

            Enumeration headNames=request.getHeaderNames();
        while(headNames.hasMoreElements()){
            String name=(String)headNames.nextElement();
            String value=request.getHeader(name);
            out.println("<tr>");
            out.println("<td>"+name+"</td>");
            out.println("<td>"+value+"</td>");
            out.println("</tr>");
        }
        %>
        </tr>
    </table><br>
    <table border="1px" align="center">
        <caption>其他访问信息</caption>
        <tr>
            <td>客户端的IP地址</td>
            <td><%=remoteAddr%></td>
        </tr>
        <tr>
            <td>客户端的端口号</td>
            <td><%=remotePort%></td>
        </tr>
        <tr>
            <td>服务端的IP地址</td>
            <td><%=localAddr%></td>
        </tr>
        <tr>
            <td>服务端的端口号</td>
            <td><%=localPort%></td>
        </tr>
    </table>
</center>
</body>
</html>
