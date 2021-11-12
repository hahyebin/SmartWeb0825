DROP TABLE student;
CREATE TABLE student
(
	sno 	VARCHAR2(5) PRIMARY KEY,
	name 	VARCHAR2(20),
	kor		NUMBER(3) 	CHECK(kor BETWEEN 0 AND 100),
	eng		NUMBER(3) 	CHECK(eng >= 0 AND eng <= 100),
	mat		NUMBER(3) 	CHECK(mat BETWEEN 0 AND 100),
	ave		NUMBER(5,2), 
	grade   CHAR(1)
);


-- NUMBER(5,2) --> 정수 3자리, 소수점자리 2자리

		  
	SELECT RANK() OVER(ORDER BY AVE DESC) 
      		sno, name, kor, eng, mat, ave, grade
  	  FROM student
     WHERE ROWNUM < 4;

	  SELECT a.sno, a.name, a.kor, a.eng, a.mat, a.ave, a.grade
		FROM (SELECT sno, name, kor, eng, mat, ave, grade 
				FROM student
			   ORDER BY ave DESC) a
		WHERE ROWNUM <=3;