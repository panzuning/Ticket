<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/application.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.11.0.js"></script>
<title>更新</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/LineController?method=add" method="POST">
		<table class="query_form_table" border="0" align="center">
			<tr>
				<th>始发站</th>
				<td><input name="startStation" /></td>
				<th>--></th>
				<th>终点站</th>
				<td><input name="endStation"  /></td>
			</tr>
			<tr>
				<th>发车时间</th>
				<td colspan="2"><input name="starttime"
					/></td>
			</tr>
			<tr>
				<th>预计时间</th>
				<td colspan="2"><input name="expectedtime"
					/></td>
			</tr>
			<tr>
				<th>车次</th>
				<td colspan="2"><select id="carSelect" name="car" style="width: 100px;" onchange="carchange(this)">
						<c:forEach items="${cars}" var="c">
							<option id="${c.car_seat}" value="${c.car_id}">${c.car_num}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<th>票价</th>
				<td colspan="2"><input name="ticketprice" /></td>
			</tr>
			<tr>
				<th>数量</th>
				<td colspan="2"><input onchange="ticketChange()" id="ticketNum" name="ticketnum"/></td>
			</tr>
			<tr>
				<td align="right"><input type="button" value="cancle" /></td>
				<td align="right"><input type="submit" name="ticketnum"
					width="50px" /></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
function carchange(){
	var $tickeNum = $("select option:selected").attr("id");
	$("#ticketNum").val($tickeNum);
}

function ticketChange(){
	var $tickeNum = $("select option:selected").attr("id");
	var $tn = $("#ticketNum").val();
	if($tn > $tickeNum){
		alert("票数不能大于座位数!");
		$("#ticketNum").val($tickeNum);
	}
}
</script>
</html>