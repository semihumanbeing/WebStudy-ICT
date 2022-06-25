package action.cart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import dao.CartDAO;
import vo.CartVO;

/**
 * Servlet implementation class CartInsertAction
 */
@WebServlet("/product/cart_insert.do")
public class CartInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// /product/cart_insert.do?p_idx=1&m_idx=1
		
		request.setCharacterEncoding("utf-8");
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
		int m_idx = Integer.parseInt(request.getParameter("m_idx"));
		
		// 값 지정
		CartVO vo = new CartVO();
		vo.setP_idx(p_idx);
		vo.setM_idx(m_idx);
		
		//조회
		CartVO resVO = CartDAO.getInstance().selectOne(vo);
		
		JSONObject json = new JSONObject();
		
		if(resVO == null) {
			int res = CartDAO.getInstance().insert(vo);
			
			if(res==1) {
				json.put("result", "success");
			} else {
				json.put("result", "fail");
			}
		} else {
			
			json.put("result", "exist");
			
		}
		
		// 결과 전송
		response.setContentType("text/json; charset=utf-8");
		
		response.getWriter().print(json.toJSONString());;

	}

}
