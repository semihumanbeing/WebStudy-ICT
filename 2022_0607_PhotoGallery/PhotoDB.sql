
-- �Ϸù�ȣ ������ü
create sequence seq_photo_p_idx

create table photo
(
	p_idx int, -- �Ϸù�ȣ
	p_subject varchar2(1000) not null, -- ����
	p_content varchar2(2000) not null, -- ����
	p_filename varchar2(1000) not null, -- ���ϸ�
	p_ip varchar2(100) not null, -- ������
	p_regdate date, -- ��ϳ�¥
	m_idx int -- ��� ����� ȸ����ȣ

)

-- �⺻Ű
alter table photo
	add constraint pk_photo_p_idx primary key (p_idx);
	
-- �ܷ�Ű
alter table photo
	add constraint fk_photo_m_idx foreign key (m_idx)
	references member2(m_idx);
	
insert into photo values(seq_photo_p_idx.nextVal, '����', '����', 'cat.jpg', '192.168.0.9', sysdate, 3);

delete from photo where p_idx = 3

select * from photo