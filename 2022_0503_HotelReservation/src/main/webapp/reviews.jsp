<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ICT호텔</title>
<link rel="stylesheet" href="css/mainpage.css">
<link rel="stylesheet" href="css/mainmenu.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<div class="main">
		<div id="header">
			<%@include file="header/header.jsp"%>
		</div>
		<div id="content">
			<div id="box">
		<div style="margin-bottom:10px;">
		</div>
		
		<table id="table" class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일자</th>
				<th>조회수</th>
			</tr>
			</thead>
			<tbody>
			<tr>
				<td>1</td>
				<td>잘 놀다 갑니다</td>
				<td>류다희</td>
				<td>2022-05-04</td>
				<td>432</td>
			</tr>
			<tr>
				<td>2</td>
				<td>재미있는 경험!</td>
				<td>제임스</td>
				<td>2022-05-02</td>
				<td>312</td>
			</tr>
			<tr>
				<td>3</td>
				<td>속지마세요 여기 학원입니다</td>
				<td>데미무어</td>
				<td>2022-05-02</td>
				<td>144</td>
			</tr>
			<tr>
				<td>4</td>
				<td>어린이날에는 역시 ICT호텔</td>
				<td>감우성</td>
				<td>2022-05-01</td>
				<td>389047</td>
			</tr>
			<tr>
				<td>5</td>
				<td>참재미있었다</td>
				<td>배용준</td>
				<td>2022-04-29</td>
				<td>32</td>
			</tr>
			<tr>
				<td>6</td>
				<td>I couldn't find the hotel plz help</td>
				<td>eric</td>
				<td>2022-04-26</td>
				<td>433</td>
			</tr>
			<tr>
				<td>7</td>
				<td>ICT호텔에서 프로포즈했습니다..</td>
				<td>ㅇㅇ</td>
				<td>2022-04-22</td>
				<td>78</td>
			</tr>
			<tr>
				<td>8</td>
				<td>역대급으로 쉬고 갑니다</td>
				<td>김창식</td>
				<td>2022-04-18</td>
				<td>39</td>
			</tr>
			<tr>
				<td>9</td>
				<td>생각보다 괜찮네...</td>
				<td>양천모</td>
				<td>2022-04-18</td>
				<td>466</td>
			</tr>
			<tr>
				<td>10</td>
				<td>야호</td>
				<td>류다희</td>
				<td>2022-04-02</td>
				<td>96</td>
			</tr>
			</tbody>
		</table>
		<div class="w3-bar">
  <a href="#" class="w3-button">&laquo;</a>
  <a href="#" class="w3-button">1</a>
  <a href="#" class="w3-button">2</a>
  <a href="#" class="w3-button">3</a>
  <a href="#" class="w3-button">4</a>
  <a href="#" class="w3-button">5</a>
  <a href="#" class="w3-button">&raquo;</a>
</div><br>
		<button type="button" class="w3-button w3-dark-grey">글쓰기</button>
		<button type="button" class="w3-button w3-dark-grey">삭제</button>
		<br> <br>
	</div>
		</div>
		<div id="aside">
			<%@include file="menu/homeside.jsp"%>
		</div>
		<div id="footer">
			<%@include file="footer/footer.jsp"%>
		</div>
	</div>
</body>
</html>