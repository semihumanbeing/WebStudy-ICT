create table payment
(
	pay_idx int primary key,
	pay_num varchar2(100),
	pay_name varchar2(100),
	pay_price int,
	pay_saleprice int,
	pay_cnt int,
	pay_amount int,
	pay_regdate varchar2(100),
	m_idx int,
	pay_method varchar2(50),
	order_idx int
	 
)

alter table payment
add constraint fk_payment_m_idx foreign key(m_idx)
references member2(m_idx)

create sequence seq_payment_pay_idx

select * from payment



alter table payment rename column c_idx to order_idx

delete from payment