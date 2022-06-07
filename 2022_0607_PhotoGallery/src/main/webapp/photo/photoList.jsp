<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
#box {
	width: 1000px;
	margin: auto;
	margin-top: 20px;
}
#title{
	background: linear-gradient(to right, #ffa7a3, #5673bd); 
	padding: 0.43em 1em; 
	font-size: 30px; 
	border-radius: 3px; 
	color: #ffffff;
}

#photoBox{
	margin: auto;
	width: 90%;
	height: 500px;
	overflow-y: scroll;
}

.photo{
	width: 160px;
	height: 200px;
	border: 1px solid grey;
	margin: 25px;
	padding: 10px;
	float: left;
	
}

.photo:hover{
	border: 1px solid grey;
}

.photo>img{
	margin-left: 10px;
	margin-bottom: 5px;
	width: 120px;
	height: 120px;
	border: 1px solid gray;
	outline: 1px solid black;
}

#picbtn{
	margin-bottom: 10xp;
}
</style>
</head>
<body>

	<div id="box">
		<div id="title">
		Photo Gallery
		</div>
		<div  style="text-align: right;">
			<!-- 로그인이 안 된 경우 -->
			<c:if test="${empty sessionScope.user}">
				<input id="loginbtn" type="button" class="btn btn-sm" value="로그인" onclick="location.href='../member/memberLoginForm.do';">
			</c:if>
			<!-- 로그인이 된 경우 -->
			<c:if test="${not empty user}">
				<b>${user.name}님 환영합니다.</b>
				<input type="button" value="로그아웃" class="btn btn-sm" onclick="location.href='../memberLogout.do'">
			</c:if>
		</div>
		<div><input type="button" class="btn btn-sm" value="사진올리기"></div>

		<!-- 데이터가 있는경우 -->
		<div id="photoBox">
		<!-- 데이터가 없는 경우 -->
		<!--<c:if test="${ empty list }">
		<div id="empty_msg"><font color="red">사진 정보가 없습니다</font></div>
		</c:if>
		-->
		<c:forEach begin="1" end="20">
		<div class="photo">
			<img>
			<div>제목</div>
			<div>날짜</div>
			<div>다운로드</div>
		
		</div>
		
		</c:forEach>
		
		</div>

	</div>

</body>
</html>