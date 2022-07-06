package vo;

public class PaymentVO {
	
	int pay_idx;
	String pay_num;
	String pay_name;
	int pay_price;
	int pay_saleprice;
	int pay_cnt;
	int pay_amount;
	String pay_regdate;
	int m_idx;
	String pay_method;
	int order_idx;
	
	public PaymentVO() {
		super();
	}
	
	public PaymentVO(String pay_num, String pay_name, int pay_price, int pay_saleprice, int pay_cnt,
			int pay_amount, int m_idx, String pay_method, int order_idx) {
		super();
		this.pay_num = pay_num;
		this.pay_name = pay_name;
		this.pay_price = pay_price;
		this.pay_saleprice = pay_saleprice;
		this.pay_cnt = pay_cnt;
		this.pay_amount = pay_amount;
		this.m_idx = m_idx;
		this.pay_method = pay_method;
		this.order_idx = order_idx;
	}

	public int getC_idx() {
		return order_idx;
	}

	public void setC_idx(int order_idx) {
		this.order_idx = order_idx;
	}

	public int getPay_idx() {
		return pay_idx;
	}
	public void setPay_idx(int pay_idx) {
		this.pay_idx = pay_idx;
	}
	public String getPay_num() {
		return pay_num;
	}
	public void setPay_num(String pay_num) {
		this.pay_num = pay_num;
	}
	public String getPay_name() {
		return pay_name;
	}
	public void setPay_name(String pay_name) {
		this.pay_name = pay_name;
	}
	public int getPay_price() {
		return pay_price;
	}
	public void setPay_price(int pay_price) {
		this.pay_price = pay_price;
	}
	public int getPay_saleprice() {
		return pay_saleprice;
	}
	public void setPay_saleprice(int pay_saleprice) {
		this.pay_saleprice = pay_saleprice;
	}
	public int getPay_cnt() {
		return pay_cnt;
	}
	public void setPay_cnt(int pay_cnt) {
		this.pay_cnt = pay_cnt;
	}
	public int getPay_amount() {
		return pay_amount;
	}
	public void setPay_amount(int pay_amount) {
		this.pay_amount = pay_amount;
	}
	public String getPay_regdate() {
		return pay_regdate;
	}
	public void setPay_regdate(String pay_regdate) {
		this.pay_regdate = pay_regdate;
	}
	public int getM_idx() {
		return m_idx;
	}
	public void setM_idx(int m_idx) {
		this.m_idx = m_idx;
	}
	public String getPay_method() {
		return pay_method;
	}
	public void setPay_method(String pay_method) {
		this.pay_method = pay_method;
	}
	
	
	

}
