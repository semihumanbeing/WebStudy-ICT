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
	width: 500px;
	margin: auto;
	margin-top: 50px;
}

textarea{
	width: 100%;
	height: 150px;
	resize: none;

}
#title{
	width: 100%;
}
#photo > img{
	align: center;
	width: 300px;
	margin-left: 100px;
	margin-top: 10px;

}
</style>
<script type="text/javascript">
function send(f){
	var p_subject = f.p_subject.value.trim();
	var p_content = f.p_content.value.trim();
	var p_idx = f.p_idx.value;
	
	if(p_subject==''){
		alert('제목을 입력하세요');
		f.p_subject.value('');
		f.p_subject.focus();
		return;
	}
	
	if(p_content==''){
		alert('내용을 입력하세요');
		f.p_content.value('');
		f.p_content.focus();
		return;
	}
	
	f.action = "update.do"; // photoUpdateAction
	f.submit();
	
}

</script>

</head>
<body>
	<form>
		<input name="p_idx" type="hidden" value="${vo.p_idx}">
		<div id="box">
			<div class="panel panel-default">
				<div class="panel-heading"><h3>내용수정</h3></div>
				
				<div id="photo">
				<img src="../upload/${vo.p_filename}">
				</div>
				<div class="panel-body">
					<table class="table table-striped">
					<tr>
						<th>제목</th>
						<td><input id="title" name="p_subject" value="${vo.p_subject}"></td>
					</tr>
					
					<tr>
						<th>내용</th>
						<td><textarea name="p_content">${vo.p_content}</textarea></td>
					</tr>
					
					<tr>
						<td colspan ="2" align="center">
						<input class="btn" type="button" value="수정하기" onclick="send(this.form);">
						<input class="btn" type="button" value="목록보기" onclick="location.href='list.do'">
						</td>
					</tr>
					
					</table>

				</div>
			</div>

		</div>
	</form>

</body>
</html>