<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="myTag" 	tagdir="/tags"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.11.0.js"></script>
<style type="text/css">
.top {
	padding-top: 50px;
}
.query {
	margin-bottom: 20px;
	margin-top: 30px;
}
.title {
	height:50px;
}
.title span{
	font-size:20px;
	float: right;
	margin-top: 10px;
	margin-right: 100px;
}
.line{
	height: 1px;
	background-color: #5599FF;
}
/*蓝色边框的表格样式 */
.tableLine {
	border:1px solid #CCCCCC;
}
/** 交替显示颜色的表格 **/
.DoubleColorTable tr{
	background-color:expression("#F5F5F5,#FFFFFF,".split(",")[rowIndex%2]);
	font-size: 12px;
	line-height:25px;
	border:0;
	cellpadding:2;
	cellspacing:1;
	padding-left:5px;
}
/*深蓝色单元格样式 */
.tableLineBg {
	background-color:#7EAAEB;
	font-weight:bold;
	color:#fff;
	padding-left:5px;
	height:25px;
}
body {
	background-image: url(static/img/bg.jpg);
	repeat: no-repeat;
    background-attachment:fixed;
    filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='static/img/bg.jpg', sizingMethod='scale');
    -ms-filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='static/img/bg.jpg', sizingMethod='scale');
    background-size: cover;
    -moz-background-size: cover;
    -webkit-background-size: cover;
}
a{
	font-size: 20px;
}
a:link{
	color:#000000;
	text-decoration:none;
}
a:hover{
	font-size:20px;
	color:#0063dc;
	text-decoration:none;
}
</style>
<title>首页</title>
</head>
<body background="">
	<div class="top">
		<%@include file="/pages/head.jsp" %>
	</div>
	<div class="query">
		&nbsp;&nbsp;车次：<input id="carnum" name="carnum" value="">
		&nbsp;&nbsp;始发站--终点站 ：<input id="startstation" name="startstation"
			value=""> -- <input id="endstation" name="endstation"
			value=""> &nbsp;&nbsp;<input type="button" name="submit"
			onclick="queryAction()" value="查询"> &nbsp;&nbsp; <input
			type="button" name="create" onclick="refrushAction()" value="刷新">
	</div>
	<table width="100%" border="1" cellpadding="0" cellspacing="1"
		class="tableLine DoubleColorTable">
		<tr>
			<td colspan="8" align="center" class="tableLineBg">路线列表</td>
		</tr>
		<tr>
			<td align="center">始发站 ---> 终点站</td>
			<td align="center">车次</td>
			<td align="center">发车时间</td>
			<td align="center">预计到达时间</td>
			<td align="center">票价</td>
			<td align="center">剩余票数</td>
			<td align="center">操 作</td>
		</tr>
		<c:forEach var="l" items="${requestScope.lines}">
			<tr>
				<td align="center">${l.start_station}--->${l.end_station}</td>
				<td align="center">${l.car_num}</td>
				<td align="center">${l.start_time}</td>
				<td align="center">${l.expected_time}</td>
				<td align="center">${l.ticket_price}</td>
				<td align="center">${l.ticket_num}</td>
				<td align="center"><a
					href="${pageContext.request.contextPath}/TicketController?method=toPay&lineid=${l.line_id}">立即购买</a>
					| <a
					href="${pageContext.request.contextPath}/TicketController?method=show&lineid=${l.line_id}">查看</a>
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
		window.location.href = "${pageContext.request.contextPath}/TicketController?method=getAllLine&carnum="
				+ carnum
				+ "&startstation="
				+ startstation
				+ "&endstation="
				+ endstation;
	}
</script>
</html>