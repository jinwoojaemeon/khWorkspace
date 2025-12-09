# 개발 학습 목차

이 저장소는 데이터베이스부터 웹 개발까지의 전반적인 학습 내용을 정리한 것입니다.

## 📁 01_SQL (데이터베이스)

### 기본 개념 및 계정 관리
- `01_계정생성.sql` - 사용자 계정 생성 및 권한 부여
- `01_테이블ex.sql` - 테이블 생성 예제
- `KH_학습용계정.sql` - 학습용 계정 설정
- `SQL_TEST계정.sql` - 테스트 계정 설정
- `system_관리자.sql` - 시스템 관리자 설정

### 데이터 조회 (DQL)
- `02_DQL(SELECT.sql` - SELECT 문 기본 사용법
- `03_함수(function).sql` - SQL 함수 사용법
- `04_GROUP_BY_HAVING.sql` - 그룹화 및 조건절
- `05_DQL연습문제.sql` - SELECT 연습문제

### 테이블 조인
- `06_JOIN.sql` - 테이블 조인 기본
- `07_JOIN연습문제.sql` - JOIN 연습문제

### 서브쿼리
- `08_서브쿼리(SUBQUERY).sql` - 서브쿼리 사용법

### 데이터 정의 언어 (DDL)
- `09_DDL(CREATE).sql` - CREATE 문 사용법
- `10_CREATE연습문제.sql` - CREATE 연습문제 1
- `10_CREATE연습문제2.sql` - CREATE 연습문제 2
- `11_DDE(ALTER_DROP).sql` - ALTER, DROP 문 사용법

### 데이터 조작 언어 (DML)
- `12_DML(INSERT_UPDATE_DELETE).sql` - INSERT, UPDATE, DELETE 문

### 기타 기능
- `13_ETC(DCL, TCL).sql` - 데이터 제어 언어, 트랜잭션 제어 언어
- `14_뷰(VIEW).sql` - 뷰 생성 및 관리
- `15_시퀀스(SEQUENCE).sql` - 시퀀스 생성 및 사용
- `16_PL_SQL.sql` - PL/SQL 프로그래밍
- `17.TRIGGER.sql` - 트리거 생성 및 관리

### 실습 및 평가
- `SQL01.sql` ~ `SQL05.sql` - SQL 실습 파일들
- `WORKBOOK_답 모음/` - 워크북 답안 모음
- `평가/` - 평가 관련 파일들

---

## 📁 02_JAVA (자바 프로그래밍)

### 기본 구조
- `Hello.java` - Hello World 프로그램
- `00_Test/` - 기본 테스트 프로젝트

### 자바 기초 (01_Basic)
- **기본 문법**
  - `basic/` - 변수, 입출력, 데이터 타입
  - `operator/` - 연산자 (산술, 비교, 논리, 대입)
  - `control/` - 제어문 (if, switch)
  - `loop/` - 반복문 (for, while, do-while)
  - `method/` - 메서드 정의 및 호출

- **객체지향 프로그래밍**
  - `object/` - 클래스와 객체
  - `objectArray/` - 객체 배열
  - `inherit/` - 상속
  - `override/` - 메서드 오버라이딩
  - `abstractclass/` - 추상 클래스
  - `interface1/` - 인터페이스
  - `ploymorphism/` - 다형성

- **고급 기능**
  - `array/` - 배열 사용법
  - `collection/` - 컬렉션 프레임워크 (List, Set, Map)
  - `exception/` - 예외 처리
  - `thread/` - 멀티스레딩
  - `io1/`, `io2/` - 입출력 스트림
  - `network/` - 네트워크 프로그래밍

- **API 및 유틸리티**
  - `api/` - 자바 API 사용법
  - `compare/` - 객체 비교 및 정렬
  - `option/` - Optional 클래스
  - `generic/` - 제네릭

