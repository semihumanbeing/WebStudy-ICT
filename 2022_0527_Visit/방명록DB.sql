-- �Ϸù�ȣ ������ü
create sequence seq_visit_idx

create table visit
(
	idx int, -- �Ϸù�ȣ
	name varchar2(100) not null, -- �̸�
	content varchar2(2000) not null, -- ����
	pwd varchar2(100) not null, -- ��й�ȣ
	ip varchar2(100) not null, -- ������
	regdate date -- �ۼ�����
)

alter table visit 
	add constraint pk_visit_idx primary key(idx);


insert into visit values (seq_visit_idx.nextVal,'�ϱ浿', '���ع�����λ��̸�����⵵��', '1234','192.168.0.9',sysdate);
insert into visit values (seq_visit_idx.nextVal,'�̱浿', '������ 2������ ��ƾ���..', '1234','192.168.0.9',sysdate);

-- ��ȸ
select * from visit order by idx desc
-- ����
delete from visit where idx = 4
-- ����
update visit set content='����' where idx = 5


