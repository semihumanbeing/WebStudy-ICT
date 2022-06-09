package action.photo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhotoDAO;
import vo.MemberVO;
import vo.PhotoVO;

/**
 * Servlet implementation class PhotoUpdateAction
 */
@WebServlet("/photo/update.do")
public class PhotoUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		String p_subject = request.getParameter("p_subject");
		String p_content = request.getParameter("p_content").replaceAll("\r\n", "<br>");
		//사진인덱스
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
				
		// ip 
		String ip = request.getRemoteAddr();
		
		// 로그인정보 읽어오기
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		if(user==null) {
			response.sendRedirect("../member/memberLoginForm.do?reason=sessionTimeOut");
			return;
		}
		
		
		// 값 포장하기
		PhotoVO vo = new PhotoVO(p_subject, p_content, ip, p_idx);
		
		// update
		int res = PhotoDAO.getInstance().update(vo);
		
		request.setAttribute("vo", vo);
		response.sendRedirect("list.do");
		
		
		
	}

}
