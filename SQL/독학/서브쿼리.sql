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
        SELECT절
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
    - 단일행 비교 연산자(=, <, <=, >, >=, <>)와 함께 사용한다.
        · 결과가 2건 이상이면 RunTime 오류가 발생한다.
    - 예: '20211021'번 선수와 같은 팀에 속하는 '선수의 이름, 포지션, 팀ID' 조회(=출력)
    SELECT TEAM_ID
    FROM   PLAYER
    WHERE  PLAYER_ID = '20211021';

    SELECT PLAYER_NAME, TEAM_ID
    FROM   PLAYER
    WHERE  TEAM_ID = (SELECT TEAM_ID
                      FROM   PLAYER
                      WHERE  PLYER_ID = '20211021');


다중행 서브쿼리
    - 서브쿼리의 결과  건수가 2건 이상일 가능성이 있을 때
    - 다중행 비교 연산자와 함께 사용한다.
        · 2건 이상일 가능성은 있지만 결과 건수가 우연히 1개인 경우
            - 단일행 비교 연산자도 에러는 발생하지 않는다.

다중행 연산자
    ✔.IN(서브쿼리) 
            임의의 결과 중 하나만 만족해도 참(Multiple OR 조건)
    ✔.비교연산자 ALL(서브쿼리) 
            결과의 모든 값을 만족해야 하는 조건
    ✔.비교연산자 ANY/SOME(서브쿼리)
            결과의 어느 하나의 값이라도 만족하면 되는 조건(ANY = SOME)
    ✔.EXISTS(서브쿼리)
            조건을 만족하는 값이 존재하는지 여부를 확인한다.
            조건을 만족하는 건을 하나라도 찾으면 검색을 중지한다(속도가 빠르다).

    IN 연산자
    SELECT PLAYER_NAME, HEIGHT, BACK_NO
    FROM   PLAYER 
    WHERE  BACK_NO = 15;

    SELECT PLAYER_NAME, HEIGHT, BACK_NO
    FROM   PLAYER
    WHERE  HEIGHT IN (SELECT HEIGHT
                      FROM   PLAYER
                      WHERE  BACK_NO = 15);

    
    ALL 연산자
    결과의 모든 값을 만족해야 하는 조건
    예: X > ALL(1, 2, 3, 4, 5)라면 X는 X > 5가 되어야 한다.
    SELECT PLAYER_NAME, HEIGHT, BACK_NO
    FROM   PLAYER
    WHERE  BACK_NO = 15;

    SELECT PLAYER_NAME, HEIGHT, BACK_NO
    FROM   PLAYER
    WHERE  HEIGHT > ALL (SELECT HEIGHT
                         FROM   PLAYER
                         WHERE  BACK_NO = 15);


    ANY(=SOME) 연산자
    결과의 어느 하나의 값이라도 만족하면 되는 조건
    예: X > ANY(1, 2, 3, 4, 5)라면 X는 X > 1이면 된다.
    예: 다음 질의로 출력된 결과 중 HEIGHT의 최소값을 구할 때
    SELECT PLAYER_NAME, HEIGHT, BACK_NO
    FROM   PLAYER
    WHERE  HEIGHT >= ANY (SELECT HEIGHT
                          FROM   PLAYER
                          WHERE  BACK_NO = 15);


    EXISTS 연산자
    조건을 만족하는 값이 존재하는지 여부를 확인한다.
    조건이 만족되는 1건만 찾으면 더이상 검색하지 않는다(속도가 빠르다).
    주로 참/거짓의 조건 판단용으로 사용된다.
    SELECT PLAYER_NAME, HEIGHT, BACK_NO
    FROM   PLAYER
    WHERE  EXISTS (SELECT HEIGHT
                   FROM   PLAYER
                   WHERE  BACK_NO = 15);
    =
    SELECT PLAYER_NAME, HEIGHT, BACK_NO
    FROM   PLAYER
    WHERE  EXISTS (SELECT 1 
                   FROM PLAYER
                   WHERE BACK_NO = 15);


