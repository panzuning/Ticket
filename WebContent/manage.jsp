<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<frameset rows="160,*" style="background: blue;">
	<frame src="${pageContext.request.contextPath}/pages/head.jsp" frameborder="0" scrolling="NO" noresize
		marginwidth="value"
		marginheight="value">
	<frameset cols="160,*">
		<frame noresize="noresize"
			src="${pageContext.request.contextPath}/pages/menu.jsp"
			frameborder="0">
		<frame src="${pageContext.request.contextPath}/pages/content.jsp"
			name="showframe" frameborder="0">
	</frameset>
</frameset>
</html>