package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDAO;
import vo.VisitVO;

/**
 * Servlet implementation class VisitInsertAction
 */
@WebServlet("/visit/insert.do")
public class VisitInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 수신인코딩설정
		request.setCharacterEncoding("utf-8");
		// 파라미터지정
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String pwd = request.getParameter("pwd");
		
		// 내용 중에 \r \n이 있으면 <br>로 변경
		content = content.replaceAll("\r\n", "<br>");
		
		// ip구하기
		String ip = request.getRemoteAddr();
		// visitVO포장
		VisitVO vo = new VisitVO(name, content, pwd);
		vo.setIp(ip);
		
		// DB insert
		int res = VisitDAO.getInstance().insert(vo);
		
		// 목록보기
		response.sendRedirect("list.do");
		
		
	}

}
