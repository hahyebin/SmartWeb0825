-- 서브쿼리 


-- 1. department_id가 20인 사원 중에서 전체 평균 연봉(salary) 이상을 받는 사원의 
-- employee_id, first_name, department_id, salary를 조회하시오.
SELECT employee_id, first_name, department_id, salary
  FROM employees
  WHERE salary >= (SELECT AVG(salary) FROM employees) -- 6461
  AND department_id = 20;
  
  
-- 답 
SELECT  employee_id, first_name, department_id, salary
  FROM  employees
 WHERE department_id = 20
   AND salary  >= (SELECT AVG(salary) FROM employees);







-- 2. job_id가 'IT_PROG'인 사원의 최대 연봉(salary)보다 더 많은 연봉을 받는 사원의
--   employee_id, first_name, job_id, salary를 조회하시오.
SELECT employee_id, first_name, job_id, salary
  FROM  employees
 WHERE salary > (SELECT MAX(salary) FROM employees WHERE  job_id = 'IT_PROG');
  
-- 답 
SELECT employee_id, first_name, job_id, salary
  FROM  employees
 WHERE salary > (SELECT MAX(salary) FROM employees WHERE  job_id = 'IT_PROG');
  
  
  
  
  
-- 3. employee_id가 115인 사원과 같은 job_id, department_id를 가진 사원의
--   employee_id, first_name, job_id, department_id를 조회하시오. (PU_CLERK, 30)
SELECT  employee_id, first_name, job_id, department_id
  FROM employees
 WHERE job_id = (SELECT job_id
                   FROM employees
                  WHERE employee_id = 115)
  AND department_id = (SELECT department_id
                         FROM employees
                        WHERE employee_id = 115);


-- 답
SELECT employee_id, first_name, job_id, department_id
  FROM employees
 WHERE (job_id, department_id) = ( SELECT job_id, department_id
                                     FROM employees 
                                    WHERE employee_id = 115);





-- 4. location_id가 1000~1900인 국가들의 country_id, country_name을 조회하시오.
SELECT   DISTINCT c.country_id, c.country_name
  FROM   countries c, locations l
  WHERE  c.country_id = l.country_id
  AND    l.location_id BETWEEN 1000 AND 1900;


-- 답
SELECT  country_id
      , country_name
  FROM countries c
 WHERE country_id IN (SELECT country_id 
                        FROM locations 
                       WHERE location_id IN (1000,1100,1200,1300,1400,1500,1600,1700,1800,1900)); 

SELECT  country_id
      , country_name
  FROM countries c
 WHERE country_id IN (SELECT country_id 
                        FROM locations 
                       WHERE location_id BETWEEN 1000 AND 1900); 












-- 5. manager가 아닌 사원들의  employee_id, first_name을 조회하시오.
--  서브쿼리 결과는 null을 포함하면 안 된다.
SELECT employee_id, first_name
  FROM employees 
  WHERE  employee_id NOT IN (SELECT  e.employee_id
                               FROM employees e, employees m
                              WHERE e.manager_id = m.employee_id);


-- manager임
SELECT employee_id, first_name
  FROM employees 
 WHERE employee_id IN (SELECT DISTINCT manager_id
                         FROM employees
                        WHERE manager_id IS NOT NULL);

-- manager 아님 
SELECT employee_id, first_name
  FROM employees 
 WHERE employee_id NOT IN (SELECT DISTINCT manager_id
                            FROM employees
                           WHERE manager_id IS NOT NULL);







      -- 1400이 번호 // 부서번호는 60인사람을 찾는 문제..
-- 6. city가 'Southlake'인 사원들의  employee_id, first_name를 조회하시오.
SELECT  e.employee_id, e.first_name, ll.city
 FROM   employees e, locations ll
 WHERE  ll.location_id = ( SELECT d.location_id 
                             FROM departments d,  locations l 
                            WHERE d.location_id = l.location_id
                              AND l.city =  'Southlake') ;
 
 

 -- 답 
SELECT  employee_id, first_name 
  FROM employees
  WHERE department_id IN (SELECT department_id
                            FROM departments 
                           WHERE LOCATION_ID IN (SELECT location_id 
                                                   FROM locations 
                                                   WHERE city =  'Southlake'));
 
 
 
 
 
 
 
-- 7. 가장 많은 사원이 근무 중인 부서의 department_id, 근무 인원 수를 조회하시오.
SELECT     department_id, count(*)
  FROM     employees 
 GROUP BY  department_id 
