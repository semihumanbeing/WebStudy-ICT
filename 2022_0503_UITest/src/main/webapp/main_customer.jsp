<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/main_menu.css">
<link rel="stylesheet" href="css/sub_menu.css">
</head>
<body>
	<div id="main_box">
		<div id="header">
			<%@include file="header/header.jsp"%>
		</div>
		<div id="aside">
			<img src="img/customer.jpg" width="100%">
			<%@include file="menu/submenu_customer.jsp"%>

		</div>
		<div id="content"></div>
		<div id="footer">
			<%@include file="footer/footer.jsp"%>
		</div>
	</div>


</body>
</html>