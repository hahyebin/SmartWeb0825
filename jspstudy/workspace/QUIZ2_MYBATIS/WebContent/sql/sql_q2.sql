/* table */
DROP TABLE board2;
CREATE TABLE board2 (
	idx NUMBER,
	title VARCHAR2(100),
	writer VARCHAR2(100),
	content VARCHAR2(1000),
	register DATE,
	PRIMARY KEY(idx) );

	
/* sequence */
DROP SEQUENCE board2_seq;
CREATE SEQUENCE board2_seq INCREMENT BY 1 START WITH 1000 NOCYCLE NOCACHE;