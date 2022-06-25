<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  <meta http-equiv="Content-Type" 
  		content="text/html; charset=UTF-8">
    <title></title>
    <style>
        a:link{text-decoration:none; color:navy}
        a:visited{text-decoration:none; color:navy}
        a:hover{text-decoration:none; color:red}
    </style>
  </head>
  <body>
  <hr width="600" border="1" noshade color="navy">
  <center>
      <font size="4" color="maroon">
          <b>ITLAND SHOPPING CENTER</b>
      </font>
  </center>
  <hr width="600" border="1" noshade color="navy">
  <center>
      <a href="list.do?category=com001">컴퓨터</a> | 
      <a href="list.do?category=ele002">가전 제품</a> | 
      <a href="list.do?category=sp003">스포츠</a>
  </center>
  <hr width="600" border="1" noshade color="navy">
  <div style="width:600px; text-align: right; margin: auto;">
  <!-- 로그인이 안된경우 -->
  <c:if test="${ empty user }">
  	<input type="button" value="로그인" onclick="location.href='../member/loginForm.do'">
  </c:if>
  <!-- 로그인이 된경우 -->
  <c:if test="${ not empty user }">
  	<b>${ user.m_name }</b>님 환영합니다
  	<input type="button" value="로그아웃" onclick="location.href='../member/logout.do'">
  	<input type="button" 	value="장바구니보기"
onclick="location.href='cart_list.do?m_idx=${user.m_idx}'"/>
  </c:if>
  </div>
  <hr width="600" border="1" noshade color="navy">
  <!-- 관리자인 경우 -->
  <c:if test="${user.m_grade eq '관리자'}">
  <div style="width:600px; margin: auto;">
  	<input type="button" value="상품등록" onclick="location.href='insert_form.do'">
  </div>
  <hr width="600" border="1" noshade color="navy">
  </c:if>
  </body>
</html>