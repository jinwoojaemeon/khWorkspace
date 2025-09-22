/*
    테이블 - 데이터베이스에서 데이터를 저장하는 기본 개념
          - 행(가로)과 열(세로)로 구성된 데이터 집합
          
    컬럼   - 테이블 내의 각 데이터 속성을 정의하는 필드
          - 컬럼은 테이블에 저장할 때 속성 = 값으로 저장
          
        => 테이블은 여러 컬럼으로 구성되고, 각 컬럼은 테이블이 표현하는 데이터의 속성을 나타냄.
        <SELECT>  --사용문법 예시 
        SELECT 컬럼명1, 컬럼명2, ... (내가 가져오고 싶은 컬럼의 정보
        FROM 테이블명
        (WHERE 조건)
        (ORDER BY 정렬기준 [ASC | DESC])
*/

-- 1. JOB 테이블의 모든 정보 조회
SELECT * 
FROM JOB;

-- 2. JOB 테이블의 직급 이름만 조회
SELECT JOB_NAME 
FROM JOB;

-- 3. DEPARTMENT 테이블의 모든 정보
SELECT * FROM DEPARTMENT;

-- 4. EMPLOYEE 테이블의 직업명, 이메일, 전화번호, 고용일 조회
SELECT EMP_NAME, EMAIL, PHONE, HIRE_DATE 
FROM EMPLOYEE;

-- 5. EMPLOYEE 테이블에서 이름, 연봉, 총수령액(보너스 포함), 실수령액(총수령액 - 세금(3%))
SELECT EMP_NAME, SALARY * 12 AS 연봉, (SALARY +(SALARY * NVL(BONUS,0)))*12"총수령액",
    ((SALARY +(SALARY * NVL(BONUS,0)))*12) - (SALARY * 0.03 * 12) AS 실수령액
FROM EMPLOYEE;

-- 데이터베이스에서 NULL은 빈 값을 의미한다.
-- 모든 연산에 NULL이 포함된 경우 결과는 NULL이 된다.  -> NVL을 사용해서 NULL대신 지정값을 설정할 수 있다.

-- 사업명, 입사일, 근무일수를 EMPLOYEE테이블에서 조회
-- 데이터베이스에서는 날짜를 계산할 때 덧셈 뺄셈이 가능하다.
-- 현재시간 - 입사일 = 근무시간
-- DATE - DATE => 무조건 결과를 일(DAY)로 표시한다.
-- 코드 실행시 현재 날짜를 표시하는 상수 : SYSDATE[년/월/일/시/분/초]


SELECT EMP_NAME, HIRE_DATE, (SYSDATE - HIRE_DATE) AS 근무일자 
FROM EMPLOYEE;

--DUAL테이블은 ORACLE에서 제공하는 가상 테이블이다.
SELECT SYSDATE FROM DUAL;

/*
    <컬럼 별칭>
    컬럼명에 별칭을 부여하면 깔끔하게 표현할 수 있음.
    컬럼명 별칭 / 컬럼명 AS 별칭/ 컬럼명 "별칭" / 컬럼명 AS "별칭"
*/

SELECT EMP_NAME 사업명, SALARY AS 급여, NVL(BONUS,0) "보너스", SALARY*12 AS "연봉"
FROM EMPLOYEE;

/*
    <리터럴> 
    직접 값을 나타내는 단위, 임의로 지정한 값 
*/

SELECT EMP_ID, EMP_NAME, SALARY, '원'
FROM EMPLOYEE;

-- <연결 연산자: || >> 여러 칼럼값들을 마치 하나의 칼럼처럼 연결할 수 있음
SELECT EMP_NAME || '님의 급여는' || SALARY || '원' AS 연결연산자
FROM EMPLOYEE; 

/*
    <DISTINCT>
    중복제거 - 칼럼에 표시된 값들을 한번만 조회하고자 할 때 사용
*/

-- 실제로 사용되고 있는 직급목록 
SELECT DISTINCT JOB_CODE
FROM EMPLOYEE;