HAVING COUNT(*) = (SELECT Max(count(*)) FROM employees GROUP BY  department_id )
 ;



-- 답
SELECT department_id, COUNT(*)
  FROM employees
GROUP BY department_id
  HAVING COUNT(*) =( SELECT MAX(COUNT(*)) 
                       FROM employees 
                      GROUP BY department_id );










-- 8. department_name 오름차순 정렬 기준으로 사원의
--   employee_id, first_name, department_id를 조회하시오.
SELECT  employee_id, first_name, department_id
  FROM  (SELECT d.department_id
           FROM departments d, employees e
           WHERE d.department_id = e.department_id
           ORDER BY d.department_name);
 


-- 답 
SELECT  e.employee_id, e.first_name, e.department_id    -- 메인 쿼리의 from 절이 가장 먼저고 서브쿼리로 감 
  FROM  employees e
 ORDER BY ( SELECT d.department_name
               FROM departments d
               WHERE d.department_id = e.department_id);





-- 8. 최대 연봉 사원의 employee_id, first_name, salary를 조회하시오.
--   rownum 활용
--   1) 높은 연봉이 가장 위로 오도록 정렬한다.(연봉 내림차순 정렬 )
--   2) 정렬 결과에서 ROWNUM이 1인 데이터를 조회한다.
SELECT a.employee_id,
       a.first_name, 
       a.salary
 FROM (SELECT employee_id, first_name, salary 
        FROM employees 
       ORDER BY salary DESC) a
   WHERE ROWNUM = 1;


-- 10. 연봉 top 11~20사원의 employee_id, first_name, salary를 조회하시오.
--    1) 높은 연봉이 가장 위로 오도록 정렬한다.(연봉 내림차순 정렬)
--    2) 정렬 결과에 ROWNUM 칼럼을 추가한다. 반드시 ROWNUM 칼럼에 별명을 부여한다.
--    3) 부여된 ROWNUM의 별명으로 11 ~ 20 사이를 조회한다.
SELECT b.employee_id, b.first_name, b.salary
 FROM(SELECT rownum as rn, a.employee_id, a.first_name, a.salary
       FROM (SELECT employee_id, first_name, salary 
              FROM employees 
             ORDER BY salary DESC) a ) b
 WHERE b.rn BETWEEN 11 AND 20;
















1.

DROP USER  SCOTT  CASCADE;



2. 

CREATE USER ADMIN IDENTIFIED BY 1234;

GRANT DBA TO ADMIN;



3.

SELECT U.USER_ID, U.USER_NAME, COUNT(B.BUY_AMOUNT) FROM USERS U LEFT JOIN BUYS B ON u.user_id = b.user_id GROUP BY  U.USER_ID, U.USER_NAME;





4.

SELECT B.USER_ID AS 고객아이디, U.USER_NAME AS 고객명, SUM(PROD_PRICE*BUY_AMOUNT) AS 총구매액 FROM BUYS B, users U WHERE B.USER_ID = U.USER_ID AND B.PROD_CATEGORY = '전자' GROUP BY B.user_id, U.USER_NAME;





5.

SELECT U.USER_ID AS 고객아이디, U.USER_NAME AS 고객명, COUNT(BUY_AMOUNT) AS 구매횟수 FROM USERS U, BUYS B WHERE U.USER_ID = B.USER_ID GROUP BY U.USER_ID, U.USER_NAME HAVING COUNT(BUY_AMOUNT) >= 2;





6.

CREATE OR REPLACE FUNCTION GET_GRADE(V_USER_ID VARCHAR2)

RETURN CHAR



IS   

  GRADE CHAR(1);   

  TOTAL NUMBER; 

  V_USER_NAME users.user_name%TYPE;



BEGIN 

     SELECT SUM(B.PROD_PRICE*B.BUY_AMOUNT) INTO TOTAL     

     FROM BUYS B, USERS U   

     WHERE B.USER_ID = U.USER_ID;

        IF  TOTAL >= 1000 THEN     

              GRADE := 'A'; 

       ELSIF TOTAL>=500 THEN       

              GRADE := 'B';   

       ELSE       

            GRADE := 'C';   

       END IF; 

       RETURN GRADE;   

   DBMS_OUTPUT.PUT_LINE(V_USER_NAME);   

  DBMS_OUTPUT.PUT_LINE(GRADE);

END GET_GRADE;





SELECT GET_GRADE('KHD') AS 등급 FROM DUAL;


























