/*
DDL(Data Defintion Language : 데이터 정의어
데이터베이스에서 사용하는 SQL명령어 중 데이터를 저장할 객체의 구조를 정의하거나 변경하는 역할
 - 실제 데이터 값이 아닌 규칙 자체를 정의하는 언어.
     
오라클에서의 객체(구조) : 테이블, 뷰, 시쿼스, 인덱스, 패키지, 트리거, 프로시저, 함수, 사용자 등
    
     
객체를 생성(CREATE), 변경(ALTER), 삭제(DROP)하는 구문
*/

/*
<CREATE>
객체를 새로 생성하는 구문

1. 테이블 생성
- 테이블 : 행과 열로 구성되는 가장 기본적인 데이터베이스 객체
          모든 데이터들은 테이블을 통해서 저장된다.
          (DBMS 용어 중 하나로, 데이터를 일종의 표 형태로 표현한 것)

[표현식]
CREATE TABLE 테이블명(
    컬럼명 자료형(크기),
    컬럼명 자료형(크기),
    컬럼명 자료형(크기),
    ...
) 

자료형
- 숫자(NUMBER)
- 문자(CHAR(바이트크기)|VARCHAR2(바이트크기))    반드시 크기를 지정해야 한다.
    - CHAR : 최대 2000바이트까지 지정 가능 / 고정 길이 
                고정된 글자 수의 데이터가 담길 경우 사용한다.
    - VARCHAR2 : 최대 4000바이트까지 지정 가능 / 가변 길이
                몇 글자의 데이터가 들어올지 확신할 수 없는 경우 사용한다. 
- 날짜(DATE) 
*/

-- 회원에 대한 데이터를 담기 위한 테이블 MEMBER 생성
CREATE TABLE MEMBER(
    MEM_NO NUMBER,
    MEM_ID VARCHAR2(30),   --user01, test1234 같은 아이디들
    MEM_PWD VARCHAR2(30), 
    MEM_NAME VARCHAR2(21),
    GENDER CHAR(3),
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    CREATE_AT DATE
);

SELECT * FROM MEMBER;
--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*
/*
2. 컬럼에 주석달기(컬럼에 대한 간단한 COMMENTS)

[표현법]
COMMENT ON COLUMN 테이블명.컬럼명 IS '주석 내용';
*/

COMMENT ON COLUMN MEMBER.MEM_NO IS '회원번호';
COMMENT ON COLUMN MEMBER.MEM_ID IS '회원아이디';
COMMENT ON COLUMN MEMBER.MEM_PWD IS '회원비밀번호';
COMMENT ON COLUMN MEMBER.MEM_NAME IS '회원이름';
COMMENT ON COLUMN MEMBER.GENDER IS '성별(남/여)';
COMMENT ON COLUMN MEMBER.PHONE IS '전화번호';
COMMENT ON COLUMN MEMBER.EMAIL IS '이메일';
COMMENT ON COLUMN MEMBER.CREATE_AT IS '회원가입일';

INSERT INTO MEMBER
VALUES(1,'USER01', 'PASS01', '동길홍', '남', '123-4567-8910', 'EEEE@MAMA.ILEILE', '25/07/30');

INSERT INTO MEMBER
VALUES(1,'USER01', 'PASS01', NULL, NULL, '123-4567-8910', 'EEEE@MAMA.ILEILE2', NULL);

SELECT * FROM MEMBER;

--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*
/*
<제약 조건>
- 원하는 데이터 값(유요한 형식의 값)만 유지하기 위해서 특정 컬럼에 설정하는 제약
- 데이터 무결성 보장을 목적으로 한다.  
    ->  데이터 무결성 : 데이터베이스에 저장된 데이터가 정확하고 일관되며 신뢰할 수 있는 상태

종류 : NOT NULL, UNIQUE, CHECK, PRIMARY KEY, FOREIGN KEY... 
*/

