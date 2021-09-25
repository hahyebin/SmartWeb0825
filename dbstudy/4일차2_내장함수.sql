-- BUILT-IN FUNCTION
-- 내장 함수


-- 1. 형 변환 함수

-- 1) TO_NUMBER('문자열')
SELECT 
      '150' + 150   -- 오라클은 '문자열'과 숫자의 혼합 연산 시 '문자열'을 숫자로 변환한다.
     , TO_NUMBER('150') + 150 AS "형 변환 함수"     --  '150' + 150 이와 같이 변환되어 처리된다.
  FROM 
      DUAL;
      
-- 2) TO_CHAR(값, [형식])
SELECT 
      TO_CHAR(123)             -- '123'
    , TO_CHAR(123, '999999')   -- '   123'  --부족한 수는 공백
    , TO_CHAR(123, '000000')   -- '000123'  --부족한 수는 0으로
    , TO_CHAR(123, '99')       -- '#####'  오류(폭이 좁다는 의미) -- > 값 > 형식 사이즈인 경우
    , TO_CHAR(1234, '9,999')   -- '1,234' (천 단위 구분 기호)
    , TO_CHAR(12345, '99,999')  -- '12,345'  
    , TO_CHAR(3.14, '9')        -- '3' (반올림 동작)
    , TO_CHAR(3.89, '9')        -- '4' (반올림 동작)
    , TO_CHAR(3.14, '9.9')      -- '3.1'  (소수부 한 자리 표시, 반올림 동작)
    , TO_CHAR(3.15, '9.999999')
  FROM 
      DUAL;
      
SELECT 
      TO_CHAR(SYSDATE)                    -- '21/09/09'
    , TO_CHAR(SYSDATE, 'YY-MM-DD')        -- '21-09-09'
    , TO_CHAR(SYSTIMESTAMP)               -- '21/09/09 10:33:19.623000 +09:00'
    , TO_CHAR(SYSTIMESTAMP, 'HH:MI:SS')   -- '10:33:19'
    , TO_CHAR(SYSDATE,'YYYY-MM-DD')
    , TO_CHAR(TO_DATE('03/11/26','MM/DD/YY'), 'MM.DD YY')

  FROM
     DUAL;
     
-- SYSDATE : 칼럼이 DATE 타입인 경우에 사용 
-- SYSTIMESTAMP : 칼럼이 TIMESTAMP 타입인 경우에 사용



-- 3. TO_DATE ('문자열',[형식])  [형식]은 전달된 문자열 설명 
-- TO_DATE 함수는 날짜를 만드는 용도이지, 날짜의 형식을 변경하는 용도가 아니다.
SELECT
      TO_DATE('21/01/30') 
    , TO_DATE('21/31/01', 'YY/DD/MM') 
    , TO_DATE(SYSDATE, 'YYYY-MM-DD')  -- 'YYYY-MM-DD' 형식으로 표시되지 않는다. TO_CHAR(SYSDATE, 'YYYY-MM-DD')로 할 수 있다.
  FROM 
      DUAL;
-- TO_DATE 는 표시가 목적이 아니라 날짜 데이터로 만들어서 문자열이 무엇을 의미하는지만 확인하는것..
-- 날짜에 원하는 형식이 있다면 그건  TO_CHAR을 이용해서 변경하는 것...



-------------------------------------------------------------------------------------------------

-- 함수 확인을 위한 기초 데이터
CREATE TABLE student (
   name VARCHAR2(30 BYTE),
   kor NUMBER(3),
   eng NUMBER(3),
   math NUMBER(3)
   );
   
INSERT INTO student VALUES('뽀로로', 70,80,90);
INSERT INTO student VALUES('띠띠뽀', NULL,80,90);
INSERT INTO student VALUES('브레드', 80,90,100);

-- 2. NULL 처리 함수

-- 중요. NULL 값을 포함한 모든 연산의 결과는 NULL이다.

-- 1) NVL(값, 값이 NULL일 때 사용할 값)
SELECT NVL(kor,0) + 1  -- NVL(kor,0) : kor이 NULL이면 0으로 처리
  FROM student
 WHERE name = '띠띠뽀';

-- 2) NVL2(값, 값이 NULL이 아닐 때 사용할 값, 값이 NULL일 때 사용할 값  )
SELECT name, NVL2(kor, '국어시험응시', '국어시험결시')
  FROM student;
   
-- 2. 집계 함수(그룹 함수)
-- 1) SUM(칼럼) : 합계
SELECT
      SUM(NVL(kor,0))
    , SUM(eng)
    , SUM(math)
 -- , SUM(eng,math)  -- 불가능, SUM 함수는 인수가 1개만 가능.
    , SUM(eng) + SUM(math) 
  FROM 
      student;


-- 2) AVG(칼럼) : 평균
SELECT
      AVG(kor)
    , AVG(eng)
    , AVG(math)
 FROM
     student;
-- 3) MAX(칼럼) : 최대값
SELECT
      MAX(kor)
    , MAX(eng)
    , MAX(math)
 FROM
    student;
-- 4) MIN(칼럼) : 최소값
SELECT
      MIN(kor)
    , MIN(eng)
    , MIN(math)
 FROM 
     student;
-- 5) COUNT(칼럼) : 해당 칼럼의 데이터 개수(NULL 제외)
SELECT
      COUNT(NAME)
    , COUNT(kor)
    , COUNT(eng)
    , COUNT(math)
    , COUNT(*)
 FROM
    STUDENT;
-- 6) COUNT(*) : 행(ROW, RECORD) 개수 (일부 칼럼이 NULL이더라도 행에 포함)

/*
이름  국어  영어  수학
이    8    NULL   8
김    5    5      NULL
박    6    5      6
COUNT(이름) : 3
COUNT(영어) : 2
COUNT(국어) : 3
COUNT(*) : 3
*/




















