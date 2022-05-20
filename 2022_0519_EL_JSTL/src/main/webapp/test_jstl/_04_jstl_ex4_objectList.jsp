<%@page import="java.util.ArrayList"%>
<%@page import="vo.PersonVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
List<PersonVO> pList = new ArrayList<PersonVO>();
pList.add(new PersonVO("일길동", 21, "010-1234-1111"));
pList.add(new PersonVO("이길동", 22, "010-1234-2222"));
pList.add(new PersonVO("삼길동", 23, "010-1234-3333"));
pList.add(new PersonVO("사길동", 24, "010-1234-4444"));
pList.add(new PersonVO("오길동", 25, "010-1234-5555"));

pageContext.setAttribute("pList", pList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">

.container {
	magin-top: 10px;
	margin: auto;
	width: 500px;
	padding-top: 80px;
	
	
}
.table {
	border: 1px solid black;
	position: relative;
	margin-top: 50px;
}

#windowtap {
	width: 600px;
	margin-left: 500px;
	position: absolute;
	vertical-align: middle;
	
}
</style>
</head>
<body>
	<div id="windowtap"><img src="../img/window.jpg" ></div>
		<div class="container mt-3">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>이름</th>
						<th>나이</th>
						<th>전화번호</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${pList}" varStatus="i">
						<tr>
							<td>${i.count}</td>
							<td>${vo.name}</td>
							<td>${vo.age}</td>
							<td>${vo.tel}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		
	</div>
</body>
</html>