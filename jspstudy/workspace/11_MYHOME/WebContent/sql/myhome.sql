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
	/* 회원번호 */	MNO		NUMBER,
	/* 아이디 */	ID		VARCHAR2(32) NOT NULL UNIQUE,
	/* 비밀번호 */	PW		VARCHAR2(32) NOT NULL,
	/* 이름 */		NAME	VARCHAR2(50),
	/* 메일 */		EMAIL	VARCHAR2(200),
	/* 가입일 */	MDATE	DATE
);
CREATE TABLE MEMBER_LOG
(
	/* 기록번호 */	LNO		NUMBER,
	/* 아이디 */	ID		VARCHAR2(32),
	/* 로그인일시 */LOGIN	DATE
);

ALTER TABLE MEMBER ADD CONSTRAINT MEMBER_PK PRIMARY KEY(MNO);
ALTER TABLE MEMBER_LOG ADD CONSTRAINT MEMBER_LOG_PK PRIMARY KEY(LNO);

ALTER TABLE MEMBER_LOG ADD CONSTRAINT MEMBER_LOG_MEMBER_FK
	FOREIGN KEY(ID) REFERENCES MEMBER(ID) ON DELETE CASCADE;  /* 관련 로그 삭제 */

DROP SEQUENCE MEMBER_SEQ;
DROP SEQUENCE MEMBER_LOG_SEQ;
CREATE SEQUENCE MEMBER_SEQ NOCACHE;
CREATE SEQUENCE MEMBER_LOG_SEQ NOCACHE;

INSERT INTO MEMBER VALUES (MEMBER_SEQ.NEXTVAL, 'admin', '1111', '관리자', 'admin@myhome.com', SYSDATE);
INSERT INTO MEMBER VALUES (MEMBER_SEQ.NEXTVAL, 'scott', '1111', '스콧', 'scott@myhome.com', SYSDATE);
COMMIT



------------------------------------------------------------------------------------------------------------------------------
/* 
    계층형 게시판 
 	자유게시판    
 */
DROP TABLE FREE;
CREATE TABLE FREE
(  
	/* 글번호 */ 	   FNO 		      NUMBER,
	/* 작성자 */ 	   WRITER		  VARCHAR2(32),
	/* 내용 */	 	   CONTENT        VARCHAR2(4000),
	/* IP */		   IP		  	  VARCHAR2(32),
	/* 조회수 */       HIT            NUMBER,
	/* 최초작성일*/    CREATED        DATE,
	/* 최종수정일*/    LASTMODIFIED   DATE,
	/* 삭제여부 */	   STATE		  NUMBER,  /* 정상: 0,    삭제된: -1 */
	/* 게시글/댓글 */  DEPTH		  NUMBER,  /* 게시글: 0,  댓글 : 1이상(원글의 DEPT+1) */
	/* 동일그룹 */	   GROUPNO		  NUMBER,  /* 게시글: 글번호(FNO), 댓글: 원글의 글번호(FNO)  */
	/* 그룹내순서 */   GROUPORD		  NUMBER   /* 동일 그룹 내 표시 순서를 의미 */
);

DROP SEQUENCE FREE_SEQ;
CREATE SEQUENCE FREE_SEQ NOCACHE;

/* 기본키 */
ALTER TABLE FREE ADD CONSTRAINT FREE_PK PRIMARY KEY(FNO);



/*************************************************************************************************************************************************************/

/* 
 	이미지 게시판 
 	1. 이미지 게시판 : BOARD
 	2. 댓글 : COMMENT 
 */

DROP TABLE COMMENTS;
DROP TABLE BOARD;
CREATE TABLE BOARD
(
	/* 게시글번호 */  	  BNO	    	NUMBER,
	/* 작성자 */	  	  WRITER    	VARCHAR2(32),	
	/* 제목 */		  	  TITLE			VARCHAR2(2000) NOT NULL,
	/* 내용 */		  	  CONTENT       VARCHAR2(4000),
	/* 올린 파일명 */     FILENAME    VARCHAR2(300),
	/* 저장된 파일명 */   SAVENAME      VARCHAR2(300),
	/* 작성일자 */		  CREATED       DATE,
	/* 최종수정일 */	  LASTMODIFIED  DATE
);

CREATE TABLE COMMENTS
(
	/* 댓글번호 */ 		 CNO 		NUMBER,
	/* 작성자 */		 WRITER     VARCHAR2(32),
	/* 내용 */			 CONTENT    VARCHAR2(4000),
	/* 원글 번호 */		 BNO		NUMBER,
	/* 삭제여부 */		 STATE      NUMBER,	
	/* 작성일자 */		 CREATED    DATE
);

/* 시퀀스 */
DROP SEQUENCE BOARD_SEQ;
DROP SEQUENCE COMMENTS_SEQ;


CREATE SEQUENCE BOARD_SEQ NOCACHE;
CREATE SEQUENCE COMMENTS_SEQ NOCACHE;

/* 기본키 외래키 (회원들과 연결하고 싶은 경우엔 MEMBER의 ID와  BOARD, COMMENT의 WRITER를 연결한다.) */
ALTER TABLE BOARD ADD CONSTRAINT BOARD_PK PRIMARY KEY(BNO);
ALTER TABLE COMMENTS ADD CONSTRAINT COMMENTS_PK PRIMARY KEY(CNO);
ALTER TABLE COMMENTS ADD CONSTRAINT COMMENTS_BOARD_FK FOREIGN KEY(BNO) REFERENCES BOARD(BNO) ON DELETE CASCADE;


ALTER TABLE BOARD ADD CONSTRAINT BOARD_MEMBER_FK FOREIGN KEY(WRITER) REFERENCES MEMBER(ID) ON DELETE CASCADE;
ALTER TABLE COMMENTS ADD CONSTRAINT COMMENTS_MEMBER_FK FOREIGN KEY(WRITER) REFERENCES MEMBER(ID) ON DELETE CASCADE;

