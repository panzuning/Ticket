<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.title {
	height: 50px;
}

.title span {
	font-size: 20px;
	float: right;
	margin-top: 10px;
	margin-right: 100px;
}

a {
	font-size: 20px;
}

a:link {
	color: #000000;
	text-decoration: none;
}

a:hover {
	font-size: 20px;
	color: #0063dc;
	text-decoration: none;
}
</style>
<title>Insert title here</title>
</head>
<body style="height: 100px;">
	<div align="center">
		<h1 align="center"
			style="width: 200px; height: 100px; size: 20px; padding-top: 15px;">汽车售票系统</h1>
	</div>
	<div class="title" align="center">
		<span><a href="${pageContext.request.contextPath}/index.jsp">首页</a>
			| <c:if test="${sessionScope.user == null }">
				<a href="${pageContext.request.contextPath}/pages/login.jsp">登录</a>
			</c:if> <c:if test="${sessionScope.user != null }">
		 	欢迎，${sessionScope.user.user_name}|
		 	<c:if test="${sessionScope.user.admin_flag == 1 }">
					<a href="${pageContext.request.contextPath}/manage.jsp">进入后台</a>
				</c:if>|
		 	<a href="${pageContext.request.contextPath}/pages/login.jsp">注销</a>
			</c:if> </span>
	</div>
</body>
</html>