/*
-- �Ϸù�ȣ ���� ��ü(������)
create sequence seq_sungtb_idx


-- ���̺� ����
create table sungtb
(
	idx int, -- primary key �Ϸù�ȣ
	name varchar2(100) not null, -- �̸�
	kor int, -- ��������
	eng int, -- ��������
	mat int -- ��������
)

-- �⺻Ű ����
alter table sungtb 
	add constraint pk_sungtb_idx primary key(idx)

-- üũ����
alter table sungtb
	add constraint ck_sungtb_kor check(kor between 0 and 100)
	
alter table sungtb
	add constraint ck_sungtb_eng check(eng between 0 and 100)

alter table sungtb
	add constraint ck_sungtb_mat check(mat between 0 and 100)
	
insert into sungtb values(seq_sungtb_idx.nextVal,'�ϱ浿',90,80,70)
insert into sungtb values(seq_sungtb_idx.nextVal,'�̱浿',80,80,80)
insert into sungtb values(seq_sungtb_idx.nextVal,'��浿',90,100,90)

commit

select * from sungtb


-- ��ȸ�� �ʿ��� �並 ����
create or replace view sungtb_view
as
select
s.*, 
to_char((kor+eng+mat)) as tot,
to_char(round((kor+eng+mat)/3,1)) as avg,
to_char(rank() over(order by (kor+eng+mat) desc)) as rank
from (select * from sungtb) s
order by idx

select * from sungtb_view

delete from sungtb where idx = 6

update sungtb set name = '�ϱ浿', kor = 100, eng = 80, mat = 70 where idx = 1














*/
