package vo;

public class PersonVO {
	
	String name;
	int age;
	String tel;
	
	public PersonVO() {
		super();
	}
	public PersonVO(String name, int age, String tel) {
		super();
		this.name = name;
		this.age = age;
		this.tel = tel;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getTel() {
		return tel;
	}
	
	

}
