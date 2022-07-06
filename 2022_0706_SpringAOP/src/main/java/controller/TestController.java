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
		
		// �ʿ��� 2���� ���յ� ������ ����ִ�. �� ���� ����ϸ� context myaop �� ������ ����Ʈ�ƿ��� advice�� ������ �˷��ش�.
		Map map = testService.list();
		
		// model�� ���� forward��Ų��.
		model.addAttribute("map", map);
		
		return "totalList";
	}

}