/*
제약조건 부여 방식
1. 컬럼 레벨 제약 조건 부여 방식
    CREATE TABLE MEMBER(
        NAME VARCHAR(30) NOT NULL 
    )
    
2. 테이블 레벨 제약 조건 부여 방식
    CREATE TABLE MEMBER(
        NAME VARCHAR(30) NOT NULL 
        CONSTRAINT MEM_PK PRIMARY KEY(NAME)
    )
*/

/*
<NOT NULL> 
해당 컬럼에 반드시 값이 존재해야만 하는 경우(즉, 절대 NULL이 들어오면 안되는 경우)에 사용
삽입/수정 시 NULL 값을 허용하지 않도록 제한
*/

DROP TABLE MEMBER;

CREATE TABLE MEMBER(
    MEM_NO NUMBER NOT NULL,
    MEM_ID VARCHAR2(30) NOT NULL,   --user01, test1234 같은 아이디들
    MEM_PWD VARCHAR2(30) NOT NULL, 
    MEM_NAME VARCHAR2(21) NOT NULL,
    GENDER CHAR(3),
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    CREATE_AT DATE
);

INSERT INTO MEMBER
VALUES(1,'USER01', 'PASS01', '동길홍', '남', '123-4567-8910', 'EEEE@MAMA.ILEILE', '25/07/30');

SELECT * FROM MEMBER;

INSERT INTO MEMBER
VALUES(1,'USER01', 'PASS01', '홍동길', NULL, NULL, NULL, NULL);

SELECT * FROM MEMBER;
-- 아이디가 중복되었음에도 불구하고 잘 추가가 되었다

/*
<UNIQUE 제약조건>
해당 컬럼에 중복 값이 들어가서는 안될 경우 사용한다.
컬럼 값에 중복 값을 제한하는 제약조건.
삽입/수정 시 기존에 있는 데이터 값 중 중복값이 있을 경우 오류를 발생시킴.

*/

DROP TABLE MEMBER;

CREATE TABLE MEMBER(
    MEM_NO NUMBER NOT NULL,
    MEM_ID VARCHAR2(30) NOT NULL UNIQUE,   -- UNIQUE 컬럼 레벨 
    MEM_PWD VARCHAR2(30) NOT NULL, 
    MEM_NAME VARCHAR2(21) NOT NULL,
    GENDER CHAR(3),
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    CREATE_AT DATE,
    UNIQUE(EMAIL)  -- UNIQUE 테이블 레벨
);

INSERT INTO MEMBER
VALUES(1, 'USER01', 'PASS01', '동길홍', '남', '123-4567-8910', 'EEEE@MAMA.ILEILE', '25/07/30');

INSERT INTO MEMBER
VALUES(1, 'USER01', 'PASS01', '홍동길', NULL, NULL, NULL, NULL);
-- UNIQUE 제약 조건에 위배되었으므로 INSERT 실패
 --> 오류 구문을 제약조건명으로 알려준다.
 --> 쉽게 어떤 제약 조건이 위반인지 알기 어렵다.
 --> 제약조건 부여 시 제약조건명을 지정해주면 오류구문에서 제약조건 확인이 쉽다.

------------------------------------------------------------------------------
/*
제약조건 부여 시 함께 제약조건명을 부여
> 컬럼레벨방식
CREATE TABLE 테이블명(
    컬럼명 자료형 CONSTRAINT 제약조건명 제약조건
)
> 테이블레벨방식
CREATE TABLE 테이블명(
    컬럼명 자료형,
    CONSTRAINT 제약조건명 제약조건(컬럼명)
)
*/
DROP TABLE MEMBER;

CREATE TABLE MEMBER(
    MEM_NO NUMBER CONSTRAINT MEMNO_NT NOT NULL,
    MEM_ID VARCHAR2(30) CONSTRAINT MEMID_NT NOT NULL CONSTRAINT MEMID_UQ UNIQUE,   
    MEM_PWD VARCHAR2(30) CONSTRAINT MEMPWD_NT NOT NULL, 
    MEM_NAME VARCHAR2(21) CONSTRAINT MEMMANE_NT NOT NULL,
    GENDER CHAR(3),
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    CREATE_AT DATE,
    CONSTRAINT EMAIL_UQ UNIQUE(EMAIL)  -- UNIQUE 테이블 레벨
);

