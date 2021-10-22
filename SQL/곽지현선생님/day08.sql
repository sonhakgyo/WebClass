1. 데이터 조작어(Data Manipulation Language)
  1-1.데이터 조회 및 변형을 위한 명령어
   - Select : 데이터 조회
   - Insert : 데이터 입력
   - Update : 데이터 수정
   - Delete : 데이터 삭제

  1-2. select
   - 	select 	컬럼1, 컬럼2
	from	테이블
	where 	조건들;

  1-3. insert
   - 	insert into 테이블명 (컬럼1, 컬럼2)
	values (값1, 값2);

  1-4. update 
   -	update 	테이블명
	set 	컬럼1 = 값,
		컬럼2 = 값
	where	조건;

  1-5. delete
   - 	delete from 테이블명
	where 	조건;

2. commit;
  2-1. commit
   - 모든 작업을 정상적으로 처리하겠다고 확정하는 명령어이다.
   - 트랜잭션의 처리 과정을 데이터베이스에 반영하기 위해서, 변경된
   내용을 모두 영구 저장한다.
   - commit 수행하면, 하나의 트랜젝션 과정을 종료하게 된다.
   - transaction작업 내용을 실제 DB에 저장한다.
   - 이전 데이터가 완전히 update된다.
   - 모든 사용자가 변경한 데이터의 결과를 볼 수 있다.

  2-2. rollback
   - 작업 중 문제가 발생했을 때, 트랜젝션의 처리 과정에서 발생한
   변경 사항을 취소하고, 트랜젝션 과정을 종료시킨다.
   - 트랜젝션으로 인한 하나의 묶음 처리가 시작되기 이전의 상태로 
   되돌린다. 
   - 트랜젝션 작업 내용을 취소한다.
   - 이전 commit한 곳까지만 복구한다.
   - 트랜젝션 작업 중 하나라도 문제가 발생하면, 모든 작업을 취소해야
   하기 때문에 하나의 논리적인 작업 단위로 구성해 놓아야 한다.
   - 문제가 발생하면, 논리적인 작업의 단위를 모두 취소해 버리면 되기
   때문이다.

3. 컬럼속성(무결성 제약조건)
  - not null 	: 널값이 입력되지 못하게 하는 조건
  - unique 	: 중복된 값이 입력되지 못하게 하는 조건
  - check	: 주어진 값만 허용하는 조건
  - primary key	: not null + unique (+ index)의 의미
  - foreign key(외래키) : 다른 테이블의 필드(컬럼)를
			참조해서 무결성을 검사하는 조건
     



SELECT 	e.DEPARTMENT_ID , d.DEPARTMENT_NAME, 
		COUNT(*) , sum(SALARY) ,
		l.CITY 
FROM	EMPLOYEES e 
	INNER JOIN DEPARTMENTS d 
	ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
	INNER JOIN LOCATIONS l 
	ON d.LOCATION_ID = l.LOCATION_ID 
WHERE d.DEPARTMENT_ID IN (10, 30, 100, 110)	
GROUP BY e.DEPARTMENT_ID, d.DEPARTMENT_NAME, l.CITY 
HAVING d.DEPARTMENT_NAME IN ('Administration', 'Accounting')
;

-- table명 	: sample
-- deptNo 	: number(20)
-- deptName : varchar2(15)
-- deploc	: varchar2(15)
-- deptManger	: varchar2(10)

CREATE TABLE sample(
	deptNo		number(20),
	deptName	varchar2(15),
	deploc		varchar2(15),
	depManger	varchar2(10)
);

-- deptNo : 10, deptName : 기획실,  deploc : 부산 , deptManger : 홍길동
-- deptNo : 20, deptName : 전산실,  deploc : 서울 , deptManger : 김말똥
-- deptNo : 30, deptName : 영업부실,  deploc : 광주 , deptManger : null
INSERT INTO SAMPLE (deptNo, deptName, deploc, depManger)
VALUES (10, '기획실', '서울', '홍길동');
INSERT INTO SAMPLE 
VALUES (20, '전산실', '부산', '김말똥');
INSERT INTO SAMPLE 
VALUES (30, '영업부실', '광주', null);

-- TRUNCATE TABLE SAMPLE ;
SELECT * FROM SAMPLE s ;

-- sample 테이블에서 deptNo가 30인 부서번호를 50으로 수정
UPDATE 	SAMPLE SET DEPTNO = 50
WHERE 	DEPTNO = 30;

-- sample 테이블에서 deptName 영업부인 deploc를 인천으로 수정
UPDATE 	SAMPLE SET DEPLOC = '인천'
WHERE DEPTNAME = '영업부실'
;

-- DELETE 
DELETE sample WHERE deptname = '전산실';
DELETE sample WHERE deptname = '기획실';
DELETE sample WHERE deptname = '영업부실';

SELECT * FROM SAMPLE s ;

ROLLBACK;
COMMIT;

-- not null

CREATE TABLE null_test(
	col1	varchar2(20) NOT NULL,
	col2 	varchar2(20)
);

CREATE TABLE null_test2(
	col1	varchar2(20) NOT NULL,
	col2 	varchar2(20) NULL,
	col3 	varchar2(20)
);

INSERT INTO NULL_TEST (col1, COL2)
VALUES ('aa', 'bb');

SELECT * FROM NULL_TEST;


INSERT INTO NULL_TEST (col1, COL2)
VALUES (null, 'bb');

INSERT INTO NULL_TEST (col1, COL2)
VALUES ('aa', null);


-- unique
CREATE TABLE unique_test(
	col1 	varchar2(20) UNIQUE NOT NULL,
	col2	varchar2(20) UNIQUE,
	col3	varchar2(20)
);

INSERT INTO UNIQUE_TEST (col1, col2, COL3)
VALUES ('aa', 'bb', 'cc');
INSERT INTO UNIQUE_TEST (col1, col2, COL3)
VALUES ('aa2', 'bb2', 'cc2');
SELECT * FROM UNIQUE_TEST ut ;

UPDATE 	UNIQUE_TEST 
SET 	COL1 = 'aa'
WHERE 	COL2 = 'bb2'
;

INSERT INTO UNIQUE_TEST (col1, col2, COL3)
VALUES ('aa3', null, 'cc2');
INSERT INTO UNIQUE_TEST (col1, col2, COL3)
VALUES ('aa4', null, 'cc2');
SELECT * FROM UNIQUE_TEST ut ;


-- check
CREATE TABLE check_test2(
	gender 	varchar2(10) NOT NULL
		CONSTRAINTS CHECK_gender2 check(gender IN('M','F','남자','여자'))
);

INSERT INTO check_test2 VALUES ('M');
SELECT * FROM check_test2 ;

