package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		
		// 1. 파라미터 받고 데이터 편집하기
		
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// 비밀번호 절반만 별찍기
		String returnStr = "";
		for (int i = 0; i < pwd.length(); i++) {
			if (i < pwd.length() / 2) {
				returnStr = returnStr + pwd.substring(i, i + 1);
			} else
				returnStr = returnStr + "*";
		}
		
		String profile = request.getParameter("profile");
		
		String gender = request.getParameter("gender");
		String bloodtype = request.getParameter("bloodtype");
		
		//parameter 명이 동일한 변수 -> 배열로 받는다.
		String[] hobbyArray = request.getParameterValues("hobby");
		String[] friendArray = request.getParameterValues("friend");
		
		//취미 처리하기
		String hobbyList = "취미 없음";
		if (hobbyArray != null) {
			StringBuffer sb = new StringBuffer();
			hobbyList = "";
			for (String hobby : hobbyArray) {
				sb.append(hobby).append(" ");
			}
			hobbyList = sb.toString();
		}
		//친구 처리하기
		String friendList;
		StringBuffer sb1 = new StringBuffer();
		for (String friend : friendArray) {
			sb1.append(friend);
			sb1.append(" ");
		}
		friendList = sb1.toString().trim();
		if (friendList.isEmpty()) {
			friendList = "친구 없음";
		}
		
		// 출력 전에 request binding (request영역에 데이터를 넣어서 공유)
		request.setAttribute("name", name);
		request.setAttribute("id", id);
		request.setAttribute("returnStr", returnStr);
		request.setAttribute("profile", profile);
		request.setAttribute("gender", gender);
		request.setAttribute("bloodtype", bloodtype);
		request.setAttribute("hobbyList", hobbyList);
		request.setAttribute("friendList", friendList);
		
		
		// 2. Dispatcher로 출력 지시하기
		RequestDispatcher disp = request.getRequestDispatcher("member_result.jsp");
		// forward를 통해서 현재 서블릿에서 사용되는 request 또는 response를 그대로 넘긴다.
		disp.forward(request, response);
		
		
	}

}