### JDBC (02_JDBC)
- `JDBCProject/` - JDBC 기본 프로젝트
- `JDBCProjectWithService/` - 서비스 계층이 포함된 JDBC 프로젝트
- `JDBCLifeGame/` - 생명 게임 JDBC 프로젝트
- `sql/member.sql` - 회원 테이블 스키마

### 실습 및 시험
- `exam/` - 시험 관련 파일들
- `Basic/` - 기본 개념 복습

### 📋 주요 프로젝트

#### 1. 자바 예제 프로젝트 (01_Basic/JavaBasic/src/com/kh/example/)
- **OOP 프로젝트들**
  - `oop1/` - 상품 관리 시스템
  - `oop2/` - 학생 정보 관리
  - `oop3/` - 도서 관리 시스템
  - `oop4/` - 도형 계산기 (삼각형, 사각형)
  - `oop5/` - 과자 관리 시스템
  - `oop6/` - 학생 성적 관리
  - `oop7/` - 상품 재고 관리

- **상속 및 다형성 프로젝트**
  - `inherit/` - 도형 클래스 상속 (원, 사각형)
  - `inherit2/` - 사람 클래스 상속 (직원, 학생)
  - `ploymorphism/` - 자동차 다형성 (아반떼, 소나타)
  - `poly1/` - 동물 관리 시스템 (고양이, 개)
  - `poly2/` - 도서관 관리 시스템

- **추상클래스 및 인터페이스**
  - `abstractNInterface/` - 스마트폰 계층 구조 (갤럭시, V40)

- **컬렉션 프레임워크**
  - `collection1/` - 음악 관리 시스템
  - `collection2/` - 로또 번호 생성기
  - `collection3/` - 회원 관리 시스템

- **예외처리**
  - `exception1/` - 캐릭터 관리 (문자 검증)
  - `exception2/` - 숫자 범위 검증

- **API 활용**
  - `api/` - 토큰 관리 시스템

#### 2. JDBC 생명게임 프로젝트 (02_JDBC/JDBCProject/)
**🎮 LifeGame - 콘솔 기반 생명 시뮬레이션 게임**

- **프로젝트 구조**
  - `controller/` - 비즈니스 로직 컨트롤러
    - `UserController.java` - 사용자 관리
    - `LifeCharacterController.java` - 캐릭터 관리
    - `StockController.java` - 주식 투자 시스템
    - `AchievementController.java` - 업적 시스템
  - `model/` - 데이터 모델
    - `dao/` - 데이터 접근 객체
    - `vo/` - 값 객체 (User, LifeCharacter, Stock, Achievement)
  - `service/` - 서비스 계층
  - `view/` - 사용자 인터페이스
    - `MainMenu.java` - 메인 메뉴
    - `LobbyMenu.java` - 로비 메뉴
    - `WorkMenu.java` - 직업 활동
    - `StockMenu.java` - 주식 투자
    - `ShoppingMenu.java` - 쇼핑
    - `SelfDevelopMenu.java` - 자기계발
    - `InvestMenu.java` - 투자
  - `common/` - 공통 유틸리티

- **주요 기능**
  - 사용자 회원가입/로그인
  - 캐릭터 생성 및 관리
  - 직업 활동을 통한 수입 획득
  - 주식 투자 시스템
  - 쇼핑을 통한 아이템 구매
  - 자기계발을 통한 능력치 향상
  - 업적 시스템
  - 랭킹 시스템

#### 3. JDBC 리뷰 프로젝트 (02_JDBC/JDBCReview/)
- 도서 관리 시스템
- MyBatis 연동 프로젝트

---

## 📁 03_Front (프론트엔드)

### HTML
- `01_글자관련태그.html` - 텍스트 관련 태그
- `02_목록관련태그.html` - 리스트 태그
- `03_표관련태그.html` - 테이블 태그
- `04_미디어관련태그.html` - 이미지, 비디오 태그
- `05_영역관련태그.html` - div, span 등 영역 태그
- `06_하이퍼링크관련태그.html` - 링크 태그
- `07_입력양식form관련태그.html` - 폼 태그
- `practice/` - HTML 실습 파일들

