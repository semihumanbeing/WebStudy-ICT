<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="table table-hover">
		<thead>
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>직위</th>
			<th>성별</th>
			<th>부서번호</th>
			<th>입사일자</th>
			<th>상사번호</th>
			<th>연봉</th>
		</tr>
		</thead>
		<c:forEach var="vo" items="${list}">
		<tr>
			<td>${vo.sabun}</td>
			<td>${vo.saname}</td>
			<td>${vo.sajob}</td>
			<td>${vo.sasex}</td>
			<td>${vo.deptno}</td>
			<td>${fn:substring(vo.sahire,0,10)}</td>
			<td>${vo.samgr}</td>
			<td><fmt:formatNumber>${vo.sapay}</fmt:formatNumber>만원</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>