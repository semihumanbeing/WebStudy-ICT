<%@page import="java.util.Properties"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
Properties prop = new Properties();
// 문자열 위주 저장 
prop.put("name", "홍길동");
prop.setProperty("age", "30");
prop.setProperty("addr", "서울시 마포구 노고산동");

// EL로 출력하기
pageContext.setAttribute("prop", prop);


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

이름: ${ prop.name } <br>
나이: ${ prop.age }<br>
주소: ${ prop.addr }<br>

</body>
</html>