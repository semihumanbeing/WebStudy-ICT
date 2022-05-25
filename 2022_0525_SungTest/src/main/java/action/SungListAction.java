package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.sungTBDAO;
import vo.SungVO;

/**
 * Servlet implementation class SungListAction
 */
@WebServlet("/sung/list.do")
public class SungListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<SungVO> list = sungTBDAO.getInstance().selectList();
		
		// request binding
		request.setAttribute("list", list);
		
		// forward
		String forwardPage ="sung_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forwardPage);
		disp.forward(request, response);
		
	}

}
