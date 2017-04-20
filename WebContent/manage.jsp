<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
body {
	background-image: url(static/img/managebg.jpg);
	repeat: no-repeat;
	background-attachment: fixed;
	filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='static/img/managebg.jpg',
		sizingMethod='scale');
	-ms-filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='static/managebg.jpg',
		sizingMethod='scale');
	background-size: cover;
	-moz-background-size: cover;
	-webkit-background-size: cover;
}

.content:BEFORE {
	content: "";
	display: inline-block;
	height: 100%;
	width: 0;
	vertical-align: middle;
	margin-left: -.25em;
}

.content {
	width: 100%;
	margin-left: 20px;
	display: inline-block;
	vertical-align: middle;
	overflow: auto;
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
/*公共部分主体内容*/
.publicMian {
	border-top: 1px solid #c2ccd5;
	display: flex; /*变为弹性盒模型*/
	display: -webkit-flex;
	background: #fff;
}
/*左边*/
.left {
	width: 168px;
	background: url("static/img/leftBg.png") 0 0 repeat-y;
	margin-right: 10px;
	/*height: 520px;*/
	min-height: 520px;
}

/*右边*/
.right {
	width: 90%;
}
iframe{
	width: 90%;
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
	<%-- <div class="top">
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
	</div> --%>

	<header>
		<%@include file="/pages/head.jsp"%>
	</header>
	<section class="publicMian">
		<div class="left">
			<nav>
				<%@include file="/pages/menu.jsp"%>
			</nav>
		</div>
		<div class="right">
			<iframe  name="showframe" frameborder="0"
				height="500px"
				src="${pageContext.request.contextPath}/pages/content.jsp"></iframe>
		</div>
	</section>
</body>
</html>