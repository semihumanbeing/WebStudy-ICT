<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function send1(f){
	var title = f.title.value.trim();
	var photo1 = f.photo[0].value;
	var photo2 = f.photo[1].value;
	
	if(title==''){
		alert('제목을 입력하세요');
		f.title.value='';
		f.title.focus();
		return;
	}
	if(photo1==''){
		alert('사진 1을 선택하세요');
		return;
	}
	if(photo2==''){
		alert('사진 2를 선택하세요');
		return;
	}
	f.action = "upload3.do";
	f.submit();
}

</script>
</head>
<body>

<form method="POST" enctype="multipart/form-data">
	제목:<input name="title">
	<!-- Spring 프로젝트에서는 복수개의파일 업로드 시 반드시 이름을 같게 지정한다. -->
	사진1:<input type="file" name="photo"><br>
	사진2:<input type="file" name="photo"><br>
	<input type="button" value="전송1(따로받기)" onclick="send1(this.form)">
	
</form>

</body>
</html>