### CSS
- `01_기본선택자.html` - CSS 선택자 기본
- `02_기타선택자.html` - 고급 선택자
- `03_선택자우선순위.html` - 선택자 우선순위
- `04_글꼴관련스타일.html` - 폰트 스타일링
- `05_텍스트관련스타일.html` - 텍스트 스타일링
- `06_영역관련스타일.html` - 박스 모델
- `07_레리아웃관련스타일1.html` - 레이아웃 기본
- `08_레이아웃관련스타일2.html` - 레이아웃 고급
- `09_flex레이아웃.html` - Flexbox 레이아웃
- `10_미디어쿼리.html` - 반응형 웹 디자인
- `화면구조잡기/` - 실제 화면 구성 실습

### JavaScript
- `01_개요.html` - JavaScript 기본 개념
- `02_데이터입출력.html` - 데이터 입출력
- `03_요소에접근하기.html` - DOM 조작
- `04_함수.html` - 함수 정의 및 사용
- `05_객체.html` - 객체 생성 및 사용
- `06_이벤트.html` - 이벤트 처리
- `07_정규표현식.html` - 정규표현식
- `08_window용객체.html` - Window 객체
- `09_JQuery1.html` - jQuery 기본
- `10_Jquery2.html` - jQuery 고급
- `11_부트스트랩.html` - Bootstrap 프레임워크
- `practice/` - JavaScript 실습 파일들
- `resources/js/` - JavaScript 리소스 파일들

### 📋 주요 프로젝트

#### 1. 가계부 애플리케이션 (JavaScript/accountBook/)
**💰 AccountBook - 로컬스토리지 기반 가계부**

- **기술 스택**
  - HTML5, CSS3, Vanilla JavaScript
  - localStorage를 활용한 데이터 저장
  - JSON을 이용한 데이터 직렬화/역직렬화

- **주요 기능**
  - 수입/지출 내역 추가 및 관리
  - 카테고리별 분류 (수입/지출 토글)
  - 필터링 기능 (전체/수입/지출)
  - 실시간 잔액 계산 및 표시
  - 데이터 영구 저장 (localStorage)
  - 반응형 UI 디자인

- **프로젝트 구조**
  - `index.html` - 메인 페이지
  - `script.js` - JavaScript 로직
  - `style.css` - 스타일링
  - `script 흐름 순서.txt` - 개발 과정 및 로직 설명

- **핵심 구현 사항**
  - DOM 조작을 통한 동적 UI 생성
  - 이벤트 리스너를 활용한 사용자 인터랙션
  - JSON.stringify/parse를 통한 데이터 관리
  - 필터링 알고리즘 구현

#### 2. 할일 관리 애플리케이션 (JavaScript/todoApp/)
**✅ TodoApp - 간단한 할일 관리 시스템**

- **기술 스택**
  - HTML5, CSS3, Vanilla JavaScript
  - localStorage 데이터 저장

- **주요 기능**
  - 할일 추가, 수정, 삭제
  - 완료 상태 토글
  - 필터링 (전체/진행중/완료)
  - 데이터 영구 저장

- **프로젝트 구조**
  - `index.html` - 메인 페이지
  - `script.js` - JavaScript 로직
  - `style.css` - 스타일링

#### 3. 화면 구성 실습 (CSS/화면구조잡기/)
**🎨 실제 웹사이트 레이아웃 구현**

- **구현 내용**
  - 헤더, 네비게이션, 메인 콘텐츠, 푸터 구성
  - 로그인 폼, 검색창, 메뉴바 구현
  - 반응형 디자인 적용
  - 이미지 및 아이콘 활용

- **파일 구성**
  - `01_영역관련속성.html` - 기본 레이아웃
  - `02_문서구조.html` - HTML 구조 설계
  - `03_세부_푸터만들기.html` - 푸터 구현
  - `04_세부_로그인폼만들기.html` - 로그인 폼
  - `05_세부_검색창만들기.html` - 검색 기능
  - `06_세부_메뉴바만들기.html` - 네비게이션
  - `07_실습_전체화면구현.html` - 통합 구현