INSERT INTO MEMBER
VALUES(1, 'USER01', 'PASS01', '동길홍', '남', '123-4567-8910', 'EEEE@MAMA.ILEILE', '25/07/30');

INSERT INTO MEMBER
VALUES(2, 'USER02', 'PASS02', '홍동길', '웱', NULL, NULL, NULL);

SELECT * FROM MEMBER;

-------------------------------------------------------------------------------
/*
<CHECK>
[표현법]
CHECK(조건식)
해당 컬럼에 들어올 수 있는 값에 대한 조건을 제시할 수 있다.
데이터를 추가/수정 시 조건식을 만족해야 정상적인 실행이 가능하다.
*/
CREATE TABLE MEMBER_CHECK(
    MEM_NO NUMBER CONSTRAINT MEMNO_NT NOT NULL,
    MEM_ID VARCHAR2(30) CONSTRAINT MEMCKID_NT NOT NULL CONSTRAINT MEMCKID_UQ UNIQUE,   
    MEM_PWD VARCHAR2(30) CONSTRAINT MEMCKPWD_NT NOT NULL, 
    MEM_NAME VARCHAR2(21) CONSTRAINT MEMCKNAME_NT NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN('남','여')),  -- 남, 여 인 경우 , 컬럼 레벨 
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    CREATE_AT DATE,
    CONSTRAINT CKEMAIL_UQ UNIQUE(EMAIL)  -- UNIQUE 테이블 레벨
    --CHECK(GENDER IN('남','여')) -- 테이블 레벨 
);

INSERT INTO MEMBER_CHECK
VALUES(1, 'USER01', 'PASS01', '동길홍', '남', '123-4567-8910', 'EEEE@MAMA.ILEILE', '25/07/30');

INSERT INTO MEMBER_CHECK
VALUES(2, 'USER02', 'PASS02', '홍동길', '웱', NULL, NULL, NULL);
-- CHECK 제약조건 때문에 '남', '여' 이외에 성별 입력 시 예외 발생
INSERT INTO MEMBER_CHECK
VALUES(3, 'USER03', 'PASS03', '홍콩길', NULL, NULL, NULL, NULL);  
-- NULL은 값이 없다는 뜻이기 때문에 CHECK 제약조건에 위배되진 않는다.

-------------------------------------------------------------------------------
/*
<PRIMARY KEY> : 기본 키 제약 조건 
기본키는 테이블에서 각 행(ROW)을 식별하기 위해 사용될 컬럼에 부여하는 제약조건(식별자 역할)

EX) 회원번호, 학번, 부서코드, 주민등록번호, 택배운송장번호...
기본키 -> 중복금지(UNIQUE) + NOT NULL 의 기능을 기본적으로 가지고 있다.
-> 식별, 무결, 연결의 성질을 가지고 있다.

한 테이블에 오직 하나만 설정 가능하다.
*/

DROP TABLE MEMBER_CHECK;

CREATE TABLE MEMBER(
    MEM_NO NUMBER CONSTRAINT MEMNO_PK PRIMARY KEY,   -- PRIMARY KEY 컬럼 레벨
    MEM_ID VARCHAR2(30) CONSTRAINT MEMID_NT NOT NULL CONSTRAINT MEMCKID_UQ UNIQUE,   
    MEM_PWD VARCHAR2(30) CONSTRAINT MEMPWD_NT NOT NULL, 
    MEM_NAME VARCHAR2(21) CONSTRAINT MEMNAME_NT NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN('남','여')), 
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    CREATE_AT DATE,
    CONSTRAINT EMAIL_UQ UNIQUE(EMAIL)  
    -- CONSTRAINT MEMNO_PK PRIMARY KEY(MEM_NO) -- 테이블 레벨 
);


