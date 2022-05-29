-- 일련번호 관리객체
create sequence seq_visit_idx

create table visit
(
	idx int, -- 일련번호
	name varchar2(100) not null, -- 이름
	content varchar2(2000) not null, -- 내용
	pwd varchar2(100) not null, -- 비밀번호
	ip varchar2(100) not null, -- 아이피
	regdate date -- 작성일자
)

alter table visit 
	add constraint pk_visit_idx primary key(idx);


insert into visit values (seq_visit_idx.nextVal,'일길동', '동해물과백두산이마르고닳도록', '1234','192.168.0.9',sysdate);
insert into visit values (seq_visit_idx.nextVal,'이길동', '영원히 2등으로 살아야해..', '1234','192.168.0.9',sysdate);

-- 조회
select * from visit order by idx desc
-- 삭제
delete from visit where idx = 4
-- 수정
update visit set content='ㅋㅋ' where idx = 5


