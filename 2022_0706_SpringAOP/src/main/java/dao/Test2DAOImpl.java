package dao;

import java.util.ArrayList;
import java.util.List;

public class Test2DAOImpl implements Test2DAO {

	@Override
	public List selectList() {
		List list = new ArrayList();
		
		list.add("����");
		list.add("����");
		list.add("����");
		list.add("�뱸");
		list.add("�λ�");
		
		return list;
	}

}
