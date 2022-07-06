package dao;

import java.util.ArrayList;
import java.util.List;

public class TestDAOImpl implements TestDAO {

	@Override
	public List selectList() {
		List list = new ArrayList();
		
		list.add("사과");
		list.add("참외");
		list.add("수박");
		list.add("포도");
		list.add("딸기");
		
		return list;
	}

}
