<%@ page import="ssn.SSN2"%>
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

	<form>
		<table border="1">
			<tr>
				<th>주민번호:</th>
				<td>${ juminNo }</td>
			</tr>
			<tr>
				<th>출생년도</th>
				<td>${ Year }</td>
			</tr>
			<tr>
				<th>나이</th>
				<td>${ age }</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>${ gender }</td>
			</tr>
			<tr>
				<th>띠</th>
				<td>${tti }</td>
			</tr>
			<tr>
				<th>출생계절</th>
				<td>${season }</td>
			</tr>
			<tr>
				<th>출생지역</th>
				<td>${local }</td>
			</tr>
			<tr>
				<th colspan="2"><a href="Jumin.html">다시하기</a></th>
			</tr>

		</table>
	</form>


</body>
</html>