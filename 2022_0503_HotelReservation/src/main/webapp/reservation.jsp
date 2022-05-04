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
			<h2>Deluxe Room</h2>
			<img class="room" src="img/room2.jpg" width="500px" height="300px">
			<button id="resbtn1" class="w3-button w3-block w3-black"
				style="width: 30%">지금 예약하기</button>
			<br> <br>
			<h2>Suite Room</h2>
			<img class="room" src="img/room.jpg" width="500px" height="300px">
			<button id="resbtn2" class="w3-button w3-block w3-black"
				style="width: 30%">지금 예약하기</button>
			<br> <br>
		</div>
		<div id="reserveaside">
			ICT호텔은 뭐시기 양식의 건축 요소를 가미한 모던한 디자인을 담고 있습니다. <br>
			<br>북유럽 고유의 목재와 전통 도자기 차 세트를 비롯해 오리엔탈 예술 작품으로 장식된 객실에서는 아시아 리조트
			특유의 여유로운 분위기를 만끽하실 수 있습니다. <br>
			<br>다양한 종류의 객실을 선택하실 수 있으며 모든 객실이 수려한 오션 뷰를 자랑합니다. 저희 리조트에는
			198개의 일반 객실과 스위트, 1-3개의 침실로 구성된 레지던스 160개와 3개의 침실이 있는 빌라 22개를 갖추고
			있습니다.<br><br>그린 하우스(Green House)에서는 아침부터 저녁까지 다이닝을 즐기실 수 있습니다. 풀
			하우스(Pool House)에서는 정통 베트남 요리와 대표적인 웨스턴 요리를 제공합니다. 비치 하우스(Beach
			House)에서 제공하는 해산물과 그릴 요리를 해변에서 즐겨보세요.
		</div>
		<div id="footer">
			<%@include file="footer/footer.jsp"%>
		</div>
	</div>
</body>
</html>