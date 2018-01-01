<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="zh-CN">
	<head>
		<meta charset="utf-8">
		<title>系统登录</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<link type="text/css" href="common/css/bootstrap.min.css" rel="stylesheet" />
		<link type="text/css" href="common/css/bootstrap-responsive.min.css" rel="stylesheet" />
	</head>

	<body>
			<div style="border: 1px solid red; width:800px;margin: 0px auto;">
		<form class="form-horizontal" action="doLogin" method="post" id="loginForm" style="margin-top: 50px;" >

			<div class="control-group">
				<label class="control-label" for="loginName">用户名:</label>
				<div class="controls">
					<input type="text" id="loginName" name="loginName" value="admin">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="password">密码:</label>
				<div class="controls">
					<input type="password" id="password" name="password" value="123456" >
				</div>
			</div>
			<div class="control-group">
                <label class="control-label" for="rememberMe">记住我:</label>
                <div class="controls"><input type="checkbox" id="rememberMe" name="rememberMe" value="1">(7天不用再登录)</div>
            </div>
			<div class="control-group">
				<div class="controls" style="color: red;">${msg}</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<button type="submit" class="btn btn-success">登录</button>
				</div>
			</div>
		</form>
		</div>
	</body>
</html>
