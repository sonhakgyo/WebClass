1. INDEX
1-1. index란
    - 조회속도를 향상시키기 위한 데이터베이스 검색 기술
    - 색인이라는 뜻으로 해당 테이블의 조회결과를 빠르게 하기 위해
　    사용.
    - 인덱스를 생성해 줌으로써 조회 속도를 빠르게 할 수 있다.
    - index를 테이블의 특정 컬럼에 한개이상 주게 되면 
　    index table이 따로 만들어 지고, 인덱스 컬럼의 로우값과 
　    rowid 값이 저장되며 로우값은 정렬된 트리 구조로 저장시켜 
　    두었다가 검색시 좀 더 빠르게 해당 데이터를 찾는데 도움을 준다.

    - 하지만 DML명령을 사용 할때는 원본 Table은 물론
　    Index Table에도 데이타를 갱신시켜 주어야 하기 때문에
　　  update, insert, delete(DML) 명령을 쓸대 속도가 
　　  느려진다는 단점이 있다.

1-2. index생성이 불필요한 경우
    - 데이터가 적은(수천건 미만) 경우에는 인덱스를 설정하지 않는게
　    오히려 성능이 좋아
    - 조회 보다 삽입, 수정, 삭제 처리가 많은 테이블
    - delete : 인덱스에서는 데이터를 사용하지 않음으로 표시하고
　    지우지는 않는다.
    - insert : split현상으로 부하가 걸린다. 
    - update : 인덱스에서는 delete를 한 후, 새로운 데이터를
　    insert작업을 함

1-3. index 생성
    - Unique 인덱스는 인덱스를 사용한 컬럼의 중복값들을 포함하지
　    않고 사용할 수 있는 장점이 있다.

    create unique index 인덱스명 on 테이블명(컬럼);

    - Non-unique 인덱스는 인덱스를 사용한 컬럼에 중복 데이터
　    값을 가질 수 있다.

    create index 인덱스명 on 테이블명(컬럼);


-


-- INDEX 
CREATE TABLE EMPLOYEES4 AS SELECT * FROM EMPLOYEES e;

SELECT ROWID, EMPLOYEE_ID
FROM   EMPLOYEES4 e;
-- WHERE EMPLOYEE_ID = 200 ???

INSERT INTO EMPLOYEES4(EMPLOYEE_ID, FIRST_NAME, LAST_NAME)
VALUES      (100, 'Steven', 'King');


CREATE UNIQUE INDEX IDX_EMPLOYEE3_ID
ON EMPLOYEES4(EMPLOYEE_ID);

DELETE FROM EMPLOYEES4 e 
WHERE  FIRST_NAME = 'Steven'
AND    EMAIL IS NULL;

SELECT * FROM EMPLOYEES4 e
WHERE  EMPLOYEE_ID = 100;

CREATE INDEX IDX_EMPLOYEE4_ID
ON EMPLOYEES4(FIRST_NAME);
