<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--  JSTL Library 설정 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<hr>
	JSP scriptlet 을 사용
	<hr>
	<%
	for (int i = 0; i < 5; i++) {
	%>
	안녕
	<%
	}
	%>

	<hr>
	JSTL 사용 (ForEach 문과 If문 사용)
	<hr>
	<!-- varStatus는 객체이다. index, count 속성값 존재 
		 JSTL의 값은 scope영역에 존재하기 때문에 EL을 사용해서 조회할 수 있다. -->
	<c:forEach begin="1" end="5" step="1" varStatus="i">
		<c:if test="${ i.count % 2 == 0 }">
			<font color="red">${ pageScope.i.count }:하이루~</font>
			<br>
		</c:if>
		<c:if test="${ i.count % 2 == 1 }">
			<font color="blue">${ pageScope.i.count }:하이루~</font>
			<br>
		</c:if>
	</c:forEach>

	<hr>
	JSTL 사용 (ForEach 문과 Choose문 사용)
	<hr>
	<!-- varStatus는 객체이다. index, count 속성값 존재 
		 JSTL의 값은 scope영역에 존재하기 때문에 EL을 사용해서 조회할 수 있다. -->
	<c:forEach begin="1" end="5" step="1" varStatus="i">
		<c:choose>
			<c:when test="${ i.count % 2 == 1 }">
				<font color="red">${ pageScope.i.count }:하이루~</font>
				<br>
			</c:when>
			<c:otherwise>
				<font color="blue">${ pageScope.i.count }:하이루~</font>
				<br>
			</c:otherwise>
		</c:choose>
	</c:forEach>


</body>
</html>