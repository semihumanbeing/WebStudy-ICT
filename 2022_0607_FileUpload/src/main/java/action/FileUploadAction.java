package action;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class FileUploadAction
 */
@WebServlet("/upload.do")
public class FileUploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// ���
		String webPath = "/upload/";
		//String path = "C:\\Work\\upload";
		ServletContext application = request.getServletContext();
		
		// WebPath -> AbsPath�� ��ȯ�ϱ�
		String path = application.getRealPath(webPath);
		System.out.println(path);
		
		
		// �ִ� ũ��
		int maxSize = 1024*1024*100; // ����������� 100�ް�����Ʈ ������ ������ �ִ�.
				
		// ���Ͼ��ε� ó����ü (MultipartRequest �� ó���ؾ��Ѵ�)
		MultipartRequest mr = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
		
		// ����
		String title = mr.getParameter("title");
		
		//���� ������ ������ request�� �޴´�.
		String ip = request.getRemoteAddr();
		
		// ���ε�� ���ϸ� ���ϱ�
		String filename = "no_file";
		File f = mr.getFile("photo");
		// ���ε�� ������ ������ ���� �̸��� ���ϱ�
		if(f!=null) {
			filename = f.getName();
		}
		
		request.setAttribute("title", title);
		request.setAttribute("ip", ip);
		request.setAttribute("filename", filename);
		

		//forward
		String forward_page = "resultUpload.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
