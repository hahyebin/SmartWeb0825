CREATE TABLE notice
(
    NO NUMBER PRIMARY KEY,
    title VARCHAR2(100),
    CONTENT VARCHAR2(100),
    created DATE,
    lastmodified DATE
);
CREATE SEQUENCE notice_seq NOCACHE;