package action.cart;

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

import dao.CartDAO;
import vo.CartVO;

/**
 * Servlet implementation class CartPaymentAction
 */
@WebServlet("/product/cart_payment.do")
public class CartPaymentAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String[] temp = request.getParameterValues("c_idx");
		int[] c_idx_array = new int[temp.length];
		for(int i = 0; i<c_idx_array.length;i++) {
			c_idx_array[i] = Integer.parseInt(temp[i]);
		}
		// Array나 ArrayList 를 parameter로 넘길 경우 Map의 형태로 넘긴다.
		Map<String,int[]> map = new HashMap<String,int[]>();
		map.put("c_idx_array", c_idx_array);
		
		
		List<CartVO>list = CartDAO.getInstance().selectList(map);
		
		//총 결제액
		int total_count = CartDAO.getInstance().selectTotalAmount(map);
		System.out.println(total_count);
		
		//forward
		String forward_page = "product_cart_payment.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
