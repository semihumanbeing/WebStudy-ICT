<%@page import="myutil.MySet"%>
<%@page import="myutil.MyList"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	WebApplicationContext wc = WebApplicationContextUtils.getWebApplicationContext(application);

	MySet mySetBean = wc.getBean("mySetBean",MySet.class);
	
	pageContext.setAttribute("mySetBean", mySetBean);
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
	MyList내의 ArrayList 출력하기
<hr>
<ul>
<c:forEach var="local" items="${ mySetBean.set }">
	<li>${ local }</li>
</c:forEach>
</ul>


</body>
</html>