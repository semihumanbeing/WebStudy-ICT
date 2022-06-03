package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import myutil.SSN;

/**
 * Servlet implementation class JuminAction
 */
@WebServlet("/jumin.do")
public class JuminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �������ڵ�����
		request.setCharacterEncoding("utf-8");
		// �ֹι�ȣ�ޱ�
		String juminNo = request.getParameter("juminNo");
		// �ΰ���������
		SSN ssn = new SSN();
		ssn.setSocialSecuritynumber(juminNo);
		
		int year = ssn.getYear();
		String ganji = ssn.getGanji();
		int age = ssn.getAge();
		String tti = ssn.getT();
		String local = ssn.getLocal();
		String gender = ssn.getGender();
		String season = ssn.getSeason();
		
		// JSON���� ����
		JSONObject json = new JSONObject();
		json.put("year", year);
		json.put("ganji", ganji);
		json.put("age", age);
		json.put("tti", tti);
		json.put("local", local);
		json.put("gender", gender);
		json.put("season", season);
		
		String jsonStr = json.toJSONString();
		
		response.setContentType("text/json; charset=utf-8;");
		
		response.getWriter().print(jsonStr);
		
		

	}

}
