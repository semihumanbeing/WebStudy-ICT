package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import dao.VisitDAO;
import vo.VisitVO;

/**
 * Servlet implementation class CheckPasswordAction
 */
@WebServlet("/visit/checkPwd.do")
public class CheckPasswordAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �������ڵ�����
		request.setCharacterEncoding("utf-8");
		// �Ķ���͹ޱ�
		int idx = Integer.parseInt(request.getParameter("idx"));
		String cfmPwd = request.getParameter("cfmPwd");
		
		// idx�� �ش��ϴ� �Խù� ������
		VisitVO vo = VisitDAO.getInstance().selectOne(idx);
		// ���üũ�ϱ�
		boolean bResult = vo.getPwd().equals(cfmPwd);
		
		// json���� �����ϱ�
		JSONObject json = new JSONObject();
		json.put("result", bResult);
		String jsonStr = json.toJSONString();
		
		// �����ϱ�
		
		response.setContentType("text/json; charset=utf-8;");
		response.getWriter().print(jsonStr);
		
		
	}

}