-- 실제로 사용되고 있는 부서목록
SELECT DISTINCT DEPT_CODE
FROM EMPLOYEE;


--SELECT DISTINCT EMP_NAME, DISTINCT JOB_CODE, DISTINCT DEPT_CODE
--FROM EMPLOYEE
// DISTINCT는 한 명령어에서 한 번만 사용 가능.

--DISTINCT 같은 경우에는 항상 ROW 데이터 전체에 대해서 중복을 제거한다. (한 묶음의 중복?) 
SELECT DISTINCT JOB_CODE, DEPT_CODE
FROM EMPLOYEE;
-- 위처럼 사용시 JOB_CODE, DEPT_CODE 를 쌍으로 묶어서 중복을 제거한 값을 보여준다. 


/*
    <WHWRE 절>
    조회하고자하는 테이블로부터 특정 조건에 만족하는 데이터만 조회할 때 사용함.
    조건식에서도 다양한 연산자를 사용할 수 있음.
    
    [표현법]
    SELECT 컬럼, 컬럼 , ... 
    FROM 테이블명
    WHERE 조건; 
    
    >> 비교연산자 << 
    > , < , >= , <= : 대소비교
    = : 양쪽이 동일하다.
    !=, ^=, <> : 양 쪽이 다르다. (NOT)
*/
-- EMPLOYEE 테이블에서 부서코드가 D9인 사원들만 조회 (모든 컬럼)
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

-- EMPLOYEE 테이블에서 부서코드가 'D1'인 사람들의 사원명, 급여, 부서코드 조회
SELECT EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D1';

-- EMPLOYEE 테이블에서 부서코드가 'D1'이 아닌 사람들의 사원명, 급여, 부서코드 조회
SELECT EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE != 'D1';

-- 월급이 400만원 이상인 사원들의 사원명, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY ,'원'
FROM EMPLOYEE
WHERE SALARY >= 4000000;

/*
    <AND, OR 연산자> 조건이 여러개 연결할 때 사용한다.
    [표현법]
    조건A AND 조건B -> 조건 A와 조건 B를 모두 만족하는 값만 참으로 한다.
    조건A OR 조건B -> 조건 A와 조건 B 중 하나만 만족해도 참으로 한다.
    
    <BETWEEB AND>
    조건식에 사용되는 구문
    몇 이상 몇 이하인 범위에 대한 조건을 제시할 때 주로 사용하는 연산자 (무조건 이상, 이하) 
    [표현법]
    비교대상 컬럼 BETWWN 하한값 AND 상한값;
*/

-- 급여가 350만원 이상 600만원 이하인 모든 사원의 사원명, 사번, 급여를 조회1
SELECT EMP_NAME, EMP_ID, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3500000 AND SALARY <= 6000000;

-- 급여가 350만원 이상 600만원 이하인 모든 사원의 사원명, 사번, 급여를 조회2
SELECT EMP_NAME, EMP_ID, SALARY
FROM EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 6000000;

-- NOT : 논리부정 연산자 -> 컬럼명 앞에 또는 BETWEEN 앞에 선언 가능

-- 급여가 350만원 이상가 아니고 600만원 이하가 아닌 모든 사원의 사원명, 사번, 급여를 조회
SELECT EMP_NAME, EMP_ID, SALARY
FROM EMPLOYEE
WHERE SALARY NOT BETWEEN 3500000 AND 6000000;

-- 입사일이 '90/01/01 이상, 01/01/01 이하인 사원들을 전체 조회'

SELECT *
FROM EMPLOYEE
--WHERE HIRE_DATE >= '90/01/01' AND HIRE_DATE <= '01/01/01';
WHERE HIRE_DATE BETWEEN '90/01/01' AND '01/01/01';

-- NULL을 비교연산 할 때는 IS NULL, IS NOT NULL을 사용한다.
-- 보너스가 없는 사람
SELECT *
FROM EMPLOYEE 
WHERE BONUS IS NULL;  // IS NOT NULL NULL이 아닌 것

