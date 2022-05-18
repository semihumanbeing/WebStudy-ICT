package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberRegisterAction
 */
@WebServlet("/member_register.do")
public class MemberRegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//http://localhost:9090/2022_0517_ServletParameter/member_register.do?name=%E3%85%81%E3%85%81%E3%85%81&id=aaa&pwd=aaa&gender=female&friend=&friend=&friend=&friend=&bloodtype=A&profile=aaa
		//수신인코딩설정
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// 비밀번호 절반만 별찍기
		String returnStr="";
		for(int i =0;i <pwd.length();i++) {
			if(i<pwd.length()/2) {
				returnStr = returnStr+pwd.substring(i,i+1);
			} else returnStr = returnStr+"*";
		}
		
		
		String profile = request.getParameter("profile");
		
		String gender = request.getParameter("gender");
		String bloodtype = request.getParameter("bloodtype");
		
		//parameter 명이 동일한 변수 -> 배열로 받는다.
		String [] hobbyArray = request.getParameterValues("hobby");
		String[] friendArray = request.getParameterValues("friend");
		
		//취미 처리하기
		String hobbyList = "취미 없음";
		if(hobbyArray != null) {
			StringBuffer sb = new StringBuffer();
			hobbyList = "";
			for(String hobby : hobbyArray) {
				sb.append(hobby).append(" ");
			}
			hobbyList = sb.toString();
		}
		//친구 처리하기
		String friendList;
		StringBuffer sb1 = new StringBuffer();
		for(String friend : friendArray) {
			sb1.append(friend);
			sb1.append(" ");
		}
		friendList = sb1.toString().trim();
		if(friendList.isEmpty()) {
			friendList = "친구 없음";
		}
		
		//응답처리
		response.setContentType("text/html; charset=utf-8;");
		
		//html 동적생성 -> 저장할 버퍼
		StringBuffer htmlBuffer = new StringBuffer();
		htmlBuffer.append("<html>");
		htmlBuffer.append("<head><title>결과</title></head>");
		htmlBuffer.append("<body><h2>내 프로필</h2>");
		htmlBuffer.append("<table border='1' width ='400'>");
		htmlBuffer.append(String.format("<tr><th width='100px'>이름</th><td>%s</td></tr>", name));
		htmlBuffer.append(String.format("<tr><th>아이디</th><td>%s</td></tr>", id));
		htmlBuffer.append(String.format("<tr><th>비밀번호</th><td>%s</td></tr>", returnStr));
		htmlBuffer.append(String.format("<tr><th>성별</th><td>%s</td></tr>", gender));
		htmlBuffer.append(String.format("<tr><th>취미</th><td>%s</td></tr>", hobbyList));
		htmlBuffer.append(String.format("<tr><th>친구</th><td>%s</td></tr>", friendList));
		htmlBuffer.append(String.format("<tr><th>혈액형</th><td>%s형</td></tr>", bloodtype));
		htmlBuffer.append(String.format("<tr><th>프로필</th><td>%s</td></tr>", profile));
		htmlBuffer.append("<tr><td colspan='2' align='center'><a href='_06_form_tag2.html'>다시하기</a></td></tr>");
		htmlBuffer.append("</table>");
		htmlBuffer.append("</body>");
		htmlBuffer.append("</html>");
		
		//전송
		response.getWriter().print(htmlBuffer.toString());
		
	}

}
