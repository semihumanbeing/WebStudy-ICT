<%@page import="vo.PersonVo"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// spring bean 이 저장된 저장소 정보를 얻어온다. (JSP 내장객체 ServletContext application 에서 스프링이 사용하고있는 영역 구함)
	WebApplicationContext wc = WebApplicationContextUtils.getWebApplicationContext(application);
	
	// bean 객체가 저장되어있는 장소로부터 id=p1인 객체 정보 얻어오기
	PersonVo p1 = (PersonVo)wc.getBean("p1");
	PersonVo p2 = wc.getBean("p2",PersonVo.class);
	
	pageContext.setAttribute("p1", p1);
	pageContext.setAttribute("p2", p2);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
IoC방식으로 생성된 PersonVo p1 info
<hr>
이름: ${p1.name}<br>
나이: ${p1.age}<br>
전화번호: ${p1.tel}
<br>
<hr>
IoC방식으로 생성된 PersonVo p2 info
<hr>
이름: ${p2.name}<br>
나이: ${p2.age}<br>
전화번호: ${p2.tel}

</body>
</html>