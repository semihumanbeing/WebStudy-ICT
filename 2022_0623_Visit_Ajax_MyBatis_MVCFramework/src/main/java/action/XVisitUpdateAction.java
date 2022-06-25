package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDAO;
import vo.VisitVO;

/**
 * Servlet implementation class VisitDeleteAction
 */
//@WebServlet("/visit/update.do")
public class XVisitUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String content = request.getParameter("content").replaceAll("\r\n", "<br>");
		String ip = request.getRemoteAddr();
		
		VisitVO vo = new VisitVO(idx, content);
		vo.setIp(ip);
		
		int res = VisitDAO.getInstance().update(vo);
		
		response.sendRedirect("list.do");

	}

}
