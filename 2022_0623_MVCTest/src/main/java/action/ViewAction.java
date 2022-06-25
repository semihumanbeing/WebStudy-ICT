package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// POJO (object�� ��ӹ޴� ��ü)
public class ViewAction {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String book = request.getParameter("book");
		String content = "";
		if(book.equalsIgnoreCase("java")) {
			content = "Java�� ���ӽ� ������ ���� ���α׷��� ���";
		} else if(book.equals("oracle")) {
			content = "���� 1���� DBMS�Դϴ�";
		} else if(book.equalsIgnoreCase("html")) {
			content = "HyperText Markup Language";
		} else if(book.equalsIgnoreCase("css")) {
			content = "Cascade StyleSheet";
		}
		
		request.setAttribute("book", book);
		request.setAttribute("content", content);
		
		return "view.jsp"; // ��ȯ���� - view ����
	}
	
}
