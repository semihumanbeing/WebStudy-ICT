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
import javax.servlet.http.HttpSession;

import dao.CartDAO;
import dao.PaymentDAO;
import vo.CartVO;
import vo.PaymentVO;

/**
 * Servlet implementation class PaymentAction
 */
@WebServlet("/cart/payment.do")
public class PaymentAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// m_idx ��������
		int m_idx = Integer.parseInt(request.getParameter("m_idx"));
		// pay method ��������
		String pay_method = request.getParameter("pay_method");

		// c_idx �Ķ���͵� ��������
		String[] temp = request.getParameterValues("c_idx");
		int[] c_idx_array = new int[temp.length];
		for (int i = 0; i < c_idx_array.length; i++) {
			c_idx_array[i] = Integer.parseInt(temp[i]);
		}
		
		Map map = new HashMap();
		map.put("c_idx_array", c_idx_array);
		
		int order_idx = CartDAO.getInstance().selectMaxOrderIdx(m_idx);
		
		// �� ������
		int total_count = CartDAO.getInstance().selectTotalAmount(map);
		
		// �����ϱ�
		int res = PaymentDAO.getInstance().insertPayment(m_idx, c_idx_array, pay_method, order_idx);
		
		// ������� ����Ʈ 
		List<PaymentVO> resultList = PaymentDAO.getInstance().selectPaymentResult(order_idx);
		
		// īƮ����
		res = CartDAO.getInstance().deleteMap(map);
		
		// request binding
		request.setAttribute("total_count", total_count);
		request.setAttribute("resultList", resultList);
		
		// forward
		String forward_page = "../product/payment_success.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
