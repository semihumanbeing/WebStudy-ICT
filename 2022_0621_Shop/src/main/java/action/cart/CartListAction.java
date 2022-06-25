package action.cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDAO;
import vo.CartVO;

/**
 * Servlet implementation class CartListAction
 */
@WebServlet("/product/cart_list.do")
public class CartListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		int m_idx = Integer.parseInt(request.getParameter("m_idx"));
		
		// m_idx 가 등록한 장바구니 목록 가져오기
		List<CartVO> list= CartDAO.getInstance().selectList(m_idx);
		
		// 장바구니총계 가져오기
		int total_amount = CartDAO.getInstance().selectTotalAmount(m_idx);
		
		// request binding
		request.setAttribute("list", list);
		request.setAttribute("total_amount", total_amount);
		
		//forward
		String forward_page = "cart_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}

