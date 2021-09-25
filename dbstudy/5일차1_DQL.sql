
-- DQL 


/*
      WILD CARD 문자
      
      1. 모든 문자를 대체할 수 있는 만능 문자
      2. 종류 
         1) 글자 수에 제약 없는(0~무한) 만능문자 : %
         2) 한 글자만 대체하는 만능문자  : _                    - ___ : 3글자
      3. 관련 연산자
         LIKE(등호(=) 대신 사용)
      4. 예시
        1) '마'로 시작하는 단어를 찾고 싶다(마요네즈, 마동석, 마술 등) : '마%'
        2) '공주'로 끝나는 단어를 찾고 싶다(칠공주, 평강공주, 백설공주, 공주) : '%공주'
        3) '맨'을 포함하는 단어를 찾고 싶다(슈퍼맨, 맨드라미, 배트맨대슈퍼맨) : '%맨%'
*/


-- 1. employees 테이블에서 last_name에 'p', 'P'가 포함된 사원의 last_name 을 조회하시오.
SELECT last_name 
  FROM employees 
 WHERE last_name LIKE '%p%' 
    OR last_name LIKE '%P%';
    
SELECT last_name
  FROM employees
 WHERE last_name LIKE IN('%P%','%p%');   -- 불가. 만능 문자 연산에서는 IN() 연산 사용하지 않음.
    

SELECT last_name 
  FROM employees
 WHERE UPPER(last_name) LIKE '%P%';

SELECT last_name 
  FROM employees
 WHERE LOWER(last_name) LIKE '%p%';


-- 2. employees 테이블에서 phone_number가 '011'로 시작하는 사원들의 last_name, phone_number 조회하시오
SELECT last_name, phone_number 
  FROM employees 
 WHERE phone_number LIKE '011%';
 
SELECT last_name, phone_number 
  FROM employees 
 WHERE SUBSTR(phone_number,1,3) = '011';    -- employees 테이블에서 phone_number 앞에서 부터 세글자와 011 과 같은 last_name과 phone_number를 조회하시오
 
 
-- 3. employees 테이블에서 last_name의 4번째 글자가 'a'인 사원들의 last_name 조회하시오.
SELECT last_name
  FROM employees 
 WHERE SUBSTR(last_name,4,1) = 'a'; 

SELECT last_name
  FROM employees 
 WHERE last_name LIKE '___a%';
 


 
------------------------------------------------------------------------------------
 
-- 그룹화
 
-- 1. employees 테이블에서 department_id별로 몇 명의 사원이 근무하는지 조회하시오.
 SELECT department_id, COUNT(*) 
   FROM employees
  GROUP BY department_id;
  
-- 2. employees 테이블에서 department_id별로 salary의 평균을 조회하시오.
-- 단. department_id가 10, 20, 30 인 부서만 조회하시오.
 SELECT department_id AS 부서번호, AVG(salary) AS 급여평균
   FROM employees
  WHERE department_id IN(10,20,30)      -- 부서별 그룹 이전에 처리하는 것이 좋다.
  GROUP BY department_id;

-- 3. employees 테이블에서 phone_number의 첫 세 글자가 같은 사원들이 몇 명인지 조회하시오.
 SELECT SUBSTR(phone_number,1,3) , COUNT(*) 
   FROM employees
  GROUP BY SUBSTR(phone_number,1,3) ;

SELECT LPAD(phone_number, 3, ' '), count(*)
  FROM employees
 GROUP BY LPAD(phone_number, 3, ' ');



-- 4. departments 테이블에서 각 지역별로 몇 개의 부서가 있는지 조회하시오.
SELECT    location_id, count(*)
  FROM    departments 
 GROUP BY location_id;
 
 
-- 5. employees 테이블에서 5명 이상의 사원이 근무하는 부서와 해당 부서의 인원수를 조회하시오.
SELECT department_id, count(*)
  FROM employees
 GROUP BY department_id
HAVING COUNT(*) >= 5;
 

 
-- 6. employees 테이블에서 평균 급여가 10000이상인 부서의 department_id, 평균급여를  조회하시오.
SELECT department_id, AVG(salary) AS 평균급여
  FROM employees
 GROUP BY  department_id
HAVING 10000 <= AVG(salary);
 
-- ** 7. employees 테이블에서 같은 부서에 근무하면서 같은 직업을 가진 사원들의 인원수와 평균 급여를 조회하시오.
--       부서순으로 오름차순 정렬하시오
SELECT department_id, job_id, count(*) AS 인원수, AVG(salary) as 평균급여
  FROM employees
 GROUP BY department_id, job_id
 ORDER BY department_id;
 



























