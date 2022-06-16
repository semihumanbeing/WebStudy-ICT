package vo;

public class VisitVO {
	int idx;
	String name;
	String content;
	String pwd;
	String ip;
	String regdate;
	
	public VisitVO() {
		super();
	}

	public VisitVO(String name, String content, String pwd) {
		super();
		this.name = name;
		this.content = content;
		this.pwd = pwd;
	}
	

	public VisitVO(int idx, String content) {
		this.idx = idx;
		this.content = content;
	}

	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	

}
