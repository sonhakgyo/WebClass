1. 조인
1-1. left outer join
- select 	*
from	Table_A t1
LEFT OUTER JOIN Table_b t2
ON t1.Acolumn = t2.BColumn

- 왼쪽 테이블이 기준이 된다
- 조긴 조건에 부합하는 데이터가 조인 당하는 테이블(오른쪽)에 있으면
해당 데이터를, 부재하면 Null로 select된다.

1-2. right outer join
- select 	*
from	Table_A t1
RIGHT OUTER JOIN Table_b t2
ON t1.Acolumn = t2.BColumn

- 오른쪽 테이블이 기준이 된다.
- 조인 조건에 부합하는 데이터가 조인 당하는 테이블(왼쪽)에 있으면
해당 데이터를, 부재하면 Null로 select된다.

1-3. full outer join
- select 	*
from	Table_A t1
FULL OUTER JOIN Table_b t2
ON t1.Acolumn = t2.BColumn

- 양쪽 테이블 모두가 기준이 된다.
- 조인 조건에 부합하는 데이터가 조인 당하는 테이블 (왼쪽,오른쪽)에 있으면
해당 데이터를, 부재하면 NULL을 select 된다.

1-4. ANSI Join VS ORACLE Join
- SQL은 데이터베이스를 관리하기 위해 만들어진 프로그래밍 언어이며,
데이터베이스를 관리해주는 대부분의 Management System(DBMS)들은
SQL을 사용한다. 물론 DBMS 자체의 특수성 때문에 SQL의 사용법이
조금씩 다르기도 하지만, 큰 틀에서 보면 나름대로의 보편성을 가지고있다.
왜냐하면 데이터베이스를 관리한다는 본질은 바뀌지 않기 때문이다.
- 이를 위해 미국 국립 표준 협회(American National Standard 
Institute. ANSI)에서도 SQL에 대한 보편적인 문법을 제시하고 있는데,
그것이 바로 ANSI Query이다.


-


SELECT * FROM EMPLOYEES e ;

SELECT  SUM(SALARY), AVG(SALARY),min(SALARY), MAX(SALARY) 
FROM 	EMPLOYEES e 
WHERE 	JOB_ID LIKE 'SA%'
;

SELECT  JOB_ID, SUM(SALARY), AVG(SALARY),min(SALARY), MAX(SALARY) 
FROM 	EMPLOYEES e 
WHERE 	JOB_ID LIKE 'SA%'
GROUP BY JOB_ID 
;

SELECT 	*
FROM 	EMPLOYEES e  
;

SELECT 	*
FROM 	DEPARTMENTS d 
;

-- inner join
SELECT 	e.FIRST_NAME , e.LAST_NAME , e.DEPARTMENT_ID ,
		d.DEPARTMENT_ID , d.DEPARTMENT_NAME 
FROM 	EMPLOYEES e INNER JOIN DEPARTMENTS d 
	ON e.DEPARTMENT_ID  = d.DEPARTMENT_ID 
ORDER BY e.FIRST_NAME 
;

SELECT * FROM DEPARTMENTS d ;
SELECT * FROM LOCATIONS l ;


SELECT  * 
FROM 	DEPARTMENTS d 
;

SELECT 	*
FROM 	LOCATIONS l 
;

SELECT 	d.DEPARTMENT_ID , d.DEPARTMENT_NAME ,
		l.LOCATION_ID , l.CITY 
FROM 	DEPARTMENTS d 
 	INNER JOIN LOCATIONS l 
 	ON d.LOCATION_ID  = l.LOCATION_ID 
;


SELECT  e.FIRST_NAME , 
		e.LAST_NAME , 
		e.DEPARTMENT_ID, 
		d.DEPARTMENT_NAME , 
		d.LOCATION_ID, 
		l.CITY,
		j.JOB_ID, 
		j.JOB_TITLE 
FROM 	EMPLOYEES e
	INNER JOIN DEPARTMENTS d 
	ON e.DEPARTMENT_ID = d.DEPARTMENT_ID 
	INNER JOIN LOCATIONS l 
	ON d.LOCATION_ID = l.LOCATION_ID
	INNER JOIN JOBS j 
	ON e.JOB_ID  = j.JOB_ID 
WHERE l.CITY = 'Seattle'
;

SELECT * FROM JOB_HISTORY
WHERE 	EMPLOYEE_ID  = 200
;

-- 107
SELECT count(*) FROM EMPLOYEES;

-- 110
-- left outer join 
SELECT 	e.EMPLOYEE_ID , e.FIRST_NAME , e.HIRE_DATE ,
		jh.START_DATE , jh.END_DATE , jh.JOB_ID , jh.DEPARTMENT_ID 
FROM 	EMPLOYEES e 
 LEFT OUTER JOIN JOB_HISTORY jh 
 ON e.EMPLOYEE_ID = jh.EMPLOYEE_ID 
 --WHERE e.EMPLOYEE_ID = 200
;

-- 10
SELECT 	e.EMPLOYEE_ID , e.FIRST_NAME , e.HIRE_DATE ,
		jh.START_DATE , jh.END_DATE , jh.JOB_ID , jh.DEPARTMENT_ID 
FROM 	EMPLOYEES e 
 inner JOIN JOB_HISTORY jh 
 ON e.EMPLOYEE_ID = jh.EMPLOYEE_ID 
;

-- 문제 1 : 사원들의 이름(EMPLOYEES), 
-- 부서번호(EMPLOYEES,DEPARTMENTS), 부서명(DEPARTMENTS)을 출력
-- 부서번호가 존재하는 사원 정보로 조회하기

SELECT  e.FIRST_NAME , e.DEPARTMENT_ID , d.DEPARTMENT_NAME 
FROM 	EMPLOYEES e 
	INNER JOIN DEPARTMENTS d 
	ON	e.DEPARTMENT_ID  = d.DEPARTMENT_ID 
;

SELECT  e.FIRST_NAME , e.DEPARTMENT_ID , d.DEPARTMENT_NAME 
FROM 	EMPLOYEES e 
	LEFT OUTER  JOIN DEPARTMENTS d 
	ON	e.DEPARTMENT_ID  = d.DEPARTMENT_ID 
;

SELECT * FROM EMPLOYEES e  WHERE FIRST_NAME  = 'Kimberely';
