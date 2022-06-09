package action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class MemberLoginAction
 */
@WebServlet("/member/login.do")
public class MemberLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// �������ڵ�
		request.setCharacterEncoding("utf-8");
		
		String m_id = request.getParameter("m_id");
		String m_pwd = request.getParameter("m_pwd");
		
		MemberVO user = MemberDAO.getInstance().selectOne(m_id);
		
		if(user == null) {
			response.sendRedirect("memberLoginForm.do?reason=failedID");
			return;
		}
		if(user.getM_pwd().equals(m_pwd)==false) {
			response.sendRedirect("memberLoginForm.do?reason=failedPWD&m_id="+m_id);
			return;
		}
		
		//�α������� ���ǿ� �ֱ�
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		// ������������ �̵�
		// ������������ photo ��ο� �ֱ� ������ ��θ� �ٲ��ش�.
		response.sendRedirect("../photo/list.do");
	}

}
