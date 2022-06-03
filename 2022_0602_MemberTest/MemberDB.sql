create table member2
(
	m_idx int, -- �Ϸù�ȣ
	m_name varchar2(100) not null, -- �̸�
	m_id varchar2(100) not null, -- ���̵�
	m_pwd varchar2(100) not null, -- ��й�ȣ
	m_zipcode varchar2(100), -- �����ȣ
	m_address varchar2(500), -- �ּ�
	m_grade varchar2(100) default  '�Ϲ�', -- ȸ�����(�Ϲ�/������)
	m_ip varchar2(100), -- ������
	m_regdate date -- ��������

)

-- �Ϸù�ȣ ������ü
create sequence seq_member_m_idx

-- �⺻Ű
alter table member2
add constraint pk_member_m_idx primary key(m_idx);

-- ���̵� unique����

alter table member2
add constraint unique_member_m_id unique(m_id);

-- ȸ����� üũ���� (�Ϲ� Ȥ�� �����ڸ� �� �� ����)
alter table member2
add constraint ck_member_m_grade check(m_grade in ('�Ϲ�', '������'));

delete from member2 where m_idx = 5

-- ���� ������

insert into member2
	values(seq_member_m_idx.nextVal, '�ϱ浿', 'one','1234','12345','����� ������ ���굿', '�Ϲ�', '192.168.0.151',sysdate);


insert into member2
	values(seq_member_m_idx.nextVal, 'ȫ����', 'admin','1234','12345','����� ������ ���굿', '������', '192.168.0.151',sysdate);

select * from member2

update member2 set m_name='nah', m_pwd='rara', m_zipcode='07411', m_address='�����', m_grade='�Ϲ�' where m_idx= 8

