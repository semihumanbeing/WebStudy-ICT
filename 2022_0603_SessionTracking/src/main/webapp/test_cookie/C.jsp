<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
						//     key : value
	Cookie cookie = new Cookie("C","C.jsp");
	response.addCookie(cookie);
%>

<%@ include file="popup.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
여기는 C.jsp
<a href="C.jsp">여기를 누르면 C.jsp로 이동합니다</a>
</body>
</html>