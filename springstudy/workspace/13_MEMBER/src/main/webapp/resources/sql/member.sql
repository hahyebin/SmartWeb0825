DROP TABLE MEMBER;
CREATE TABLE MEMBER
(
  NO NUMBER PRIMARY KEY,
  ID VARCHAR2(32) NOT NULL UNIQUE,
  PW VARCHAR2(64),                       -- 암호화된 비밀번호 최대 64바이트(1바이트가 2글자로 표현)
  NAME VARCHAR2(32),
  EMAIL VARCHAR2(100) NOT NULL UNIQUE,   -- 이메일 인증 때문에 중복 방지 
  STATE NUMBER(1),   -- 상태 (인증, 비인증, 탈퇴 회원이다 확인 가능함 )    정상:1 탈퇴:-1
  REGISTED DATE      -- 가입일
);
DROP SEQUENCE MEMBER_SEQ;
CREATE SEQUENCE MEMBER_SEQ NOCACHE;