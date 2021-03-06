-- 모델링 

-- 1. [보기] - [Data Modeler] - [브라우저]
-- 2. [브라우저] 창 - [제목없음_1] - [관계형 모델[]] - 우클릭 - [새 관계형 모델]
-- 3. 상단 메뉴 [새 테이블] 클릭 후 [Relational_1] 창에 그리기(클릭 or 드래그)
--   1) 일반 : 테이블 이름, DDL에 생성 체크
--   2) 열   : 열 이름, 논리적, 타입, 옵션(PK, 필수(NOT NULL)) 
--   3) 고유 제약 조건 : UNIQUE
-- 4. 상단 메뉴 [새 외래키] 클릭 후 PK 클릭 후 FK 클릭 
--   1) 규칙 삭제 : NO ACTION(규칙만 삭제함)
--   2) 규칙 삭제 : CASCADE(규칙과 관련된 열도 함께 삭제함)


DROP TABLE CUSTOMER;
DROP TABLE BANK;

DROP TABLE ENROLL;
DROP TABLE STUDENT;
DROP TABLE SUBJECT;

DROP TABLE SCHOOL;

DROP TABLE PROCEEDING;
DROP TABLE PROJECT;
DROP TABLE EMPLOYEE;
DROP TABLE DEPARTMENT;
