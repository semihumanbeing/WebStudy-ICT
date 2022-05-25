<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
부서목록 조회
	<table border="1" width="400px">
		<!-- title -->
		<tr>
			<td>부서번호</td>
			<td>부서명</td>
			<td>위치</td>
		</tr>
		<!-- 데이터가 없는 경우 -->
		<c:if test="${ empty list }">
			<tr>
			<td colspan="3" align="center"><font color="red">data가 없습니다.</font></td>
			</tr>
		</c:if>
		<!-- 데이터가 있는 경우 -->
		<!-- for(DeptVO vo: list)와 동일함 -->
		<c:forEach var="vo" items="${list}">
		<tr>
		<td>${vo.deptno}</td>
		<td>${vo.dname}</td>
		<td>${vo.loc}</td>
		</tr>
		</c:forEach>


	</table>


</body>
</html>