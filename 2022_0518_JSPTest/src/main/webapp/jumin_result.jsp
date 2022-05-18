<%@ page import="ssn.SSN2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//수신인코딩설정
	request.setCharacterEncoding("utf-8");
String jumin1 = request.getParameter("jumin1");
String jumin2 = request.getParameter("jumin2");
String jumin = jumin1 + jumin2;
 SSN2 ssn = new SSN2();
 ssn.setSocialSecuritynumber(jumin);

String juminNo = String.format(jumin1 + "-" + jumin2);



%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<form>
		<table border="1">
			<tr>
				<th>주민번호:</th>
				<td><%=juminNo%></td>
			</tr>
			<tr>
				<th>출생년도</th>
				<td><%=ssn.getYear()%></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><%=ssn.getAge()%></td>
			</tr>
			<tr>
				<th>성별</th>
				<td><%=ssn.getGender()%></td>
			</tr>
			<tr>
				<th>띠</th>
				<td><%=ssn.getT()%></td>
			</tr>
			<tr>
				<th>출생계절</th>
				<td><%=ssn.getSeason()%></td>
			</tr>
			<tr>
				<th>출생지역</th>
				<td><%=ssn.getLocal()%></td>
			</tr>
			<tr>
				<th colspan="2"><a href="Jumin.html">다시하기</a></th>
			</tr>

		</table>
	</form>


</body>
</html>