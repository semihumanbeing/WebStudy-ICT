package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vo.PersonVO;

@Controller
public class JSONController {
	
	//Map -> JSON
	@RequestMapping("map_json.do")
	@ResponseBody
	public Map map_to_json() {
		Map map = new HashMap();
		map.put("addr", "서울시마포구");
		map.put("tel","010-111-1111");
		map.put("name","홍길동");
		return map;
		
	}
	
	//Object -> JSON
	@RequestMapping("object_json.do")
	@ResponseBody
	public PersonVO object_to_json() {
		PersonVO vo = new PersonVO("일길동", 20, "010-111-1111");
		return vo;
	}
	
	//Array -> JSON
	@RequestMapping("array_json.do")
	@ResponseBody
	public String[] array_to_json() {
		String[] sidoArray = {"서울", "경기", "부산", "목포"};
		return sidoArray;
	}
	
	//ArrayList -> JSON
	@RequestMapping("arrayList_json.do")
	@ResponseBody
	public List arrayList_to_json() {
		List list = new ArrayList();
		list.add("사과");
		list.add("참외");
		list.add("포도");
		list.add("수박");
		return list;
		
	}
	
	// 혼합형식 전달
	@RequestMapping("arrayList_map_json")
	@ResponseBody
	public Map mix_to_json() {
		String[] sidoArray = {"서울", "경기", "부산", "목포"};
		
		List list = new ArrayList();
		list.add("사과");
		list.add("참외");
		list.add("포도");
		list.add("수박");
		
		Map map = new HashMap();
		map.put("sido", sidoArray);
		map.put("fruit", list);
		
		return map;
		
	}
	
}
