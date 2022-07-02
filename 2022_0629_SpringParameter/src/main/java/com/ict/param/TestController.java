package com.ict.param;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	public TestController() {
		System.out.println("--TestController()--");
	}
	
	@RequestMapping("/test.do")
	public String test(Model model) {
		// Dispatcher Servlet�� �Ѱ��� Model�� ����ؼ� �����͸� �ִ´�.
		// ��������� Model�� ���ؼ� ���޵� �����ʹ� ... 
		// view �� forward �� : request binding ��Ų��.
		
		String msg = "model message";
		model.addAttribute("msg", msg);
		
		// redirect �� : parameter �� ���ȴ�. ("redirect:list.do" => list.do?msg=�ȳ��ϼ���)
		return "test";
	}
	
	@RequestMapping("/test2.do")
	public ModelAndView Test2() {
		String msg = "Model and View �� ���޵�  ������";
		String title = "Spring�� �޼ҵ� ó���ϴ� ���";
		// Data�ֱ� (forward�� �� request binding ��Ų��.)
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", title);
		mv.addObject("msg", msg);
		
		return mv;
	}
}
