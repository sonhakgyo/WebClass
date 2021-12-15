1. JOIN(조인)
1-1. join이란?
- 두 개 이상의 테이블을 서로 연결하여 데이터를 검색할 때 사용하는 방법으로
- 두 개의 테이블을 마치 하나의 테이블인 것처럼 보여주는 것이다.

1-2. JOIN의 기본 사용 방법
- 두개의 테이블에 하나라도 같은 컬럼이 있어야 합니다.
- 두 컬럼의 값은 공유 되어야 합니다.
- 보통 조인을 위해 기본키(Primary Key)와 외래키(Foreign Key)를
활용 합니다.

1-3. inner join
- 각 테이블에서 조인 조건에 일치되는 데이터만 가져온다.
- inner join은 '교집합' 이다.

1-4. outer join
- 조인 조건에 일치하는 데이터 및 일치하지 않은 데이터를 모두 select 한다.
- 조인 조건에 일치하는 데이터가 없다면 NULL로 가져온다.
- Outer Join은 Inner Join과는 다르게 주(main) 테이블이
어떤 테이블인지가 중요한다.그래서 어떤 테이블이 중심이 되느냐에 따라
다시 Left Outer Join, Rigth Outer Join, Full Outer Join으로
세분 할 수 있다. Left Outer Join은 왼쪽에 있는 테이블이, 
Right Outer Join은 오른쪽에 있는 테이블이, Full Outer Join은 
양쪽 모두가 중심이라는 뜻이다.


-


--  nvl() : 널값을 다른 데이터로 변경하는 함수 
SELECT 	FIRST_NAME
	,	LAST_NAME 
	,	NVL(COMMISSION_PCT, 0) 
FROM	EMPLOYEES e
;


-- decode() : switch문의 역할을 하는 함수
SELECT 	DEPARTMENT_ID 
	,	DECODE(DEPARTMENT_ID, 20, 'MA', 
		60, 'IT', 90, 'EX', 'ETC') 	
FROM 	DEPARTMENTS d 
;

-- case()
SELECT 	FIRST_NAME 
	, 	DEPARTMENT_ID 
	,	CASE WHEN DEPARTMENT_ID = 20 THEN 'MA'
			 WHEN DEPARTMENT_ID = 60 THEN 'IT'
			 WHEN DEPARTMENT_ID = 90 THEN 'EX'
			 ELSE ''
			 END "department"
FROM 	EMPLOYEES e 
;

-- distinct, group by
/*
 * distinct : 유니크(중복을 제거)한 데이터(컬럼이나 레코드)를
 * 조회하는 경우 사용한다.
 * 
 * Group by : 데이터를 그룹핑해서 그 결과를 가져오는 경우 사용한다.
 * 집계 함수와 짝을 이루어 사용 할 수 있다. *
 */

SELECT 	DISTINCT DEPARTMENT_ID 
FROM 	EMPLOYEES e 
;

SELECT 	DEPARTMENT_ID 
FROM 	EMPLOYEES e 
GROUP BY DEPARTMENT_ID 
;

-- 부서별 급여 합계
SELECT 	SUM(SALARY), DEPARTMENT_ID 
FROM 	EMPLOYEES e 
GROUP BY DEPARTMENT_ID 
;

SELECT 	DISTINCT DEPARTMENT_ID, SUM(SALARY) 
FROM 	EMPLOYEES e 
;

-- 부서별 사원수와 평균 급여, 급여의 합을 구해보자
SELECT  DEPARTMENT_ID 
	,	SUM(SALARY)
	,	AVG(SALARY)
	,	COUNT(SALARY) 
FROM 	EMPLOYEES e
GROUP BY DEPARTMENT_ID 
;

-- 부서별(DEPARTMENT_ID), 직급별(job_id)
-- 사원수, 평균급여, 급여합
SELECT  DEPARTMENT_ID , JOB_ID 
	,	TO_CHAR(SUM(SALARY), '999,999') totalSalary 
	,	SUM(SALARY)
	,	COUNT(SALARY)
	,	AVG(SALARY) 
FROM 	EMPLOYEES e 
GROUP BY DEPARTMENT_ID , JOB_ID 
ORDER BY DEPARTMENT_ID , JOB_ID 
;

-- where 절 추가
SELECT  DEPARTMENT_ID , JOB_ID 
	,	TO_CHAR(SUM(SALARY), '999,999') totalSalary 
	,	SUM(SALARY)
	,	COUNT(SALARY)
	,	AVG(SALARY) 
FROM 	EMPLOYEES e 
WHERE 	DEPARTMENT_ID = 80
GROUP BY DEPARTMENT_ID , JOB_ID 
ORDER BY DEPARTMENT_ID , JOB_ID 
;

-- having절 
-- 현재 부서별 사원수
/*
 * where 절에서는 집계함수를 사용 할 수 없다.
 * having 절은 집계함수를 가지고 조건을 비교할 때 사용한다.
 */
SELECT 	DEPARTMENT_ID
	,	COUNT(*) 
FROM 	EMPLOYEES e
WHERE 	DEPARTMENT_ID IS NOT NULL
-- AND 	count(*) >= 10
GROUP BY DEPARTMENT_ID 
HAVING COUNT(*) >= 10 
;

-- 문제1.
-- employees 테이블에서 job_id가 'SA'로 시작하는 사람에 대하여
-- 급여의 평균, 최고액, 최저액, 합계를 구하여 출력하라.
SELECT 	AVG(SALARY)
	,	MAX(SALARY)
	,	MIN(SALARY)
	,	SUM(SALARY) 
FROM 	EMPLOYEES e
WHERE 	JOB_ID LIKE 'SA%'
;


-- 문제4. employees 테이블에서 각 부서별로 인원수,
-- 급여의 평균, 최저급여, 최고급여, 급여의 합을 구하여 급여의 합이 많은 
-- 순으로 출력하라.

SELECT 	DEPARTMENT_ID 
	,	COUNT(*) AS "총합"
	,	AVG(SALARY)
	,	MIN(SALARY)
	,	MAX(SALARY)
	, 	SUM(SALARY) 
FROM 	EMPLOYEES e 
GROUP BY DEPARTMENT_ID
ORDER BY "총합" DESC
--ORDER BY  3  
;


-- 문제6. employees 테이블에서 부서별, 업무별 그룹하여 결과를 부서번호,
-- 업무, 인원수, 급여의 평균, 급여의 합을 구하여 출력하라.

SELECT  DEPARTMENT_ID 
	,	JOB_ID 
	,	COUNT(*)
	,	AVG(SALARY)
	,	SUM(SALARY) 
FROM 	EMPLOYEES e
GROUP BY DEPARTMENT_ID , JOB_ID 
;


-- 문제7. employees 테이블에서 부서 인원이 4보다 많은 부서의 부서번호,
-- 인원수, 급여의 합을 구하여 출력하라.

SELECT  DEPARTMENT_ID 
	,	COUNT(*) 
	,	SUM(SALARY) 
FROM 	EMPLOYEES e
GROUP BY DEPARTMENT_ID 
HAVING 	COUNT(*) > 4 
;

-- 문제8. employees테이블에서 급여가 최대 10000이상인 부서에 대해서
-- 부서번호, 평균 급여, 급여의 합계 구하여 출력하라.

SELECT 	DEPARTMENT_ID 
	,	AVG(SALARY)
	,	SUM(SALARY) 
FROM 	EMPLOYEES e
GROUP BY DEPARTMENT_ID 
HAVING MAX(SALARY) >= 10000 
;

SELECT * FROM EMPLOYEES e ;
SELECT * FROM DEPARTMENTS d ;
