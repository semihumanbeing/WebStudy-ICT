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
#popup {
	width: 400px;
	padding: 10px;
	border: 1px solid grey;
	position: absolute;

	background: linear-gradient(to right, #ffa7a3, #5673bd);
	box-shadow: 2px 2px 3px black;
	display: none;
}

#popup>img {
	width: 377px;
	height:377px;
	outline: 1px solid grey;
	
}

#photoSubject{
	background: white;
	padding 3px;
	margin-top: 3px;
	margin-bottom: 3px;
	overflow: visible;

}

#photoContent{
	background: white;
	padding 3px;
	margin-top: 3px;
	margin-bottom: 3px;
	min-height: 60px;
	overflow: visible;

}
</style>
</head>
<body>
	<div id="popup">
		<div style="text-align: right;">
			<span id="photoRegidate"></span>
			<input type="button" value="x" onclick="hidePopup();">
		</div>
		<img id="photoimg" src="../resources/upload${vo.p_filename}">
		<div id="photoSubject">제목</div>
		<div id="photoContent">내용</div>
		<div id="photoJob" style="text-align: center; display:none;'">
			<input type="button" class="btn" value="수정" onclick="photoUpdate();"> 
			<input type="button" class="btn" value="삭제" onclick="photoDelete();">
		</div>
	</div>
</body>
</html>