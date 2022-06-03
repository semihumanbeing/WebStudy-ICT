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
		// 수신인코딩설정
		request.setCharacterEncoding("utf-8");
		// 파라미터받기
		int idx = Integer.parseInt(request.getParameter("idx"));
		String cfmPwd = request.getParameter("cfmPwd");
		
		// idx에 해당하는 게시물 얻어오기
		VisitVO vo = VisitDAO.getInstance().selectOne(idx);
		// 비번체크하기
		boolean bResult = vo.getPwd().equals(cfmPwd);
		
		// json으로 포장하기
		JSONObject json = new JSONObject();
		json.put("result", bResult);
		String jsonStr = json.toJSONString();
		
		// 응답하기
		
		response.setContentType("text/json; charset=utf-8;");
		response.getWriter().print(jsonStr);
		
		
	}

}
