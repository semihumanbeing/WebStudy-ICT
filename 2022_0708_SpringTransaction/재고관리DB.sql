
--�԰�
create sequence seq_product_in_idx

create table product_in
(
   idx   int,--�Ϸù�ȣ
   name  varchar2(255),   --��ǰ�� 
   cnt   int,			  --�԰����	
   regdate date           --�԰�����
)

drop table product_in

alter table product_in
add constraint pk_product_in_idx primary key(idx);

--���
create sequence seq_product_out_idx

create table product_out
(
   idx   int,--�Ϸù�ȣ
   name  varchar2(255),   --��ǰ�� 
   cnt   int,			  --������	
   regdate date           --�������
)

drop table product_out

alter table product_out
add constraint pk_product_out_idx primary key(idx);

--���
create sequence seq_product_remain_idx

create table product_remain
(
   idx   int,--�Ϸù�ȣ
   name  varchar2(255),   --��ǰ�� 
   cnt   int,			  --������	
   regdate date          --�������
)

drop table product_remain

alter table product_remain
add constraint pk_product_remain_idx primary key(idx);

-- ����ǰ���� unique ����
alter table product_remain 
add constraint unique_product_remain_name unique(name);


delete from product_in;
delete from product_out;
delete from product_remain;

