뷰(view)
    - 테이블은 실제로 데이터를 갖고 있지만 뷰는 실제 데이터를 갖지 않는다.
        · 뷰 정의(View Definition, SQL 텍스트 파일)만 갖고 있다.
        · 쿼리에서 뷰가 사용되면 DBMS 내부적으로 질의를 재작성(Rewrite)한다.
    - 실제 데이터를 갖고 있지 않지만 테이블의 역할을 수행한다.
        · 가상 테이블(Virtual Table)이라고도 한다.
    - CREATE VIEW문을 통해 VIEW를 생성한다.
        CREATE VIEW V_PLAYER_TEAM AS
        SELECT      P.PLAYER_NAME, P.BACK_NO, P.TEAM_ID, T.TEAM_NAME
        FROM        PLAYER P INNER JOIN TEAM T
        ON          P.TEAM_ID = T.TEAM_ID;

    - VIEW의 확인
        SELECT * FROM USER_VIEWS;

    - 생성된 뷰는 '테이블과 동일한 형태로 사용 가능'하다.
        DESC V_PLAYER_TEAM;

        SELECT * FROM V_PLAYER_TEAM;

        SELECT PLAYER_NAME, BACK_NO, TEAM_ID, TEAM_NAME
        FROM   V_PLAYER_TEAM
        WHERE  PLAYER_NAME LIKE '이%';
    - '파싱 시점에 DBMS가 내부적으로 뷰 해당부분을 SQL문으로 재작성'한다.
        
    - VIEW의 제거
        DROP VIEW V_PLAYER_TEAM;

    - 계층적 뷰 생성
    - 문제 예: 사원과 부서 테이블로부터의 사원번호, 사원명, 부서번호, 부서명을 추출한
      'V_EMP_DEPT'를 작성하시오. 
      또한 이 뷰로부터 사원명과 부서명만을 다시 추출한 'V-EMP_DEPT2'를 작성하시오.

-

뷰의 장점
    - 독립성
        · 테이블 구조 변경 시 뷰만 변경되고 뷰를 사용하는 응용프로그램은 변경될 필요가 없다.
        예: 앞에서 PLAYER와 TEAM 테이블이 변경된 경우
            V_PLAYER_TEAM 뷰가 이에 맞게 변경된다면 응용프로그램은 변경될 필요가 없다.  
    - 편리성(-> 가독성)
        · 복잡한 질의를 뷰로 생성하여 질의의 가독성을 높인다.
    - 보안성
        · 민감한 정보(급여정보 등)를 제외하고 뷰를 생성하여 사용자로부터 정보를 보호할 수 있다.


인라인 뷰(Inline View)
    - FROM절에서 사용되는 서브쿼리
    - 실행 순간에만 임시적으로 생성되며 DB에 저장되지 않는다.
        · 인라인 뷰 = 동적 뷰(Dynamic View)
        · 일반 뷰 = 정적 뷰(Static View)
    - 인라인 뷰의 SELECT문에서 정의된 칼럼은 메인쿼리에서 '사용 가능'하다.
        · cf) 일반적으로 서브쿼리에서 정의된 칼럼은 메인쿼리에서 '사용 불가능'하다.
        SELECT EMPNO
        FROM   (SELECT EMPNO, ENAME 
                FROM EMP
                ORDER BY MGR);      -- OK

        SELECT MGR
        FROM   (SELECT EMPNO, ENAME 
                FROM EMP
                ORDER BY MGR);      -- ERROR

    - 문제 예
    급여가 2000 초과인 직원들에 대해 직원번호, 직원명, 급여, 부서명을 조회하려고 한다.
    오류를 수정하라.
        SELECT E.EMPNO, E.ENAME, E.SAL, D.DNAME
        FROM   (SELECT EMPNO, ENAME, SAL, 'DEPTNO' -- 추가해야 한다.
                FROM EMP
                WHERE SAL > 2000) E, DEPT D
        WHERE  E.DEPTNO = D.DEPTNO;





