<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">



</style>
<title>订单详情</title>
</head>
<body>
	<div class="top">
		<%@include file="/pages/head.jsp" %>
	</div>
	<div class="content">
		<table border="0" cellpadding="10px;">
			<tr align="right">
				<th>订单号：</th>			
				<td>${orderid}</td>
			</tr>
			<tr align="right">
				<th>车次：</th>			
				<td>${line.car_num }</td>
			</tr>
			<tr align="right">
				<th>始发站 --> 终点站：</th>			
				<td>${line.start_station } --> ${line.end_station }</td>
			</tr>
			<tr align="right">
				<th>乘车人信息：</th>			
				<td>${userinfo }</td>
			</tr>
			<tr align="right">
				<th>数量：</th>			
				<td align="left">${count }</td>
				<th>总金额：</th>			
				<td align="left">${totalcount}</td>
			</tr>
			<tr>
				<td colspan="4" align="right"><input type="button" name="dopay" value="去付款"></td>
			</tr>
		</table>
	
	</div>
	

</body>
</html>