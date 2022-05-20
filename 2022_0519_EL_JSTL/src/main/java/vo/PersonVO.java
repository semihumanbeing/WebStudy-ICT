package vo;

// VO : 읽기 전용
// DTO: 읽기/쓰기
// EL을 쓰는 과정에서 게터/세터가 사용된다.

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
