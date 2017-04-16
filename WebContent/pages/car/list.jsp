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
<title>car</title>
</head>
<body>
	<div class="top"></div>
	<div class="query">
		&nbsp;&nbsp;车牌号：<input id="carnum" name="carnum" value=""> &nbsp;&nbsp;司机：<input
			name="cardriver" id="cardriver" value=""> &nbsp;&nbsp;<input
			type="button" name="query" onclick="queryAction()" value="查询"> &nbsp;&nbsp; <input
			type="button" name="create" onclick="createAction()" value="新增">
	</div>
	<table width="100%" border="1" cellpadding="0" cellspacing="1"
		class="tableLine DoubleColorTable">
		<tr>
			<td colspan="8" align="center" class="tableLineBg">用户列表</td>
		</tr>
		<tr>
			<td align="center">汽车编号</td>
			<td align="center">车牌号</td>
			<td align="center">司机</td>
			<td align="center">座位数</td>
			<td align="center">操 作</td>
		</tr>
		<c:forEach var="c" items="${requestScope.cars}">
			<tr>
				<td align="center">${c.car_id}</td>
				<td align="center">${c.car_num}</td>
				<td align="center">${c.car_driver}</td>
				<td align="center">${c.car_seat}</td>
				<td align="center"><a
					href="${pageContext.request.contextPath}/CarController?method=toUpdate&carid=${c.car_id}">修改</a>
					| <a
					href="${pageContext.request.contextPath}/CarController?method=delete&carid=${c.car_id}">删除</a>
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
function queryAction(){
	var carnum = $("#carnum").val();
	var cardriver = $("#cardriver").val();
	window.location.href = "${pageContext.request.contextPath}/CarController?method=getAllCar&carnum="
		+ carnum
		+ "&cardriver="
		+ cardriver;
}
function createAction(){
	window.location.href = "${pageContext.request.contextPath}/pages/car/create.jsp";
}

</script>
</html>