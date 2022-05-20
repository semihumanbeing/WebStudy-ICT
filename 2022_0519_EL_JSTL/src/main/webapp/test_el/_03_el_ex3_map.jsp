<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

Map map = new HashMap();
map.put("driver", "oracle.jdbc.driver.OracleDriver"); // key, value 구조로 저장
map.put("url","jdbc:oracle:thin:@localhost:1521:xe"); // connection url
map.put("user","scott");
map.put("pwd","tiger");

// page context에 map을 집어넣어야 el을 사용할 수 있다.
pageContext.setAttribute("map", map); // "map" 이라는 키로 map 내의 모든 정보를 저장한다.

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
EL을 이용한 Map data 출력하기
<hr>

${ pageScope.map }<br><br>
DRIVER : ${ map.driver}<br>
URL : ${ map.url }<br> <!-- root 표현방식 -->
USER : ${ map['user']}<br> <!-- bracket표현방식 -->
PWD : ${ map["pwd"] }<br>


</body>
</html>