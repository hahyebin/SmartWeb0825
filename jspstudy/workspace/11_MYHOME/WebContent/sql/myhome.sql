/* 
   댓글형 게시판 
	1. 공지사항 : notice
	2. 댓글 : reply
*/
DROP TABLE reply;
DROP TABLE notice;

CREATE TABLE notice
(
	/* 게시글 번호 */	nno				NUMBER,
	/* 작성자 */		writer		    VARCHAR2(50),
	/* 제목 */			title			VARCHAR2(2000),
	/* 내용 */			content			VARCHAR2(4000),
	/* 조회수 */		hit				NUMBER,
	/* 작성자 IP */		ip				VARCHAR2(32),
	/* 작성일 */		ndate   		DATE,
	/* 최종 수정일 */	nlastmodified   DATE
);


CREATE TABLE reply 
(
	/* 댓글 번호 */		rno 		NUMBER,
	/* 작성자 */		writer 	 	VARCHAR2(50),
	/* 댓글내용 */		content 	VARCHAR2(2000),
	/* 작성자ip */		ip			VARCHAR2(32),
	/* 게시글 번호 */	nno    		NUMBER,
	/* 댓글 작성일 */	rdate 		DATE
);

/* 기본키 */
ALTER TABLE notice ADD CONSTRAINT notice_pk PRIMARY KEY(nno);
ALTER TABLE reply ADD CONSTRAINT reply_pk PRIMARY KEY(rno);

/* 외래키 */
ALTER TABLE reply ADD CONSTRAINT reply_notice_fk FOREIGN KEY(nno) REFERENCES notice(nno) ON DELETE CASCADE;

/* 시퀀스 */
DROP SEQUENCE notice_seq;
DROP SEQUENCE reply_seq;
CREATE SEQUENCE notice_seq NOCACHE;
CREATE SEQUENCE reply_seq NOCACHE;


INSERT INTO NOTICE values (notice_seq.nextval, '관리자', '이용 시 주의사항', '바른말 사용하기', 0, '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE);
COMMIT


/*
    회원 
    1. 회원 : member
    2. 기록 : member_log 
*/

DROP TABLE MEMBER_LOG;
DROP TABLE MEMBER;

CREATE TABLE MEMBER 
(
	/* 회원 번호 */	 MNO	NUMBER,
	/* 아이디 */	 ID		VARCHAR2(32) NOT NULL UNIQUE,
	/* 비밀번호 */	 PW		VARCHAR2(32) NOT NULL,
	/* 이름 */		 NAME 	VARCHAR2(50),
	/* 메일 */		 EMAIL 	VARCHAR2(200),
	/* 가입일 */ 	 MDATE 	DATE
);

CREATE TABLE MEMBER_LOG 
(
	/* 기록번호 */    LNO	  NUMBER,
	/* 아이디 */	  ID 	  VARCHAR2(32),
	/* 로그인일시 */  LOGIN	  DATE
);


/* 기본키 */
ALTER TABLE MEMBER ADD CONSTRAINT MEMBER_PK PRIMARY KEY(MNO); 
ALTER TABLE MEMBER_LOG ADD CONSTRAINT MEMBER_LOG_PK PRIMARY KEY(LNO); 

/* 외래키->아이디에 유니크를 꼭 줘야지 가능함 외래키는 유니크한 열에만  가능  */
ALTER TABLE MEMBER_LOG ADD CONSTRAINT MEMBER_LOG_MEMBER_FK 
   FOREIGN KEY(ID) REFERENCES MEMBER(ID) ON DELETE CASCADE;

/* 시퀀스 */
DROP SEQUENCE MEMBER_SEQ;
DROP SEQUENCE MEMBER_LOG_SEQ;

CREATE SEQUENCE MEMBER_SEQ NOCACHE;
CREATE SEQUENCE MEMBER_LOG_SEQ NOCACHE;


INSERT INTO MEMBER VALUES (MEMBER_SEQ.NEXTVAL, 'admin', '1111', '관리자', 'admin@myhome.com', SYSDATE);
INSERT INTO MEMBER VALUES (MEMBER_SEQ.NEXTVAL, 'scott', '1111', '스캇', 'scott@myhome.com', SYSDATE);
COMMIT


