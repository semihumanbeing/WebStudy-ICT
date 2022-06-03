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
<script type="text/javascript">

function del(f){
	
	var idx = f.idx.value;
	var cfmPwd = f.cfmPwd.value.trim();
	
	if(cfmPwd ==''){
		alert('삭제할 게시글의 비밀번호를 입력하세요');
		f.cfmPwd.value='';
		f.cfmPwd.focus();
		return;
	}
	
	// jquery ajax
	$.ajax({
		url:'checkPwd.do', // CheckPasswordAction
		data:{'idx':idx, 'cfmPwd':cfmPwd},
		dataType:'json',
		success:function(resultData){
			// resultData = {"result":true}
			if(resultData.result==false){
				alert('비밀번호가 틀립니다.');
				return;
			}
			
			if(confirm('정말 삭제하시겠습니까?')==false){
				return;
			}
			
			location.href='delete.do?idx='+idx;
			
		},
		error:function(err){
			alert(err.responseText);
		}
	});
	
	
}
function update(f){
	
	var idx = f.idx.value;
	var cfmPwd = f.cfmPwd.value.trim();
	
	if(cfmPwd ==''){
		alert('수정할 게시글의 비밀번호를 입력하세요');
		f.cfmPwd.value='';
		f.cfmPwd.focus();
		return;
	}
	$.ajax({
		url:'checkPwd.do', // CheckPasswordAction
		data:{'idx':idx, 'cfmPwd':cfmPwd},
		dataType:'json',
		success:function(resultData){
			// resultData = {"result":true}
			if(resultData.result ==false){
				alert('비밀번호가 틀렸습니다.');
				f.cfmPwd.value='';
				return;
			}
			if(!confirm('정말 수정하시겠습니까?')){
				return;
			}
			
			location.href="updateForm.do?idx="+idx;
			
		},
		error:function(err){
			alert(err.responseText);
		}
	});
	
	
	
}
</script>

<style type="text/css">
#box {
	width: 500px;
	margin: auto;
	margin-top: 20px;
}

#title {
	font-weight: bold;
	font-size: 20pt;
	text-align: center;
	color: #1DA1F2;
}

.content-type {
	padding: 5px;
	min-height: 60px;
	box-shadow: -1px -1px 1px #777777;
	border: 1px solid grey;
	color: black;
	font-weight: bold;
}
</style>
</head>
<body>
	<div id="box">
		<h1 id="title">::::방명록::::</h1>
		<div style="margin-top: 10px; margin-bottom: 10px; text-align: right;">
			<input class="btn btn-primary" type="button" value="글쓰기"
				onclick="location.href='insertForm.do'">
		</div>
		<c:if test="${ empty list }">
			<div id="emptyMessage">게시글이 없습니다.</div>
		</c:if>

		<c:forEach var="vo" items="${list}">
			<form>
				<input type="hidden" name="idx" value="${vo.idx}">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4>${vo.name}님의글</h4>
					</div>
					<div class="panel-body">
						<div class="content-type">${vo.content}</div>
						<div>작성일자: ${fn:substring(vo.regdate,0,16)} | ${vo.ip}</div>
						<div>
							비밀번호<input type="password" id="cfmPwd"> 
							<input class="btn btn-success" type="button" value="수정" onclick="update(this.form);"> 
							<input class="btn btn-warning" type="button" value="삭제" onclick="del(this.form);">
						</div>
					</div>
				</div>
			</form>
		</c:forEach>

	</div>

</body>
</html>