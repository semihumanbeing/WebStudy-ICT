package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import annotation.RequestMapping;

public class BookController {
	public BookController() {
		System.out.println("book controller");
	}
	
	@RequestMapping("/book/list.do")
	public String list(HttpServletResponse response, HttpServletRequest request) {
		List<String> list = new ArrayList<String>();
	      list.add("Java");
	      list.add("Oracle");
	      list.add("html");
	      list.add("CSS");
	      list.add("JavaScript");
	      list.add("jQuery");
	      
	      request.setAttribute("list", list);
		return "list.jsp";
	}
}
