-- 조인 
-- 1. 2개 이상의 테이블을 조회하는 방법이다.
-- 2. 크로스 조인(카테전 곱), 내부 조인(Inner Join), 외부 조인(Outer Join) 등의 종류가 있다.


-- 의도적인 크로스 조인(모든 조합)  -> 내가 틀리게 적었음을 알 수 있다.
SELECT e.name
     , d.dept_name
  FROM 
      department d CROSS JOIN employee e;
 
 
SELECT e.name
     , d.dept_name
  FROM 
      department d, employee e;

-- 내부 조인 
-- INNER JOIN 
-- 양쪽 테이블에 모두 존재하는 데이터만 조인하는 것


-- 1) 콤마(,) 표기법
SELECT 
       e.name 
     , d.dept_name
  FROM
       department d, employee e
 WHERE 
       d.dept_no = e.depart   -- 조인 조건 
   AND d.dept_no = 1;         -- 일반 조건
 
-- 2) JOIN ON
SELECT 
       e.name 
     , d.dept_name
  FROM
       department d  INNER JOIN employee e
    ON
       d.dept_no = e.depart ;  -- 조인 조건 


SELECT 
       e.name 
     , d.dept_name
  FROM
       department d INNER JOIN employee e 
    ON
       d.dept_no = e.depart   -- 조인 조건 
 WHERE
       d.dept_no = 1;

SELECT 
     D.dept_no, E.NAME, D.dept_name, e.gender
     FROM employee E INNER JOIN department D
     ON E.depart = D.dept_no
     WHERE e.gender = 'M';



-- 외부조인
-- OUTER JOIN
-- 양쪽 테이블에 모두 존재하는 데이터 + 한 쪽 테이블에만 있는 데이터를 조인하는 것 

-- 1. 왼쪽 조인 
--  1) 콤마(,) 표기법
SELECT e.name
     , d.dept_name
  FROM department d , employee e  -- 왼쪽 조인 : 왼족 테이블의 모든 데이터는 포함해서 조인할 것
 WHERE d.dept_no = e.depart(+);   -- 왼쪽 조인을 의미
 
 
SELECT e.name
     , d.dept_name
  FROM employee e, department d   -- 왼쪽 조인 : 왼족 테이블의 모든 데이터는 포함해서 조인할 것
 WHERE e.depart = d.dept_no; 
 
 
 
-- 2) JOIN ON
SELECT e.name
     , d.dept_name
 FROM department d LEFT JOIN employee e  -- FROM 
   ON d.dept_no = e.depart;

-- 오른쪽 조인을 확인하기 위해서 근무하는 부서가 없는 사원을 한 명 추가
-- 부서가 없는 사원의 추가를 위해서 '외래키(FK)'를 잠시 비활성화 
ALTER TABLE employee disable CONSTRAINT employee_department_fk;
INSERT INTO employee VALUES(1005, '김미나', 5, '사원', 'F','18-05-01',1800000);

-- 2. 오른쪽 조인      
-- 1) 콤마(,) 표기법
SELECT e.name, d.dept_name
  FROM department d, employee e    --오른쪽조인 : 오른쪽 테이블의 모든 데이터는 포함해서 조인할 것
 WHERE d.dept_no(+) = e.depart;  --오른쪽 조인을 의미


-- 2) JOIN ON 
SELECT e.name, d.dept_name
  FROM department d RIGHT JOIN employee e    --오른쪽조인 : 오른쪽 테이블의 모든 데이터는 포함해서 조인할 것
    ON d.dept_no = e.depart; 


SELECT e.name, d.dept_name
  FROM  employee e  LEFT JOIN  department d  --오른쪽조인 : 오른쪽 테이블의 모든 데이터는 포함해서 조인할 것
    ON d.dept_no = e.depart; 




-- ***** 조인을 이용해서 아래 결과 테이블 만들기
/*
부서번호  인원수
 1        2
 2        2
 3        0
 4        0
*/

SELECT D.dept_no AS 부서번호
     , COUNT(E.depart) AS 인원수
  FROM department D LEFT JOIN employee E
    ON D.dept_no = E.depart
 GROUP BY D.dept_no
 ORDER BY D.dept_no;


-- '서울'에서 근무하는 사원들의 사원번호와 이름을 조회하시오.
SELECT e.emp_no, e.NAME
  FROM employee e, department d
 WHERE d.dept_no = e.depart
   AND d.location ='서울';












