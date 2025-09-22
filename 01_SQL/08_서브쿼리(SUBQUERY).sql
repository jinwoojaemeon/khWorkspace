/*
    *서브쿼리
    - 하나의 SQL문 안에 포함된 또 다른 SELECT문
    - 메인 SQL문을 위해서 보조 역할을 하는 쿼리
*/

-- 예시 1 : 노옹철 사원과 같은 부서에 속한 사원들 전체 조회
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';  -- 노웅철 사원의 부서코드

SELECT DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '노옹철';

SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                        FROM EMPLOYEE
                        WHERE EMP_NAME = '노옹철');
                        
-- 예시 2 : 전 직원의 평균 급여보다 더 많은 급여를 받는 사원들의 사번, 이름, 직급코드, 급여 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY 
FROM EMPLOYEE
WHERE SALARY > (SELECT AVG(SALARY)
                        FROM EMPLOYEE);
            
/*
    * 서브쿼리 구문
          서브쿼리를 수행한 결과값이 몇 행, 몇 열로 나오느냐에 따라서 분류
          -- 단일행 서브쿼리 : 서브쿼리의 조회 결과값이 오로지 한 개일 때
          -- 다중행 서브쿼리 : 서브쿼리의 조회 결과값이 여러 행일 때(여러행 한 열)
          -- 다중열 서브쿼리 : 서브쿼리의 조회 결과값이 한 행이지만 컬럼이 여러개일 때
          -- 다중행 다중열 서브쿼리 : 서브쿼리의 조회 결과값이 여러 행 여러 컬럼일 때
          
      >> 서브쿼리의 결과값에 따라서 서브쿼리 앞 쪽에 연산자가 달라진다.
*/            

/*
    <단일 행 서브 쿼리>
    서브 쿼리 결과로 값이 딱 한 개 ( 1행 1열 )
    일반적으로 비교연산자(=, !=, <=, >=, ... )와 함께 사용. 
*/
-- 1) 전 직원의 평균 급여보다 급여를 더 적게 받는 사원들의 사원명, 직급코드, 급여 조회
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY < (SELECT AVG(SALARY) FROM EMPLOYEE);
-- SELECT AVG(SALARY) FROM EMPLOYEE 의 조회 결과가 단일 행 결과가 나온다.
        
-- 2) 최저 급여를 받는 사원의 사번, 이름, 급여, 입사일 조회
SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY = (SELECT MIN(SALARY) FROM EMPLOYEE);
            
-- 3) 노옹철 사원의 급여보다 급여를 많이 받는 사원들의 사번, 이름, 부서명, 급여를 조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE SALARY > (SELECT SALARY 
                FROM EMPLOYEE 
                WHERE EMP_NAME = '노옹철');

-- 4) 부서 별 급여 합이 가장 큰 부서의 부서코드, 급여합
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY)) 
                        FROM EMPLOYEE 
                        GROUP BY DEPT_CODE);


-- 5) '전지연'사원과 같은 부서의 사람들의 사번, 사원명, 전화번호, 입사일, 부서명 조회
        -- 단, 전지연 사원은 제외
SELECT EMP_ID, EMP_NAME, PHONE, HIRE_DATE, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE DEPT_CODE = (SELECT DEPT_CODE 
                    FROM EMPLOYEE 
                    WHERE EMP_NAME='전지연')
  AND EMP_NAME != '전지연';
            
 ---*----*----*----*----*----*----*----*----*----*----*----*----*----*---*--          
/*
    2. 다중 행 서브쿼리
    서브 쿼리를 수행한 결과 값이 여러행 일 때 (컬럼은 한 개)
    - 비교대상 IN : 여러 개의 결과 값 중 한 개라도 일치하는 값이 있는지
    - 비교대상 ANY(값-): 여러 개의 결과 값 중 한 개라도 비교 연산을 만족하는가?
    - 비교대상 ALL(값-): 여러 개의 결과 값 모두가 비교 연산을 만족하는가?
    위 3가지 연산자와 함께 사용하는 경우가 많다.
*/
            
