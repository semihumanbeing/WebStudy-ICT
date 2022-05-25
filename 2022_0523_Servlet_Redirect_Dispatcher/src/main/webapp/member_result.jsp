<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
}

caption {
	text-align: center;
}
</style>
</head>
<body>
	<div id="box">
		<h2>회원정보</h2>
		<table class="table table-striped">

			<tr>
				<th>이름</th>
				<td>${ requestScope.name }</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>${ id }</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>${ returnStr }</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>${ gender }</td>
			</tr>
			<tr>
				<th>취미</th>
				<td>${ hobbyList }</td>
			</tr>
			<tr>
				<th>친구</th>
				<td>${ friendList }</td>
			</tr>
			<tr>
				<th>혈액형</th>
				<td>${ bloodtype }</td>
			</tr>
			<tr>
				<th>프로필</th>
				<td>${ profile }</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><a href="member_form.html">다시하기</a></td>
			</tr>
		</table>
	</div>
</body>
</html>