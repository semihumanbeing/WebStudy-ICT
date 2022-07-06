package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.Test2DAO;
import dao.TestDAO;

public class TestServiceImpl implements TestService {

	TestDAO dao1;
	Test2DAO dao2;
	
	public TestServiceImpl(TestDAO dao1, Test2DAO dao2) {
		super();
		this.dao1 = dao1;
		this.dao2 = dao2;
	}

	@Override
	public Map list() {
		
		List fruitList = dao1.selectList();
		List sidoList = dao2.selectList();
		
		Map map = new HashMap();
		map.put("fruitList", fruitList);
		map.put("sidoList", sidoList);
		
		try {
			Thread.sleep(1234);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return map;
	}

}
