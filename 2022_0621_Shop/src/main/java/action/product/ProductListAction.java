package action.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import vo.ProductVO;

/**
 * Servlet implementation class ProductListAction
 */
@WebServlet("/product/list.do")
public class ProductListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 수신 인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		// 파라미터 받기
		String category = request.getParameter("category");
		
		// 파라미터가 없을 때 기본값 설정
		if(category == null || category.isEmpty()) {
			category = "com001";
		}
		
		// 카테고리별 상품리스트 구하기
		List<ProductVO> list = ProductDAO.getInstance().selectList(category);
		
		// request binding
		request.setAttribute("list", list);
			
		//forward
		String forward_page = "product_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}

