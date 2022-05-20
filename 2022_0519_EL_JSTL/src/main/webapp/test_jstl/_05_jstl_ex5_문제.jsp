<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
List<String> seoul = new ArrayList<String>();
seoul.add("강동구");
seoul.add("강남구");
seoul.add("강서구");
seoul.add("강북구");
seoul.add("종로구");

List<String> busan = new ArrayList<String>();
busan.add("해운대구");
busan.add("사하구");
busan.add("수영구");
busan.add("남구");

List<String> daegu = new ArrayList<String>();
daegu.add("수성구");
daegu.add("달서구");
daegu.add("북구");
daegu.add("중구");

Map<String, List<String>> sidoMap = new HashMap<String, List<String>>();
sidoMap.put("seoul", seoul);
sidoMap.put("busan", busan);
sidoMap.put("daegu", daegu);

pageContext.setAttribute("sidoMap", sidoMap);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1" width="300px">
		<tr>
			<th>시</th>
			<th>구</th>
		</tr>
		<c:forEach items="${sidoMap}" var="si">
			<tr>
				<td>${si.key}</td>
				<td>
					<table border="1" width=100%>
						<c:forEach items="${si.value}" var="do1">
							<tr>
								<td>${do1}</td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>