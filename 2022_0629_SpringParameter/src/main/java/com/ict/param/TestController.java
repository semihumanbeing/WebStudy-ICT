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
		// Dispatcher Servlet이 넘겨준 Model을 사용해서 데이터를 넣는다.
		// 결과적으로 Model을 통해서 전달된 데이터는 ... 
		// view 로 forward 시 : request binding 시킨다.
		
		String msg = "model message";
		model.addAttribute("msg", msg);
		
		// redirect 시 : parameter 로 사용된다. ("redirect:list.do" => list.do?msg=안녕하세요)
		return "test";
	}
	
	@RequestMapping("/test2.do")
	public ModelAndView Test2() {
		String msg = "Model and View 로 전달된  데이터";
		String title = "Spring이 메소드 처리하는 방법";
		// Data넣기 (forward할 때 request binding 시킨다.)
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", title);
		mv.addObject("msg", msg);
		
		return mv;
	}
}
