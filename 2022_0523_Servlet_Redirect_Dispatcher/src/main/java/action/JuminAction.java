package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ssn.SSN2;

/**
 * Servlet implementation class JuminAction
 */
@WebServlet("/jumin_action.do")
public class JuminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수신인코딩설정
		request.setCharacterEncoding("utf-8");
		String jumin1 = request.getParameter("jumin1");
		String jumin2 = request.getParameter("jumin2");
		String jumin = jumin1 + jumin2;
		SSN2 ssn = new SSN2();
		ssn.setSocialSecuritynumber(jumin);

		String juminNo = String.format(jumin1 + "-" + jumin2);
		int Year = ssn.getYear();
		int age = ssn.getAge();
		String gender = ssn.getGender();
		String tti = ssn.getT();
		String season = ssn.getSeason();
		String local = ssn.getLocal();
		
		request.setAttribute("juminNo", juminNo);
		request.setAttribute("Year", Year);
		request.setAttribute("age", age);
		request.setAttribute("gender", gender);
		request.setAttribute("tti", tti);
		request.setAttribute("season", season);
		request.setAttribute("local", local);
		
		RequestDispatcher disp = request.getRequestDispatcher("jumin_result.jsp");
		disp.forward(request, response);
		
	}

}
