<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div><h2>지도, 주차, 문의사항</h2></div>
	<div id="map" style="width: 500px; height: 400px; margin-left: 220px"></div>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=74225eda86e41f228d0a79bee33cbbc0"></script>
	<script>
		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center : new kakao.maps.LatLng(37.55267299632712,
					126.93759003871145), //지도의 중심좌표.
			level : 3
		//지도의 레벨(확대, 축소 정도)
		};
		var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
	</script>
	
	<div id="mapinfo"><br>ICT 호텔 리조트 and 스파는 인천 국제 공항에서 60분, 신촌역에서 5분 거리에 위치하고 있어 편리한 입지를 자랑하며,<br> 몽고메리 링크와 미지휘트니스 골프 코스에 매우 인접해있습니다. <br>또한 다양한 관광지도 편리하게 이용하실 수 있습니다.<br><br> </div>
	<div><h2>주차</h2>
ICT 호텔 리조트 & 스파를 이용하시는 고객께서는 <br>대리 주차 서비스와 일반 주차를 무료로 이용하실 수 있습니다.<br><br><br><br></div>
	<div><h2>문의사항</h2>예약 또는 문의사항은 <br>+82 123 345 1234 또는 <br>concierge.seoul@icthotel.com으로 연락 주시기 바랍니다.<br><br> <br><br></div>

</body>
</html>