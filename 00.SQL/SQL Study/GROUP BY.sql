GROUP BY
    - 집계 함수는 일반적으로 GROUP BY절을 사용하여 그룹별 연산을 수행한다.
    - 일반적이라는 말은 굳이 안 쓸 수도 있다는 말이다.

    · 소그룹별 집계 시 'GROUP BY'를 사용한다.
    SELECT   POSITION, COUNT(*) 전체행수, COUNT(HEIGHT) 키건수, AVG(HEIGHT) 평균키
    FROM     PLAYER 
    GROUP BY POSITION;  -- POSITION별로 집계한다. 단일컬럼, 개별컬럼은 조회 불가능하다.

    · 테이블 전체가 하나의 그룹인 경우 GROUP BY절 생략이 가능하다.
    SELECT COUNT(*) 전체행수, COUNT(HEIGHT) 키건수, ROUNG(AVG(HEIGHT)), 2, 평균키
    FROM   PLAYER;


-


GROUP BY ~ HAVING ~
    - 포지션별 키의 평균 조회
        SELECT   POSITION, ROUND(AVG(HEIGHT)2,) 평균키
        FROM     PLAYER
        GROUP BY POSITION

    - 집계함수에 조건을 부여하는 경우
        · 예: 포지션별 키의 평균이 180 이상인 경우만 조회하는 질의문

    - WHERE절 사용 -> 'ERROR' 
        · WHERE절이 GROUP BY절보다 먼저 수행되기 때문이다.
        SELECT   POSITION, ROUND(AVG(HEIGHT),2) 평균키
        FROM     PLAYER
        WHERE    AVG(HEIGHT) >= 180
        GROUP BY POSITION;

        -- WHERE절에서는 집계함수를 사용하지 못한다.
        -- 이때 사용하는 것이 HAVING이다.

    - 집계함수의 조건은 HAVING절에서 정의한다.
    포지션별 키의 평균이 180 이상인 경우만 조회하는 질의문
        SELECT   POSITION, ROUND((HEIGHT),2) 평균키
        FROM     PLAYER
        GROUP BY POSITION
        HAVING   AVG(HEIGHT) >= 180;

    - 응용문제 
    포지션별 키의 평균을 조회하되 해당 포지션 키의 최대값이 190 이상인 경우에만 조회하는 질의문
        SELECT   POSITION, ROUND(AVG(HEIGHT),2) 평균키
        FROM     PLAYER
        GROUP BY POSITION
        HAVING   MAX(HEIGHT) >= 190;


    - 그룹핑 기준이 2개인 경우
        SELECT DNAME, JOB, COUNT(*) 직원수, SUM(SALARY) AS 급여합
        FROM   EMP, DEPT
        WHERE  DEPT.DEPTNO = EMP.DEPTNO
        GROUP BY DEPTNAME,JOB
        ORDER BY DEPTNAME,JOB;