-- 1) 유재식 또는 윤은해 사원과 같은 직급인 사원들의 사번, 사원명, 직급코드, 급여 조회          
-- 단일 행 서브 쿼리 여러 개를 통해 구현 
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE JOB_CODE = ( SELECT JOB_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '유재식') 
   OR JOB_CODE = ( SELECT JOB_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '윤은해');
                
-- IN 절을 통해 다중 행 서브쿼리로 처리할 수 있음.
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE JOB_CODE IN(SELECT JOB_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME IN('유재식', '윤은해'));
            
-- 2) 대리 직금임에도 과장직급의 최소 급여보다 더 많이 받는 사원들의 사번, 이름 , 직급 조회
-- 대리 직급의 정보를 포함 
SELECT EMP_ID, EMP_NAME, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '대리'
    AND SALARY > (SELECT MIN(SALARY) 
                FROM EMPLOYEE 
                JOIN JOB USING(JOB_CODE) 
                WHERE JOB_NAME = '과장');
         
-- ANY를 사용하여 쿼리문을 작성할 수 있다.      
SELECT EMP_ID, EMP_NAME, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '대리'
    AND SALARY > ANY (SELECT SALARY
                        FROM EMPLOYEE 
                        JOIN JOB USING(JOB_CODE) 
                        WHERE JOB_NAME = '과장');        
                    

 --*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*
 /*
    3. 다중 열 서브쿼리
    결과값은 한 행이지만 나열된 컬럼 수가 여러 개일 경우 ( 두 개 이상의 컬럼 )
 */
            
-- 1) 하이유 사원과 같은 부서코드, 같은 직급코드에 해당하는 사원들 조회
-- 사원명, 부서코드, 직급코드, 입사일
SELECT EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE 
                    FROM EMPLOYEE 
                    WHERE EMP_NAME = '하이유')
   AND JOB_CODE = (SELECT JOB_CODE 
                       FROM EMPLOYEE 
                       WHERE EMP_NAME = '하이유');
            
-- 다중 열 서브쿼리로 구현
-- 튜플 비교 : 두 개 이상의 컬럼을 조합해서 비교하는 방식
SELECT EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) = (SELECT DEPT_CODE, JOB_CODE    -- 순서 끼리 비교
                                FROM EMPLOYEE 
                                WHERE EMP_NAME = '하이유')
    AND EMP_NAME != '하이유';
                                                
-- 박나라 사원과 같은 직급 코드, 같은 사수를 가지고 있는 사원들의 사번, 사원명, 직급코드, 사수번호 조회
-- 단, 박나라 사원은 조회 X 
SELECT EMP_ID, EMP_NAME, JOB_CODE, MANAGER_ID
FROM EMPLOYEE
WHERE (JOB_CODE, MANAGER_ID) = (SELECT JOB_CODE, MANAGER_ID 
                                FROM EMPLOYEE
                                WHERE EMP_NAME = '박나라')
 AND EMP_NAME != '박나라';           
            
--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*    
/*
    4.다중 행 다중 열 서브쿼리
    서브쿼리의 조회 결과값이 여러 행 여러 열일 경우 
*/
-- 1) 각 직급 별 최소 급여를 받는 사원의 사번, 사원명, 직급코드, 급여

-- 사원의 사번, 사원명, 직급 코드, 급여
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE;
-- 각 직급 별 최소 급여 
SELECT JOB_CODE, MIN(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE;
--각 직급 별 최소 급여를 받는 사원의 사번, 사원명, 직급코드, 급여
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE = 'J1' AND SALARY = 8000000)
   OR (JOB_CODE = 'J2' AND SALARY = 3700000)
   OR (JOB_CODE = 'J3' AND SALARY = 3400000)
   OR (JOB_CODE = 'J4' AND SALARY = 1550000)
   OR (JOB_CODE = 'J5' AND SALARY = 2200000)
   OR (JOB_CODE = 'J6' AND SALARY = 2000000)
   OR (JOB_CODE = 'J7' AND SALARY = 1380000);      
            
-- 다중 행 다중 열 서브쿼리 구성
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN (SELECT JOB_CODE, MIN(SALARY)
                                FROM EMPLOYEE
                                GROUP BY JOB_CODE)
ORDER BY JOB_CODE;
            
