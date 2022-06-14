<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
	img{
		width: 120px;
		height: 100px;
	}

</style>
</head>
<body>

	<table class="table table-hover">
		<tr class="success">
			<th>번호</th>
			<th>이미지</th>
			<th>상품명</th>
			<th>가격(최저가)</th>
			<th>가격(최고가)</th>
			<th>판매처</th>
		</tr>
		<c:forEach varStatus="i" var="vo" items="${list}">
		<tr>
			<td>${param.start + i.index}</td>
			<td><img src="${vo.image}"> </td>
			<td><a href="${vo.link}" target="blank">${vo.title}</a></td>
			<td><fmt:formatNumber value="${vo.lprice}"></fmt:formatNumber></td>
			<td><fmt:formatNumber value="${vo.hprice}"></fmt:formatNumber></td>
			<td>${vo.mallName}</td>
		</tr>
		</c:forEach>

	</table>


</body>
</html>