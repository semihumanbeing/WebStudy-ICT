package myutil;

import java.util.List;

public class MyList {
	
	List<String> list;

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		//Spring�� myList ��� Ŭ������ ���鶧 ArrayList�� ���� injection �����ٰ��̴�.
		this.list = list;
	}
	
	
	

}
