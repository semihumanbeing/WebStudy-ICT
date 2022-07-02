<%@page import="vo.PersonVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 생성자를 이용한 방법
	PersonVo p1 = new PersonVo("일길동",20,"010-1111-1111");

	// setter를 이용한 방법
	PersonVo p2 = new PersonVo();
	p2.setName("이길동");
	p2.setAge(21);
	p2.setTel("010-2222-2222");
	
	pageContext.setAttribute("p1", p1);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Non-IoC
이름: ${ p1.name }
</body>
</html>