<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>4강의실 홈페이지</title>
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
			<img src="img/company.jpg" width="100%">
			<%@include file="menu/submenu_company.jsp"%>

		</div>
		<div id="content">
			<%@include file="content/mappage.jsp" %>

		</div>
		<div id="footer">
			<%@include file="footer/footer.jsp"%>
		</div>
	</div>


</body>
</html>