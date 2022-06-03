<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% // cookie 정보 읽어오기
	Cookie[] cookieArray = request.getCookies();
	String html = "";
	if(cookieArray !=null){
		StringBuffer sb = new StringBuffer("<h4>[방문페이지]</h4>");
		for(Cookie c: cookieArray){
			String name = c.getName();
			String value = c.getValue();
			if(!name.equals("JSESSIONID")){
				sb.append(String.format("<a href='%s'>%s</a><br>", value, name));
				
			}
		}
		
		html = sb.toString();
	}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#disp {
	position: absolute;
	top: 30px;
	right: 50px;
	width: 200px;
	height: 200px;
	padding: 30px;
	background: #cccccc;
	color: blue;
}

a{
	color: blue;
	text-decoration: none;
}
</style>

</head>
<body>
	<div id="disp"><%= html %></div>
</body>
</html>