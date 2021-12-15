1. 계정 생성하기
1-1. sqlplus 창에서 system 계정으로 로그인
1-2. 명령어 입력
    create user testuser identified by 1234;
    grant connect, resource to testuser;

2. View
2-1. view란
    - view는 table과 유사하며, 테이블 처럼 사용한다.
    - 테이블과는 달리 데이터를 저장하기 위한 물리적인 공간이 
　    필요하지 않은 가상테이블이다.
    - 데이터를 물리적으로 갖지 않지만 논리적인 집합은 갖는다.
    - 테이블과 마찬가지로 select, insert, update, delete명령이
　    가능하다.

3. 시퀀스(Sequence)
3-1. 시퀀스란?
    - 시퀀스란 자동으로 순차적으로 증가하는 순번을 반환하는 데이터베이스
　    객체이다.
    - 보통 PK값에 중복값을 방지하기위해 사용한다.
    - 예를들어 게시판에 글이 하나 추가될 때마다 글번호(PK)가 생겨야 하는
　    경우에, 만약 100번까지 글 번호가 생성되어있다면 그 다음 글이 추가가
　    되려면 글 번호가 101로, 하나의 row를 생성해주어야 한다. 
　    이때, 101이라는 숫자를 얻으려면 기존 그 번호중 가장 큰 값에 + 1을
　    하는 로직을 어딘가에 넣어야한다.시퀀스를 사용하면 이러한 로직이
　    필요없이 데이터베이스에 row가 추가될때마다 자동으로 +1를 시켜준다.
    - 연속적으로 번호를 만들어주는 기능

3-2. 구문형식
    create sequence 시퀀스이름
	increment by n		n: 증가값을 설정, 
				2: 2씩 증가
				기본값 : 1 
	start with n		시작값 설정, 기본값 1
	maxvalue n | nomaxvalue	시퀀스 최대값 설정
				nomaxvalue : 무한대 값
	minvalue n | nominvalue 시퀀스 최소값을 설정
				nominvalue : 무한대 값
	cycle | nocycle		시퀀스를 순화 사용할지를 설정
				cycle로 설정시 maxvalue에 
				도달했을 경우 다시 minvalue부터 시작
	cache n | nocache	시퀀스의 속도를 개선을위해 캐싱여부 지정



-


CREATE VIEW v_emp(
	emp_id, first_name, job_id, hiredate, dept_id
) 
AS 
SELECT 	employee_id, first_name, job_id, 
		hire_date, department_id
FROM 	EMPLOYEES
WHERE 	job_id = 'ST_CLERK'
;

-

CREATE OR REPLACE VIEW v_emp2(
	emp_id, first_name, job_id, hiredate, dept_id
) 
AS 
SELECT NVL(EMPLOYEE_ID, NULL), NVL(FIRST_NAME, NULL),
　	   JOB_ID, HIRE_DATE, DEPARTMENT_ID
FROM   EMPLOYEES E
WHERE  JOB_ID = 'SH_CLERK';

SELECT * FROM v_emp2;

/* V_EMP */
update V_EMP SET first_name = 'KIM'   /* 홑따옴표를 사용해야 한다. */
WHERE  FIRST_NAME = 'Julia';          /* 쌍따옴표와 홑따옴표 사용 주의! */

SELECT * FROM V_EMP;

/* V_EMP2 */
update V_EMP2 SET first_name = 'KIM'   
WHERE  FIRST_NAME = 'Julia';          


-


CREATE VIEW v_emp_salary(
	emp_id, last_name, salary, total_sal
) 
AS
SELECT employee_id, last_name, salary, 
　	   (salary+NVL(commission_pct, 0))*12
FROM   employees e;

/* 뷰를 잘못 만들었다면 DRIP VIEW로 삭제하고 다시 실행한다. */
DROP VIEW V_EMP_SALARY;

SELECT * FROM v_emp_salary;



CREATE VIEW V_EMP3(
	EMP_ID, NAME, DEPARTMENT_ID, HIRE_DATE
) 
AS
SELECT EMPLOYEE_ID, FIRST_NAME || ' ' || LAST_NAME,
　	   DEPARTMENT_ID, HIRE_DATE
FROM   EMPLOYEES e
WHERE  DEPARTMENT_ID = 50;

SELECT * FROM V_EMP3;


-


-- SEQUENCE : 제품번호 생성하는 시퀀스 만들기
CREATE SEQUENCE SEQ_SERIAL_NO
	INCREMENT BY 1 
	START WITH   100
	MAXVALUE     110
	MINVALUE     99
	CYCLE
	CACHE        2;  -- 캐싱여부 = 캐싱 사이즈를 2로 설정한다.


CREATE TABLE GOOD(
	GOOD_NO   NUMBER(3),
	GOOD_NAME VARCHAR2(10)
);

-- NEXTVAL : 다음값 
INSERT INTO GOOD VALUES(SEQ_SERIAL_NO.NEXTVAL, '제품1');

SELECT * FROM GOOD;


-- CURRVAL : 현재값
SELECT SEQ_SERIAL_NO.CURRVAL FROM DUAL;

INSERT INTO GOOD VALUES(SEQ_SERIAL_NO.CURRVAL, '제품12');

SELECT * FROM GOOD;


--


-- SEQUENCE : 제품번호 생성하는 시퀀스 만들기
CREATE SEQUENCE SEQ_SERIAL_NO2
	INCREMENT BY 1 
	START WITH   100
	MAXVALUE     110
	MINVALUE     99
	CYCLE
	CACHE        2;  -- 캐싱여부 = 캐싱 사이즈를 2로 설정한다.


DROP SEQUENCE SEQ_SERIAL_NO2;
