-- DQL
-- Data Query Language

-- 1.employee 테이블의 모든 칼럼을 조회하시오.
SELECT * FROM employee;  -- 실무에서는  * 사용 금지 

-- 2. department 테이블의 부서위치를 중복 제거해서 조회하시오
SELECT DISTINCT LOCATION FROM department;


-- 3. employee 테이블에서 '과장'의 이름을 조회하시오.
-- (칼럼 앞에 오너(칼럼이 속한 테이블)를 명시할 수 있다.)
SELECT employee.name FROM employee WHERE employee.position = '과장';

-- 4. employee 테이블에서 급여가 5000000 이상인 직원들의 이름과 직급을 조회하시오
SELECT name, position FROM employee WHERE salary >= 5000000;

--5. employee 테이블에서 2000000~ 4000000 사이의 급여를 받는 사원의 이름과 급여를 조회하시오
SELECT NAME, SALARY FROM employee WHERE  salary >= 2000000 AND salary <= 4000000;
SELECT NAME, SALARY FROM employee WHERE  salary BETWEEN 2000000 AND 4000000;           -- 사용지향 

-- 6. employee 테이블에서 고용일이 '90/01/01' ~ '99/12/31' 사이인 사원의 이름과 직급을 조회하시오.
SELECT name, position FROM employee WHERE hire_date BETWEEN '90/01/01' AND '99/12/31';
SELECT name, position FROM employee WHERE TO_DATE(hire_date, 'yy/mm//dd') BETWEEN TO_DATE('90/01/01', 'yy/mm//dd') AND TO_DATE('99/12/31','yy/mm//dd');

-- 7. employee 테이블에서 직급이 '과장'과 '부장'인 사원의 이름과 부서번호를 조회하시오.
SELECT name, depart FROM employee WHERE position = '과장' OR position = '부장';
SELECT name, depart FROM employee WHERE position IN('과장','부장');                    -- 사용지향

-- 8. department 테이블에서 부서위치가 '대구'인 지점의 부서명을 조회하시오.
-- AS : Alias (별명), 본래 명칭 대신 사용할 이름을 지정(칼럼, 테이블)
-- 칼럼 AS 별명(AS 생략가능하지만 생략 지양)
SELECT DISTINCT DEPT_NAME AS 부서명 FROM DEPARTMENT WHERE location ='대구';
SELECT DISTINCT DEPT_NAME 부서명 FROM DEPARTMENT WHERE location IN('대구');






