/* table */
DROP TABLE board;
CREATE TABLE board (
	idx NUMBER,
	title VARCHAR2(100),
	writer VARCHAR2(100),
	content VARCHAR2(1000),
	register DATE,
	PRIMARY KEY(idx) );

	
/* sequence */
DROP SEQUENCE board_seq;
CREATE SEQUENCE board_seq INCREMENT BY 1 START WITH 1000 NOCYCLE NOCACHE;

insert into BOARD values(board_seq.nextval,'공지사항','관리자','공지사항임',sysdate );
commit