INSERT INTO MEMBER
VALUES(1, 'USER01', 'PASS01', '동길홍', '남', '123-4567-8910', 'EEEE@MAMA.ILEILE', '25/07/30');

INSERT INTO MEMBER
VALUES(1, 'USER02', 'PASS02', '길홍동', '남', '123-4567-0198', 'EEEE@MAMA.ILEILE', '25/07/30');
-- 기본키에 중복된 값을 담으려고 할 때 (UNIQUE 제약조건 위반 )

INSERT INTO MEMBER
VALUES(NULL, 'USER02', 'PASS02', '길홍동', '남', '123-4567-0198', 'EEEE@MAMA.ILEILE', '25/07/30');
-- 기본키에 NULL 값을 담으려고 할 때 (NOT NULL 제약조건 위반 )
INSERT INTO MEMBER
VALUES(2, 'USER02', 'PASS02', '길홍동', '남', '123-4567-0198', 'CEEE@MAMA.ILEILE', '25/07/30');

INSERT INTO MEMBER
VALUES(3, 'USER03', 'PASS03', '홍동길', '남', '123-4567-0198', 'CEE@MAMA.ILEILE', '25/07/30');

INSERT INTO MEMBER
VALUES(4, 'USER04', 'PASS04', '길동홍', '남', '123-4567-0198', 'CE@MAMA.ILEILE', '25/07/30');

INSERT INTO MEMBER
VALUES(5, 'USER05', 'PASS05', '홍길동', '남', '123-4567-0198', 'CEEE@MMA.ILEILE', '25/07/30');

-- 복합 키: 두 개의 컬럼을 동시에 하나의 PRIMARY KEY로 지정하는 것

CREATE TABLE TB_LIKE(
    MEM_NO NUMBER,
    PRODUCT_NAME VARCHAR(30),
    LIKE_DATE DATE,
    PRIMARY KEY(MEM_NO, PRODUCT_NAME)
);

-- 회원 4명 (1,2,3,4번)
-- 상품 2개 (자전거A, 자전거B)

INSERT INTO TB_LIKE VALUES(1, '자전거A', SYSDATE);
INSERT INTO TB_LIKE VALUES(1, '자전거B', SYSDATE);
INSERT INTO TB_LIKE VALUES(1, '자전거A', SYSDATE);

-------------------------------------------------------------------------------
-- 회원 등급에 대한 데이터를 보관하는 테이블 
CREATE TABLE MEM_GRADE(
    GRADE_CODE NUMBER PRIMARY KEY,
    GRADE_NAME VARCHAR2(30) NOT NULL
);

INSERT INTO MEM_GRADE VALUES(10, '일반회원');
INSERT INTO MEM_GRADE VALUES(20, '우수회원');
INSERT INTO MEM_GRADE VALUES(30, '특별회원');
INSERT INTO MEM_GRADE VALUES(40, 'VIP회원');

SELECT * FROM MEM_GRADE;

CREATE TABLE MEM(
    MEM_NO NUMBER PRIMARY KEY,   -- PRIMARY KEY 컬럼 레벨
    MEM_ID VARCHAR2(30) NOT NULL UNIQUE,   
    MEM_PWD VARCHAR2(30) NOT NULL, 
    MEM_NAME VARCHAR2(21) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN('남','여')), 
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    CREATE_AT DATE,
    GRADE_ID NUMBER
);

INSERT INTO MEM
VALUES(1, 'USER1', 'PW1', '콩길동', NULL, NULL, NULL,'25/01/01', NULL);
INSERT INTO MEM
VALUES(2, 'USER2', 'PW2', '공길동', NULL, NULL, NULL,'25/01/01', 10);
INSERT INTO MEM
VALUES(3, 'USER3', 'PW3', '궁길동', NULL, NULL, NULL,'25/01/01', 20);
INSERT INTO MEM
VALUES(4, 'USER4', 'PW4', '쿵길동', NULL, NULL, NULL,'25/01/01', 30);
INSERT INTO MEM
VALUES(5, 'USER5', 'PW5', '캉길동', NULL, NULL, NULL,'25/01/01', 40);
INSERT INTO MEM
VALUES(6, 'USER6', 'PW6', '컹길동', NULL, NULL, NULL,'25/01/01', 50);

