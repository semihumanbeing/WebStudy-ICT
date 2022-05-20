<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 수행영역: _jspService()
	// 각 영역에 데이터 넣기
	
	pageContext.setAttribute("msg", "page영역에서 온 메시지입니다. <br>이 편지는 영국에서 최초로 시작되어 4일 안에 당신 곁을 떠나야 합니다. ");
	request.setAttribute("msg", "request영역에서 온 메시지입니다. <br>이 글을 본 당신생명이 하루밖에 남지 않았습니다. 정말 죄송합니다. <br>저도 이런 글 올리는 것 죄송한데요 제 친구도 제 말을 거짓말로 알았다가 죽었습니다.");
	session.setAttribute("msg", " session영역에서 온 메시지입니다. <br>여러분 제가 드디어 버그를 알아냈습니다! <br>이 글을 다른곳에다가 5번 옮기고 F3을 누르면 캐시창에 9999999999원이 있고 창고에 99999999999템이 들어올것입니다 꼭 해보세요!");
	application.setAttribute("msg", "applicationScope영역에서 온 메시지입니다. <br>이것은 불행의 자동응답입니다. 이것을 들은 사람은 곧바로 50가구의 집에 전화를 해야 합니다. <br>이를 실행한 사람은 더욱 불행해질 것입니다. 그럼 실례…….");
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 형식: ${영역.객체명} --%>

pageScope 내의 msg : <br>${ pageScope.msg }<br><br>
requestScope 내의 msg : <br>${ requestScope.msg }<br><br>
sessionScope 내의 msg : <br>${ sessionScope.msg }<br><br>
applicationScope 내의 msg : <br>${ applicationScope.msg }<br><br>

나는 어느 영역의 msg일까? : ${ msg }

<%-- 
영역이 생략되면 참조되는 순서
1. pageScope 
2. requestScope
3. sessionScope
4. applicationScope

 --%>

</body>
</html>