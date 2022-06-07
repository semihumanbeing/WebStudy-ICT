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
 * Servlet implementation class FileUploadAction2
 */
@WebServlet("/upload2.do")
public class FileUploadAction2 extends HttpServlet {
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
		
		// �ִ� ũ��
		int maxSize = 1024*1024*100; // ����������� 100�ް�����Ʈ ������ ������ �ִ�.
				
		// ���Ͼ��ε� ó����ü (MultipartRequest �� ó���ؾ��Ѵ�)
		MultipartRequest mr = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
		
		// ����
		String title = mr.getParameter("title");
		
		//���� ������ ������ request�� �޴´�.
		String ip = request.getRemoteAddr();
		
		// ���ε�� ���ϸ� ���ϱ�
		String filename1 = "no_file";
		String filename2 = "no_file";
		File f1 = mr.getFile("photo1");
		File f2 = mr.getFile("photo2");
		// ���ε�� ������ ������ ���� �̸��� ���ϱ�
		if(f1!=null) {
			filename1 = f1.getName();
		}
		if(f2!=null) {
			filename2 = f2.getName();
		}
		
		request.setAttribute("title", title);
		request.setAttribute("ip", ip);
		request.setAttribute("filename1", filename1);
		request.setAttribute("filename2", filename2);
		System.out.println(filename1);
		System.out.println(filename2);

		//forward
		String forward_page = "resultUpload.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