SELECT * FROM MEM
LEFT JOIN MEM_GRADE ON(GRADE_ID=GRADE_CODE);

/*
<FOREIGN_KEY(외래키) 제약조건 >
다른 테이블의 기본키(PK) 또는 고유키(UNIQUE)를 참조하도록 설정하는 제약조건
-> 다른 테이블을 참조한다고 표현 
-> 대부분의 경우는 FOREIGN KEY를 통해서 테이블 간의 관계가 활성화된다.

컬럼 레벨, 테이블 레벨 방식 둘 다 사용이 가능하다.

[표현법]
> 컬럼레벨방식
컬럼명 자료형 REFERENCES 참조할테이블명(참조할컬럼명)

> 테이블레벨방식
FOREIGN KET(컬럼명) REFERENCES 참조할테이블명(참조할컬럼명)
*/

DROP TABLE MEM;

CREATE TABLE MEM(
    MEM_NO NUMBER PRIMARY KEY,   -- PRIMARY KEY 컬럼 레벨
    MEM_ID VARCHAR2(30) NOT NULL UNIQUE,   
    MEM_PWD VARCHAR2(30) NOT NULL, 
    MEM_NAME VARCHAR2(21) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN('남','여')), 
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    CREATE_AT DATE,
    GRADE_ID NUMBER REFERENCES MEM_GRADE(GRADE_CODE)
);


INSERT INTO MEM
VALUES(1, 'USER1', 'PW1', '공길동', NULL, NULL, NULL,'25/01/01', 10);
INSERT INTO MEM
VALUES(2, 'USER2', 'PW2', '궁길동', NULL, NULL, NULL,'25/01/01', 20);
INSERT INTO MEM
VALUES(3, 'USER3', 'PW3', '쿵길동', NULL, NULL, NULL,'25/01/01', 30);
INSERT INTO MEM
VALUES(4, 'USER4', 'PW4', '캉길동', NULL, NULL, NULL,'25/01/01', 40);

-- 유효하지 않은 회원등급번호는 정상적으로 INSERT할 수 없다.
INSERT INTO MEM
VALUES(5, 'USER5', 'PW5', '컹길동', NULL, NULL, NULL,'25/01/01', 50);

SELECT * FROM MEM;
-- MEM_GRADE (부모테이블) -|----<- MEM (자식테이블)
-- 부모테이블 : 외래키로 참조되는 테이블
-- 자식테이블 : 외래키를 통해 부모테이블을 참조하는 테이블
--> 1:N 관계일 경우 보통 N이 자식테이블 

DELETE FROM MEM_GRADE
WHERE GRADE_CODE = 10;
-- MEM 테이블에서 10이라는 GRADE_ID가 있기 때문에 부모 테이블의 GRADE_CODE 10을 가진 데이터 삭제가 안된다.
-- MEM 테이블에서 참조하고 있지 않은 GRADE_CODE를 가진 데이터는 삭제가 가능하다.

-- 자식테이블에서 이미 사용하고 있는 값이 있을 경우
-- 부모테이블로부터 무조건 삭제가 안되는 '삭제제한' 옵션이 기본값으로 설정되어있다.
-------------------------------------------------------------------------------
/*
자식테이블 생성 시 외래키 제약조건 부여할 때 삭제옵션을 함께 지정 가능
-삭제옵션 : 부모테이블의 데이터 삭제 시 그 데이터를 참조하고있는 자식테이블의 데이터를 어떻게 처리를 할 것인가
  - ON DELETE RESTRICTED(기본값) : 삭제제한옵션, 자식데이터로부터 쓰이는 부모데이터는 삭제가 안된다.
  - ON DELETE SET NULL : 부모데이터 삭제 시 해당 데이터를 사용하고 있는 자식 데이터의 값을 NULL로 변경 
  - ON DELETE CASCADE : 부모데이터 삭제 시 해당 데이터를 사용하고 있는 자식 데이터도 모두 삭제한다.
*/
DROP TABLE MEM;

