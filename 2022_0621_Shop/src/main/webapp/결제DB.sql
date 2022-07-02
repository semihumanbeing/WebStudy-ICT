create table payment
(
	pay_idx int primary key,
	pay_num varchar2(100),
	pay_price int,
	pay_saleprice int,
	pay_cnt int,
	pay_amount int,
	pay_regdate varchar2(100),
	m_idx int,
	pay_method varchar2(50)
	 -- 자료형확인해서 다시채우세여~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
)