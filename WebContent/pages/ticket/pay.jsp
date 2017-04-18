<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>pay</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.11.0.js"></script>
<style type="text/css">

.cantent{
	
	width:800px;
	border: 1px solid #00F;
	border-color: #EEC591;
	margin-left: 100px;
	margin-top: 100px;
}
.pay {
	margin-top: 20px;
	margin-left: 100px;
}
</style>
</head>
<body>
	<div class="top">
		<%@include file="/pages/head.jsp" %>
	</div>
	<div class="cantent">
	<table cellpadding="8px" >
		<tr>
			<th>车次:</th>
			<td>${line.car_num}</td>
		</tr>
		<tr>
			<th>始发站 - 终点站:</th>
			<td>${line.start_station} - ${line.end_station}</td>
		</tr>
		<tr>
			<th>始发站 - 终点站：</th>
			<td>${line.start_station} - ${line.end_station}</td>
		</tr>
		<tr>
			<th>单张票价:</th>
			<td>${line.ticket_price}</td>
		</tr>
		<tr>
			<th>乘     车     人：</th>
			<td><input type="text" name="name" id="" value="${sessionScope.user.user_name }"></td>
		</tr>
		<tr>
			<th>乘车人电话：</th>
			<td><input type="text" name="phone" id="" value="${sessionScope.user.user_phone }"></td>
		</tr>
		<tr>
			<th></th>
			<td align="right"><input type="button" value="添加乘车人"></td>
		</tr>
	</table>
	<div class="pay">
		<span>数量：<input id="count" type="text" value="1"></span>
		<span>总金额：<input id="totalcount" type="text" value=""></span><br><br><br>
	</div>
	<div style="margin-left: 500px;margin-bottom: 20px;">
		<input type="hidden" name="lineid" value="${line.line_id}">
		<input type="button" name="pay" value="提交订单">
		</div>
	</div>
</body>
<script type="text/javascript">
$(function(){
	$("#count").val("1");
	$("#totalcount").val($("#count").val() * ${line.ticket_price});
});

</script>
</html>