1. Oracle data type
1-1. 데이터 타입
- 데이터 타입이란 컬럼이 저장되는 데이터 유형을 말합니다.
기본 데이터 타입은 문자형, 실수, 소수, 자료형 등의 여러 데이터를 
식별하는 타입입니다.

1-2. 고정길이, 가변길이
- 가변길이란 실제 입력된 데이터 길이에 따라서 크기가 변하는 것을
의미한다.
- 예를들어 가변형 문자형 데이터타입인 varchar2에 10이라는
데이터 공간을 할당하고 abc라는 데이터를 입력했다면, 그 데이터는
10이라는 데이터 공간을 할당했기에 10byte까지만 데이터를
입력받을 수 있고 3글자만 입력되었으므로 그 데이터 공간은 3byte된다.
반대로 고정형 문자형 테이터 타입인 char에 10이라는 데이터공간을
할당하고 마찬가지로 abc라는 데이터를 입력했다고 치면 그 데이터는
3글자만 입력되었지만 데이터공간은 10byte가 됩니다. 남/여 같이
1글자만 들어올 수 있는 것이 아니라면 대부분 varchar2를 사용한다.

1-3. 숫자형 데이터 타입
- 숫자형 타입은 대부분 NUMBER형을 사용합니다. P는 소수점을
포함한 전체 자릿수를 의미하고, S는 소수점 자릿수를 의미한다.
NUMBER는 가변 숫자이므로 P와 S를 입ㄹ벽하지 않으면 저장 데이터의
크기에 맞게 자동으로 조절됩니다.
- 고정 소수점 숫자는 NUMBER(p,s)로 정의하며,
정수(Integer)는 NUMBER(p) 또는 NUMBER(p,0)으로 정의한다.

1-4. 날짜 데이터 타입
- 가장 일반적으로 쓰는 데이터타입은 DATE이다.

1-5. DDL(Data Definition Language)
- 데이터의 구조를 정의하기 위한 테이블 생성,삭제 같은 명령어
- Create : 테이블 생성
- Drop : 테이블 삭제
- Alter : 테이블 수정
- Truncate : 테이블에 있는 모든 데이터 삭제


-


-- 문1. EMPLOYEES 테이블에서 (급여의 평균)보다 작은 사원의
-- 사원번호, 이름, 담당업무, 급여, 부서번호를 출력하라
SELECT 	e.EMPLOYEE_ID , e.FIRST_NAME, e.JOB_ID ,
		e.SALARY , e.DEPARTMENT_ID 
FROM 	EMPLOYEES e 
WHERE 	SALARY  < (SELECT AVG(SALARY) FROM EMPLOYEES e2)
;

-- 문2. EMPLOYEES 테이블에서 (100번 부서의 
-- 최소 급여보다 최소 급여)가 많은 다른 모든 부서를 출력하라
SELECT 	DEPARTMENT_ID, MIN(SALARY) 
FROM 	EMPLOYEES e 
GROUP BY DEPARTMENT_ID
HAVING MIN(SALARY) > (	SELECT 	min(SALARY) 
						FROM 	EMPLOYEES e2
						WHERE 	DEPARTMENT_ID = 100)
;						


-- 문3. EMPLOYEES 테이블에서 (가장 많은 사원)을 갖는 
-- Manager의 사원번호를 출력하라.
SELECT 	MANAGER_ID
FROM 	EMPLOYEES e
GROUP BY MANAGER_ID
HAVING COUNT(MANAGER_ID) = (SELECT 	MAX(COUNT(*))  
							FROM 	EMPLOYEES e
							GROUP BY MANAGER_ID)  
;

SELECT 	MANAGER_ID
FROM 	EMPLOYEES e
GROUP BY MANAGER_ID
HAVING COUNT(*) = (SELECT 	MAX(COUNT(*))  
							FROM 	EMPLOYEES e
							GROUP BY MANAGER_ID)  
;


SELECT  MANAGER_ID
FROM 	EMPLOYEES e
GROUP BY MANAGER_ID 
HAVING 	count(EMPLOYEE_ID) = (SELECT max(count(*))
							FROM 	EMPLOYEES e3 
							GROUP BY MANAGER_ID) 
;

SELECT 	MAX(COUNT(EMPLOYEE_ID))  
FROM 	EMPLOYEES e
GROUP BY MANAGER_ID 
;

SELECT 	MAX(COUNT(*))  
FROM 	EMPLOYEES e
GROUP BY MANAGER_ID 
;

SELECT COUNT(*) FROM EMPLOYEES e ;
SELECT COUNT(EMPLOYEE_ID) FROM EMPLOYEES e ;
SELECT COUNT(MANAGER_ID) FROM EMPLOYEES e ;
SELECT * FROM EMPLOYEES e WHERE MANAGER_ID IS NULL;


-- 문4. EMPLOYEES 테이블에서 (가장 많은 사원이 속해있는 부서 번호)와
-- 사원수를 출력하라

SELECT 	DEPARTMENT_ID , COUNT(*) 
FROM 	EMPLOYEES e2  
GROUP BY DEPARTMENT_ID 
HAVING COUNT(*) = (	SELECT  MAX(COUNT(*))  
					FROM  	EMPLOYEES e 
					GROUP BY DEPARTMENT_ID)
;	


SELECT  MAX(COUNT(*))  
FROM  	EMPLOYEES e 
GROUP BY DEPARTMENT_ID 
;


-- 문5. EMPLOYEES 테이블에서 사원번호가 123인 사원의 직업과 같고,
-- 사원번호가 192인 사원의 급여(sal)보다 많은 사원의 
-- 사원번호, 이름, 직업, 급여를 출력하라

SELECT 	e.EMPLOYEE_ID , e.FIRST_NAME , e.JOB_ID , e.SALARY 
FROM 	EMPLOYEES e 
WHERE 	JOB_ID = (SELECT JOB_ID FROM EMPLOYEES e2 WHERE EMPLOYEE_ID = 123)
AND		SALARY > (SELECT SALARY FROM EMPLOYEES e3 WHERE EMPLOYEE_ID = 192) 
;

------------------------------------------------------------------ DDL

-- 테이블 생성
CREATE TABLE EMPLOYEES2(
	employee_id		number(10),
	name			varchar2(20),
	salary			number(7,2)
);

CREATE TABLE EMPLOYEES3(
	employee_id		number(10),
	name			varchar2(20),
	salary			number(7,2),
	create_date		DATE	DEFAULT sysdate 
);

-- 기존 테이블과 동일하게 작성 
CREATE TABLE employees3 
AS 
SELECT * FROM EMPLOYEES2 e ;

-- 컬럼추가
ALTER TABLE EMPLOYEES2 ADD(
	manager_id 	varchar2(10)
);

ALTER TABLE EMPLOYEES2 modify(
	manager_id 	varchar2(20)
);

-- 컬럼 삭제
ALTER TABLE EMPLOYEES2 DROP COLUMN manager_id;

SELECT * FROM EMPLOYEES2;

INSERT INTO EMPLOYEES2 
VALUES (4, '테스트', 30000);

INSERT INTO EMPLOYEES3 (employee_id, name)
VALUES (4, '테스트');

-- DELETE FROM EMPLOYEES2 e WHERE EMPLOYEE_ID  = 1;

-- 데이터 비우기
-- TRUNCATE TABLE EMPLOYEES2 ;

-- 테이블 삭제
-- DROP TABLE EMPLOYEES3 ;