package vo;

public class PersonVO {
	
	String name;
	String nickname;
	int age;
	String tel;
	String hometel;
	
	public PersonVO() {
		super();
	}
	
	public PersonVO(String name, String nickname, int age, String tel, String hometel) {
		super();
		this.name = name;
		this.nickname = nickname;
		this.age = age;
		this.tel = tel;
		this.hometel = hometel;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	public String getHometel() {
		return hometel;
	}
	public void setHometel(String hometel) {
		this.hometel = hometel;
	}
	

}
