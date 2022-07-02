<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	var check_cnt = /^[0-9]{1,3}$/;
	var check_count = 0;

	function modify(c_idx){
		// 수정할 수량
		var c_cnt = document.getElementById("c_cnt_"+c_idx).value;
		if(check_cnt.test(c_cnt)==false){
			alert('상품은 1~999개만 주문 가능합니다.');
			f.c_cnt.value='1';
			f.c_cnt.focus();
			return;
		}
			location.href="cart_update.do?c_idx="+c_idx+"&c_cnt="+c_cnt;
		
	}
	
	function del(c_idx){
		if(confirm('정말 삭제하시겠습니까?')==false) return;
		location.href="cart_delete.do?c_idx="+c_idx;
	}
	
	//체크여부 확인
	$(document).ready(function(){
		$("#check_all").click(function(){
			
			var checked= $(this).is(":checked");
			$("input[name='c_idx']").prop("checked",checked);
			
		});
		// 각각의 체크박스가 클릭되면
		$("input[name='c_idx']").click(function(){
			var total_count = $("input[name='c_idx']").length;
			check_count = $("input[name='c_idx']:checked").length;
			console.log(check_count);
			if(total_count==check_count){
				$("#check_all").prop("checked", true);
			} else{
				$("#check_all").prop("checked", false);
			}
		});
		
	});
	
	function purchase(f){
		if(check_count == 0){
			alert('결제할 상품을 선택하세요');
			return;
		}
		
		f.action = "cart_payment.do";
		f.submit();
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
					<input id="c_cnt_${ vo.c_idx }" size="4"  align="center" value="${ vo.c_cnt }">
					<input type="button" value="수정" onclick="modify('${vo.c_idx}')">
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
				<input type="button" value="결제하기" onclick="purchase(this.form)">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>