----------------------------------------------------------------------------------------------------------------
// 0725 
/*  
    <LIKE>
    비교하고자하는 컬럼값이 내가 제시한 특정 패턴에 만족할 경우 조회
    
    [표현법]
    비교한 대상 컬럼 LIKE '특정패턴' ; -> 일치하는 것만 조회
    
    특정패턴을 제시할 때 와일드카드라는 특정 패턴이 정의 되어있다.
    1. '%' : 포함문자 검색 (0글자 이상 전부 조회)
    EX) 비교할 대상 컬럼 LIKE "문자%" : 비교할 대상컬럼 값 중에서 해당 문자로 시작하는 값을 전부 조회
        비교할 대상 컬럼 LIKE "%문자" : 비교할 대상컬럼 값 중에서 해당 문자로 끝나는 값을 전부 조회
        비교할 대상 컬럼 LIKE "%문자%" : 비교할 대상컬럼 값 중에서 해당 문자가 포함된 값을 전부 조회
    
    2. '_' : 1글자를 대체 검색할 때 사용
    EX) 비교할 대상 컬럼 LIKE '_문자" : 비교할 대상 컬럼 값 문자 앞에 아무 글자나 딱 한 글자 있는 값을 조회
        비교할 대상 컬럼 LIKE "문자_" : 비교할 대상 컬럼 값 문자 앞에 아무 글자나 딱 한 글자 있는 값을 조회
        비교할 대상 컬럼 LIKE "_문자_" : 비교할 대상 컬럼 값 문자 앞,뒤에 아무 글자나 딱 한 글자 있는 값을 조회
            
        비교할 대상 컬럼 LIKE '_문자___" >> 내가 원하는 형태로 _를 통해서 조회를 조절할 수 있다. 
*/

SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE EMP_NAME LIKE '전%';

SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%연';

SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%';

SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE EMP_NAME LIKE '_태';

SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE EMP_NAME LIKE '_하_';

--사원들 중에서 전화번호가 3번째 자리가 1인 사원들의 사번, 사원명, 전화번호 조회
SELECT EMP_ID, EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE LIKE '__1%';

-- 이메일 중 _앞의 글자가 3글자인 사원들의 사번, 이름, 이메일 조회
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
--WHERE EMAIL LIKE '____%';  // 와일드카드로 인식되기 때문에 정상적으로 출력할 수 없다.
--와일드카드를 직접 문자로 사용할 때는 일반 문자로 구분을 해줘야한다.
-- ESCAPE OPTION을 등록해서 나만의 탈출문자를 사용할 수  있음.
WHERE EMAIL LIKE '___/_%' ESCAPE '/';


/*
    <IN>
    WHERE절에 비교대상 컬럼 값을 가지고 내가 제시한 목록 중에 일치하는지 검사하는 문법
    
    [표현법]
    비교대상 컬럼 IN (값, 값, 값, 값...)
*/

--부서코드가 D6 이거나 D8 이거나 D5인 부서원들의 이름, 부서코드, 급여
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
--WHERE DEPT_CODE = 'D6' OR DEPT_CODE = 'D8' OR DEPT_CODE = 'D5';
WHERE DEPT_CODE IN ('D6', 'D8', 'D5');

/*
    <연산자 우선순위>
        1. 산술연산자
        2. 연결연산자
        3. 비교연산자
        4. IS NULL / LIKE / IN
        5. BETWEEN A AND B
        6. NOT 
        7. AND  
        8. OR 
    // 에러가 날 것 같은 연산자에는 () 를 잘 쳐두면 좋다
*/

-----------------------실습---------------------------

-- 1. 이름이 '연'으로 끝나는 사원들의 사원명, 입사일 조회
SELECT EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%연';

-- 2. 전화번호 처음 3자리가 010이 아닌 사원들의 사원명, 전화번호 조회
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE NOT LIKE '010%'; 

