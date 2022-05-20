<%@page import="vo.PersonVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
PersonVO p = new PersonVO("일길동",25,"010-1234-5555");

// requestScope 영역에 값 넣기
request.setAttribute("p", p);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<hr>
PersonVO 출력하기
<hr>
이름: ${ requestScope.p.name }<br>
나이: ${ p.age }<br>
전화번호: ${ p['tel'] }<br>


</body>
</html>