package controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vo.PersonVo;

@Controller
public class ParamController {
	
	public ParamController() {
		System.out.println("ParamController");
	}
	
	@RequestMapping("/person/insert_form.do")
	public String insert_form() {
		// WEB-INF/view/person/person_insert_form.jsp
		return "person/person_insert_form";
	}
	
	// 낱개로 받기
	// parameter를 받을 메서드의 인자값은 DispatcherServlet에 대한 요구사항이다.
	// parameter명과 받을 변수명이 같으면 @RequestParam 생략 가능하다.
	@RequestMapping(value="/person/insert1.do", produces = "text/html; charset=utf8;")
	@ResponseBody
	public String insert1(@RequestParam(value="name", required=true)String name, 
						  @RequestParam("age")int age, 
						  @RequestParam("tel")String tel,
						  @RequestParam(value="addr", required=false, defaultValue="서울시" ) String address) {
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(tel);
		System.out.println(address);
		
		
		return "하나하나 받아서 입력완료";
	}
	
	@RequestMapping(value="/person/insert2.do", produces = "text/html; charset=utf8;")
	@ResponseBody
	public String insert2(PersonVo vo) {
		
		System.out.println(vo.getName());
		System.out.println(vo.getAge());
		System.out.println(vo.getTel());
		return "객체로 받아서 입력완료";
	}
	
	@RequestMapping(value="/person/insert3.do", produces = "text/html; charset=utf8;")
	@ResponseBody
	public String insert3(@RequestParam Map map) {
		
		System.out.println(map.get("name"));
		System.out.println(map.get("age"));
		System.out.println(map.get("tel"));
		return "맵으로 받아서 입력완료";
	}
}
