<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
	width: 1000px;
	margin: auto;
	margin-top: 20px;
}

#title {
	background: linear-gradient(to right, #ffa7a3, #5673bd);
	padding: 0.43em 1em;
	font-size: 30px;
	border-radius: 3px;
	color: #ffffff;
}

#photoBox {
	margin: auto;
	width: 90%;
	height: 500px;
	overflow-y: scroll;
}

.photo {
	width: 160px;
	height: 210px;
	border: 1px solid grey;
	margin: 25px;
	padding: 10px;
	float: left;
}

.photo:hover {
	border: 1px solid grey;
}

.photo>img {
	margin-left: 10px;
	margin-bottom: 5px;
	width: 120px;
	height: 120px;
	border: 1px solid gray;
	outline: 1px solid black;
}

#picbtn {
	margin-bottom: 10xp;
}

#empty_msg {
	margin-top: 200px;
	text-align: center;
}

.photoClass {
	margin-top: 2px;
	padding: 2px;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}
</style>
<script type="text/javascript">
var global_p_idx;
	function uploadPhoto() {
		// 로그인 여부 확인
		if ("${empty user}" == "true") {
			if (confirm('로그인 후 이용 가능합니다. \n로그인 하시겠습니까?') == false) {
				return;
			}
			location.href = "${pageContext.request.contextPath}/member/memberLoginForm.do";
			return;
		}

		// 로그인된 경우
		location.href = "insertForm.do";

	}
	
	function download(filename){
		if("${empty sessionScope.user}"=="true"){
			if(confirm('로그인 후 파일 다운로드가 가능합니다.\n로그인 하시겠습니까?')==false)return;
			
			location.href="${pageContext.request.contextPath}/member/memberLoginForm.do";
			return;
		}
		// 파일 다운로드 서블릿 호출
		// 파일명이 한글 혹은 특수문자면 인코딩 해서 전송한다.
		location.href="../FileDownload.do?dir=/upload/&filename="+encodeURIComponent(filename,"utf-8");
		
	}
	
	function photoView(p_idx){
		// 화면중앙에 배치
		putCenter();
		
		global_p_idx = p_idx;
		// 데이터 가져와서 세팅하기
		$.ajax({
			url: 'photoView.do', // PhotoViewAction
			data: {"p_idx":p_idx},
			dataType: 'json',
			success: function(resData){
				// 팝업윈도우 배치작업
				$("#photoimg").attr('src','../upload/'+resData.p_filename);
				$("#photoSubject").html(resData.p_subject);
				$("#photoContent").html(resData.p_content);
				$("#photoRegidate").html(resData.p_regdate.substring(0,16));
				
				if(('${user.m_idx}'== resData.m_idx)||("${user.m_grade eq '관리자'}"=="true")){
					$("#photoJob").show();
				} else{
					$("#photoJob").hide();
				}
			},
			error: function(err){
				alert(err.responseText);
			}
			
		});
		
	}
	
	function putCenter(){
		// 화면 중앙을 계산해서 팝업을 보여준다.
		var windowWidth = $(window).width();
		var windowHeight = $(window).height();
		
		console.log(windowWidth, windowHeight);
		
		// popup 크기구하기
		var popupWidth = $("#popup").width();
		var popupHeight = $("#popup").height();
		
		console.log(popupWidth, popupHeight);
		
		var left = windowWidth/2 - popupWidth/2;
		var top = windowHeight/2 - popupHeight/2;
		
		$("#popup").css({'left':left,'top':top});
		
		$("#popup").show();
		
	}
	
	function hidePopup(){
		$("#popup").hide();
		
	}
	

	
	function photoUpdate(){
		location.href="updateForm.do?p_idx=" + global_p_idx;
		// PhotoUpdateFormAction
	}
	
	function photoDelete(){
		if(confirm("정말 삭제하시겠습니까?")==false) return;
		location.href="delete.do?p_idx=" + global_p_idx;
		// PhotoDeleteAction
	}
	
</script>
</head>
<body>
<!-- photo popup 추가하기 -->
<%@include file="PhotoPopup.jsp" %>


	<div id="box">
		<div id="title">Photo Gallery</div>
		<div style="text-align: right;">
			<!-- 로그인이 안 된 경우 -->
			<c:if test="${empty sessionScope.user}">
				<input type="button" class="btn btn-sm" value="로그인"
					onclick="location.href='../member/memberLoginForm.do';">
				<input type="button" class="btn btn-sm" value="회원가입"
					onclick="location.href='../member/insertForm.do';">
			</c:if>
			<!-- 로그인이 된 경우 -->
			<c:if test="${not empty user}">
				<b>${user.m_name}님 환영합니다.</b>
				<input type="button" value="로그아웃" class="btn btn-sm"
					onclick="location.href='../member/logout.do'">
			</c:if>
			<c:if test="${user.m_grade eq '관리자'}">
				<input type="button" value="멤버정보보기" class="btn btn-sm"
					onclick="location.href='../member/list.do'">
			</c:if>
		</div>
		<div>
			<input type="button" class="btn btn-sm" value="사진올리기"
				onclick="uploadPhoto();">
		</div>

		<!-- 데이터가 있는경우 -->
		<div id="photoBox">
			<!-- 데이터가 없는 경우 -->
			<c:if test="${ empty list }">
				<div id="empty_msg">
					<font color="red">사진 정보가 없습니다</font>
				</div>
			</c:if>

			<c:forEach var="vo" items="${list}">
				<div class="photo">
					<img src="../upload/${vo.p_filename}" onclick="photoView('${vo.p_idx}');">
					<div class="photoClass">제목:${vo.p_subject}</div>
					<div class="photoClass">
						<input class="btn" type="button" value="다운로드"
							onclick="download('${vo.p_filename}');">
					</div>

				</div>
			</c:forEach>

		</div>

	</div>

</body>
</html>