package dao;

import java.util.ArrayList;
import java.util.List;

public class TestDAOImpl implements TestDAO {

	@Override
	public List selectList() {
		List list = new ArrayList();
		
		list.add("���");
		list.add("����");
		list.add("����");
		list.add("����");
		list.add("����");
		
		return list;
	}

}