CREATE TABLE MEM(
    MEM_NO NUMBER PRIMARY KEY,   -- PRIMARY KEY 컬럼 레벨
    MEM_ID VARCHAR2(30) NOT NULL UNIQUE,   
    MEM_PWD VARCHAR2(30) NOT NULL, 
    MEM_NAME VARCHAR2(21) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN('남','여')), 
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    CREATE_AT DATE,
    GRADE_ID NUMBER REFERENCES MEM_GRADE(GRADE_CODE) ON DELETE SET NULL
);

INSERT INTO MEM
VALUES(1, 'USER1', 'PW1', '공길동', NULL, NULL, NULL,'25/01/01', 10);
INSERT INTO MEM
VALUES(2, 'USER2', 'PW2', '궁길동', NULL, NULL, NULL,'25/01/01', 20);
INSERT INTO MEM
VALUES(3, 'USER3', 'PW3', '쿵길동', NULL, NULL, NULL,'25/01/01', 40);
INSERT INTO MEM
VALUES(4, 'USER4', 'PW4', '캉길동', NULL, NULL, NULL,'25/01/01', NULL);

DELETE FROM MEM_GRADE
WHERE GRADE_CODE = 20;
-- 정상적으로 삭제, GRADE_CODE가 NULL로 바뀐다
-->> MEM_GRADE의 PK 20 데이터가 삭제되면 SET NULL 옵션에 따라
--    GRADE_CODE 20인 데이터를 참조하던 자식 데이터들은 전부 NULL을 가진다.




DROP TABLE MEM;

CREATE TABLE MEM(
    MEM_NO NUMBER PRIMARY KEY,   -- PRIMARY KEY 컬럼 레벨
    MEM_ID VARCHAR2(30) NOT NULL UNIQUE,   
    MEM_PWD VARCHAR2(30) NOT NULL, 
    MEM_NAME VARCHAR2(21) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN('남','여')), 
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    CREATE_AT DATE,
    GRADE_ID NUMBER REFERENCES MEM_GRADE(GRADE_CODE) ON DELETE CASCADE
);

INSERT INTO MEM_GRADE VALUES(20, '우수회원');

INSERT INTO MEM
VALUES(1, 'USER1', 'PW1', '공길동', NULL, NULL, NULL,'25/01/01', 10);
INSERT INTO MEM
VALUES(2, 'USER2', 'PW2', '궁길동', NULL, NULL, NULL,'25/01/01', 20);
INSERT INTO MEM
VALUES(3, 'USER3', 'PW3', '쿵길동', NULL, NULL, NULL,'25/01/01', 40);
INSERT INTO MEM
VALUES(4, 'USER4', 'PW4', '캉길동', NULL, NULL, NULL,'25/01/01', NULL);

DELETE FROM MEM_GRADE
WHERE GRADE_CODE = 20; 
-- 해당 ROW 데이터도 모두 삭제가 되었다.
-- 게시판 게시글이 삭제가 되었을 때 같이 있던 댓글들도 다 삭제하는 것으로 비유
-->> MEM_GRADE의 PK 20 데이터가 삭제되면 CASCADE 옵션에 따라
--    GRADE_CODE 20인 데이터를 참조하던 데이터는 모두 함께 삭제가 된다.

-------------------------------------------------------------------------------
/*
<DEFAULT 기본값> 제약조건은 아니다.
컬럼을 선정하지 않고 INSERT 시에 NULL이 아닌 기본값을 INSERT하고자 한다.
미리 값을 세팅해 둘 수 있다.

표현법 
컬럼명 자료형 DEFAULT 기본값
*/

DROP TABLE MEM;

