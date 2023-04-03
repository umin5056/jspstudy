// 시퀀스
drop sequence board seq;
create sequence board_seq nocache;

// 테이블
drop table board;
create table board (
	board_no		 number 			not null,
	title 			 varchar2(1000byte) not null,
	content			 clob,
	modified_date 	 date,
	created_date	 date,
	constraint pk_board primary key(board_no) 
);

-- 행(row)
insert into board values(board_seq.nextval, '[공지]월요일 알림', 'DBCP는 DataBase Connection Poo;을 의미한다.', null, sysdate);
insert into board values(board_seq.nextval, '[협조]내일준비물', '물감, 리코더, 공책 가져오', null, sysdate);
commit;
