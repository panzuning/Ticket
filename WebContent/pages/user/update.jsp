<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/application.css">
<title>更新</title>
</head>
<body>
	<div style="margin-top: 50px;"></div>
	<form action="${pageContext.request.contextPath}/UserController?method=update" method="POST">
		<table class="query_form_table" border="0" align="center">
			<tr>
				<th>编号</th>
				<td><input name="userid" readonly="readonly"
					value="${user.user_id}" /> &nbsp;</td>
			</tr>
			<tr>
				<th>用户名称：</th>
				<td><input name="username" value="${user.user_name}" /></td>
			</tr>
			<tr>
				<th>用户密码：</th>
				<td colspan="2"><input name="userpwd"
					value="${user.user_pwd}" /></td>
			</tr>
			<tr>
				<th>用户电话：</th>
				<td colspan="2"><input name="userphone"
					value="${user.user_phone}" /></td>
			</tr>
			<tr>
				<th>邮箱：</th>
				<td colspan="2"><input name="useremail"
					value="${user.user_email}" /></td>
			</tr>
			<tr>
				<th>地址：</th>
				<td colspan="2"><input name="useraddress"
					value="${user.user_address}" /></td>
			</tr>
			<tr>
				<th>管理员：</th>
				<td colspan="2"><input name="adminflag"
					value="${user.admin_flag}" /></td>
			</tr>
			<tr>
				<td align="right"><input type="button" value="cancle" /></td>
				<td align="right"><input type="submit" name="ticketnum"
					width="50px" /></td>
			</tr>
		</table>
	</form>
</body>
</html>