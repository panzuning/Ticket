<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>menu</title>
<style type="text/css">
ul {
	float: left;
	line-height: 24px;
	padding-left: 10px;
}

li {
	list-style-type: none;
}

a {
	text-decoration: none;
}
</style>
</head>
<body>
	<ul>
		<li><a target="showframe"
			href="${pageContext.request.contextPath}/TicketController?method=getAllTicket">车票查询</a></li>
		<li><a target="showframe"
			href="${pageContext.request.contextPath}/UserController?method=getAllUser">用户管理</a></li>
		<li><a target="showframe"
			href="${pageContext.request.contextPath}/CarController?method=getAllCar">车辆管理</a></li>
		<li><a target="showframe"
			href="${pageContext.request.contextPath}/LineController?method=getAllLine">路线管理</a></li>
		<li><a target="showframe"
			href="${pageContext.request.contextPath}/OrderController?method=getAllOrder">订单管理</a></li>
	</ul>
</body>
</html>