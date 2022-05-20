<%@page import="java.util.Properties"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
// 배열 만들기
String[] fruitArray = { "사과", "참외", "수박", "딸기", "포도" };

// Set
Set<Object> colorSet = new HashSet<Object>();
colorSet.add("Red");
colorSet.add("Green");
colorSet.add("Blue");
colorSet.add("Yellow");
colorSet.add("Cyan");

// List
List<String> sidoList = new ArrayList<String>();
sidoList.add("서울");
sidoList.add("경기");
sidoList.add("인천");
sidoList.add("대전");
sidoList.add("강원");

// Map (객체를 넣을 수 있다.)
Map<String, String> engMap = new HashMap<String, String>();
engMap.put("one", "하나");
engMap.put("two", "둘");
engMap.put("three", "셋");
engMap.put("four", "넷");
engMap.put("five", "다섯");

// Properties에 저장하기 (문자열 위주로 저장된다.)
Properties prop = new Properties();
prop.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
prop.setProperty("url", "jdbc:oracle:thin:@localhost:1521:xe");
prop.setProperty("user", "scott");
prop.setProperty("pwd", "tiger");

// pageContext에 값 넣기
pageContext.setAttribute("fruitArray", fruitArray);
pageContext.setAttribute("colorSet", colorSet);
pageContext.setAttribute("sidoList", sidoList);
pageContext.setAttribute("engMap", engMap);
pageContext.setAttribute("prop", prop);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<hr>
	ForEach 문으로 Array 출력하기
	<hr>
	<ul>
		<!-- for(String fruit: fruitArray) 
		 varStatus="i" i.index(0부터 시작)
		 			   i.count(1부터 시작)
	  	 items="배열 or Collections(set/list) or Map"
	-->
		<c:forEach var="fruit" items="${ fruitArray }" varStatus="i">
			<li>${i.index}: ${ fruit }(${i.count})</li>
		</c:forEach>
	</ul>
	<hr>
	ForEach 문으로 Set 출력하기
	<hr>
	<ul>
		<c:forEach var="color" items="${ colorSet }" varStatus="i">
			<li>${i.index}: ${ color }(${i.count})</li>
		</c:forEach>
	</ul>

	<hr>
	ForEach 문으로 List 출력하기
	<hr>
	<ul>
		<c:forEach var="sido" items="${sidoList}">
			<li>${ sido }</li>
		</c:forEach>
	</ul>

	<hr>
	ForEach 문으로 Map 출력하기
	<hr>
	<ul>
		<c:forEach var="word" items="${ engMap }">
			<%--<li>${ word }</li> --%>
			<li>영어로 ${word.key}는 한글로 ${word.value}입니다.</li>
		</c:forEach>
	</ul>

	<hr>
	ForEach 문으로 Properties 출력하기
	<hr>
	<ul>
		<c:forEach var="info" items="${ prop }">
			<%--<li>${ word }</li> --%>
			<li>${info.key} : ${info.value}</li>
		</c:forEach>
	</ul>

</body>
</html>