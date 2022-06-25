/*

--장바구니 일련번호
create sequence seq_cart_idx

--장바구니 테이블
create table cart
(
  c_idx  int  primary key,
  c_cnt  int  not null,
  p_idx  int,
  m_idx  int
)

--상품테이블(product)의 idx와 p_idx간의 외래키 설정
alter table cart
  add constraint fk_cart_p_idx foreign key(p_idx) 
                               references product(p_idx)

alter table cart
  add constraint fk_cart_m_idx foreign key(m_idx) 
                               references member2(m_idx)
                               on delete cascade

alter table cart
	drop constraint fk_cart_m_idx

alter table cart
	drop constraint fk_cart_p_idx


select * from product
select * from member2

insert into cart values(seq_cart_idx.nextVal,1,3,1);
insert into cart values(seq_cart_idx.nextVal,1,4,1);
insert into cart values(seq_cart_idx.nextVal,1,9,23);

select * from cart

commit

-- Join을 통해서 조회정보를 추출
create or replace view cart_view
as
	select
	   p.p_idx p_idx,c_idx, p_num,p_name,p_price,p_saleprice,
	   c_cnt, c_cnt* p_saleprice amount, m_idx
	from product p inner join  cart c on p.p_idx = c.p_idx  

select * from cart_view where m_idx = 1;

--장바구니 상품의 총계
select sum(amount) from cart_view where m_idx = 1;













*/