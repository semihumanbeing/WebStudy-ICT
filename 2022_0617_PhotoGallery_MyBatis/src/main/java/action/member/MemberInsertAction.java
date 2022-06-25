package action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class MemberInsertAction
 */
@WebServlet("/member/insert.do")
public class MemberInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String m_name = request.getParameter("m_name");
		String m_id = request.getParameter("m_id");
		String m_pwd = request.getParameter("m_pwd");
		String m_zipcode = request.getParameter("m_zipcode");
		String m_address = request.getParameter("m_address");
		String m_grade = "¿œπ›";
		String m_ip = request.getRemoteAddr();
		
		MemberVO vo = new MemberVO(m_name,m_id,m_pwd,m_zipcode,m_address,m_grade,m_ip);
		
		int res = MemberDAO.getInstance().insert(vo);
		
		response.sendRedirect("../photo/list.do");

	}

}
