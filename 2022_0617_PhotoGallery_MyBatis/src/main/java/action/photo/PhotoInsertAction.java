package action.photo;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.PhotoDAO;
import vo.MemberVO;
import vo.PhotoVO;

/**
 * Servlet implementation class PhotoInsertAction
 */
@WebServlet("/photo/insert.do")
public class PhotoInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// photo/insert.do?p_subject=제목&p_content=내용&p_photo=a.jpg
		// 업로드 위치 
		String webpath = "/upload/"; // 웹경로
		String path = request.getServletContext().getRealPath(webpath); // 절대경로
		
		// 업로드 크기
		int maxSize = 1024 * 1024 * 100; // 100mb
		
		// multipartRequest 이용하기
		MultipartRequest mr = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
		
		// 업로드된 파일명 얻어오기
		String p_filename = "no_file";
		File f = mr.getFile("p_photo");
		if(f!=null) {
			p_filename = f.getName(); // 업로드된 파일명 구하기
		}
		String p_subject = mr.getParameter("p_subject");
		String p_content = mr.getParameter("p_content").replaceAll("\r\n", "<br>");
		
		// ip 
		String ip = request.getRemoteAddr();
		
		// 로그인정보 읽어오기
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		if(user==null) {
			response.sendRedirect("../member/memberLoginForm.do?reason=sessionTimeOut");
			return;
		}
		
		int m_idx = user.getM_idx();
		
		PhotoVO vo = new PhotoVO(p_subject, p_content, p_filename, ip, m_idx);
		
		int res = PhotoDAO.getInstance().insert(vo);
		
		request.setAttribute("vo", vo);
		response.sendRedirect("list.do");
		
		
		
	}

}
