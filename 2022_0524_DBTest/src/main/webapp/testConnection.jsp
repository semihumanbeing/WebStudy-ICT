<%@page import="service.DBService"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! //선언부
int count = 0;
%>
<%
Connection connection = DBService.getInstance().getConnection();
out.print(String.format("--success: %d--\n", ++count));

connection.close(); // 사용 후에는 반드시 닫아주어야 한다.

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