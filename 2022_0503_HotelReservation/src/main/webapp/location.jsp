<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ICT호텔</title>
<link rel="stylesheet" href="css/mainpage.css">
<link rel="stylesheet" href="css/mainmenu.css">
</head>
<body>
	<div class="main">
		<div id="header">
			<%@include file="header/header.jsp"%>
		</div>
		<div id="content">
			<%@include file="contents/mappage.jsp" %>
		</div>
		<div id="aside">
			<%@include file="menu/homeside.jsp"%>
		</div>
		<div id="footer">
			<%@include file="footer/footer.jsp"%>
		</div>
	</div>
</body>
</html>