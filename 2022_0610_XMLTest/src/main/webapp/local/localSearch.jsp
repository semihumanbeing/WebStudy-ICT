<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
	width: 1000px;
}
</style>
</head>
<body>
<!--  결과 table로 만들기 
place_name, road_address_name, place_url, phone, distance
-->
<table class="table table-hover">
<tr>
	<th>번호</th>
	<th>장소명</th>
	<th>거리</th>
	<th>도로명주소</th>
	<th>전화번호</th>
</tr>
<c:forEach varStatus="i" var="vo" items="${list}">
<tr>
<td>${i.count}</td>
<td><a href="${vo.place_url}">${vo.place_name}</a></td>
<td>${vo.distance}m</td>
<td>${vo.road_address_name}</td>
<td>${vo.phone}</td>
</tr>
</c:forEach>
</table>
</body>
</html>