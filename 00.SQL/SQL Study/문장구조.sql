SELECT문의 구조 및 실행 순서
SELECT 문장 구조
    SELECT   POSITION, ROUND(AVG(HEIGHT), 2) 평균키
    FROM     PLAYER
    WHERE    HEIGHT IS NOT NULL
    GROUP BY POSITION
    HAVING   AVG(HEIGHT) > 190
    ORDER BY AVG(HEIGHT) DESC;

실제 실행 순서
    (1). FROM     - 질의 대상 테이블 참조
    (2). WHERE    - 반환 대상이 아닌 데이터 제거
    (3). GROUP BY - 행 그룹화
    (4). HAVING   - 반환 대상이 아닌 그룹 제거
    (5). SELECT   - 데이터값 계산 및 조회(=출력)
    (6). ORDER BY - 출력 데이터 정렬 



ROWNUM 활용 시 주의사항
    - ROWNUM을 사용한 TOP N 쿼리
    - 예: 키가 작은 3명의 선수 조회
        · 잘못된 쿼리 : WHERE절이 ORDER BY절보다 먼저 수행되는 것을 알아야 한다.
        SELECT   PLAYER_NAME, HEIGHT, ROWNUM
        FROM     PLAYER
        WHERE    ROWNUM < 4
        ORDER BY HEIGHT;

        · 수정 쿼리
        SELECT   PLAYER_NAME, HEIGHT, ROWNUM
        FROM     (SELECT   PLAYER_NAME, HEIGHT, ROWNUM AS ORGNO
        　        FROM     PLAYER
        　        ORDER BY HEIGHT)
        WHERE    ROWNUM < 4
