<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<script type="text/javascript">
	// 점수 체크 정규식
	var check = /^[0-9]{1,3}$/; // 0에서 999사이

	function send(f) {
		var name = f.name.value.trim();
		var kor = f.kor.value;
		var eng = f.eng.value;
		var mat = f.mat.value;

		if (name == '') {
			alert('이름을 입력하세요');
			f.name.value = '';
			f.name.focus();
			return;
		}

		if (check.test(kor) == false || kor > 100) {
			alert('국어점수는 0에서 100사이의 정수만 입력하세요');
			f.kor.value = '';
			f.kor.focus();
			return;
		}
		if (check.test(eng) == false || eng > 100) {
			alert('영어점수는 0에서 100사이의 정수만 입력하세요');
			f.eng.value = '';
			f.eng.focus();
			return;
		}
		if (check.test(mat) == false || mat > 100) {
			alert('수학점수는 0에서 100사이의 정수만 입력하세요');
			f.mat.value = '';
			f.mat.focus();
			return;
		}
		if(confirm('정말 수정하시겠습니까?')== false){
			return;
		}
		
		f.method = "GET";
		f.action = "update.do";
		f.submit();

	}
</script>
<style type="text/css">
#box {
	width: 400px;
	margin: auto;
	margin-top: 50px;
}

th {
	text-align: right;
}

td {
	text-align: center;
}
</style>
</head>
<body>

	<form>
		<div id="box">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>성적 수정하기</h4>
				</div>
				<div class="panel-body">
					<table class="table">
						<tr>
							<th>이름</th>
							<td><input name="name" value="${vo.name}"></td>
						</tr>
						<tr>
							<th>국어</th>
							<td><input name="kor" value="${vo.kor}"></td>
						</tr>
						<tr>
							<th>영어</th>
							<td><input name="eng" value="${vo.eng}"></td>
						</tr>
						<tr>
							<th>수학</th>
							<td><input name="mat" value="${vo.mat}"></td>
							<td><input name="idx" type="hidden" value="${vo.idx}"></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input
								class="btn btn-primary" type="button" value="수정하기"
								onclick="send(this.form);"> <input
								class="btn btn-warning" type="button" value="목록보기"
								onclick="location.href='list.do'"></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</form>
</body>
</html>