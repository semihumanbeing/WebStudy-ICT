<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	부서목록 조회
	<table border="1" width="600px">
		<!-- title -->
		<tr>
			<td>사번</td>
			<td>사원명</td>
			<td>성별</td>
			<td>부서번호</td>
			<td>직급</td>
			<td>입사일자</td>
			<td>입사일자2</td>
			<td>매니저</td>
			<td>급여</td>
		</tr>
		<!-- 데이터가 없는 경우 -->
		<c:if test="${ empty list }">
			<tr>
				<td colspan="8" align="center"><font color="red">data가
						없습니다.</font></td>
			</tr>
		</c:if>
		<!-- 데이터가 있는 경우 -->
		<!-- for(DeptVO vo: list)와 동일함 -->
		<c:forEach var="vo" items="${list}">
			<tr>
				<td>${vo.sabun}</td>
				<td>${vo.saname}</td>
				<td>${vo.sasex}</td>
				<td>${vo.deptno}</td>
				<td>${vo.sajob}</td>
				<td>${fn:substring(vo.sahire,0,16)}</td>
				<td><fmt:formatDate pattern="YYYY년MM월dd일" value="${vo.sahire}"/></td>
				<td>${vo.samgr}</td>
				<td>${vo.sapay}</td>
			</tr>
		</c:forEach>


	</table>

</body>
</html>