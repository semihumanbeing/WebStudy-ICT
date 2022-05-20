package vo;

// VO : �б� ����
// DTO: �б�/����
// EL�� ���� �������� ����/���Ͱ� ���ȴ�.

public class PersonVO {
	
	String name;
	int age;
	String tel;
	
	public PersonVO() {
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
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	

}
