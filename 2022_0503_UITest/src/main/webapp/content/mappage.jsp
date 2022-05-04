<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="map" style="width: 500px; height: 400px; border-radius: 10px;"></div>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=74225eda86e41f228d0a79bee33cbbc0"></script>
	<script>
		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center : new kakao.maps.LatLng(37.55267299632712,126.93759003871145), //지도의 중심좌표.
			level : 3
		//지도의 레벨(확대, 축소 정도)
		};
		var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
	</script>
	<div id="info">
	찾아오시는 길<br><br>
	신촌역 6번출구에서 도보 5분	
	</div>
</body>
</html>