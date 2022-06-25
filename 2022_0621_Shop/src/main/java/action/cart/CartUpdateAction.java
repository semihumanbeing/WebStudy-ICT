package action.cart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDAO;
import vo.CartVO;
import vo.MemberVO;

/**
 * Servlet implementation class CartUpdateAction
 */
@WebServlet("/product/cart_update.do")
public class CartUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		int c_idx = Integer.parseInt(request.getParameter("c_idx"));
		int c_cnt = Integer.parseInt(request.getParameter("c_cnt"));
		
		CartVO vo = new CartVO();
		vo.setC_idx(c_idx);
		vo.setC_cnt(c_cnt);
		
		int res = CartDAO.getInstance().update(vo);
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		response.sendRedirect("cart_list.do?m_idx="+user.getM_idx());

	}

}

