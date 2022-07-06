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

<script type="text/javascript">
function send(f){
	var m_id = f.m_id.value.trim();
	var m_pwd = f.m_pwd.value.trim();
	
	if(m_id==''){
		alert('아이디를 입력하세요');
		f.m_id.value='';
		f.m_id.focus();
		return;
	}
	if(m_pwd==''){
		alert('비밀번호를 입력하세요');
		f.m_pwd.value='';
		f.m_pwd.focus();
		return;
	}
	f.action = "login.do";
	f.submit();
	
}

</script>
<script type="text/javascript">
	$(document).ready(function(){
		setTimeout(showMessage, 100);
	});
	
	function showMessage(){
		if("${param.reason eq 'failedID'}"=="true"){
			alert('아이디가 틀렸습니다');
			return;
		}
		if("${param.reason eq 'failedPWD'}"=="true"){
			alert('비밀번호가 틀렸습니다');
			return;
		}
		if("${param.reason eq 'sessionTimeOut'}"=="true"){
			alert('로그아웃 되었습니다.');
			return;
		}
	}

</script>
</head>
<body>
	<form>
	<input type="hidden" name="url" value="${param.url}">
		<div id="box">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3>로그인</h3>
				</div>
				<div class="panel-body">
					<table class="table table-striped">
						<tr>
							<th>아이디</th>
							<td><input name="m_id" value="${param.m_id}"></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input name="m_pwd" type="password"></td>
						</tr>

						<tr>
							<td colspan="2" align="center"><input type="button"
								class="btn btn-default" value="로그인" onclick="send(this.form);">
								<input type="button" class="btn btn-default" value="목록보기"
								onclick="location.href='../product/list.do'"></td>
						</tr>

					</table>

				</div>
			</div>

		</div>
	</form>
</body>
</html>