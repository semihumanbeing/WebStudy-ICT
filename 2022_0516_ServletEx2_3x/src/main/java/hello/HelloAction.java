package hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloAction
 */
@WebServlet("/Hello.do")
public class HelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(
			HttpServletRequest request, // ��ûó����ü (Ŭ���̾�Ʈ->���������� �Ѿ���� ����)
			HttpServletResponse response // ����ó����ü(����->Ŭ���̾�Ʈ ������ ���޵Ǵ� ����)
			) 
					throws ServletException, IOException {
		String ip = request.getRemoteAddr();
		System.out.printf("[%s]: --helloAction call--\n", ip);
		
		// ��û������ ������ ���ؼ� �����Ѵ�
		// /2022_0516_ServletEx2_3x/Hello.do
		// /2022_0516_ServletEx2_3x/Hello.do?nation=kor
		// /2022_0516_ServletEx2_3x/Hello.do?nation=eng
		// /2022_0516_ServletEx2_3x/Hello.do?nation=jpn
		// /2022_0516_ServletEx2_3x/Hello.do?nation=chn
		// /2022_0516_ServletEx2_3x/Hello.do?nation=ger
		// /2022_0516_ServletEx2_3x/Hello.do?nation=fra
		
		String nation = request.getParameter("nation");
		
		if(nation == null) nation = "ger";
		String message ="";
		
		switch(nation) {
		case "kor": message = "�ѱ���: �ȳ��ϼ���"; break;
		case "eng": message = "����: Hello"; break;
		case "jpn": message = "�Ϻ���: ���۳�������"; break;
		case "chn": message = "�߱���: ���Ͽ�"; break;
		case "ger": message = "���Ͼ�: ����Ź"; break;
		case "fra": message = "�Ҿ�: ���ָ�"; break;
		default : message = "������ �� �� �����ϴ�";
		
		}
		
		// ����ó��(response�̿�)
		//1. ���۹�������: mime type(text/xml, text/json, image/jpg..) + ���ڵ�
		response.setContentType("text/html; charset=utf-8;");
		
		//2. ��½�Ʈ�� ������
		PrintWriter out = response.getWriter();
		
		//3. ���� HTML ���� ����
		out.println("<html>");
		out.println("<head><title>hello����</title><head>");
		out.println("<body>");
		out.printf("[%s]�� %s<br>",ip, message);
		out.println("<a href='hello.html'>�ٽ��ϱ�</a>");
		out.println("</body>");
		out.println("</html>");
		
		
		
	}

}
