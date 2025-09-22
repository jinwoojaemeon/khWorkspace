/*
<시퀀스 SEQUENCE>
자동으로 숫자를 발생 시켜주는 역할을 하는 객체 
주로 기본키로 사용되는 회원번호, 사원번호, 게시글번호, 택배 운송장 번호 ... 등에 활용된다.
시퀀스를 사용하면 중복 없는 숫자 값을 편리하게 관리할 수 있다. 

1. 시퀀스 객체 생성

[표현식] 
CREATE SEQUENCE 시퀀스명
[START WITH 시작숫자]          -- 처음 발생시킬 시작 값을 지정(기본값: 1)
[INCREMENT NY 숫자]           -- 증가값을 지정할 수 있다. (기본 증가값: 1)
[MAXVALUE 최댓값]             -- 최댓값 지정(기본값 매우큼)
[MINVALUE 최솟값]             -- 최솟값 지정(기본값 1)
[CYCLE|NOCYCLE]              -- 순환 여부(기본값 NOCYCLE)
[CACHE 바이트 수|NOCACHE]              -- 캐시 메모리 사용 여부
                                ** 캐시메모리 : 미리 일정량의 값들을 생성해서 메모리에 준비
                                               -> 속도 향상
                               EX) CACHE 20 -> 시퀀스를 미리 20개 만들어두고 필요할 때 꺼내어 쓴다                                               
*/

CREATE SEQUENCE SEQ_TEST;
-- 현재 계정이 소유한 시퀀스들의 목록 확인.
SELECT * FROM USER_SEQUENCES;

CREATE SEQUENCE SEQ_EMPNO
START WITH 300
INCREMENT BY 5
MAXVALUE 310
NOCYCLE
NOCACHE;

/*
2. 시퀀스 사용
시퀀스명.NEXTVAL : 다음 숫자 발생( INCREMENT 만큼 증가 )
시퀀스명.CURRVAL : 가장 최근 생성된 값  -  CURRVAL는 최초 사용 시 오류 발생
                                        -> NEXTVAL를 한번이라도 호출해야 사용 가능
*/

SELECT * FROM USER_SEQUENCES;

SELECT SEQ_EMPNO.CURRVAL FROM DUAL;
SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 300 
SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 305
SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 310
SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 에러 발생. MAX값 제한에 막힌다. 

/*
3. 시퀀스 구조 변경 
ALTER SEQUENCE 시퀀스명 
[INCREMENT NY 숫자]           -- 증가값을 지정할 수 있다. (기본 증가값: 1)
[MAXVALUE 최댓값]             -- 최댓값 지정(기본값 매우큼)
[MINVALUE 최솟값]             -- 최솟값 지정(기본값 1)
[CYCLE|NOCYCLE]              -- 순환 여부(기본값 NOCYCLE)
[CACHE 바이트 수|NOCACHE]              -- 캐시 메모리 사용 여부

START WITH는 변경 불가
*/

ALTER SEQUENCE SEQ_EMPNO
INCREMENT BY 10
MAXVALUE 400;

SELECT * FROM USER_SEQUENCES;

--사용 예시
INSERT INTO EMPLOYEE(
    EMP_ID, 
    EMP_NAME, 
    EMP_NO,
    JOB_CODE
)VALUES(
    SEQ_EMPNO.NEXTVAL, 
    '백시헌', 
    '031113-3231233', 
    'J5'
);

/*
4. 시퀀스 삭제
DROP SEQUENCE 시퀀스명;
*/
DROP SEQUENCE SEQ_TEST;
SELECT * FROM USER_SEQUENCES;















