<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
function del(idx){
	
	if(confirm('정말 삭제하시겠습니까?')== false){
		return;
	}
	location.href = "delete.do?idx="+idx;
}
function update(idx){
	location.href = "update_form.do?idx="+idx;
}

</script>
<style type="text/css">
th, td {
	text-align: center;
}

#title {
	text-align: center;
	font-weight: bolder;
	font-size: 20pt;
	color: green;
}

#box {
	width: 800px;
	margin: auto;
	margin-top: 30px;
}


</style>
</head>
<body>
	<div id="box">
		<h1 id="title">::::성적관리::::</h1>
		<div style="text-align: right; margin-bottom: 10px;">
		<button type="button" class="btn btn-primary" onclick="location.href='insert_form.do'">등록하기</button>
		</div>
		<div>
			<table class="table table-hover">
				<thead>
					<tr class="success">
						<th>번호</th>
						<th>이름</th>
						<th>국어</th>
						<th>영어</th>
						<th>수학</th>
						<th>총점</th>
						<th>평균</th>
						<th>등수</th>
						<th>비고</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${empty list }">
						<tr>
							<td colspan="9" align="center"><span style="color: red;">데이터가
									없습니다</span></td>
						</tr>
					</c:if>
					<c:forEach var="vo" items="${ list }">
						<tr>
							<td>${ vo.idx }</td>
							<td>${ vo.name }</td>
							<td>${ vo.kor }</td>
							<td>${ vo.eng }</td>
							<td>${ vo.mat }</td>
							<td>${ vo.tot }</td>
							<td>${ vo.avg }</td>
							<td>${ vo.rank }</td>
							<td><input onclick="update('${vo.idx}');" class="btn btn-success" type="button" value="수정">
								<input onclick="del('${vo.idx}');" class="btn btn-warning" type="button" value="삭제">
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>