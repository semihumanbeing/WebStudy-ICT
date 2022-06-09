
-- 일련번호 관리객체
create sequence seq_photo_p_idx

create table photo
(
	p_idx int, -- 일련번호
	p_subject varchar2(1000) not null, -- 제목
	p_content varchar2(2000) not null, -- 내용
	p_filename varchar2(1000) not null, -- 파일명
	p_ip varchar2(100) not null, -- 아이피
	p_regdate date, -- 등록날짜
	m_idx int -- 등록 사용자 회원번호

)

-- 기본키
alter table photo
	add constraint pk_photo_p_idx primary key (p_idx);
	
-- 외래키
alter table photo
	add constraint fk_photo_m_idx foreign key (m_idx)
	references member2(m_idx);
	
insert into photo values(seq_photo_p_idx.nextVal, '제목', '내용', 'cat.jpg', '192.168.0.9', sysdate, 3);

delete from photo where p_idx = 3

select * from photo