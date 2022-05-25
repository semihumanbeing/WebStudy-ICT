<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

여기는 a.jsp입니다
<%
//	System.out.println("--a.jsp 왔다감--");
	// redirect (응답 내용이 재요청사항)
	response.sendRedirect("b.jsp");
%>

</body>
</html>