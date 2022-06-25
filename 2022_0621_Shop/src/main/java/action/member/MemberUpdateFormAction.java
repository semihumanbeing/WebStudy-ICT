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
 * Servlet implementation class MemberUpdateFormAction
 */
@WebServlet("/member/updateForm.do")
public class MemberUpdateFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int m_idx = Integer.parseInt(request.getParameter("m_idx"));
		
		// m_idx에 해당하는 데이터 가져오기
		
		MemberVO vo = MemberDAO.getInstance().selectOne(m_idx);
		
		request.setAttribute("vo", vo);

		//forward
		String forward_page = "memberUpdateForm.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
