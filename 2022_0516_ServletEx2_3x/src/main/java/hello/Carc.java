package hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Carc
 */
@WebServlet("/carc.do")
public class Carc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8;");
		
		PrintWriter out = response.getWriter();
		String su1 = request.getParameter("su1");
		String su2 = request.getParameter("su2");
		int answer = Integer.parseInt(su1)+Integer.parseInt(su2);
		
		out.println("<html>");
		out.println("<head><title>결과</title></head>");
		out.println("<body><h2>");
		out.println("---계산 결과---<br>");
		out.printf("%s + %s = %d", su1, su2, answer);
		out.println("</h2></body>");
		out.println("</html>");
		
		
	}

}
