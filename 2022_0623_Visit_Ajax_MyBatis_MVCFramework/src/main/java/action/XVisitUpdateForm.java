package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDAO;
import vo.VisitVO;

/**
 * Servlet implementation class VisitListAction
 */
//@WebServlet("/visit/updateForm.do")
public class XVisitUpdateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		// 목록 가져오기		
		VisitVO vo = VisitDAO.getInstance().selectOne(idx);
		
		// 변경 내용을 다시 세팅하기
		String content = vo.getContent().replaceAll("<br>", "\r\n");
		vo.setContent(content);
		
		request.setAttribute("vo", vo);
		
		//forward
		String forward_page = "visitUpdateForm.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