---

## 📁 04_Servlet (서블릿 & JSP)

### 기본 서블릿
- `servlet/` - 서블릿 기본 구조 및 동작
  - `RequestGetServlet.java` - GET 요청 처리
  - `RequestPostServlet.java` - POST 요청 처리

### JSP
- `jsp/` - JSP 기본 사용법
  - `scripting_elements.jsp` - 스크립팅 요소
  - `directive.jsp` - 지시어
  - `pizza/` - 피자 주문 시스템

### EL & JSTL
- `elAction/` - Expression Language와 JSTL
  - `el_basic.jsp` - EL 기본 사용법
  - `el_operation.jsp` - EL 연산자
  - `action_include.jsp` - include 액션
  - `action_forward.jsp` - forward 액션
  - `custom_core.jsp` - 커스텀 코어 태그
  - `custom_fmt.jsp` - 커스텀 포맷 태그
  - `custom_function.jsp` - 커스텀 함수

### 📋 주요 프로젝트

#### 1. JSP 게시판 프로젝트 (jspProject/)
**📝 JSP 기반 종합 게시판 시스템**

- **기술 스택**
  - JSP, Servlet, JDBC
  - Oracle Database
  - Apache Commons FileUpload (파일 업로드)
  - JSTL, EL

- **프로젝트 구조**
  - `controller/` - 서블릿 컨트롤러
    - `board/` - 게시판 관련 컨트롤러
      - `ListController.java` - 게시글 목록
      - `DetailController.java` - 게시글 상세보기
      - `InsertController.java` - 게시글 작성
      - `UpdateController.java` - 게시글 수정
      - `DeleteController.java` - 게시글 삭제
      - `ThumbnailListController.java` - 썸네일 게시판
      - `AjaxReplyListController.java` - 댓글 AJAX
    - `member/` - 회원 관련 컨트롤러
      - `LoginController.java` - 로그인
      - `InsertController.java` - 회원가입
      - `MyPageController.java` - 마이페이지
      - `AjaxIdCheckController.java` - 아이디 중복체크
  - `model/` - 데이터 모델
    - `dao/` - 데이터 접근 객체
    - `vo/` - 값 객체 (Board, Member, Reply, Attachment)
  - `service/` - 비즈니스 로직
  - `common/` - 공통 유틸리티 (JDBCTemplate, PageInfo)

- **주요 기능**
  - 회원가입/로그인/로그아웃
  - 게시글 CRUD (생성, 조회, 수정, 삭제)
  - 파일 업로드 및 다운로드
  - 썸네일 이미지 생성
  - 댓글 시스템 (AJAX)
  - 페이징 처리
  - 검색 기능
  - 마이페이지

#### 2. MyBatis 연동 프로젝트 (mybatisProject/)
**🗄️ MyBatis 기반 게시판 시스템**

- **기술 스택**
  - JSP, Servlet, MyBatis
  - Oracle Database
  - Maven 프로젝트 구조

- **프로젝트 구조**
  - `controller/` - 서블릿 컨트롤러 (JSP 프로젝트와 동일)
  - `model/` - 데이터 모델
  - `service/` - 비즈니스 로직
  - `resources/mappers/` - MyBatis 매퍼 XML
    - `board-mapper.xml` - 게시판 관련 SQL
    - `member-mapper.xml` - 회원 관련 SQL
  - `resources/mybatis-config.xml` - MyBatis 설정

- **주요 개선사항**
  - JDBC 대신 MyBatis 사용으로 SQL 관리 개선
  - XML 매퍼를 통한 SQL 쿼리 관리
  - 동적 SQL 활용
  - 매핑 자동화



### 서버 설정
- `Servers/` - Tomcat 서버 설정 파일들

---

## 📁 05_Spring (Spring Framework)

