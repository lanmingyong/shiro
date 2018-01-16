<%--
  Created by IntelliJ IDEA.
  User: LANMINGYONG
  Date: 2018/1/7
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <script src="../common/js/jquery-3.2.1.min.js"></script>
    <script src="../common/js/bootstrap.min.js"></script>
    <script src="../common/js/login.js"></script>
    <script src="../common/js/md5.js"></script>
    <link rel="stylesheet" href="../common/css/bootstrap.min.css">
    <link rel="stylesheet" href="../common/css/login.css">

</head>
<body class="container" >
<div class="row" id="login">
        <form class="form-horizontal col-md-offset-4 col-xs-offset-4 col-md-4 col-xs-4" method="post" action="/user/login">
            <div class="heading col-md-12 col-xs-12">用户登录</div>
            <div class="form-group  col-md-11 col-xs-11">

                    <div class="input-group">

                        <div class="input-group-addon">用户</div>
                        <input type="text" class="form-control" name="username" onblur="testUser()" placeholder="在此处输入用户名" id="username">
                    </div>
            </div>
            <div class="col-md-1 col-xs-1" style="padding-bottom: 9px;padding-top: 9px;">
                <span class="glyphicon glyphicon-ok"></span>
            </div>
            <div class="form-group col-md-11 col-xs-11">

                    <div class="input-group">

                        <div class="input-group-addon">密码</div>
                        <input type="password" class="form-control" name="password" onblur="testPassword()" placeholder="在此处输入密码" id="password">
                    </div>

            </div>
            <div class="col-md-1 col-xs-1" style="padding-bottom: 9px;padding-top: 9px;">
                <span class="glyphicon glyphicon-remove"></span>
            </div>
            <div class="form-group">
                <div class="col-md-offset-1  col-xs-offset-1 col-md-11 col-xs-11">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" name="rememberMe"> 记住我
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-3 col-xs-3">
                    <button type="submit" class="btn btn-success">登录</button>
                </div>
                <div class="col-md-offset-6 col-xs-offset-6 col-md-3 col-xs-3">
                    <button type="reset" class="btn btn-primary">取消</button>
                </div>
            </div>
        </form>
</div>
<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" id="errorModal">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            用户名不存在!
        </div>
    </div>
</div>
</body>
</html>
