package vo;

public class MemberVO {
	
	int m_idx;
	String m_name;
	String m_id;
	String m_pwd;
	String m_zipcode;
	String m_address;
	String m_grade;
	String m_ip;
	String m_regdate;
	
	// update
	public MemberVO(int m_idx, String m_name, String m_pwd, String m_zipcode, String m_address,
			String m_grade, String m_ip) {
		super();
		this.m_idx = m_idx;
		this.m_name = m_name;
		this.m_pwd = m_pwd;
		this.m_zipcode = m_zipcode;
		this.m_address = m_address;
		this.m_grade = m_grade;
		this.m_ip = m_ip;
	}
	
	//기본생성자
	public MemberVO() {
		super();
	}
	
	// insert
	public MemberVO(String m_name, String m_id, String m_pwd, String m_zipcode, String m_address, String m_grade,
			String m_ip) {
		super();
		this.m_name = m_name;
		this.m_id = m_id;
		this.m_pwd = m_pwd;
		this.m_zipcode = m_zipcode;
		this.m_address = m_address;
		this.m_grade = m_grade;
		this.m_ip = m_ip;
	}
	
	public int getM_idx() {
		return m_idx;
	}
	public void setM_idx(int m_idx) {
		this.m_idx = m_idx;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pwd() {
		return m_pwd;
	}
	public void setM_pwd(String m_pwd) {
		this.m_pwd = m_pwd;
	}
	public String getM_zipcode() {
		return m_zipcode;
	}
	public void setM_zipcode(String m_zipcode) {
		this.m_zipcode = m_zipcode;
	}
	public String getM_address() {
		return m_address;
	}
	public void setM_address(String m_address) {
		this.m_address = m_address;
	}
	public String getM_grade() {
		return m_grade;
	}
	public void setM_grade(String m_grade) {
		this.m_grade = m_grade;
	}
	public String getM_ip() {
		return m_ip;
	}
	public void setM_ip(String m_ip) {
		this.m_ip = m_ip;
	}
	public String getM_regdate() {
		return m_regdate;
	}
	public void setM_regdate(String m_regdate) {
		this.m_regdate = m_regdate;
	}
	
	

}