### Spring Boot 프로젝트 (spring/spring/)
**🌱 Spring Boot 기반 웹 애플리케이션**

- **기술 스택**
  - Spring Boot 3.5.6
  - Spring Security
  - MyBatis 3.0.5
  - Oracle Database
  - JSP, JSTL
  - Maven

- **프로젝트 구조**
  - `controller/` - Spring MVC 컨트롤러
    - `HomeController.java` - 메인 페이지 (공공데이터 API 연동)
    - `BoardController.java` - 게시판 관리
    - `MemberController.java` - 회원 관리
  - `service/` - 비즈니스 로직
    - `BoardService.java` - 게시판 서비스
    - `MemberService.java` - 회원 서비스
    - `ToiletService.java` - 공공데이터 API 서비스
  - `model/` - 데이터 모델
    - `mapper/` - MyBatis 매퍼 인터페이스
    - `vo/` - 값 객체 (Board, Member, Reply, Attachment, Category)
    - `dto/` - 데이터 전송 객체 (Toilet, ToiletListResponse)
  - `config/` - 설정 클래스
    - `WebConfig.java` - 웹 설정 (인터셉터 등록)
    - `securityConfig.java` - Spring Security 설정
    - `FilterConfig.java` - 필터 설정
  - `interceptor/` - 인터셉터
    - `LoginCheckInterceptor.java` - 로그인 체크 인터셉터
  - `filter/` - 필터
    - `RequestTimeFilter.java` - 요청 시간 측정 필터
  - `resources/mappers/` - MyBatis 매퍼 XML
  - `webapp/WEB-INF/views/` - JSP 뷰 페이지

- **주요 기능**
  - Spring Boot 기반 웹 애플리케이션 구조
  - Spring Security를 활용한 보안 설정
  - MyBatis 연동을 통한 데이터베이스 접근
  - 인터셉터를 활용한 로그인 체크
  - 필터를 통한 요청 처리
  - 공공데이터 API 연동 (서울시 공중화장실 정보)
  - 게시판 CRUD 기능
  - 회원 관리 기능
  - 파일 업로드 기능
  - 썸네일 게시판 기능
  - 댓글 시스템

- **핵심 학습 내용**
  - Spring Boot 프로젝트 설정 및 구조
  - Spring MVC 패턴 구현
  - 의존성 주입 (DI) 및 제어의 역전 (IoC)
  - Spring Security 설정 및 활용
  - 인터셉터와 필터의 차이 및 활용
  - MyBatis Spring Boot Starter 연동
  - 공공데이터 API 연동 및 JSON 파싱
  - RESTful API 설계

---

## 📁 06_REACT (React 프론트엔드)

### ES6 (ECMAScript 2015) 학습
- `01_variable.js` - 변수 선언 (let, const)
- `02_function.js` - 화살표 함수, 기본 매개변수
- `03_loop.js` - 반복문 (for...of, for...in)
- `04_class.js` - 클래스 문법
- `05_etc.js` - 기타 ES6 문법 (템플릿 리터럴, 구조 분해 등)
- `06_module/` - 모듈 시스템 (export/import)

### React 프로젝트 (react-project/)
**⚛️ React + Vite 기반 프론트엔드 프로젝트**

- **기술 스택**
  - React 19.2.0
  - Vite 7.2.4
  - styled-components 6.1.19
  - ESLint

- **프로젝트 구조**
  - `src/`
    - `App.jsx` - 메인 컴포넌트
    - `main.jsx` - 진입점
    - `components/` - 컴포넌트
      - `JavaScript.jsx` - JSX 문법 예제
      - `Style.jsx` - styled-components 예제
    - `assets/` - 정적 리소스
    - `index.css` - 전역 스타일

- **주요 기능**
  - JSX 문법 학습
  - React 컴포넌트 작성
  - styled-components를 활용한 스타일링
  - 상태 관리 (useState)
  - 조건부 렌더링
  - 리스트 렌더링