연관(Correlated) 서브쿼리
    - 메인쿼리의 칼럼이 서브쿼리에서 사용된 쿼리
    - 문제: AVG(SALARY)은 SALARY의 평균을 구하는 함수이다. 무엇을 조회하는 질의인가?

    SELECT ENAME, SALARY, DEPTNO
    FROM   EMP M
    WHERE  SALARY > (SELECT AVG(S.SALARY)
                     FROM   EMP S
                     WHERE  M.DEPTNO = S.DEPTNO);
    * 메인쿼리에서 EMP M을 서브쿼리에 전달
    * 서브쿼리에서 EMP M과 같은 부서인 EMP S의 평균 급여를 계산하여 메인쿼리에 전달
    * 메인쿼리에서 EMP M의 급여와 서브쿼리에서 전달받은 급여를 비교

연관 서브쿼리의 특징
    - 메인쿼리의 칼럼이 서브쿼리에서 사용된 커리
        - cf) 비연관 서브쿼리 : 서브쿼리에서 메인쿼리의 칼럼을 사용하지 않는다.
    - 메인쿼리가 먼저 수행되고, 그 후에 서브쿼리가 수행된다.
        - 테이블의 별칭을 이용하여 메인쿼리에서 서브쿼리로 정보를 전달한다.
        - 서브쿼리가 메인쿼리의 값을 이용, 그 후에 서브쿼리의 결과를 메인쿼리가 이용한다.
    - 서브쿼리에서 메인쿼리의 칼럼과 서브쿼리의 칼럼 간 비교가 이루어진다.
        - 메인쿼리에서는 서브쿼리의 칼럼이 사용 불가능하다.


다중컬럼 서브쿼리
    - 서브쿼리의 결과로 여러 칼럼이 반환된다.
    - 예: PLAYER_ID가 20211021인 선수와 키, 포지션이 같은 선수 조회
    SELECT PLAYER_NAME, HEIGHT, POSITION, BACK_NO
    FROM   PLAYER
    WHERE  (HEIGHT, POSITION) = (SELECT HEIGHT, POSITION
                                 FROM   PLAYER
                                 WHERE  PLAYER_ID = '20211021');


스칼라 서브쿼리(Scalar Subquery)
스칼라 : https://terms.naver.com/entry.naver?cid=58439&docId=3482097&categoryId=58439
    - '하나의 값'을 반환하는 서브쿼리
        · 단일 행, 단일 칼럼 ==> 값이 하나.
        · 하나의 값을 반환한다는 점에서 함수(Function)의 특성을 가진다.
        · 공집합을 반환하는 경우 NULL이 대응된다.
    - 값이 하나이기 때문에 '칼럼이 올 수 있는 대부분의 곳에서 사용 가능'하다.
        · SELECT절, WHERE절, 함수의 인자, ORDER BY절, CASE절, HAVING절 등
    - 예: SELECT, WHERE절에서 스칼라 서브쿼리의 이용

    SELECT절
    SELECT EMPNO, ENAME, (SELECT DNAME FROM DEPT WHERE DEPTNO = A.DEPTNO) AS DNAME
    FROM   EMP A;

    WHERE절 
    SELECT EMPNO, ENAME, DEPTNO
    FROM   EMP A
    WHERE  (SELECT DNAME FROM DEPT WHERE DEPTNO = A.DEPTNO) = 'SALES';
    
    - 스칼라 서브쿼리는 함수의 인자로도 사용 가능하다.
    - 예: 앞페이지의 상단 질의를 수정하여 부서명을 3글자만 출력하는 질의 작성(SUBSTR 함수 사용)
    SELECT EMPNO, ENAME, SUBSTR((SELECT DNAME FROM EDPT WHERE DEPTNO = A.DEPTNO), 1 ,3)
    FROM   EMP A;









