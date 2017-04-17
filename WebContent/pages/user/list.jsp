<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="myTag" 	tagdir="/tags"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/application.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/application.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.11.0.js"></script>
<style type="text/css">
.top {
	padding-top: 50px;
}

.query {
	margin-bottom: 20px;
}
</style>
<title>用户管理</title>
</head>
<body>
	<div class="top"></div>
	<div class="query">
		&nbsp;&nbsp;用户名：<input id="username" name="username" value="">
		&nbsp;&nbsp;用户电话：<input id="userphone" name="userphone" value="">
		&nbsp;邮箱：<input id="useremail" name="useremail" value=""> &nbsp;管理员身份：<input type="checkbox" id="admin" value="" name="admin">&nbsp;&nbsp;&nbsp;<input type="button"
			name="query" value="查询" onclick="queryAction()"> &nbsp;&nbsp; <input type="button"
			name="create" onclick="createAction()" value="新增">
	</div>
	<table width="100%" border="1" cellpadding="0" cellspacing="1"
		class="tableLine DoubleColorTable">
		<tr>
			<td colspan="8" align="center" class="tableLineBg">用户列表</td>
		</tr>
		<tr>
			<td align="center">用户编号</td>
			<td align="center">用户名称</td>
			<td align="center">用户密码</td>
			<td align="center">用户电话</td>
			<td align="center">邮 箱</td>
			<td align="center">地 址</td>
			<td align="center">是否为管理员</td>
			<td align="center">操 作</td>
		</tr>
		<c:forEach var="u" items="${requestScope.users}">
			<tr>
				<td align="center">${u.user_id}</td>
				<td align="center">${u.user_name}</td>
				<td align="center">${u.user_pwd}</td>
				<td align="center">${u.user_phone}</td>
				<td align="center">${u.user_email}</td>
				<td align="center">${u.user_address}</td>
				<td align="center">${u.admin_flag == 1?"是":"否"}</td>
				<td align="center"><a
					href="${pageContext.request.contextPath}/UserController?method=toUpdate&userid=${u.user_id}">修改</a>
					| <a
					href="${pageContext.request.contextPath}/UserController?method=delete&userid=${u.user_id}">删除</a>
				</td>
			</tr>
		</c:forEach>

		<tr>
			<td colspan="8" align="center"><input type="hidden"
				id="queryJsonStr" value='' /> <%-- <myTag:page page="${page}"></myTag:page> --%>
			</td>
		</tr>
	</table>
</body>
<script type="text/javascript">
	function createAction() {
		window.location.href = "${pageContext.request.contextPath}/pages/user/create.jsp";
	}
	function queryAction() {
		var username = $("#username").val();
		var userphone = $("#userphone").val();
		var useremail = $("#useremail").val();
		window.location.href = "${pageContext.request.contextPath}/UserController?method=getAllUser&username="
				+ username
				+ "&userphone="
				+ userphone
				+ "&useremail="
				+ useremail ;
	}
</script>
</html>