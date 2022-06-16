package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@WebServlet("/visit/list.do")
public class VisitListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String search = request.getParameter("search");
		String searchText = request.getParameter("searchText");
		
		if(search==null || search.isEmpty()) {
			search = "all";
		}
		// 검색조건을 담을 Map
		Map<String, String> map = new HashMap<String,String>();
		if(!search.equals("all")) {
			if(search.equals("name_content")) {
				map.put("name", searchText);
				map.put("content", searchText);
			} else if(search.equals("name")) {
				map.put("name", searchText);
			} else if(search.equals("content")) {
				map.put("content", searchText);
			}
			
			
		}
		
		
		// 목록 가져오기		
		List<VisitVO> list = VisitDAO.getInstance().selectList(map);
		
		request.setAttribute("list", list);
		
		//forward
		String forward_page = "visitList.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
