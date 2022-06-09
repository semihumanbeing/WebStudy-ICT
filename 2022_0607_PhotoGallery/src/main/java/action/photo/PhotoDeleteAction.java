package action.photo;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhotoDAO;
import vo.PhotoVO;

/**
 * Servlet implementation class PhotoDeleteAction
 */
@WebServlet("/photo/delete.do")
public class PhotoDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// �Ķ���ͱ��ϱ�
		request.setCharacterEncoding("utf-8");
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
		
		// select one �ϰ�
		PhotoVO vo = PhotoDAO.getInstance().selectOne(p_idx);
		
		
		// ������ ���ؼ� ���� ����
		String webPath = "/upload/";
		String path = request.getServletContext().getRealPath(webPath);
		File f = new File(path,vo.getP_filename());
		f.delete();
		
		// db���� delete
		int res = PhotoDAO.getInstance().delete(p_idx);
		
		
		// response send redirect to photo list action
		response.sendRedirect("list.do");
		
		

	}

}
