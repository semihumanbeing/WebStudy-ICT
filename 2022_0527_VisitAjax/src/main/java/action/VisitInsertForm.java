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
@WebServlet("/visit/insertForm.do")
public class VisitInsertForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��� ��������		
		List<VisitVO> list = VisitDAO.getInstance().selectList();
		
		request.setAttribute("list", list);
		
		//forward
		String forward_page = "visitInsertForm.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}