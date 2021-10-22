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













