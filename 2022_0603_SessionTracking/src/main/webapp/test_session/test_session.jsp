<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 내장객체: session, request, out ..
	String session_id = session.getId();
	out.print("jsp: "+session_id + "<br>");
	
	HttpSession session1 = request.getSession();
	out.print("mine: "+session1.getId()+"<br>");
	
	// 유효시간 지정
	session.setMaxInactiveInterval(60);
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


</body>
</html>