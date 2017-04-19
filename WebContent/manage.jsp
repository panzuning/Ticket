<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.content:BEFORE {
	content: "";
	display: inline-block;
	height: 100%;
	width: 0;
	vertical-align: middle;
	margin-left: -.25em;
}

.content {
	width:1700px;
	margin-left: 20px;
	display:inline-block;
	vertical-align: middle;
}

.menu {
	width: 100px;
	float: left;
	margin-left: 20px;
}

.showcontent {
	float: left;
	padding-left: 50px;
}
</style>
<title>后台首页</title>
</head>
<%-- <frameset rows="180,*" style="background: blue;">
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
</frameset> --%>
<body>
	<div class="top">
		<%@include file="/pages/head.jsp"%>
	</div>
	<div class="content">
		<div class="menu">
			<%@include file="/pages/menu.jsp"%>
		</div>
		<div class="showcontent">
			<iframe frameborder="0" name="showframe" width="1500px"
				height="500px"
				src="${pageContext.request.contextPath}/pages/content.jsp"></iframe>
		</div>
	</div>
</body>
</html>