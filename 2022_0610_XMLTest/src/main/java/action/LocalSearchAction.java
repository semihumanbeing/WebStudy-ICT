package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MySearchUtil;
import vo.LocalVO;

/**
 * Servlet implementation class LocalSearchAction
 */
@WebServlet("/local/search.do")
public class LocalSearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String query = request.getParameter("query");
		double latitude = Double.parseDouble(request.getParameter("latitude")); // y
		double longitude = Double.parseDouble(request.getParameter("longitude")); // x
		
	
		List<LocalVO> list = MySearchUtil.search_kakao_local(query, latitude, longitude, 10000);
		
		request.setAttribute("list", list);

		//forward
		String forward_page = "localSearch.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
