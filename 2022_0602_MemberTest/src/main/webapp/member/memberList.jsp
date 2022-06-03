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
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<style type="text/css">
#box {
	width: 1000px;
	margin: auto;
	margin-top: 30px;
}

#title {
	text-align: center;
	font-size: 25px;
	font-weight: bold;
	color: blue;
}

#table{
	margin-top: 10px;
}

th{
	text-align: center;
}
</style>
<script type="text/javascript">
	function del(m_idx){
		Swal.fire({
			  title: '삭제하기',
			  html: "<h4>삭제하시겠습니까?</h4>",
			  icon: 'question',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: '삭제',
			  cancelButtonText: '취소'
			}).then((result) => {
			  if (result.isConfirmed) {
			    location.href="delete.do?m_idx="+m_idx;
			  }
			})
		
	}
</script>
</head>
<body>

	<div id="box">

		<h1 id="title">::::회원목록::::</h1>
		<!-- 회원가입 -->
		<div>
			<input class="btn btn-primary" type="button" value="회원가입" onclick="location.href='insertForm.do'">
		</div>
		<div id ="table">
			<table class="table table-striped">
				<tr class="info">
					<th>번호</th>
					<th>이름</th>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>우편번호</th>
					<th>주소</th>
					<th>회원등급</th>
					<th>아이피</th>
					<th>가입일자</th>
					<th>편집</th>
				</tr>

				<!-- 데이터가 없는경우 -->
				<c:if test="${empty list }">
					<tr>
						<td colspan="10" align="center"><font color="red">등록된
								회원이 없습니다.</font></td>
					</tr>
				</c:if>

				<c:forEach var="vo" items="${list}">
					<tr>
					<td>${vo.m_idx}</td>
					<td>${vo.m_name}</td>
					<td>${vo.m_id}</td>
					<td>${vo.m_pwd}</td>
					<td>${vo.m_zipcode}</td>
					<td>${vo.m_address}</td>
					<td>${vo.m_grade}</td>
					<td>${vo.m_ip}</td>
					<td>${fn:substring(vo.m_regdate,0,10)}</td>
					<td>
					<input class="btn btn-success" type="button" value="수정" onclick="location.href='updateForm.do?m_idx=${vo.m_idx}';">
					<input class="btn btn-warning" type="button" value="삭제" onclick='del(${vo.m_idx});'>
					</td>
					</tr>
				</c:forEach>


			</table>

		</div>




	</div>



</body>
</html>