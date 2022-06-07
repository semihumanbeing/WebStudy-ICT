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
	width: 320px;
	margin: auto;
	margin-top: 100px;
}
</style>

</head>
<body>
	<div id="box">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3>로그인</h3>
			</div>
			<div class="panel-body">
				<table class="table table-striped">
					<tr>
						<th>아이디</th>
						<td><input name="m_id"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input name="m_pwd" type="password"></td>
					</tr>

					<tr>
						<td colspan="2" align="center"><input type="button"
							class="btn btn-default" value="로그인"> <input type="button"
							class="btn btn-default" value="목록보기"
							onclick="location.href='../photo/list.do'"></td>
					</tr>

				</table>

			</div>
		</div>

	</div>
</body>
</html>