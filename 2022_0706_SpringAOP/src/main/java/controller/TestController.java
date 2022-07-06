package controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.TestService;

@Controller
public class TestController {
	
	TestService testService;

	public TestController(TestService testService) {
		this.testService = testService;
	}
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		
		// 맵에는 2가지 취합된 정보가 들어있다. 이 곳을 통과하면 context myaop 에 설정된 포인트컷에서 advice에 내용을 알려준다.
		Map map = testService.list();
		
		// model을 통해 forward시킨다.
		model.addAttribute("map", map);
		
		return "totalList";
	}

}
