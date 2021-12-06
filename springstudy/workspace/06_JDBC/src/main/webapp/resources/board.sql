drop table board;
CREATE TABLE BOARD
(
    NO NUMBER PRIMARY KEY,
    WRITER VARCHAR2(100),
    TITLE VARCHAR2(100),
    CONTENT VARCHAR2(100),
    CREATED VARCHAR2(10),
    LASTMODIFIED VARCHAR2(10)
);
drop SEQUENCE BOARD_SEQ;
CREATE SEQUENCE BOARD_SEQ NOCACHE;

insert into board values(1, '공지사항', '관리자', '공지사항입니다.', '2021-12-06', '2021-12-06');
insert into board values(2, '필독', '관리자', '필독입니다.', '2021-12-06', '2021-12-06');
commit;