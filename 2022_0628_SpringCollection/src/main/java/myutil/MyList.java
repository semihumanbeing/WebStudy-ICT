package myutil;

import java.util.List;

public class MyList {
	
	List<String> list;

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		//Spring이 myList 라는 클래스를 만들때 ArrayList를 만들어서 injection 시켜줄것이다.
		this.list = list;
	}
	
	
	

}
