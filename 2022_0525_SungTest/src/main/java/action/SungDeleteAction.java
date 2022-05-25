package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.sungTBDAO;
import vo.SungVO;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/sung/delete.do")
public class SungDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 1. 수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		// 2. 파라미터 받기
		int idx = Integer.parseInt(request.getParameter("idx"));

		// 4. delete
		int res = sungTBDAO.getInstance().delete(idx);

		// 5. 목록보기로 redirect
		response.sendRedirect("list.do");

	}

}
