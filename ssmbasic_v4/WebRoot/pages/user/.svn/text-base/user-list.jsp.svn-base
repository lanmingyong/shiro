<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../basic.jsp"%>
<!doctype html>
<html lang="zh-CN">
    <head>
        <meta charset="utf-8">
		<title>用户列表</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<link type="text/css" href="common/css/loading.css" rel="stylesheet" />
		<link type="text/css" href="common/css/pagination.css" rel="stylesheet" />
		<link type="text/css" href="common/css/bootstrap.min.css" rel="stylesheet" />
		<link type="text/css" href="common/css/bootstrap-responsive.min.css" rel="stylesheet" />
		<style type="text/css">
		  select, textarea, input[type="text"], input[type="password"], input[type="datetime"], input[type="datetime-local"], input[type="date"], input[type="month"], input[type="time"], input[type="week"], input[type="number"], input[type="email"], input[type="url"], input[type="search"], input[type="tel"], input[type="color"], .uneditable-input {height: auto;}
		  .table th ,.table td{text-align: center;}
		</style>
	</head>

	<body>
	    <h3>用户列表</h3>
	    <div>用户名：<input type="text" id="txtParam" />&nbsp;
	    <button class="btn btn-sm btn-default" onclick="showUserPageList(1);">搜索</button>&nbsp;
	    <button class="btn btn-sm btn-default" onclick="self.location='user/0/edit'">添加</button>
	    <button class="btn btn-sm btn-default" onclick="DialogCustomForm('添加用户','divUserForm','userFormDig');">Ajax添加</button>
	    </div>
        <table cellpadding="0" cellspacing="0" border="1" class="table table-condensed" style="width:900px; font-size: 13px;text-align: center;">
            <thead>
                <tr><th width="10%">登录名</th><th width="10%">姓名</th><th width="20%">生日</th><th width="10%">电话</th><th width="15%">邮箱</th><th width="10%">下载图像</th><th width="25%">操作</th></tr>
            </thead>
            <tbody id="tbUserList">
            <c:forEach items="${pageInfo.items}" var="item">
               <tr>
                    <td>${item.loginName}</td>
                    <td>${item.userName}</td>
                    <td><fmt:formatDate value="${item.birthday}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                    <td>${item.userPhone}</td>
                    <td>${item.userEmail}</td>
                    <td><a href="user/${item.userId}/download" target="_blank">下载</a></td>
                    <td>
                        <a class="btn btn-xs btn-link" href="javascript:showUser(${item.userId});">Ajax修改</a>
                        <a class="btn btn-xs btn-link" href="user/${item.userId}/edit">修改</a>
                        <a class="btn btn-xs btn-link" href="javascript:deleteUser(${item.userId});">删除</a>
                    </td>
                </tr>
           </c:forEach>
           </tbody>
           <tfoot>
             <tr>
                <td colspan="7"><div class="page" id="pgUser"></div></td>
             </tr>
           </tfoot>
        </table>
        
	</body>
	
	<%-- 用户编辑弹层 --%>
	<div id="divUserForm" style="display: none;">
	   <input type="hidden" id="hdnUserId" />
	   <table cellpadding="0" cellspacing="0" class="table table-condensed" style="width: 500px;">
            <tr>
                <td>登录名：</td>
                <td><input type="text" id="tloginName" /></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="text" id="tpassword" /></td>
            </tr>
            <tr>
                <td>姓名：</td>
                <td><input type="text" id="tuserName" /></td>
            </tr>
            <tr>
                <td>生日：</td>
                <td><input type="text" id="tbirthday" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" /></td>
            </tr>
            <tr>
                <td>电话：</td>
                <td><input type="text" id="tuserPhone" /></td>
            </tr>
            <tr>
                <td>邮件：</td>
                <td><input type="text" id="tuserEmail" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><button class="btn btn-sm btn-default" onclick="saveUser();">保存</button></td>
            </tr>
        </table>
    </div>
    <div id="ibody" class="ibody"></div>
	<script type="text/javascript" src="common/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="common/js/jquery.bgiframe.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>common/js/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="common/js/loading-min.js"></script>
	<script type="text/javascript" src="common/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="common/js/jquery.pagination.js"></script>
	<script type="text/javascript" src="common/js/dialog/jquery.artDialog.js?skin=default"></script>
	<script type="text/javascript" src="common/js/syscommon.js"></script>
	<script type="text/javascript" src="common/js/user-list.js"></script>
	<script type="text/javascript">createUserPagination(${pageInfo.totalPages},${pageInfo.totalRows},${pageInfo.pageNum},${pageInfo.pageSize});</script>
</html>
