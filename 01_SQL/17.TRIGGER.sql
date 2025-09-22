/*
<트리거> : 특정 테이블에 대해 INSERT, UPDATE, DELETE와 같은 DML 이벤트가 발생 했을 때
    자동으로 실행되는 PL/SQL 코드 블록이다.
    
    EX) - 회원 탈퇴 시 기존의 회원 테이블에 데이터를 DELETE하기 전에 항상 탈퇴한 회원들을 저장하는 테이블에 
            INSERT 시켜줘야 하는 경우에 트리거 사용한다.
        - 신고 횟수가 일정 수를 넘었을 때 묵시적으로 해당 회원을 블랙리스트 목록에 추가 해야할 때.
        
트리거의 특징
    - 사용자가 명시적으로 실행하지 않아도 자동 실행 된다.
    - 데이터 무결성, 로깅, 자동 처리 등에 유용하다.
    - 테이블 단위로 작성되며, 트리거 대상은 테이블이다.
    
트리거 분류
    - 시점(언제 실행되는지)
        - BEFROE TRIGGER : 내가 지정한 테이블에 DML이벤트가 실행 되기 전에 동작
        - AFTER TRIGGER : 내가 지정한 테이블에 DML이벤트가 실행된 직후에 동작
    
    - 적용 대상(어디에 적용하는지)
        - 문장 트리거 : 이벤특 발생한 SQL문에 대해 딱 한번만 트리거 실행(FOR EACH ROW 없음)
        - 행 트리거 : 이벤트가 적용된 각 행 마다 실행(FOR EACH ROW 필요)
            -- 행 트리거에서는 변경 전/변경 후 데이터를 참조 가능하다.
            - :OLD : 기존 행 데이터
              :NEW : 새로 들어오는 데이터
              
    [트리거 생성 표현식]
    CREATE [OR REPLACE] TRIGGER 트리거명 
    BEFORE | AFTER  INSERT|UPDATE|DELETE
    ON 테이블명
    [FOR EACH ROW] -- 행 트리거일 경우 표시
    [DECLARE 변수선언]
    BEGIN
        실행할 내용
    END;
    /
*/

SET SERVEROUTPUT ON;

-- EMPLOYEE 테이블에 새로운 행이 추가될 때 마다 자동으로 '신입사원님 안녕하세요' 출력
CREATE OR REPLACE TRIGGER TRG_01
AFTER INSERT 
ON EMPLOYEE 
BEGIN
    DBMS_OUTPUT.PUT_LINE('신입사원님 안녕하세요. ');
END;
/

INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, JOB_CODE)
VALUES(301, '김지원', '111111-2222222', 'J7');

-- 입출고에 대한 데이터 기록(INSERT)될 때 마다 해당 상품에 대한 재고 수량을 매번 수정(UPDATE)
-- 상품테이블(재고), 입출고기록테이블

--1. 상품에 대한 데이터를 보관할 상품 테이블(TB_PRODUCT)
CREATE TABLE TB_PRODUCT(
    PCODE NUMBER PRIMARY KEY,    -- 상품번호 
    PNAME VARCHAR2(30) NOT NULL, -- 상품명
    BRAND VARCHAR2(30) NOT NULL,  -- 제조사
    PRICE NUMBER,                 -- 가격
    STOCK NUMBER DEFAULT 0        -- 재고
);

CREATE SEQUENCE SEQ_PCODE
START WITH 200
INCREMENT BY 5;

INSERT INTO TB_PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '갤럭시S25', '삼성', 1240000, DEFAULT);
INSERT INTO TB_PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '아이폰16', '애플', 1620000, DEFAULT);
INSERT INTO TB_PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '구글폰6', '구글', 1810000, DEFAULT);

-- 2. 상품 입출고 상세 이력 테이블 생성(TB_PRODETAIL)
-- 어떤 상품이 어떤 날짜에 몇 개가 입고/출고 되는지 기록
DROP TABLE TB_PRODETAIL;

CREATE TABLE TB_PRODETAIL(
    DECODE NUMBER PRIMARY KEY,            -- 이력번호
    pCODE NUMBER REFERENCES TB_PRODUCT,  -- 상품 번호
    PDATE DATE NOT NULL,                -- 입출고 날짜
    AMOUNT NUMBER NOT NULL,             -- 입출고 수량
    STATUS CHAR(3) CHECK(STATUS IN('IN', 'OUT'))
);

CREATE SEQUENCE SEQ_DECODE;

--200번 상품이 오늘 날짜로 10개 입고
INSERT INTO TB_PRODETAIL
VALUES(SEQ_DECODE.NEXTVAL, 200, SYSDATE, 10, 'IN');

-- 200번 상품의 재고 수량이 10 증가해야한다
UPDATE TB_PRODUCT
SET STOCK = STOCK + 10
WHERE PCODE = 200;

COMMIT;

/* TB_PRODETAIL테이블에 INSERT 이벤트 발생 시 
    TB_PRODUCT 테이블에 매번 자동으로 재고 수량을 UPDATE 하는 트리거 */

/*
    상품이 입고(IN) >> 해당 상품을 찾아서 재고 수량 증가 UPDATE
    UPDATE TB_PRODUCT
    SET STOCK = STOCK + (INSERT된 자료의 AMOUNT)
    WHERE PCODE = (INSERT된 자료의 PCODE)
    
    상품이 출고(OUT) >> 해당 상품을 찾아서 재고 수량 감소 UPDATE
    UPDATE TB_PRODUCT
    SET STOCK = STOCK + (INSERT된 자료의 AMOUNT)
    WHERE PCODE = (INSERT된 자료의 PCODE)
*/


CREATE OR REPLACE TRIGGER TRG_02
AFTER INSERT
ON TB_PRODETAIL
FOR EACH ROW
BEGIN
    IF(:NEW.STATUS = 'IN')
        THEN UPDATE TB_PRODUCT
            SET STOCK = STOCK + :NEW.AMOUNT
            WHERE PCODE = :NEW.PCODE;
    ELSE
        UPDATE TB_PRODUCT
        SET STOCK = STOCK - :NEW.AMOUNT
        WHERE PCODE = :NEW.PCODE;
    END IF;
END;
/

INSERT INTO TB_PRODETAIL
VALUES(SEQ_DECODE.NEXTVAL, 200, SYSDATE, 10, 'OUT');

INSERT INTO TB_PRODETAIL
VALUES(SEQ_DECODE.NEXTVAL, 205, SYSDATE, 10, 'IN');














