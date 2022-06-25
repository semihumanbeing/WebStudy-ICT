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
 * Servlet implementation class CartDeleteAction
 */
@WebServlet("/product/cart_delete.do")
public class CartDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		if(user==null) {
			response.sendRedirect("../member/loginForm.do?reason=sessionTimeout");
			return;
		}
		
		int c_idx = Integer.parseInt(request.getParameter("c_idx"));
		
		int res = CartDAO.getInstance().delete(c_idx);
		response.sendRedirect("cart_list.do?m_idx="+user.getM_idx());

	}

}

