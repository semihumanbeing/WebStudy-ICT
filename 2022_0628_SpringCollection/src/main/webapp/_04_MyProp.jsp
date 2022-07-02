<%@page import="myutil.MyProp"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	WebApplicationContext wc = WebApplicationContextUtils.getWebApplicationContext(application);

	MyProp myPropBean = wc.getBean("myPropBean",MyProp.class);
	
	pageContext.setAttribute("myPropBean", myPropBean);
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
	MyProp내의 Properties 출력하기
<hr>
<ul>
<c:forEach var="jdbc" items="${ myPropBean.prop }">
	<li>${ jdbc.key }:${ jdbc.value }</li>
</c:forEach>
</ul>


</body>
</html>