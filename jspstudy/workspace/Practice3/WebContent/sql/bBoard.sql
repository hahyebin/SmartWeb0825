DROP TABLE rreply;
drop table bboard;

create table bboard (
	idx NUMBER PRIMARY KEY,
	writer VARCHAR2(100),
	title VARCHAR2(100),
	content VARCHAR2(1000),
	category VARCHAR2(100),
	readCount NUMBER,
	register DATE
);

DROP SEQUENCE bboard_seq;
CREATE SEQUENCE bboard_seq NOCACHE;



create table rreply (
	ridx 	NUMBER PRIMARY KEY,
	writer  VARCHAR2(100),
	content VARCHAR2(2000),
	idx		NUMBER,
	register DATE
);

DROP SEQUENCE rreply_seq;
CREATE SEQUENCE rreply_seq NOCACHE;

/* 외래키 */
ALTER TABLE rreply ADD CONSTRAINT rreply_bboard_fk FOREIGN KEY(idx) REFERENCES bboard(idx) ON DELETE CASCADE;