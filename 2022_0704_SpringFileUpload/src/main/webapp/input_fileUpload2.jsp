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
	var photo = f.photo.value;
	if(title==''){
		alert('제목을 입력하세요');
		f.title.value='';
		f.title.focus();
		return;
	}
	if(photo==''){
		alert('사진을 선택하세요');
		return;
	}
	f.action = "upload1.do";
	f.submit();
}

function send2(f){
	var title = f.title.value.trim();
	var photo = f.photo.value;
	if(title==''){
		alert('제목을 입력하세요');
		f.title.value='';
		f.title.focus();
		return;
	}
	if(photo==''){
		alert('사진을 선택하세요');
		return;
	}
	f.action = "upload2.do";
	f.submit();
}
</script>
</head>
<body>

<form method="POST" enctype="multipart/form-data">
	제목:<input name="title">
	사진:<input type="file" name="photo"><br>
	<input type="button" value="전송1(따로받기)" onclick="send1(this.form)">
	<input type="button" value="전송2(같이받기)" onclick="send2(this.form)">
	
</form>

</body>
</html>