- **React 학습 프로젝트들**
  - `react01_jsx/` - JSX 기본 학습
  - `react02_component/` - 컴포넌트 학습
  - `react03_reactClassComponents/` - 클래스 컴포넌트 학습
  - `react05_Router/` - React Router 학습
  - `todoapp/` - Todo 애플리케이션
  - `user-manager/` - 사용자 관리 애플리케이션

- **핵심 학습 내용**
  - React 기본 개념 및 JSX 문법
  - 함수형 컴포넌트와 클래스 컴포넌트
  - Props와 State
  - React Hooks (useState, useEffect 등)
  - 이벤트 처리
  - 조건부 렌더링 및 리스트 렌더링
  - React Router를 활용한 라우팅
  - styled-components를 활용한 CSS-in-JS

---

## 📁 07_RestServer (REST API 서버)

### Spring Boot REST API 프로젝트 (board/)
**🚀 RESTful API 기반 게시판 서버**

- **기술 스택**
  - Spring Boot 3.4.12
  - MyBatis 3.0.5
  - H2 Database
  - Gradle
  - Lombok

- **프로젝트 구조**
  - `controller/` - REST 컨트롤러
    - `BoardController.java` - 게시판 API 엔드포인트
      - `GET /api/board` - 게시글 목록 조회
      - `POST /api/board` - 게시글 작성
  - `service/` - 비즈니스 로직
    - `BoardService.java` - 게시판 서비스 인터페이스
    - `BoardServiceImpl.java` - 게시판 서비스 구현
  - `mapper/` - MyBatis 매퍼
    - `BoardMapper.java` - 게시판 매퍼 인터페이스
  - `entity/` - 엔티티 클래스
    - `Board.java` - 게시글 엔티티
    - `Member.java` - 회원 엔티티
  - `dto/` - 데이터 전송 객체
    - `request/` - 요청 DTO
      - `BoardRequest.java` - 게시글 요청 DTO
    - `response/` - 응답 DTO
      - `BoardResponse.java` - 게시글 응답 DTO
  - `resources/`
    - `mappers/` - MyBatis 매퍼 XML
    - `static/` - 정적 리소스 (HTML, CSS, JS)
      - `index.html` - 프론트엔드 테스트 페이지
      - `js/index.js` - AJAX를 활용한 API 호출

- **주요 기능**
  - RESTful API 설계 및 구현
  - 게시글 CRUD 기능
  - 파일 업로드 기능
  - JSON 기반 데이터 통신
  - H2 인메모리 데이터베이스 활용
  - AJAX를 활용한 프론트엔드 연동

- **API 엔드포인트**
  - `GET /api/board` - 게시글 목록 조회
  - `POST /api/board` - 게시글 작성 (파일 업로드 지원)

- **핵심 학습 내용**
  - RESTful API 설계 원칙
  - Spring Boot REST Controller 작성
  - ResponseEntity를 활용한 HTTP 응답 처리
  - MultipartFile을 활용한 파일 업로드
  - DTO 패턴을 활용한 데이터 전송
  - MyBatis를 활용한 데이터베이스 연동
  - H2 Database 설정 및 활용
  - AJAX를 활용한 비동기 통신
  - CORS 설정 및 처리

---

## 🎯 학습 순서

1. **01_SQL** - 데이터베이스 기본 개념 및 SQL 문법
2. **02_JAVA** - 객체지향 프로그래밍 및 JDBC
3. **03_Front** - HTML, CSS, JavaScript를 통한 프론트엔드 개발
4. **04_Servlet** - 서버사이드 개발 및 웹 애플리케이션 구축
5. **05_Spring** - Spring Framework를 활용한 엔터프라이즈 애플리케이션 개발
6. **06_REACT** - React를 활용한 모던 프론트엔드 개발
7. **07_RestServer** - RESTful API 서버 구축 및 프론트엔드 연동

각 폴더는 순차적으로 학습할 수 있도록 구성되어 있으며, 실습 파일과 연습문제를 통해 단계별로 실력을 향상시킬 수 있습니다.