-- 3. 이름에 '하'가 포함되어있고 급여가 240만원 이상인 사원들의 사원명, 급여 조회
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%' AND SALARY >= 2400000;

-- 4. 부서(DEPARTMENT)테이블에서 해외영업부서인 부서들의 부서코드, 부서명 조회
SELECT DEPT_ID, DEPT_TITLE
FROM DEPARTMENT
WHERE DEPT_TITLE LIKE '%해외영업%';

-- 5. 사수(MANAGER)가 없고 부서 배치도 받지 않은 사원들의 사원명, 사번, 부서코드 조회
SELECT EMP_NAME, EMP_ID, DEPT_CODE
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL AND DEPT_CODE IS NULL;

-- 6. 연봉(급여 * 12)가 3천만원 이상이고 보너스를 받지 않는 사원들의 사번, 사원명, 급여, 보너스 조회
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE (SALARY*12) >= 30000000 AND BONUS IS NULL;

-- 7. 입사일이 '95/01/01' 이상이고 부서배치를 받지 않은 사원들의 사번, 사원명, 입사일, 부서코드 조회
SELECT EMP_ID, EMP_NAME, HIRE_DATE, DEPT_CODE
FROM EMPLOYEE
WHERE HIRE_DATE >= '95/01/01' AND DEPT_CODE IS NULL;

-- 8. 급여가 200만원 이상이고 500만원 이하인 사원 중에서 입사일이 '01/01/01 이상이고 보너스를 
--    받지 않는 사원들의 사번, 사원명, 급여, 입사일, 보너스 조회;
SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE, NVL(BONUS, 0) AS 보너스
FROM EMPLOYEE
WHERE (SALARY BETWEEN 2000000 AND 5000000) AND (HIRE_DATE >= '95/01/01') AND (BONUS IS NULL);

-- 9. 보너스를 포함한 연봉((SALARY + (SALARY * BONUS)) * 12 이 NULL이 아니고 이름에 '하'가 포함된 
--    사원들의 사번, 사원명, 급여, 보너스 포함 연봉 조회 
SELECT EMP_ID, EMP_NAME, SALARY, (SALARY*BONUS) * 12 AS 보너스포함연봉
FROM EMPLOYEE
WHERE (((SALARY + (SALARY * BONUS)) * 12) IS NOT NULL) AND (EMP_NAME LIKE '%하%');


/*
    <ORDER BY>
    데이터를 정렬해서 조회하기 위한 구문 
    SELECT문 가장 마지막 줄에 작성, 실행순서 또한 가장 마지막에 실행이 된다.
    
    [표현법]
    
    SELECT 조회 할 컬럼...
    FROM 테이블
    WHERE 조건식
    ORDER BY 정렬기준이 될 컬럼 | 별칭 | 컬럼순번  [ASC | DESC] [NULLS FIRST | NULLS LAST]
    
    -ASC : 오름차순 [작은 값부터 큰 값까지] -> 기본값
    -DESC : 내림차순 [큰 값부터 작은 값까지]  
    - NULL은 기본적으로 가장 큰 값으로 분류해서 정렬한다.
*/

SELECT *
FROM EMPLOYEE
--ORDER BY BONUS DESC;   
--ORDER BY BONUS ASC NULLS FIRST;   
ORDER BY BONUS DESC, SALARY ASC;   
// 정렬 기준에 컬럼 값이 동일할 경우 그 다음 차순을 위해서 여러개의 기준 칼럼을 제시할 수 있다.


-- 전 사원의 사원명, 연봉을 조회, 이때 연봉을 기준으로 내림차순 정렬 

SELECT EMP_NAME, SALARY * 12 AS 연봉
FROM EMPLOYEE
--ORDER BY SALARY*12 DESC;
--ORDER BY 연봉 DESC;
ORDER BY 2 DESC;    // 컬럼의 2번째(SALARY)를 기준으로 내림차순 











