package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// POJO (object만 상속받는 객체)
public class ListAction {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		List<String> list = new ArrayList<String>();
		
		list.add("java");
		list.add("oracle");
		list.add("html");
		list.add("css");
		list.add("javascript");
		list.add("spring");
		
		request.setAttribute("list", list);
		
		return "list.jsp"; // 반환정보 - view 정보
	}
	
}
