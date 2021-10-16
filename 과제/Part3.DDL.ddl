-- 생성자 Oracle SQL Developer Data Modeler 20.4.0.374.0801
--   위치:        2021-10-16 15:12:26 KST
--   사이트:      Oracle Database 11g
--   유형:      Oracle Database 11g

-- 1. 모델링 토대로 테이블 생성하시오
DROP TABLE STUDENT;
DROP TABLE LECTURE;
DROP TABLE PROFESSOR;

CREATE TABLE lecture (
    lecture_no    VARCHAR2(5 BYTE) NOT NULL,
    lecture_name  VARCHAR2(30 BYTE) NOT NULL,
    lecture_lab   VARCHAR2(30 BYTE),
    professor_no  VARCHAR2(5 BYTE) NOT NULL
);

ALTER TABLE lecture ADD CONSTRAINT lecture_pk PRIMARY KEY ( lecture_no );

CREATE TABLE professor (
    professor_no     VARCHAR2(5 BYTE) NOT NULL,
    professor_name   VARCHAR2(30 BYTE),
    professor_major  VARCHAR2(30 BYTE)
);

ALTER TABLE professor ADD CONSTRAINT professor_pk PRIMARY KEY ( professor_no );

CREATE TABLE student (
    student_no       VARCHAR2(6 BYTE) NOT NULL,
    student_name     VARCHAR2(30 BYTE) NOT NULL,
    student_address  VARCHAR2(100 BYTE),
    student_grade    NUMBER(1),
    professor_no     VARCHAR2(5 BYTE) NOT NULL
);

ALTER TABLE student ADD CONSTRAINT student_pk PRIMARY KEY ( student_no );

ALTER TABLE lecture
    ADD CONSTRAINT lecture_professor_fk FOREIGN KEY ( professor_no )
        REFERENCES professor ( professor_no )
            ON DELETE CASCADE;

ALTER TABLE student
    ADD CONSTRAINT student_professor_fk FOREIGN KEY ( professor_no )
        REFERENCES professor ( professor_no )
            ON DELETE CASCADE;



-- Oracle SQL Developer Data Modeler 요약 보고서: 
-- 
-- CREATE TABLE                             3
-- CREATE INDEX                             0
-- ALTER TABLE                              5
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
