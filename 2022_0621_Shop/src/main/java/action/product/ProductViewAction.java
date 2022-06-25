package action.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import vo.ProductVO;

/**
 * Servlet implementation class ProductVriewAction
 */
@WebServlet("/product/view.do")
public class ProductViewAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 1. 파라미터 받기
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
		
		// 2. p_idx에 해당하는 상품정보 1건 얻어오기
		ProductVO vo = ProductDAO.getInstance().selectOne(p_idx);
		
		request.setAttribute("vo", vo);

		//forward
		String forward_page = "product_content.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}

