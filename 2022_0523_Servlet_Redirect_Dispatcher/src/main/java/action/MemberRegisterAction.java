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
		
		// 1. �Ķ���� �ް� ������ �����ϱ�
		
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// ��й�ȣ ���ݸ� �����
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
		
		//parameter ���� ������ ���� -> �迭�� �޴´�.
		String[] hobbyArray = request.getParameterValues("hobby");
		String[] friendArray = request.getParameterValues("friend");
		
		//��� ó���ϱ�
		String hobbyList = "��� ����";
		if (hobbyArray != null) {
			StringBuffer sb = new StringBuffer();
			hobbyList = "";
			for (String hobby : hobbyArray) {
				sb.append(hobby).append(" ");
			}
			hobbyList = sb.toString();
		}
		//ģ�� ó���ϱ�
		String friendList;
		StringBuffer sb1 = new StringBuffer();
		for (String friend : friendArray) {
			sb1.append(friend);
			sb1.append(" ");
		}
		friendList = sb1.toString().trim();
		if (friendList.isEmpty()) {
			friendList = "ģ�� ����";
		}
		
		// ��� ���� request binding (request������ �����͸� �־ ����)
		request.setAttribute("name", name);
		request.setAttribute("id", id);
		request.setAttribute("returnStr", returnStr);
		request.setAttribute("profile", profile);
		request.setAttribute("gender", gender);
		request.setAttribute("bloodtype", bloodtype);
		request.setAttribute("hobbyList", hobbyList);
		request.setAttribute("friendList", friendList);
		
		
		// 2. Dispatcher�� ��� �����ϱ�
		RequestDispatcher disp = request.getRequestDispatcher("member_result.jsp");
		// forward�� ���ؼ� ���� �������� ���Ǵ� request �Ǵ� response�� �״�� �ѱ��.
		disp.forward(request, response);
		
		
	}

}
