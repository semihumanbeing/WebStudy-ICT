<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
//System.out.println("a.jsp");
// Dispatcher(서버 내부에서 전송)
// Dispatcher 방식 또는 Forward방식
RequestDispatcher disp = request.getRequestDispatcher("b.jsp");

// 현재 a.jsp의 request와 response를 그대로 전달한다.
disp.forward(request, response);


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