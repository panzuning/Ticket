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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery-1.11.0.js"></script>
<style type="text/css">
.top {
	padding-top: 50px;
}

.query {
	margin-bottom: 20px;
}
</style>
<title>车票管理</title>
</head>
<body>
	<div class="top"></div>
	<div class="query">
		&nbsp;&nbsp;订单号：<input id="orderid" name="orderid" value="">
		&nbsp;&nbsp;交易状态：<select id="selectStatu">
			<option>请选择</option>
			<option value="0">未付款</option>
			<option value="1">已付款</option>
			<option value="2">交易关闭</option>
			<option value="3">交易取消</option>
		</select> <input type="hidden" id="paystatu" name="paystatu">
		&nbsp;&nbsp;&nbsp;<input type="button" name="query" value="查询"
			onclick="queryAction()"> &nbsp;&nbsp;
	</div>
	<table width="100%" border="1" cellpadding="0" cellspacing="1"
		class="tableLine DoubleColorTable">
		<tr>
			<td colspan="9" align="center" class="tableLineBg">票务列表</td>
		</tr>
		<tr>
			<td align="center">票编号</td>
			<td align="center">乘车人</td>
			<td align="center">乘车人电话</td>
			<td align="center">车次</td>
			<td align="center">始发站-->终点站</td>
			<td align="center">票价</td>
			<td align="center">订单状态</td>
			<td align="center">出票状态</td>
			<td align="center">操 作</td>
		</tr>
		<c:if test="${!empty requestScope.tickets}">
			<c:forEach var="t" items="${requestScope.tickets}">
				<tr>
					<td align="center">${t.ticketId}</td>
					<td align="center">${t.rider}</td>
					<td align="center">${t.riderphone}</td>
					<td align="center">${t.carNum}</td>
					<td align="center">${t.startStation}-->${t.endStation}</td>
					<td align="center">${t.ticketPrice}</td>
					<td align="center"><c:if test="${t.payStatu == 0}">
					未付款
				</c:if> <c:if test="${t.payStatu == 1}">
					已付款
				</c:if> <c:if test="${t.payStatu == 2}">
					交易关闭
				</c:if> <c:if test="${t.payStatu == 3}">
					交易取消
				</c:if></td>
				<td align="center"><c:if test="${t.drawTicket == 0}">未出票</c:if>
				<c:if test="${t.drawTicket == 1}">已出票</c:if></td>
					<td align="center"><a
						href="#">查看</a>
						| <a
						href="#">删除</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="8" align="center"><input type="hidden"
					id="queryJsonStr" value='' /> <%-- <myTag:page page="${page}"></myTag:page> --%>
				</td>
			</tr>
		</c:if>
		<c:if test="${empty requestScope.tickets}">
			<td colspan="9" align="center">没有查到任何数据。。。</td>
		</c:if>
	</table>
</body>
<script type="text/javascript">
	$(function() {
		$("#selectStatu").change(function() {
			$("#paystatu").val(this.value);
		});
	});
	function queryAction() {
		var orderid = $("#orderid").val();
		var paystatu = $("#paystatu").val();
		window.location.href = "${pageContext.request.contextPath}/OrderController?method=getAllOrder&orderid="
				+ orderid + "&paystatu=" + paystatu;
	}
</script>
</html>