1. 기본키(primary key)
1-1. 기본키란?	
-  기본키 역시 기본적인 제약 조건들은 테이블을 생성할때 같이
정의한다.
- 테이블당 하나만 정의 가능하다.(두개 이상의 PK는 조합키/복합키
라고 불립니다. 묶어서 하나로 봅니다.)
- PK는 NOT NULL + Unique (+ index)의 기능을 가지고 있다.
- 주키/기본키/pk/식별자 등 으로 불리고 있다.
- 자동 INDEX가 생성이되는데 이는 검색 키로서 검색 속도를 향상시킨다.

1-2. 기본키 선언방법

	create table consTest{
		pkCol1	char(8) PRIMARY KEY,
		pkCol2	char(8),
		pkCol3  NUMBER CONSTRAINT constText_pk3 PRIMARY KEY,
			
		CONSTRAINT pk_code PRIMARY KEY(pkCol2)
	}

	-> 1) 컬럼명 옆에 바로 주키를 선언한다.
	-> 2) CONSTRAINT [제약조건명] PRIMARY KEY(컬럼명)
	-> 3) [해당컬럼][타입] CONSTRAINT [제약조건명] PRIMARY KEY
	-> 4) ALTER TABLE [테이블명] ADD CONSTRAINT [제약조건명]PRIMARY KEY (컬럼명)

2. FOREIGN KEY(외래키)
2-1. FOREIGN KEY 란
- 외부키, 외래키, 참조키, 외부 식별자 등으로 불린다. 흔히 FK라고도 한다.
- FK가 정의된 테이블을 자식 테이블이라고 칭한다.
- 참조되는 테이블 즉 PK가 있는 테이블을 부모 테이블 이라 한다.
- 부모테이블의 PK컬럼에 존재하는 데이터만 자식테이블에 입력할 수 있다.
- 부모테이블은 자식의 데이터나 테이블이 삭제된다고 영향을 받지 않는다.
- 참조하는 데이터 컬럼과 데이터 타입이 반드시 일치해야 한다.
- 참조할 수 있는 컬럼은 기본키(PK) 이거나 UNIQUE 만 가능하다.
    (보통 PK랑 엮는다)

2-2. 외래키 선언 방법

	create table parentTable(
		parentPK 	NUMBER 	PRIMARY KEY
	);

	create table constTest(
		parentPK	NUMBER,
		
		CONSTRAINTS fk_code FOREIGN KEY(parentPK)
		REFERENCES parentTable(parentPK) ON DELETE CASCADE
	);
	
	-> CONSTRAINTS [FK이름] FOREIGN KEY(자식 컬럼)
		REFERENCES [부모테이블](부모 컬럼) ON DELETE CASCADE

    - 참조할 컬럼과 같은 컬럼이 자식 테이블에 존재해야 합니다.
    (같은 이름을 쓸필요는 없지만, 관계를 알아보기 쉽게 같은 컬럼명을 사용한다.)
    - 자식테이블에 값을 먼저 넣을수 없다.
    - 참조되는 컬럼에 데이터가 있어야 값을 넣을 수 있다.

    - 테이블 생성 시 설정
	CONSTRAINTS 외래키 이름 FOREIGN KEY(컬럼명) 
	REFERENCES 참조 테이블명(참조컬럼)

    - 테이블 생성 후 설정
	ALTER TABLE 테이블명 
	ADD CONSTRAINTS 외래키 이름 FOREIGN KEY (참조컬럼) 
	REFERENCES 참조 테이블명(참조컬럼)

    2-3. ON DELETE CASCADE
    - 참조되는 부모 테이블의 행에 대한 DELETE를 허용한다.
　    즉, 참조되는 부모테이블 값이 삭제되면 연쇄적으로 자식테이블 값 역시 삭제된다.

    2-4. ON DELETE SET NULL
    - 참조되는 부모 테이블의 행에 대한 DELETE를 허용한다.
    이건 CASCADE와 다른데 부모테이블의 값이 삭제되면 해당 참조하는 자식테이블의
    값들은 NULL값으로 설정된다.

3. view
    3-1. View의 활용
    - 보안관리를 위한 뷰
        -> 보안 등급에 맞추어 컬럼 및 범위를 정하여 조회 하도록 함
        -> 연산결과만 제공하고 알고리즘을 숨기기 위해 사용
        -> select list를 함수로 가공하여 update, insert를 못하도록 함
        -> 테이블 명이나 컬럼 명을 숨기도록 함

    - 사용평의성을 위한 뷰
	-> 검색 조건을 단순화하여 사용할 수 있도록 함
	-> 조인을 단순화
	-> 사용자를 위한 컬럼명이나 테이블명 제공
