-- 프로시저
-- 1. 한 번에 처리할 수 있는 쿼리문의 집합을 의미한다.
-- 2. CREATE PROCEDURE를 통해서 작성한다.
-- 3. 기존 프로시저를 덮어쓰기 하기 위해서 CREATE OR REPLACE PROCEDURE를 사용할 수 있다. 
-- 4. EXECUTE를 통해서 실행한다. 줄여서 EXEC라고 한다.

-- 프로시저 proc1 정의
CREATE OR REPLACE PROCEDURE proc1
IS
   -- IS : 변수 선언하는 곳, AS도 가능 
BEGIN
   DBMS_OUTPUT.PUT_LINE('Hello');
END proc1;

-- 프로시저 proc1의 실행 
EXEC proc1();


-- 프로시저 proc2 정의
CREATE OR REPLACE PROCEDURE proc2
IS 
   age NUMBER(3);
BEGIN
   age := 26;
   DBMS_OUTPUT.PUT_LINE('내 나이는 : ' || age);

END proc2;

EXEC PROC2();





-- 프로시저 proc3 정의
-- 입력 파라미터 : 변수 IN 타입 
CREATE OR REPLACE PROCEDURE proc3(v_id IN NUMBER)  -- 입력 파라미터에 varchar2 일때는 바이트 안적어도가능
IS
  v_first_name employees.first_name%TYPE;
 

BEGIN
  SELECT first_name INTO v_first_name
  FROM employees
  WHERE employee_id = v_id;
  DBMS_OUTPUT.PUT_LINE('사원번호 '|| v_id || ', 이름 : '|| V_first_name);
  
EXCEPTION 
   WHEN  OTHERS THEN
     DBMS_OUTPUT.PUT_LINE('예외 발생');
     
END proc3;


-- 프로시저 proc3 실행
EXEC proc3(100);  -- 인수 100을 입력 파라미터 v_id에 전달






-- 프로시저 proc4 정의
-- 출력 파라미터 : 변수명 OUT 타입     -> 실행하는 EXEC proc4(변수) 변수값이 리턴되고 매개변수를 다시 선언해줘여한다. 
CREATE OR REPLACE PROCEDURE proc4(v_salary OUT NUMBER)
IS
BEGIN
    SELECT salary INTO v_salary 
     FROM employees
     WHERE employee_id = 100;
   
   
END proc4;

-- 프로시저 proc4 실행 
DECLARE 
   sal employees.salary%TYPE;
BEGIN
  proc4(sal);    --EXECUTE 없어야 실행 
  DBMS_OUTPUT.PUT_LINE(sal);
  
END;



-- 프로시저 proc5 정의
CREATE OR REPLACE PROCEDURE proc5(v_id IN NUMBER, sal OUT NUMBER)
IS 

BEGIN
    SELECT salary INTO sal 
      FROM employees
     WHERE employee_id = v_id;
     
EXCEPTION  
   WHEN OTHERS THEN
    sal := -999999;

END proc5;



-- 프로시저 proc5 실행 
DECLARE 
    employee_id  employees.employee_id%TYPE;
    salary       employees.salary%TYPE;
BEGIN
    employee_id := 100;
    proc5(employee_id, salary);
    DBMS_OUTPUT.PUT_LINE('사원번호 : '|| employee_id || ', 연봉 : '|| salary);
END;










































