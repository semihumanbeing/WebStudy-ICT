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

		// photo/insert.do?p_subject=����&p_content=����&p_photo=a.jpg
		// ���ε� ��ġ 
		String webpath = "/upload/"; // �����
		String path = request.getServletContext().getRealPath(webpath); // ������
		
		// ���ε� ũ��
		int maxSize = 1024 * 1024 * 100; // 100mb
		
		// multipartRequest �̿��ϱ�
		MultipartRequest mr = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
		
		// ���ε�� ���ϸ� ������
		String p_filename = "no_file";
		File f = mr.getFile("p_photo");
		if(f!=null) {
			p_filename = f.getName(); // ���ε�� ���ϸ� ���ϱ�
		}
		String p_subject = mr.getParameter("p_subject");
		String p_content = mr.getParameter("p_content").replaceAll("\r\n", "<br>");
		
		// ip 
		String ip = request.getRemoteAddr();
		
		// �α������� �о����
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
