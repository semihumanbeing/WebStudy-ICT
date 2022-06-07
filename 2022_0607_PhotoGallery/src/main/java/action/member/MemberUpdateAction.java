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
@WebServlet("/member/update.do")
public class MemberUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("m_name");
		String pwd = request.getParameter("m_pwd");
		String zipcode = request.getParameter("m_zipcode");
		String address = request.getParameter("m_address");
		String grade = request.getParameter("m_grade");
		int idx = Integer.parseInt(request.getParameter("m_idx"));
		String ip = request.getRemoteAddr();
		
		MemberVO vo = new MemberVO(idx, name, pwd, zipcode, address, grade, ip);
		
		int res = MemberDAO.getInstance().update(vo);
		
		response.sendRedirect("list.do");

	}

}
