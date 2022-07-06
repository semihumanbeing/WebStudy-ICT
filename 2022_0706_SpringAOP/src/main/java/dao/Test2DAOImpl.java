package dao;

import java.util.ArrayList;
import java.util.List;

public class Test2DAOImpl implements Test2DAO {

	@Override
	public List selectList() {
		List list = new ArrayList();
		
		list.add("서울");
		list.add("강원");
		list.add("대전");
		list.add("대구");
		list.add("부산");
		
		return list;
	}

}
