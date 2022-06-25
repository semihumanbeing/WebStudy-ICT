package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// POJO (object만 상속받는 객체)
public class ViewAction {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String book = request.getParameter("book");
		String content = "";
		if(book.equalsIgnoreCase("java")) {
			content = "Java는 제임스 고슬링이 만든 프로그래밍 언어";
		} else if(book.equals("oracle")) {
			content = "세계 1위의 DBMS입니다";
		} else if(book.equalsIgnoreCase("html")) {
			content = "HyperText Markup Language";
		} else if(book.equalsIgnoreCase("css")) {
			content = "Cascade StyleSheet";
		}
		
		request.setAttribute("book", book);
		request.setAttribute("content", content);
		
		return "view.jsp"; // 반환정보 - view 정보
	}
	
}
