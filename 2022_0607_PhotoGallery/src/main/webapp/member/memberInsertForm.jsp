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
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style type="text/css">
#box {
	width: 700px;
	margin: auto;
	margin-top: 60px;
}

#id_msg {
	margin-left: 10px;
	display: inline-block;
	width: 300px;
}
</style>

<script type="text/javascript">
	var check = /^[a-zA-Z0-9]{3,16}$/;

	// 문서내 element 배치가 완료되면 
	$(document).ready(
		function() {
		// 아이디 입력창에서 키가 입력되면
		$("#m_id").keyup(
			function(event) {
			var m_id = $(this).val();
			console.log(m_id);

			if (check.test(m_id) == false) {
				$("#id_msg").html("알파벳,숫자로 16자리까지만 입력 가능합니다").css("color", "red");
				$("#btn-register").attr("disabled", true);
				return;
			}
			//$("#id_msg").html("ㅇㅋ").css("color","blue");

			//서버에 사용가능 여부 확인(jquery ajax)
			$.ajax({
			url : 'checkID.do', // membercheckIDaction
			data : {
					'm_id' : m_id
				}, // parameter
					dataType : 'json',
					success : function(resultData) {
					if (resultData.result) {
					// 사용가능
					$("#id_msg").html('사용 가능한 아이디입니다.').css("color", "blue");
					$("#btn-register").attr("disabled",false);
					} else {	// 이미 사용중인 아이디
					$("#id_msg").html('이미 사용중인 아이디입니다.').css("color", "red");
					$("#btn-register").attr("disabled",true);
						}
					},
					error : function(err) {
						alert(err.responseText);
					}
				});

			});
		});

	function find() {
		var width = 500; //팝업의 너비
		var height = 600; //팝업의 높이
		new daum.Postcode({
			oncomplete : function(data) {
				// data = {'zonecode':12345, 'roadAddress':'서울시 마포구..'}
				// 선택된 주소의 우편번호 넣기
				$("#m_zipcode").val(data.zonecode);
				$("#m_address").val(data.roadAddress);
			},
			theme : {
				searchBgColor : "#FFFFFF", //검색창 배경색
				queryTextColor : "#000000" //검색창 글자색
			},
			width: width, //생성자에 크기 값을 명시적으로 지정해야 합니다.
			height: height,
		}).open({
		    left: (window.screen.width / 2) - (width / 2),
		    top: (window.screen.height / 2) - (height / 2)
		});
		

	}
	
	function send(f){
		// 입력값 체크(이름,비번,우편번호,주소)
		var m_name = f.m_name.value.trim();
		var m_id = f.m_id.value.trim();
		var m_pwd = f.m_pwd.value.trim();
		var m_zipcode = f.m_zipcode;
		var m_address = f.m_address;
		
		if(m_name==''){
			alert('이름을 입력하세요');
			f.m_name.value='';
			f.m_name.focus();
			return;
		}
		
		if(m_id==''){
			alert('아이디를 입력하세요');
			f.m_name.value='';
			f.m_name.focus();
			return;
		}
		
		if(m_pwd==''){
			alert('비밀번호를 입력하세요');
			f.m_pwd.value='';
			f.m_pwd.focus();
			return;
		}
		
		if(m_zipcode==''){
			alert('우편번호를 입력하세요');
			f.m_zipcode.value='';
			f.m_zipcode.focus();
			return;
		}
		
		if(m_address==''){
			alert('주소를 입력하세요');
			f.m_address.value='';
			f.m_address.focus();
			return;
		}
		
		if(confirm('정말 가입하시겠습니까?')){
		f.action = "insert.do" // MemberInsertAction
		f.submit();
		}
	}
</script>
</head>
<body>

<!-- 현재경로: ${pageContext.request.contextPath}<br> -->
	<form>
		<div id="box">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4>회원가입</h4>
				</div>
				<div class="panel-body">
					<table class="table table-striped">

						<tr>
							<th>이름</th>
							<td><input name="m_name"></td>
						</tr>

						<tr>
							<th>아이디</th>
							<td><input id="m_id" name="m_id"> <span id="id_msg"></span></td>
						</tr>

						<tr>
							<th>비밀번호</th>
							<td><input name="m_pwd" type="password"></td>
						</tr>

						<tr>
							<th>우편번호</th>
							<td><input id="m_zipcode" name="m_zipcode"><input
								class="btn" type="button" value="주소찾기" id="btnFind"
								onclick="find();"></td>
						</tr>

						<tr>
							<th>주소</th>
							<td><input name="m_address" size="60" id="m_address"></td>
						</tr>

						<tr>
							<td colspan="2" align="center"><input
								class="btn" type="button" value="가입하기"
								id="btn-register" disabled="disabled" onclick="send(this.form)">
								<input class="btn" type="button" value="목록보기"
								onclick="location.href='${pageContext.request.contextPath}/photo/list.do';"></td>
						</tr>

					</table>

				</div>
			</div>
		</div>
	</form>

</body>
</html>