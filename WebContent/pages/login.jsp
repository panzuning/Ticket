<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>登录</title>
<style type="text/css">
form {
	width:500px;
	border: 1px solid #00F;
	border-color: #EEC591;
	margin-left: 100px;
	margin-top: 100px;
}
span {
	color: #F00;
}
</style>
</head>
<body>
	<form
		action="${pageContext.request.contextPath }/UserController?method=login" method="post">
		
		<table align="center" style="margin-top: 100px;" cellpadding="10px">
			<tr>
				<td colspan="2" align="right"><span>${requestScope.message}</span></td>
			</tr>
			<tr>
				<th>用户名：</th>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<th>密&nbsp;码：</th>
				<td><input type="password" name="userpwd"></td>
			</tr>
			<tr>
				<td align="right" colspan="2"><input type="button"
					name="userpwd" value="注册">&nbsp;&nbsp;<input type="submit"
					name="username" value="登录"></td>
			</tr>
		</table>
	</form>
</body>
</html>