CREATE TABLE MEM(
    MEM_NO NUMBER PRIMARY KEY,   -- PRIMARY KEY 컬럼 레벨
    MEM_ID VARCHAR2(30) NOT NULL UNIQUE,   
    MEM_AGE NUMBER,
    HOBBY VARCHAR2(20) DEFAULT '코딩',
    CEARTE_AT DATE DEFAULT SYSDATE
);

-- INSERT INT0 MEM 테이블명 VALUES(값1, 값2, ... ) - 모든 컬럼 값을 나열해야한다.
INSERT INTO MEM VALUES(1,'USER01', 20, '운동', '20/01/01');
INSERT INTO MEM VALUES(2,'USER02', 40, NULL, NULL);
INSERT INTO MEM VALUES(3,'USER03', 30, DEFAULT, DEFAULT);
-- INSERT INTO 테이블명(컬럼1, 컬럼2) VALUES(값1, 값2, ... )
INSERT INTO MEM(MEM_NO, MEM_ID, MEM_AGE) VALUES(4, 'USER04', 22);
-- >> 선택되지 않은 컬럼에는 기본적으로 NULL이 들어가지만 
       --해당 칼럼에 DEFAULT값이 부여되어있다면 NULL이 아닌 DEFAULT값이 적용된다.
INSERT INTO MEM(MEM_NO, MEM_ID) VALUES(5, 'USER05');

-------------------------------------------------------------------------------
-- 관리자계정으로 계정생성 
CREATE USER C##KH IDENTIFIED BY KH;

GRANT CONNECT, RESOURCE TO C##KH;

ALTER USER C##KH DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
-- KH 계정으로 전환 , CTRL+F , CTRL+R 
--------------------------------------------------------------------------------
-- 테이블을 복제할 수 있다. 여기서부터 KH계정으로 진행한다.
CREATE TABLE EMPLOYEE_COPY
AS (SELECT * FROM EMPLOYEE);

-- CREATE TALBE 테이블명 AS SELECT문 
-- AS 뒤에오는 SELECT문의 결과를 기반으로 테이블을 생성하겠다.

DROP TABLE EMPLOYEE_COPY;

CREATE TABLE EMPLOYEE_COPY
AS (SELECT * FROM EMPLOYEE WHERE 1=0);
--------------------------------------------------------------------------------
/*
<ALTER>
테이블이 수정된 후에 제약 조건을 수정하는 방법 
ALTER TABLE 테이블명 변경할 내용

[제약 조건 추가 방법]
PRIMARY KEY : ALTER TABLE 테이블명 ADD PRIMARY KEY(컬럼명);
PRIMARY KEY : ALTER TABLE 테이블명 ADD CONSTRAINT 제약조건명 PRIMARY KEY(컬럼명);
FOREIGN KEY : ALTER TABLE 테이블명 ADD FOREIGN KEY(컬럼명) REFERENCES 참조할 테이블명(컬럼명);
UNIQUE : ALTER TABLE ADD UNIQUE(컬럼명);
CHECK : ALTER TABLE 테이블명 ADD CHECK(컬럼에 대한 조건식)

[제약 조건 제거 방법]
ALTER TABLE 테이블명 DROP CONSTRAINT 제약조건이름;

NOT NULL : ALTER TABLE 테이블명 MODIFY 컬럼명 NOT NULL;
           ALTER TABLE 테이블명 MODIFY 컬럼명 NULL;
*/
-- EMPLOYEE_COPY 테이블에 PRIMARY KEY 제약조건 추가(EMP_ID)
ALTER TABLE EMPLOYEE_COPY ADD PRIMARY KEY(EMP_ID);

-- EMPLOYEE 테이블에 DEPT_CODE에 외래키 제약조건을 추가(DEPT_ID 참조)
ALTER TABLE EMPLOYEE ADD CONSTRAINT DEPT_FK FOREIGN KEY(DEPT_CODE) REFERENCES DEPARTMENT(DEPT_ID);














