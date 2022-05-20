<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
/*
 java code 
 EL : Expression language
 1.형식 : $ { 상수 or 변수 or 연산자 }
 2.변수 : 각 scope 에 저장된 변수(pageScope, requestscope, sessionScope, applicationScope)
		param 변수 xxx.jsp?name = 홍길동 => ${param.name}
 3.EL은 출력용 언어. 읽기 전용이라 수정하거나 삭제할 수 없다.
 4.연산자
   - 산술연산자: +, -, *, /(div), %(mod)
   - 관계연산자: >(gt), >=(ge), <(lt), <=(le), ==(eq), !=(ne)
   - 논리연산자: &&(and), ||(or), !(not)
   - 삼항연산자: (조건) ? 참 : 거짓
   - 기타: empty
   
*/

%>
<!-- HTML 주석 EL 표현형식을 HTML에 표시하면 처리가 되기 때문에 JSP주석에 사용해야한다. -->
<%-- JSP 주석 EL 표현형 ${변수}--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
산술연산자
<hr>

\${ 1+2 } => ${ 1+2 } <br>
\${ 3-2 } => ${ 3-2 } <br>
\${ 4*2 } => ${ 4*2 } <br>
\${ 10/3 } => ${ 10/3 } <%--or ${ 10 div 3 }--%> <br>
\${ 10%3 } => ${ 10 % 3 } or ${ 10 mod 3 } <br>

<hr>
관계연산자
<hr>
\${ 3>2 } => ${ 3>2 } <br>
\${ 3 gt 2 } => ${ 3 gt 2 }<br><br>
\${ 3>=2 } => ${ 3>=2 } <br>
\${ 3 ge 2 } => ${ 3 ge 2 }<br><br>
\${ 3<2 } => ${ 3<2 } <br>
\${ 3 lt 2 } => ${ 3 lt 2 }<br><br>
\${ 3<=2 } => ${ 3<=2 } <br>
\${ 3 le 2 } => ${ 3 le 2 }<br><br>
\${ 3==2 } => ${ 3==2 } <br>
\${ 3 eq 2 } => ${ 3 eq 2 }<br><br>
\${ 3!=2 } => ${ 3!=2 } <br>

<hr>
논리연산자
<hr>
\${ true && true } => ${ true && true }<br> 
\${ true && false } => ${ true && false }<br> 

\${ false || false } => ${ false || false }<br>
\${ true || false } => ${ true || false }<br> 

<hr>
기타 : empty (특정 객체가 비어있는지 확인)
<hr>

parameter 메시지 : ${ empty param.msg ? '전달메시지 없음' : param.msg }

</body>
</html>