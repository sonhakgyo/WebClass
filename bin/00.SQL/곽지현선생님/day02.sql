1. 데이터 조작어 - 검색
 1-1. select 문의 구성 요소
  - select 	속성이름
    from 	테이블이름
    where	검색조건
    and		검색조건
    order by 	속성이름 -- asc : 오름차순 , desc : 내림차순
;

  	select 	* 
	from 	Student 
	where	stu_no = 20001001
	and	stu_name = '김유신';

 1-2. 주석
  -- 한줄주석
  /*
	여러줄 주석
  */

 1-3. dual
  - oracle에서 기본으로 제공하는 dummy table
  - 오라클 자체에서 제공되는 테이블
  - 간단하게 함수를 이용해서 계산 결과값을 확인 할 때 사용하는 테이블
  - dual 테이블은 사용자가 함수(계산)를 실행할 때 임시로 사용하는데
  적합하다.
  - 함수에 대한 쓰임을 알고 싶을 때 특정 테이블을 생성할 필요 없이
  dual테이블을 이용하여 함수의 값을 리턴(return) 받을 수 있다.


-


SELECT 	* 
FROM	EMPLOYEES;


SELECT 	EMPLOYEE_ID , FIRST_NAME , LAST_NAME 
FROM 	EMPLOYEES
WHERE 	FIRST_NAME = 'Lex'
;

-- EMPLOYEES테이블에서 LAST_NAME이 Smith인 사람의 
-- EMPLOYEE_ID, LAST_NAME, EMAIL

SELECT	EMPLOYEE_ID , LAST_NAME , EMAIL 
FROM 	EMPLOYEES
WHERE 	LAST_NAME  = 'Smith'
;

SELECT  *
FROM 	EMPLOYEES e 
ORDER BY HIRE_DATE ASC 
;

SELECT  *
FROM 	EMPLOYEES e 
ORDER BY HIRE_DATE DESC 
;

-- as : 별칭, 알리아스

SELECT  e.EMPLOYEE_ID , e.FIRST_NAME , e.SALARY 
FROM 	EMPLOYEES e
;

SELECT  e.EMPLOYEE_ID AS "ID", 
		e.FIRST_NAME AS "NAME", 
		e.SALARY 
FROM 	EMPLOYEES e
;


SELECT  e.EMPLOYEE_ID "ID", 
		e.FIRST_NAME "NAME", 
		e.SALARY 
FROM 	EMPLOYEES e
;

-- DISTINCT : 중복제거
SELECT 	DISTINCT  JOB_ID 
FROM 	EMPLOYEES e ;

-- >=
SELECT 	*
FROM 	EMPLOYEES e 
WHERE 	SALARY >= 5000
;
-- and
SELECT *
FROM 	EMPLOYEES e 
WHERE 	DEPARTMENT_ID  = 50
AND 	JOB_ID = 'SH_CLERK'
;

SELECT *
FROM 	DEPARTMENTS d 
;

-- or
-- EMPLOYEES 테이블에서 DEPARTMENT_ID 50이거나
-- Manger_Id가 100인 사람의 
-- FIRST_Name, last_Name, Manager_id, Department_id
SELECT 	FIRST_NAME , LAST_NAME , MANAGER_ID , DEPARTMENT_ID 
FROM 	EMPLOYEES e  
WHERE 	MANAGER_ID  = 100
OR 		DEPARTMENT_ID  = 50
;

-- not
SELECT 	*
FROM 	EMPLOYEES e
WHERE 	NOT (DEPARTMENT_ID = 50)
;

-- <>
SELECT 	*
FROM 	EMPLOYEES e
WHERE 	DEPARTMENT_ID <> 50
;

-- salary 4000 ~ 8000
SELECT 	*
FROM 	EMPLOYEES e
WHERE 	SALARY >= 4000 
AND 	SALARY <= 8000
;

-- between A and B
SELECT 	*
FROM 	EMPLOYEES e
WHERE 	SALARY BETWEEN 4000 AND 8000
;

-- salary = 6500, salary = 7700, salary = 13000
-- First_name, Last_name, salary
SELECT 	FIRST_NAME , LAST_NAME , SALARY 
FROM 	EMPLOYEES e 
WHERE 	SALARY = 6500
OR 		SALARY = 7700
OR 		SALARY = 13000
;

-- in
SELECT 	FIRST_NAME , LAST_NAME , SALARY 
FROM 	EMPLOYEES e 
WHERE 	SALARY in(6500, 7700, 13000)
;

-- like
SELECT 	FIRST_NAME , LAST_NAME 
FROM 	EMPLOYEES e
WHERE 	FIRST_NAME LIKE 'D%'
ORDER BY FIRST_NAME 
;

SELECT 	FIRST_NAME , LAST_NAME 
FROM 	EMPLOYEES e
WHERE 	FIRST_NAME LIKE '%d'
ORDER BY FIRST_NAME 
;

SELECT 	FIRST_NAME , LAST_NAME 
FROM 	EMPLOYEES e
WHERE 	FIRST_NAME LIKE '%d%'
ORDER BY FIRST_NAME 
;

-- is null
SELECT 	FIRST_NAME , LAST_NAME , COMMISSION_PCT 
FROM 	EMPLOYEES e 
WHERE 	COMMISSION_PCT IS NULL 
;

-- is not null
SELECT 	FIRST_NAME , LAST_NAME , COMMISSION_PCT 
FROM 	EMPLOYEES e 
WHERE 	COMMISSION_PCT IS not NULL 
;

-- 합계 : sum
SELECT 	sum(SALARY) 
FROM 	EMPLOYEES e 
;

-- count
SELECT count(*)
FROM  	EMPLOYEES e 
;

SELECT count(EMPLOYEE_ID)
FROM  	EMPLOYEES e 
;

SELECT * FROM EMPLOYEES e ;

-- distinct, count
SELECT 	count(DISTINCT COMMISSION_PCT) AS "commitCNT"
FROM 	EMPLOYEES e 
;

-- EMPLOYEES 테이블에서 First_name의 count와
-- 중복을 제거한 First_name count를 조회하시오
SELECT  count(FIRST_NAME), count(DISTINCT FIRST_NAME) 
FROM 	EMPLOYEES e 
;

-- 평균 - avg
SELECT 	avg(SALARY) 
FROM 	EMPLOYEES e 
;

-- department_id = 80 인 급여 평균을 구하여
SELECT 	avg(SALARY) 
FROM 	EMPLOYEES e
WHERE 	DEPARTMENT_ID = 80
;

-- 최대값 : max()
SELECT  max(SALARY) 
FROM 	EMPLOYEES e 
;

SELECT 	MAX(HIRE_DATE) 
FROM 	EMPLOYEES e 
;

-- 최소값 : min()
SELECT 	min(SALARY)
FROM 	EMPLOYEES e 
;

SELECT 	min(HIRE_DATE)
FROM 	EMPLOYEES e 
;

-- 절대 값 : abs()
SELECT 	abs(-23)
FROM	dual
;

SELECT 	SYSDATE  
FROM 	dual;

-- 반올림 : round()
SELECT 	ROUND(0.123), ROUND(0.5432), ROUND(2.512)
FROM 	DUAL;

-- 절삭 : trunc()
SELECT 	TRUNC(1234.12345679)
FROM	DUAL ;

SELECT 	TRUNC(1234.12345679, 2)
FROM	DUAL ;

SELECT 	TRUNC(1234.12345679, 0)
FROM	DUAL ;

SELECT 	TRUNC(1234.12345679, -1)
FROM	DUAL ;
