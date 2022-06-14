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
import vo.ProductVo;

/**
 * Servlet implementation class ProductSearchAction
 */
@WebServlet("/product/search.do")
public class ProductSearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// /product/search.do?p_name=��Ʈ��
		
		// �������ڵ� ����
		request.setCharacterEncoding("utf-8");
		
		// �Ķ���� �ޱ�
		String p_name = request.getParameter("p_name");
		
		int start = 1;
		int display = 10; 
		
		try {
			start = Integer.parseInt(request.getParameter("start"));
		} catch (Exception e) {
			
		}
		
		try {
			display = Integer.parseInt(request.getParameter("display"));
		} catch (Exception e) {
			
		}	
		
		
		
		// �˻����� ��������
		List<ProductVo> list = MySearchUtil.search_shop(p_name, start, display); 
		
		request.setAttribute("list", list);

		//forward
		String forward_page = "productSearch.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}

