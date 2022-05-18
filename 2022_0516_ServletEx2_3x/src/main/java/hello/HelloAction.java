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
			HttpServletRequest request, // 요청처리객체 (클라이언트->서버측으로 넘어오는 정보)
			HttpServletResponse response // 응답처리객체(서버->클라이언트 측으로 전달되는 정보)
			) 
					throws ServletException, IOException {
		String ip = request.getRemoteAddr();
		System.out.printf("[%s]: --helloAction call--\n", ip);
		
		// 요청사항을 쿼리를 통해서 전달한다
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
		case "kor": message = "한국어: 안녕하세요"; break;
		case "eng": message = "영어: Hello"; break;
		case "jpn": message = "일본어: 오겡끼데스까"; break;
		case "chn": message = "중국어: 니하오"; break;
		case "ger": message = "독일어: 구텐탁"; break;
		case "fra": message = "불어: 봉주르"; break;
		default : message = "국적을 알 수 없습니다";
		
		}
		
		// 응답처리(response이용)
		//1. 전송문서정보: mime type(text/xml, text/json, image/jpg..) + 인코딩
		response.setContentType("text/html; charset=utf-8;");
		
		//2. 출력스트림 얻어오기
		PrintWriter out = response.getWriter();
		
		//3. 동적 HTML 생성 전송
		out.println("<html>");
		out.println("<head><title>hello응답</title><head>");
		out.println("<body>");
		out.printf("[%s]님 %s<br>",ip, message);
		out.println("<a href='hello.html'>다시하기</a>");
		out.println("</body>");
		out.println("</html>");
		
		
		
	}

}
