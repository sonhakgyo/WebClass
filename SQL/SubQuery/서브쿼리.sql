서브쿼리 
    SQL문 안에 포함된 SQL문
    예: 신장이 가장 큰 선수의 정보 조회

    SELECT MAX(HEIGHT)
    FROM   PLAYER;
    +
    SELECT PLAYER_NAME, POSITION, HEIGHT
    FROM   PLAYER
    WHERE  HEIGHT = 194;
    =
    SELECT PLAYER_NAME, POSITION, HEIGHT
    FROM   PLAYER
    WHERE  HEIGHT = (SELECT MAX(HEIGHT) FROM PLAYER);

서브쿼리 위치
        SELCET절
        WHERE절
        FROM절 -> FROM절에 있는 서브쿼리를 인라인 뷰(Inline View)라고 부른다.
                  뷰와 비슷하지만 조금 다르다고 한다.

결과 칼럼/행의 수
        단일행 서브쿼리 / 다중행 서브쿼리
        단일칼럼 서브쿼리 / 다중칼럼 서브쿼리

메인쿼리와의 연관성 
    연관(상관) 서브쿼리 / 비연산 서브쿼리

서브쿼리는 메인쿼리의 칼럼 모두 사용이 가능하다.
메인쿼리는 서브쿼리의 칼럼 사용이 불가능하다.
    인라인 뷰(Inline View)에 정의된 칼럼만 사용 가능하다.


결과 '칼럼'과 '행'의 수에 따른 서브쿼리 종류 구분
    단일행(Single Row)
        서브쿼리의 실행 결과로 항상 1건 이하의 행을 반환한다. 
        단일행 비교 연산자(=, <, <=, >, >=, <>)와 함께 사용한다.
    다중행(Multi Row)
        서브쿼리의 실행 결과로 여러 건의 행 반환이 가능하다.
        다중행 비교 연산자(IN, ALL, ANY, SOME, EXISTS)와 함께 사용한다.
    단일칼럼(Single Column)
        서브쿼리의 실행 결과로 하나의 칼럼을 반환한다.
    다중칼럼(Multi Column)
        서브쿼리의 실행 결과로 여러 칼럼을 반환한다.
        서브쿼리와 메인쿼리의 비교 연산 수행 시 비교하는 칼럼 개수와 위치가 동일해야 한다.



단일행 서브쿼리
    - 서브쿼리의 결과 건수가 반드시 1건 이하
    - 단일행 비교 연산자(=, <, <=, >, >=, <>)와 함께 사용
        · 결과가 2건 이상이면 RunTime 오류가 발생한다.
    - 예: '20211021'번 선수와 같은 팀에 속하는 '선수의 이름, 포지션, 팀ID' 조회(=출력)
    SELECT TEAM_ID
    FROM   PLAYER
    WHERE  PLAYER_ID = '20211021';

    SELECT PLAYER_NAME, TEAM_ID
    FROM   PLAYER
    WHERE  TEAM_ID = 
                    (SELECT TEAM_ID
                     FROM   PLAYER
                     WHERE  PLYER_ID = '20211021');








