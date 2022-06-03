package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class MemberCheckIDAction
 */
@WebServlet("/member/checkID.do")
public class MemberCheckIDAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String m_id = request.getParameter("m_id");
		
		MemberVO vo = MemberDAO.getInstance().selectOne(m_id);
		// id 사용유무
		boolean bResult = false;
		if(vo==null) bResult = true;
		
		// 결과전송데이터 json으로
		
		JSONObject json = new JSONObject();
		json.put("result", bResult);
		
		String jsonString = json.toJSONString(); // {"result":true}
		
		response.setContentType("text/json; charset=utf-8");
		response.getWriter().print(jsonString);
	}

}
