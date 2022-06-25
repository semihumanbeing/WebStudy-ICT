<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	var check_cnt = /^[0-9]{1,3}$/;

	function modify(f){
		// 수정할 수량
		var c_cnt = f.c_cnt.value;
		if(check_cnt.test(c_cnt)==false){
			alert('상품은 1~999개만 주문 가능합니다.');
			f.c_cnt.value='1';
			f.c_cnt.focus();
			return;
		}
		f.action = "cart_update.do";
		f.submit();
		
	}
	
	function del(c_idx){
		if(confirm('정말 삭제하시겠습니까?')==false) return;
		location.href="cart_delete.do?c_idx="+c_idx;
	}

</script>
</head>
<jsp:include page="index.jsp"/>
<body>
<form action="purchase.do">
	<table align="center" width="600" border="1"
 style="border-collapse:collapse;font-size:8pt"
 bordercolor="navy" cellpadding="4" cellspacing="0">
		<tr>
			<td colspan="7">:: 장바구니 내용</td>
		</tr>
		<tr bgcolor="#dedede">
			<th>선택</th>
			<th>제품번호</th>
			<th width="25%">제품명</th>
			<th>단가</th>
			<th>수량</th>
			<th>금액</th>
			<th>삭제</th>
		</tr>
		
		<!--  장바구니가 비어있을때 -->
		<c:if test="${ empty list }">
			<tr>
				<td colspan="6" align="center">
					<b>장바구니가 비었습니다.</b>
				</td>
			</tr>
		</c:if>
		
		<!-- 장바구니에 내용이 있을때 -->
		<c:forEach var="vo" items="${ list }">
			<tr align="center">
				<td><input type="checkbox" name="c_idx" value="${ vo.c_idx }"></td>
				<td>${ vo.p_num }</td>
				<td>${ vo.p_name }</td>
				<td>
					단가:<fmt:formatNumber value="${ vo.p_price }"/>원<br>
					<font color="red">
					세일가격:<b><fmt:formatNumber value="${ vo.p_saleprice }"/>원</b>
					</font>
				</td>
				<td>
					<!-- 수량 조정 폼 -->
					<input name="c_cnt" size="4"  align="center" value="${ vo.c_cnt }">
					<input type="button" value="수정" onclick="modify(this.form)">
				</td>
				<td><fmt:formatNumber value="${vo.amount}"/>원</td>
				<td>
					<input type="button" value="삭제"
	 style="border:1 solid black;cursor:hand"
	 onclick="del('${vo.c_idx}')">
				</td>
			</tr>
		</c:forEach>
		

		<tr>
			<td colspan="6" align="right">
				총 결재액 :
			</td>
			<td><fmt:formatNumber value="${ total_amount }"/></td>
		</tr>
		
		<!-- 전체 선택 버튼 -->
		<tr>
			<td colspan="5">
				<input type="checkbox" id="check_all">전체선택
			</td>
			<td colspan="2"align="right">
				<input type="submit" value="결제하기">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>






