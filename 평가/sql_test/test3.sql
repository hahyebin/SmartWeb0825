-- 모든 고객의 고객아이디, 고객명, 구매횟수를 조회하시오. 외부조인을 사용하시오. (15점)   같은사람이 주문 여러번 고려하기
SELECT u.user_id AS 아이디
     , u.user_name AS 고객명
     , COUNT(b.buy_amount) AS 구매횟수
 FROM users u LEFT JOIN buys b
 ON u.user_id = b.user_id
 GROUP BY  u.user_id, u.user_name;

-- 카테고리가 '전자'인 제품을 구매한 고객아이디, 고객명, 총구매액을 조회하시오. (15점)
SELECT b.user_id AS 고객아이디
     , u.user_name AS 고객명
     , SUM(b.prod_price*b.buy_amount) AS 총구매액
 FROM  users u, buys b
 WHERE  u.user_id = b.user_id 
 AND b.prod_category = '전자'
 GROUP BY b.user_id, u.user_name;




--구매횟수가 2회 이상인 고객아이디, 고객명, 구매횟수를 조회하시오. 내부조인을 사용하시오. (15점)
SELECT u.user_id AS 고객아이디
     , u.user_name AS 고객명
     , COUNT(B.buy_amount) AS 구매횟수
 FROM users u, buys b
 WHERE u.user_id = b.user_id
 GROUP BY u.user_id, u.user_name
 HAVING COUNT(B.buy_amount) >= 2;







--사용자의 아이디를 전달하면 
--해당 아이디를 가진 사용자의 구매총액(PROD_PRICE * BUY_AMOUNT)의 합계를 계산한 뒤
-- 합계가 1000 이상이면 'A',
--1000 미만 500 이상이면 'B', 500 미만이면 'C'를 반환하는 get_grade() 사용자 함수를 작성하시오. 

-- 아이디가 'KHD'인 사용자의 정보를 조회하는 쿼리문을 작성하고 호출하시오. (15점)

CREATE OR REPLACE FUNCTION GET_GRADE(V_USER_ID VARCHAR2)
RETURN CHAR

IS
    GRADE CHAR(1);
    TOTAL NUMBER;

BEGIN
    SELECT SUM(B.PROD_PRICE*B.BUY_AMOUNT) INTO TOTAL
      FROM BUYS B, USERS U
      WHERE B.USER_ID = U.USER_ID
      AND B.USER_ID = V_USER_ID;




    IF  TOTAL >= 1000 THEN
       GRADE := 'A';
    ELSIF TOTAL >=500 THEN
       GRADE := 'B';
    ELSE
       GRADE := 'C';
    END IF;
    RETURN GRADE;

END GET_GRADE;



SELECT USER_NAME AS 고객명, GET_GRADE('KHD') AS 등급 FROM USERS WHERE USER_ID = 'KHD';
