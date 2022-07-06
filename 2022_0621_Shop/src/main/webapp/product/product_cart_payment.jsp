<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
#paymentform {
	margin: auto;
	width: 600px;
}
table{
	width: 100%;
	
}
</style>
<script type="text/javascript">
function send(f){
	var pay_method = f.pay_method.value;
	if(pay_method==''){
		alert('결제방식을 선택하세요');
		return;
	}
	if(!confirm('결제하시겠습니까?')){
		return;
	}
	
	f.action = "../cart/payment.do";
	f.submit();
	
}

</script>
</head>
<body>
<div id="paymentform">
<form>
	<hr>
	<h1>결제하기</h1>
	<br>
	<input type="hidden" name="m_idx" value="${ user.m_idx }">
	<h4>${ user.m_name }님의 결제정보입니다.</h4>
	<hr>
	<table class="table table-bordered">
		<tr>
			<th>상품번호</th>
			<th>상품명</th>
			<th>단가(할인가)</th>
			<th>수량</th>
		</tr>
			
		<c:forEach var="p" items="${ list }">
			<input type="hidden" name="c_idx" value="${ p.c_idx }">
		<tr>
			<td>${ p.p_num }</td>
			<td>${ p.p_name }</td>
			<td><fmt:formatNumber value="${ p.p_price }"/>(<fmt:formatNumber value="${ p.p_saleprice }"/>)원</td>
			<td>${ p.c_cnt }</td>
		</tr>
		</c:forEach>
	</table>
	<h1><fmt:formatNumber value="${ total_count }"/>원</h1>
	<input type="radio" name="pay_method" id="card" value="카드결제">
	 <label for="card">카드결제</label><br>
	<input type="radio" name="pay_method" id="transfer" value="무통장입금">
	<label for="transfer">무통장입금</label><br><br>
	<input class="btn btn-primary btn-lg" type="button" value="결제하기" onclick="send(this.form)"><br><br>
	<input class="btn btn-primary btn-sm" type="button" value="홈페이지로 돌아가기" onclick="location.href='list.do'">
</form>
</div>
</body>
</html>