package action.product;

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

import dao.ProductDAO;
import vo.ProductVO;

/**
 * Servlet implementation class ProductInsertaction
 */
@WebServlet("/product/insert.do")
public class ProductInsertaction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 경로
		String webPath = "/images/";
		ServletContext application = request.getServletContext();
		String path = application.getRealPath(webPath);
		
		int maxSize = 1024*1024*100; // 100mb
		
		// 파일업로드 처리객체
		MultipartRequest mr = new MultipartRequest(request, path, maxSize,"utf-8", new DefaultFileRenamePolicy());
		
		// 파일명 구하기
		String photo_s = "no_file";
		String photo_l = "no_file";
		File fs = mr.getFile("photo_s");
		File fl = mr.getFile("photo_l");
		if(fs!=null) {
			photo_s = fs.getName();
		}
		if(fl!=null) {
			photo_l = fl.getName();
		}
		
		String category = mr.getParameter("category");
		String p_num  = mr.getParameter("p_num");
		String p_name = mr.getParameter("p_name");
		String p_company = mr.getParameter("p_company");
		int p_price = Integer.parseInt(mr.getParameter("p_price"));
		int p_saleprice = Integer.parseInt(mr.getParameter("p_saleprice"));
		String p_content = mr.getParameter("p_content").replaceAll("\r\n", "<br>");
		
		ProductVO vo = new ProductVO(category, p_num, p_name, p_company, p_price, p_saleprice, photo_s, photo_l, p_content);
		ProductDAO.getInstance().insert(vo);
		
		//forward
		response.sendRedirect("list.do?category="+category);

	}

}
