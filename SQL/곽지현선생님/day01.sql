2. 데이터베이스 개요
 2-1. 자료(Data)
  - 관찰이나 측정을 통해 수집한 단순한 사실이나 값
 
 2-2. 정보(Infomation)
  - 의사 결정에 도움을 줄 수 있는 유용한 형태
  - 자료를 가공(처리)해서 얻을 수 있는 결과를 의미

 2-3. 데이터베이스
  - 어느 한 조직체의 여러 응용 시스템이 공동으로 사용할 수 있도록
  통합하여 저장한 운영데이터의 집합
  - 공동의 목적을 지원하기 위한 서로 관련된 자료들의 모임

3. DBMS
 3-1. DBMS(DataBase Management System)
  - 사용자에게 데이터베이스를 생성하고 유지할 수 있게 하는 프로그램 집합
  - DBMS는 데이터베이스 언어를 가지고 있으며 이를 통해 데이터의
  삽입/삭제/수정/조회 등을 할 수 있다.

4. 데이터베이스 모델의 종류
 - 계층형데이터 모델
 - 망 데이터 모델
 - 관계 데이터 모델(Relational Data Model)
	-> 개체 집합에 대한 속성 관계를 표현하기 위하여 개체를 
	테이블(table)로 사용하고 개체 집합들 사이의 관계는
	공통 속성으로 연결하는 독립된 형태의 데이터 모델

5. 관계형 모델의 구성요소
 5-1. 관계형 데이터 모델의 용어
  - 테이블(Table)
  - 열(Column)
  - 행(Row)

6. SQL
 6-1. SQL이란 무엇인가?
  - SQL(Structured Query Language)은 관계형 데이터베이스 언어이다.
  - 데이터의 삽입, 삭제, 갱신, 질의, 보호(보안) 명령으로 구성
  - SQL은 관계 데이터베이스 언어로 비절차적 데이터베이스 언어로
  분류한다.

 6-2. SQL 기능에 따른 분류
  - 데이터 정의어(DDL)
	-> 테이블이나 관계의 구조를 생성하는데 사용하며 
	CREATE,ALTER, DROP 문 등이 있음.	

  - 데이터 조작어(DML)
	-> 테이블에 데이터를 검색, 삽입, 수정, 삭제 하는데 사용하며
	SELECT(R), INSERT(C), DELETE(D), UPDATE(U)문 등이 있다.

  - 데이터 제어어(DCL)
	-> 데이터의 사용 권한을 관리하는 데 사용하며 GRANT, REVOKE
	문 등이 있다.


