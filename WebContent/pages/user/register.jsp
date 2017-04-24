<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/application.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery-1.11.0.js"></script>
<title>注册</title>
</head>
<body>
	<div style="margin-top: 50px;"></div>
	<form
		action="${pageContext.request.contextPath}/UserController?method=register"
		method="POST">
		<table class="query_form_table" border="0" align="center">
			<tr>
				<th>用户名称：</th>
				<td><input name="username" id="username" /></td>
			</tr>
			<tr>
				<th>用户密码：</th>
				<td colspan="2"><input name="userpwd" id="passwd" /></td>
			</tr>
			<tr>
				<th>确认密码：</th>
				<td colspan="2"><input name="reuserpwd" id="repasswd" /></td>
			</tr>
			<tr>
				<th>用户电话：</th>
				<td colspan="2"><input name="userphone" id="phone" /></td>
			</tr>
			<tr>
				<th>邮箱：</th>
				<td colspan="2"><input name="email" id="email" /></td>
			</tr>
			<tr>
				<th>地址：</th>
				<td colspan="2"><input name="address" id="address" /></td>
			</tr>
			<tr>
				<th>管理员：</th>
				<td colspan="2"><input type="checkbox" name="adminFlag"
					value="1" /></td>
			</tr>
			<tr>
				<td align="right"><input type="button" value="cancle" /></td>
				<td align="right"><input type="submit" name="ticketnum"
					id="submit" width="50px" /></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
$(function(){
	$("#submit").click(function(){
		var username = $("#username").val();
		var passwd = $("#passwd").val();
		var repasswd = $("#repasswd").val();
		var email = $("#email").val();
		var address = $("#address").val();
		if(username == ""){
			alert("请输入用户名");
			return false;
		}else if(passwd == "" || repasswd == ""){
			alert("请输入密码");
			return false;
		}else if(passwd != repasswd){
			alert("密码不一致");
			return false;
		}else if(email == ""){
			alert("请输入邮箱");
			return false;
		}else if(address == ""){
			alert("请输入地址");
			return false;
		}
	});
});
</script>
</html>