<%@ page import="java.util.Random" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	// 선언부
	int a = 10;
	
	// 멤버메서드
	void sub(){
		
	}
%>

<%
	// scriptlet 코드 (서블릿 서비스내부에 기록된다.)
	// jspservice() 메서드 내에 코딩된다.
	Random random = new Random();
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
for(int i =0; i<5; i++){ 
%>
하이루~<br>
<%} %>

<%int x = 100; %>

a=<%=a %><br>
x=<%= x %>


<% for(int i =0; i<10; i++){
	out.print(a + " ");	
}
	%>



</body>
</html>