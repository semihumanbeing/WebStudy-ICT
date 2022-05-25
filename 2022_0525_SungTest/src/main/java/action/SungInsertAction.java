package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.sungTBDAO;
import vo.SungVO;

/**
 * Servlet implementation class SungInsertAction
 */
@WebServlet("/sung/insert.do")
public class SungInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 1. 수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		// 2. 파라미터 받기
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		// 3. SungVO 포장
		SungVO vo = new SungVO(name, kor, eng, mat);
		
		// 4. insert
		int res = sungTBDAO.getInstance().insert(vo);
		
		// 5. 목록보기로 redirect
		
		response.sendRedirect("list.do");
		
		
		
	}

}
