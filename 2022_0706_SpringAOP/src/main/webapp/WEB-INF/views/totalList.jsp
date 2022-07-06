<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
과일목록
<hr>
<ul>
	<c:forEach var="fruit" items="${ map.fruitList }">
		<li>${fruit}</li>
	</c:forEach>
</ul>
<hr>
시도목록
<hr>
<ul>
	<c:forEach var="sido" items="${ map.sidoList }">
		<li>${sido}</li>
	</c:forEach>
</ul>


</body>
</html>