-- 2) 각 부서 별 최고 급여를 받는 사원들의 사번, 사원명, 부서코드 급여
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE (DEPT_CODE, SALARY) IN (SELECT DEPT_CODE, MAX(SALARY)
                                FROM EMPLOYEE
                                GROUP BY DEPT_CODE)
ORDER BY DEPT_CODE;
            
-- 3) 각 부서 별 급여 합계가 전체 급여 총 합의 20%보다 많은 부서의 부서명, 부서별 급여 합계 조회
SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) > (SELECT SUM(SALARY)*0.2
                            FROM EMPLOYEE);
                
/*
    5. 인라인 뷰
    FROM절에 서브쿼리를 작성한 것
    서브쿼리에 수행 결과를 마치 테이블처럼 사용. 
*/            

SELECT *
FROM EMPLOYEE;

/* 사원들의 사번, 이름, 보너스 포함 연봉, 부서코드 조회
     단, 보너스 포함 연봉이 NULL이면 안된다.
     단, 보너스 포함 연봉이 3000만원 이상인 사원들만 조회*/
SELECT ROWNUM ,EMP_ID, EMP_NAME,
    (SALARY+(SALARY * NVL(BONUS,0)))*12 AS "연봉",
         DEPT_CODE
FROM EMPLOYEE
WHERE  (SALARY+(SALARY * NVL(BONUS,0))) * 12 >= 30000000
ORDER BY "연봉" DESC;
-- LIMIT 5 >>  ORACLE에서는 지원하지 않는 문법.

/*
ROWNUN : 오라클에서 기본적으로 제공해주는 컬럼, 조회된 순서대로 1부터 순번을 부여해준다.
         단, ROWNUM은 FROM절에서 결정이 됨. 
-- > 인라인뷰를 통해서 TOP-N 분석 : 상위 몇 개만 조회
*/

-- 전 직원 중 급여가 가장 높은 직원 5명 
SELECT ROWNUM, EMP_NAME, SALARY
FROM EMPLOYEE
ORDER BY SALARY DESC;

--> ORDER BY절이 수행된 결과를 가지고 ROWNUM 부여 : 상위 5명 
SELECT ROWNUM, EMP_NAME, SALARY
FROM (SELECT  EMP_NAME, SALARY
        FROM EMPLOYEE
        ORDER BY SALARY DESC)    -- > 인라인 뷰 . 내림차순으로 정렬 된 순서로 ROWNUM 채워지기 시작
WHERE ROWNUM <= 5;

-- 가장 최근에 입사한 사원 5명의 사원명, 급여, 입사일
SELECT *
FROM (SELECT EMP_NAME, SALARY, HIRE_DATE
        FROM EMPLOYEE
        ORDER BY HIRE_DATE DESC)
WHERE ROWNUM <= 5;

-- 각 부서별 평균 급여가 높은 3개의 부서 조회
-- 부서 별 평균 급여가 높은 순서 먼저 구하기 
SELECT DEPT_CODE, AVG(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY AVG(SALARY) DESC;

SELECT DEPT_CODE, SALARY_AVG
FROM (SELECT DEPT_CODE, AVG(SALARY) AS SALARY_AVG   
        FROM EMPLOYEE
        GROUP BY DEPT_CODE
        ORDER BY AVG(SALARY) DESC)
WHERE ROWNUM <= 3;
-- 인라인 뷰에 수식이나 함수가 있을 경우 맨 처음 SELECT 구문에서 컬럼이 조회가 안 될 수 있으니
-- 수식이나 함수를 사용한 인라인뷰가 있을 경우 별칭을 부여하는 것이 좋다. 

-- 부서 별 평균 급여가 270만원을 초과하는 부서들에 대해서  
-- 부서코드, 부서별 총 급여합, 부서별 평균급여, 부서별 사원수 조회
SELECT DEPT_CODE, SUM(SALARY), AVG(SALARY), COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING AVG(SALARY) > 2700000;

SELECT *
FROM (SELECT DEPT_CODE, SUM(SALARY), AVG(SALARY) AS SALARY_AVG, COUNT(*)
        FROM EMPLOYEE
        GROUP BY DEPT_CODE)
WHERE SALARY_AVG > 2700000;







            
            
            
            
            
            
                        