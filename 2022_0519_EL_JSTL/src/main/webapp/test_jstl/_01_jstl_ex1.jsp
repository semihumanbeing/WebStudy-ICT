<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL 라이브러리 연결 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%

/*
	JSTL : JSP Standard Tag Library
	1. c (core): if, choose, forEach 
	2. fmt(formatter): 숫자형식, 날짜형식
	3. fn (function): 문자열 기능(substring, indexOf, length..)
*/
	// 숫자
	int money = 1234500000;
	
	//날짜
	Date today = new Date(); // 현재 시스템 날짜 구하기
	
	//문자열날짜
	String strDate = "2022-05-19 15:42:30.0";
	
	pageContext.setAttribute("money", money);
	pageContext.setAttribute("today", today);
	pageContext.setAttribute("strDate", strDate);



%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fmt:setLocale value="ko_kr"/>
<!-- JSTL내에서 사용되는 값은 EL 표현식으로 표현한다. -->
내가 소유한 현금은....<fmt:formatNumber value="${ money }" type="currency"/> <br>

<!-- JSTL 날짜출력 Date타입만 가능하다. -->
오늘 날짜는 바로바로 <fmt:formatDate pattern="YYYY년MM월dd일" value="${ today }"/><br>

<!-- JSTL 문자열 잘라내기 -->
${ fn:substring(strDate,0,10) } <br>

</body>
</html>