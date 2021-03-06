
--입고
create sequence seq_product_in_idx

create table product_in
(
   idx   int,--일련번호
   name  varchar2(255),   --상품명 
   cnt   int,			  --입고수량	
   regdate date           --입고일자
)

drop table product_in

alter table product_in
add constraint pk_product_in_idx primary key(idx);

--출고
create sequence seq_product_out_idx

create table product_out
(
   idx   int,--일련번호
   name  varchar2(255),   --상품명 
   cnt   int,			  --출고수량	
   regdate date           --출고일자
)

drop table product_out

alter table product_out
add constraint pk_product_out_idx primary key(idx);

--출고
create sequence seq_product_remain_idx

create table product_remain
(
   idx   int,--일련번호
   name  varchar2(255),   --상품명 
   cnt   int,			  --재고수량	
   regdate date          --재고일자
)

drop table product_remain

alter table product_remain
add constraint pk_product_remain_idx primary key(idx);

-- 재고상품명은 unique 설정
alter table product_remain 
add constraint unique_product_remain_name unique(name);


delete from product_in;
delete from product_out;
delete from product_remain;

