drop table member;

create table member
(
  member_no number primary key,
  id varchar2(100) not null unique,
  name varchar2(100),
  gender varchar2(3),
  address varchar2(100)
);

drop SEQUENCE member_seq;
create SEQUENCE member_seq NOCACHE;


drop table board;
create table board
(
    board_no number primary key,
    title varchar2(100) not null,
    content varchar2(100),
    writer varchar2(100),
    ip  varchar2(40),
    created date,
    lastmodified date
);

create table board_attach
(
    uuid varchar2(32) primary key,   -- 저장된 첨부파일명을 의미함
    path varchar2(200),
    origin varchar2(300),
    filetype varchar2(1) default 'I',
    board_no number REFERENCES board(board_no)
);


drop SEQUENCE board_seq;
create SEQUENCE board_seq NOCACHE;



