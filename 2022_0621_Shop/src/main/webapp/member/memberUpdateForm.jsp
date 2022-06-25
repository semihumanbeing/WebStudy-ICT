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
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
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
			Swal.fire({
				  icon: 'error',
				  title: '이름을 입력하세요',
				  text: '이름이 비어있습니다.',
				  focusConfirm: true
				}).then((result)=>{
					if(result.isConfirmed){
						f.m_name.value='';
						f.m_name.focus();
					}
				});
			
			return;
			
		}
		
		if(m_pwd==''){
			Swal.fire({
				  icon: 'error',
				  title: '비밀번호를 입력하세요',
				  text: '비밀번호가 비어있습니다.',
				  focusConfirm: true
				}).then((result)=>{
					if(result.isConfirmed){
						f.m_pwd.value='';
						f.m_pwd.focus();
					}
				});
			
			return;
		}
		
		if(m_zipcode==''){
			Swal.fire({
				  icon: 'error',
				  title: '우편번호를 입력하세요',
				  text: '우편번호가 비어있습니다.',
				  focusConfirm: true
				}).then((result)=>{
					if(result.isConfirmed){
						f.m_zipcode.value='';
						f.m_zipcode.focus();
					}
				});
			
			return;
		}
		
		if(m_address==''){
			Swal.fire({
				  icon: 'error',
				  title: '주소를 입력하세요',
				  text: '주소가 비어있습니다.',
				  focusConfirm: true
				}).then((result)=>{
					if(result.isConfirmed){
						f.m_address.value='';
						f.m_address.focus();
					}
				});
			
			return;
		}
		
		Swal.fire({
			  title: '수정하기',
			  html: "<h4>수정하시겠습니까?</h4>",
			  icon: 'question',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: '수정',
			  cancelButtonText: '취소'
			}).then((result) => {
			  if (result.isConfirmed) {
			    f.action = "update.do" // MemberUpdateAction
				f.submit();
			  }
			})
		
	 
	}
</script>
<script type="text/javascript">
// 현재 element가 배치완료되면 자동 호출
$(document).ready(function(){
	$("#m_grade").val('${vo.m_grade}');
	
});
</script>
</head>
<body>


	<form>
	<input type="hidden" name="m_idx" value="${vo.m_idx}" >
		<div id="box">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>회원정보 수정</h4>
				</div>
				<div class="panel-body">
					<table class="table table-striped">
						
						<tr>
							<th>이름</th>
							<td><input name="m_name" value="${vo.m_name}"></td>
						</tr>

						<tr>
							<th>아이디</th>
							<td><input name="m_id" value="${vo.m_id}" readonly="readonly"></td>
						</tr>

						<tr>
							<th>비밀번호</th>
							<td><input name="m_pwd" type="password" value="${vo.m_pwd}"></td>
						</tr>

						<tr>
							<th>우편번호</th>
							<td><input id="m_zipcode" name="m_zipcode" value="${vo.m_zipcode}"><input
								class="btn btn-primary" type="button" value="주소찾기" id="btnFind"
								onclick="find();"></td>
						</tr>

						<tr>
							<th>주소</th>
							<td><input name="m_address" size="60" id="m_address" value="${vo.m_address}"></td>
						</tr>
						
						<tr>
							<th>회원등급</th>
							<td><select id="m_grade" name="m_grade">
								<option value="일반">일반</option>
								<option value="관리자">관리자</option>
							</select></td>
						</tr>

						<tr>
							<td colspan="2" align="center"><input
								class="btn btn-primary" type="button" value="수정하기"
								id="btn-register" onclick="send(this.form)">
								<input class="btn btn-success" type="button" value="목록보기"
								onclick="location.href='list.do';"></td>
						</tr>

					</table>

				</div>
			</div>
		</div>
	</form>

</body>
</html>