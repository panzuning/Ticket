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
<title>line</title>
</head>
<body>
	<div class="top"></div>
	<div class="query">
		&nbsp;&nbsp;车次：<input id="carnum" name="carnum" value="">
		&nbsp;&nbsp;始发站--终点站 ：<input id="startstation" name="startstation"
			value=""> -- <input id="endstation" name="endstation"
			value=""> &nbsp;&nbsp;<input type="button" name="submit"
			onclick="queryAction()" value="查询"> &nbsp;&nbsp; <input
			type="button" name="create" onclick="createAction()" value="新增">
	</div>
	<table width="100%" border="1" cellpadding="0" cellspacing="1"
		class="tableLine DoubleColorTable">
		<tr>
			<td colspan="8" align="center" class="tableLineBg">路线列表</td>
		</tr>
		<tr>
			<td align="center">路线编号</td>
			<td align="center">始发站 ---> 终点站</td>
			<td align="center">车次</td>
			<td align="center">发车时间</td>
			<td align="center">预计到达时间</td>
			<td align="center">票价</td>
			<td align="center">票数</td>
			<td align="center">操 作</td>
		</tr>
		<c:forEach var="l" items="${requestScope.lines}">
			<tr>
				<td align="center">${l.line_id}</td>
				<td align="center">${l.start_station}--->${l.end_station}</td>
				<td align="center">${l.car_num}</td>
				<td align="center">${l.start_time}</td>
				<td align="center">${l.expected_time}</td>
				<td align="center">${l.ticket_price}</td>
				<td align="center">${l.ticket_num}</td>
				<td align="center"><a
					href="${pageContext.request.contextPath}/LineController?method=toUpdate&lineid=${l.line_id}">修改</a>
					| <a
					href="${pageContext.request.contextPath}/LineController?method=delete&lineid=${l.line_id}">删除</a>
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
		window.location.href = "${pageContext.request.contextPath}/LineController?method=toAdd";
	}
	function queryAction() {
		var carnum = $("#carnum").val();
		var startstation = $("#startstation").val();
		var endstation = $("#endstation").val();
		window.location.href = "${pageContext.request.contextPath}/LineController?method=getAllLine&carnum="
				+ carnum
				+ "&startstation="
				+ startstation
				+ "&endstation="
				+ endstation;
	}
</script>
</html>