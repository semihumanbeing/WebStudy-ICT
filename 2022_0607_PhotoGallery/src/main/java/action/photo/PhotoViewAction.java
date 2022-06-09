package action.photo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import dao.PhotoDAO;
import vo.PhotoVO;

/**
 * Servlet implementation class PhotoViewAction
 */
@WebServlet("/photo/photoView.do")
public class PhotoViewAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
		PhotoVO vo = PhotoDAO.getInstance().selectOne(p_idx);
		JSONObject json = new JSONObject();
		
		if(vo!=null) {
		json.put("p_idx", vo.getP_idx());
		json.put("p_subject", vo.getP_subject());
		json.put("p_content", vo.getP_content());
		json.put("p_filename", vo.getP_filename());
		json.put("p_ip", vo.getP_ip());
		json.put("p_regdate", vo.getRegdate());
		json.put("m_idx", vo.getM_idx());
		} else {
			json.put("p_idx", 0);
		}
		
		String jsonStr = json.toJSONString();
		response.setContentType("text/json; charset=utf-8;");
		response.getWriter().print(jsonStr);

	}

}
