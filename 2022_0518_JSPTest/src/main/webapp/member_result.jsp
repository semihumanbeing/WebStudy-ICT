<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// java code -> jspService(request, response 메서드 안에 삽입)
	// JSP 내장객체: pagecontext, request, response, session, application
	// 			  out, 
	//수신인코딩설정
	request.setCharacterEncoding("utf-8");
	
	String name = request.getParameter("name");
	
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	// 비밀번호 절반만 별찍기
	String returnStr = "";
	for (int i = 0; i < pwd.length(); i++) {
		if (i < pwd.length() / 2) {
			returnStr = returnStr + pwd.substring(i, i + 1);
		} else
			returnStr = returnStr + "*";
	}
	
	String profile = request.getParameter("profile");
	
	String gender = request.getParameter("gender");
	String bloodtype = request.getParameter("bloodtype");
	
	//parameter 명이 동일한 변수 -> 배열로 받는다.
	String[] hobbyArray = request.getParameterValues("hobby");
	String[] friendArray = request.getParameterValues("friend");
	
	//취미 처리하기
	String hobbyList = "취미 없음";
	if (hobbyArray != null) {
		StringBuffer sb = new StringBuffer();
		hobbyList = "";
		for (String hobby : hobbyArray) {
			sb.append(hobby).append(" ");
		}
		hobbyList = sb.toString();
	}
	//친구 처리하기
	String friendList;
	StringBuffer sb1 = new StringBuffer();
	for (String friend : friendArray) {
		sb1.append(friend);
		sb1.append(" ");
	}
	friendList = sb1.toString().trim();
	if (friendList.isEmpty()) {
		friendList = "친구 없음";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
#box {
	width: 400px;
	margin: auto;
	margin-top: 30px;
	border: 1px solid black;
	
}

caption {
	text-align: center;
}
</style>
</head>
<body>
	<div id="box">
		<table class="table table-striped">
			<caption>::::회원정보::::</caption>
			<tr>
				<th>이름</th>
				<td><%=name%></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><%=id%></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><%=returnStr%></td>
			</tr>
			<tr>
				<th>성별</th>
				<td><%=gender%></td>
			</tr>
			<tr>
				<th>취미</th>
				<td><%=hobbyList%></td>
			</tr>
			<tr>
				<th>친구</th>
				<td><%=friendList%></td>
			</tr>
			<tr>
				<th>혈액형</th>
				<td><%=bloodtype%></td>
			</tr>
			<tr>
				<th>프로필</th>
				<td><%=profile%></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><a href="_06_form_tag2.html">다시하기</a></td>
			</tr>
		</table>
	</div>
</body>
</html>