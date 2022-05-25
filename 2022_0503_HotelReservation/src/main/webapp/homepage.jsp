<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ICT 호텔</title>
<link rel="stylesheet" href="css/mainpage.css">
<link rel="stylesheet" href="css/mainmenu.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<div class="main">
		<div id="header">
			<%@include file="header/headerhome.jsp"%></div>

		<div id="mainbutton">
			<a href="#">클릭해서 로그인하세요<br>헤더를 누르면 로그인없이 입장됩니다.</a>
		</div>
		<button
			onclick="document.getElementById('id01').style.display='block'"
			class="w3-button w3-black w3-large">Login</button>

		<div id="id01" class="w3-modal">
			<div class="w3-modal-content w3-card-4 w3-animate-zoom"
				style="max-width: 600px">

				<div class="w3-center">
					<br> <span
						onclick="document.getElementById('id01').style.display='none'"
						class="w3-button w3-xlarge w3-hover-red w3-display-topright"
						title="Close Modal">&times;</span> <img src="img/cat.jpg"
						alt="Avatar" style="width: 30%" class="w3-circle w3-margin-top">
				</div>

				<form class="w3-container" action="main_page.jsp">
					<div class="w3-section">
						<label><b>아이디</b></label> <input
							class="w3-input w3-border w3-margin-bottom" type="text"
							placeholder="Enter Username" name="usrname" required> <label><b>비밀번호</b></label>
						<input class="w3-input w3-border" type="password"
							placeholder="Enter Password" name="psw" required>
						<button class="w3-button w3-block w3-green w3-section w3-padding"
							type="submit">로그인</button>
						<input class="w3-check w3-margin-top" type="checkbox"
							checked="checked"> Remember me
					</div>
				</form>

				<div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
					<span class="w3-right w3-padding w3-hide-small">Forgot <a
						href="#">password?</a></span>
				</div>

			</div>
		</div>
		<script>
			// Get the modal
			var modal = document.getElementById('id01');

			// When the user clicks anywhere outside of the modal, close it
			window.onclick = function(event) {
				if (event.target == modal) {
					modal.style.display = "none";
				}
			}
		</script>
	</div>
</body>
</html>