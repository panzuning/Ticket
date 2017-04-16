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
	<form action="${pageContext.request.contextPath}/LineController?method=update" method="POST">
		<table class="query_form_table" border="0" align="center">
			<tr>
				<th>编号</th>
				<td><input name="lineid" readonly="readonly"
					value="${line.line_id}" /> &nbsp;</td>
			</tr>
			<tr>
				<th>始发站</th>
				<td><input name="startStation" value="${line.start_station}" /></td>
				<th>--></th>
				<th>终点站</th>
				<td><input name="endStation" value="${line.end_station}" /></td>
			</tr>
			<tr>
				<th>发车时间</th>
				<td colspan="2"><input name="starttime"
					value="${line.start_time}" /></td>
			</tr>
			<tr>
				<th>预计时间</th>
				<td colspan="2"><input name="expectedtime"
					value="${line.expected_time}" /></td>
			</tr>
			<tr>
				<th>车次</th>
				<td colspan="2"><select name="cars">
						<option value="${line.car_id}" selected="selected">${line.car_num}</option>
						<c:forEach items="${cars}" var="c">
							<option value="${c.car_id}">${c.car_num}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<th>票价</th>
				<td colspan="2"><input name="ticketprice"
					value="${line.ticket_price}" /></td>
			</tr>
			<tr>
				<th>数量</th>
				<td colspan="2"><input name="ticketnum"
					value="${line.ticket_num}" /></td>
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