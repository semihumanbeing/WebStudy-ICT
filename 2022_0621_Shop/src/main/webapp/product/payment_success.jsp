<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
#paypanel{
	margin: auto;
	margin-top: 20px;
	width: 600px;
	
}

#resulttable{
	width: 100%;
}
</style>
</head>
<body>
<div id="paypanel">
	<h1>결제 성공!</h1>
	<br>
	<h4>${ user.m_name }님의 결제정보입니다.</h4>
	<hr>
	<table id="resulttable" class="table table-bordered">
		<tr>
			<th>상품번호</th>
			<th>상품명</th>
			<th>단가(할인가)</th>
			<th>수량</th>
			<th>결제방식</th>
		</tr>
		
		<c:forEach var="p" items="${ resultList }">
		<tr>
			<td>${ p.pay_num }</td>
			<td>${ p.pay_name }</td>
			<td><fmt:formatNumber value="${ p.pay_price }"/>(<fmt:formatNumber value="${ p.pay_saleprice }"/>)원</td>
			<td>${ p.pay_cnt }</td>
			<td>${ p.pay_method }</td>
		</tr>
		</c:forEach>
	</table>
	<h1><fmt:formatNumber value="${ total_count }"/>원</h1>

	<input class="btn btn-primary btn-sm" type="button" value="홈페이지로 돌아가기" onclick="location.href='../product/list.do'">
</div>
</body>
</html>