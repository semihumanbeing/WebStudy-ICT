<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	var regex_age = /^[0-9]{1,3}$/;
	
	function send1(f){
		var name = f.name.value.trim();
		var age = f.age.value;
		var tel = f.tel.value.trim();
		
		if(name==''){
			alert('이름을 입력하세요');
			f.name.value='';
			f.name.focus();
			return;
		}
		
		if(regex_age.test(age)==false){
			alert('나이는 3자리 수 이하의 숫자만 가능합니다');
			f.age.value='';
			f.age.focus();
			return;
		}
		
		if(tel==''){
			alert('전화번호를 입력하세요');
			f.tel.value='';
			f.tel.focus();
			return;
		}
		
		f.action = "insert1.do";
		f.submit();
		
	}
	
	function send2(f){
		var name = f.name.value.trim();
		var age = f.age.value;
		var tel = f.tel.value.trim();
		
		if(name==''){
			alert('이름을 입력하세요');
			f.name.value='';
			f.name.focus();
			return;
		}
		
		if(regex_age.test(age)==false){
			alert('나이는 3자리 수 이하의 숫자만 가능합니다');
			f.age.value='';
			f.age.focus();
			return;
		}
		
		if(tel==''){
			alert('전화번호를 입력하세요');
			f.tel.value='';
			f.tel.focus();
			return;
		}
		
		f.action = "insert2.do";
		f.submit();
		
	}
	
	function send3(f){
		var name = f.name.value.trim();
		var age = f.age.value;
		var tel = f.tel.value.trim();
		
		if(name==''){
			alert('이름을 입력하세요');
			f.name.value='';
			f.name.focus();
			return;
		}
		
		if(regex_age.test(age)==false){
			alert('나이는 3자리 수 이하의 숫자만 가능합니다');
			f.age.value='';
			f.age.focus();
			return;
		}
		
		if(tel==''){
			alert('전화번호를 입력하세요');
			f.tel.value='';
			f.tel.focus();
			return;
		}
		
		f.action = "insert3.do";
		f.submit();
		
	}
</script>
</head>
<body>
개인정보입력폼
<form>
	<table border="1">
		<tr>
			<th>이름</th>
			<td><input name="name" value="홍길동"></td>
		</tr>
		<tr>
			<th>나이</th>
			<td><input name="age" value="20"></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input name="tel" value="010-1111-1111"></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="낱개로 받기" onclick="send1(this.form);">
				<input type="button" value="객체로 받기" onclick="send2(this.form);">
				<input type="button" value="Map으로 받기" onclick="send3(this.form);">
			</td>
		</tr>
	</table>
</form>
</body>
</html>