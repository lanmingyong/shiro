<%--
  Created by IntelliJ IDEA.
  User: LANMINGYONG
  Date: 2018/1/8
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试页面</title>
    <script type="text/javascript" src="../common/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="../common/js/md5.js"></script>
    <script type="text/javascript" src="../common/js/base64.js"></script>
    <script type="text/javascript" src="../common/js/sha1.js"></script>
    <script type="text/javascript">
     
        //**********************md5**********************
        var string="admin"
        var hash = hex_md5(string)
        console.log("md5="+hash)
       
        //**********************base64**********************
        var b = new Base64();
        var str = b.encode(string);
        console.log("base64 encode:" + str);
        //解密
        str = b.decode(str);
        console.log("base64 decode:" + str);
        
        //**********************sha1**********************
        var sha = hex_sha1(string)
        console.log("sha=" +sha)
        
        $(document).ready(function () {
            $("#md5").text(hash)
            $("#base64").text(b.encode(str))
            $("#sha1").text(sha)
        })
    </script>
</head>
<body>
<p  id="md5" ></p>
<p id="base64" ></p>
<p id="sha1" ></p>
</body>
</html>
