<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/application.css">
<title>添加</title>
</head>
<body>
	<div style="margin-top: 40px;"></div>
	<form
		action="${pageContext.request.contextPath}/CarController?method=add"
		method="POST">
		<table class="query_form_table" border="0" align="center">
			<tr>
				<th>车牌号：</th>
				<td><input name="carnum" /></td>
			</tr>
			<tr>
				<th>司机名称：</th>
				<td colspan="2"><input name="cardriver" /></td>
			</tr>
			<tr>
				<th>座位数：</th>
				<td colspan="2"><input name="carseat" /></td>
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