# 🚀 MyBatis Community
> MyBatis ORM을 활용한 JSP 기반 웹 애플리케이션

## 📘 개요 (Overview)

본 프로젝트는 **Servlet과 JSP를 이용한 MVC 패턴 기반의 웹 애플리케이션**으로,  
**MyBatis ORM 프레임워크**를 활용하여 데이터베이스 연동을 구현했습니다.  
회원 관리(로그인·회원가입) 및 게시판 CRUD 기능을 중심으로 구성되었으며,  
Oracle 데이터베이스와 MyBatis를 통해 효율적인 데이터 연동을 수행합니다.  
Eclipse + Tomcat 환경에서 실행 가능합니다.

## 🧱 기술 스택 (Tech Stack)
| 구분 | 사용 기술 |
|------|------------|
| Frontend | HTML, CSS, JavaScript, JSP, JSTL |
| Backend | Java (Servlet) |
| ORM | MyBatis 3.5.19 |
| Server| Apache Tomcat |
| Database | Oracle |
| File Upload | Apache Commons FileUpload2 |
| Tools | Eclipse, Git, GitHub |

## 🛠️ 설치 및 실행 (Installation & Run)
# 1. 프로젝트 클론
git clone https://github.com/your-username/mybatisProject.git

# 2. 이클립스(Eclipse)에서 Import
- File > Import > Existing Projects into Workspace
- 복제한 프로젝트 폴더 선택 후 Import

# 3. 데이터베이스(Oracle) 설정
- Oracle 실행 후 데이터베이스 및 테이블 생성
- resources/mybatis-config.xml에서 데이터베이스 연결 정보 수정
- Oracle JDBC 드라이버 확인 (ojdbc17.jar)

# 4. Tomcat 서버 설정
- Eclipse > Servers > New > Server > Apache Tomcat 선택
- 프로젝트를 서버에 Add 후 실행

# 5. 웹 애플리케이션 실행
- 브라우저에서 접속
http://localhost:8080/mybatisProject

## 📂 프로젝트 구조 (Directory Structure)
mybatisProject/<br>
 ├── src/main/java/<br>
 │   ├── com/kh/mybatis/controller/     # Servlet 컨트롤러<br>
 │   │   ├── board/                     # 게시판 관련 컨트롤러<br>
 │   │   └── member/                    # 회원 관련 컨트롤러<br>
 │   ├── com/kh/mybatis/model/<br>
 │   │   ├── dao/                       # MyBatis DAO<br>
 │   │   └── vo/                        # VO (Value Object)<br>
 │   ├── com/kh/mybatis/service/        # 비즈니스 로직<br>
 │   └── com/kh/mybatis/common/         # 공용 유틸 (Template, PageInfo)<br>
 ├── src/main/webapp/<br>
 │   ├── WEB-INF/<br>
 │   │   ├── views/                     # JSP 뷰 페이지<br>
 │   │   │   ├── board/                 # 게시판 관련 JSP<br>
 │   │   │   ├── member/                # 회원 관련 JSP<br>
 │   │   │   └── common/                # 공통 JSP<br>
 │   │   ├── lib/                       # 라이브러리<br>
 │   │   └── web.xml                    # 배포 서술자<br>
 │   ├── resources/                     # CSS, JS, 이미지, 파일 업로드<br>
 │   └── index.jsp                      # 메인 페이지<br>
 ├── resources/<br>
 │   ├── mappers/                       # MyBatis 매퍼 XML<br>
 │   └── mybatis-config.xml             # MyBatis 설정<br>
 └── README.md

## 🌟 주요 기능 (Key Features)
✅ 회원가입 / 로그인 / 로그아웃 기능 <br>
✅ 게시글 등록, 조회, 수정, 삭제 (CRUD) <br>
✅ **MyBatis ORM**을 활용한 효율적인 데이터베이스 연동 <br>
✅ **파일 업로드 기능** (commons-fileupload2 라이브러리 활용) <br>
✅ **썸네일 게시글 기능** (다중 이미지 업로드 및 관리) <br>
✅ **페이지네이션** (PageInfo 클래스 기반) <br>
✅ **검색 기능** (제목, 내용, 작성자별 검색) <br>
✅ **댓글 시스템** (Ajax 기반 실시간 댓글) <br>
✅ Oracle DB 연동을 통한 데이터 관리 <br>
✅ MVC 패턴 기반 구조로 모듈화된 개발 <br>
✅ JSP include를 통한 공통 레이아웃 구성

## 📸 화면 미리보기 (Preview)

| 기능 | 미리보기 |
|------|-----------|
| 메인 화면 | ![Main Page](assets/main-page.html) |
| 로그인 화면 | ![Login Page](assets/login-page.html) |
| 게시판 목록 | ![Board List](assets/board-list.html) |
| 게시글 작성 | ![Post Write](assets/post-write.html) |

## 💡 학습 포인트 (Learning Points)

- **MyBatis ORM 프레임워크** 활용 방법 학습
- **SQL 매퍼 XML** 작성 및 동적 쿼리 구현
- **ResultMap**을 활용한 복잡한 객체 매핑
- **JSP & Servlet 기반 MVC 구조** 설계 방법 학습
- **Apache Commons FileUpload2** 라이브러리를 활용한 파일 업로드 구현
- **multipart/form-data** 방식의 파일 전송 처리
- **페이지네이션 시스템** 설계 및 구현 (PageInfo 클래스 활용)
- **트랜잭션 관리**를 통한 데이터 일관성 보장
- **Tomcat 서버**를 활용한 배포 및 실행 환경 이해
- **JSP 내 JSTL / EL** 사용으로 동적 페이지 구현
- **Oracle 시퀀스** 활용 및 생성된 키 반환 처리
- **Ajax 기반 댓글 시스템** 구현으로 실시간 상호작용 학습
- **다중 파일 업로드** 처리 및 파일 레벨 관리 시스템
- **JavaScript FileReader API**를 활용한 이미지 미리보기 구현

---

## 📋 구성 클래스 및 역할

### **🏠 메인 진입점**
- **`src/main/webapp/index.jsp`** — 메인 페이지 (실행 화면)
  - `menubar.jsp`를 include하여 공통 레이아웃 구성
  - 로그인/비로그인 상태에 따른 UI 분기 처리

### **👤 회원 관리 (Member Management)**

#### **com.kh.mybatis.controller.member 패키지**
- **`LoginController`** (`/login.me`)
  - `doGet()` — 로그인 처리 및 세션 관리
  - 로그인 성공 시 세션에 사용자 정보 저장, 실패 시 에러 페이지 이동
- **`InsertController`** (`/insert.me`)
  - `doGet()` — 회원가입 처리
  - 폼 데이터 수집 및 Member 객체 생성 후 DB 저장
- **`EnrollFormController`** (`/enrollForm.me`)
  - `doGet()` — 회원가입 폼 페이지로 이동
- **`MyPageController`** (`/myPage.me`)
  - `doGet()` — 마이페이지 조회 및 수정 폼 제공
- **`UpdateController`** (`/update.me`)
  - `doGet()` — 회원 정보 수정 처리
- **`UpdatePwdController`** (`/updatePwd.me`)
  - `doGet()` — 비밀번호 변경 처리
- **`DeleteController`** (`/delete.me`)
  - `doGet()` — 회원 탈퇴 처리 (상태 변경)
- **`LogoutController`** (`/logout.me`)
  - `doGet()` — 로그아웃 처리 및 세션 무효화
- **`AjaxIdCheckController`** (`/idCheck.me`)
  - `doPost()` — Ajax 기반 아이디 중복 확인

#### **com.kh.mybatis.service.MemberService**
- `loginMember(String userId, String userPwd): Member` — 로그인 인증
- `insertMember(Member m): int` — 회원가입 처리
- `updateMember(Member m): int` — 회원 정보 수정
- `updatePwd(String userId, String userPwd, String newPwd): int` — 비밀번호 변경
- `deleteMember(String userId, String userPwd): int` — 회원 탈퇴
- `idCheck(String checkId): int` — 아이디 중복 확인

#### **com.kh.mybatis.model.vo.Member**
- 회원 정보 VO 클래스 (Lombok 사용)
- `insertCreateMember()` — 회원가입용 객체 생성
- `loginMember()` — 로그인용 객체 생성
- `createUpdateMember()` — 수정용 객체 생성

### **📝 게시판 관리 (Board Management)**

#### **com.kh.mybatis.controller.board 패키지**

##### **일반 게시판**
- **`ListController`** (`/list.bo`)
  - `doGet()` — 게시글 목록 조회 및 **PageInfo 기반 페이지네이션** 처리
- **`SearchController`** (`/search.bo`)
  - `doGet()` — **검색 기능** (제목, 내용, 작성자별 검색) 및 페이징 처리
- **`DetailController`** (`/detail.bo`)
  - `doGet()` — 게시글 상세 조회, 첨부파일 조회 및 조회수 증가
- **`EnrollFormController`** (`/enrollForm.bo`)
  - `doGet()` — 게시글 작성 폼 페이지로 이동 (카테고리 목록 조회)
- **`InsertController`** (`/insert.bo`)
  - `doGet()` — **파일 업로드 기능을 포함한** 게시글 작성 처리
  - commons-fileupload2 라이브러리 활용한 multipart 요청 처리
- **`UpdateFormController`** (`/updateForm.bo`)
  - `doGet()` — 게시글 수정 폼 페이지로 이동 (기존 첨부파일 정보 포함)
- **`UpdateController`** (`/update.bo`)
  - `doGet()` — **파일 업로드 기능을 포함한** 게시글 수정 처리
  - 기존 파일 삭제 및 새 파일 업로드 처리
- **`DeleteController`** (`/delete.bo`)
  - `doGet()` — 게시글 삭제 처리

##### **썸네일 게시판**
- **`ThumbnailListController`** (`/list.th`)
  - `doGet()` — 썸네일 게시글 목록 조회 (썸네일 이미지 포함)
- **`ThumbnailDetailController`** (`/detail.th`)
  - `doGet()` — 썸네일 게시글 상세 조회, 다중 이미지 조회 및 조회수 증가
- **`ThumbnailEnrollController`** (`/enrollForm.th`)
  - `doGet()` — 썸네일 게시글 작성 폼 페이지로 이동
- **`ThumbnailInsertController`** (`/insert.th`)
  - `doGet()` — **다중 이미지 업로드 기능을 포함한** 썸네일 게시글 작성 처리
  - 대표이미지(FILE_LEVEL=1)와 상세이미지(FILE_LEVEL=2) 구분 저장

##### **댓글 시스템 (Ajax)**
- **`AjaxReplyListController`** (`/rlist.bo`)
  - `doPost()` — Ajax 기반 댓글 목록 조회
- **`AjaxReplyInsertController`** (`/rinsert.bo`)
  - `doPost()` — Ajax 기반 댓글 작성
- **`AjaxDeleteReplyController`** (`/rdelete.bo`)
  - `doPost()` — Ajax 기반 댓글 삭제

#### **com.kh.mybatis.service.BoardService**

##### **일반 게시판 서비스**
- `selectAllBoard(PageInfo pi): ArrayList<Board>` — **PageInfo 기반** 게시글 목록 조회
- `selectAllBoardCount(): int` — 게시글 총 개수 조회
- `selectSearchBoard(HashMap<String, String> searchMap, PageInfo pi): ArrayList<Board>` — **검색 조건에 맞는** 게시글 목록 조회
- `selectSearchBoardCount(HashMap<String, String> searchMap): int` — **검색 조건에 맞는** 게시글 총 개수 조회
- `insertBoard(Board b, Attachment at): int` — **첨부파일을 포함한** 게시글 작성
- `updateBoard(Board b, Attachment at): int` — **첨부파일을 포함한** 게시글 수정
- `selectBoardByBoardNo(int boardNo): Board` — 게시글 상세 조회
- `selectAttachment(int boardNo): Attachment` — 첨부파일 조회
- `selectAllCategory(): ArrayList<Category>` — 카테고리 목록 조회
- `deleteBoard(int boardNo): int` — 게시글 삭제
- `increaseCount(int boardNo): int` — 조회수 증가

##### **썸네일 게시판 서비스**
- `selectThumbnailList(): ArrayList<Board>` — 썸네일 게시글 목록 조회
- `selectThumbnailBoardByBoardNo(int boardNo): Board` — 썸네일 게시글 상세 조회
- `insertThumbnailBoard(Board b, ArrayList<Attachment> list): int` — **다중 이미지를 포함한** 썸네일 게시글 작성
- `selectAttachmentList(int boardNo): ArrayList<Attachment>` — 첨부파일 리스트 조회

##### **댓글 서비스**
- `insertReply(Reply r): int` — 댓글 작성
- `selectReplyByBoardNo(int boardNo): ArrayList<Reply>` — 댓글 목록 조회
- `deleteReply(int replyNo): int` — 댓글 삭제

#### **com.kh.mybatis.model.vo 패키지**
- **`Board`** — 게시글 정보 VO 클래스 (Lombok 사용)
- **`Attachment`** — 첨부파일 정보 VO 클래스 (Lombok 사용)
  - 원본 파일명, 변경된 파일명, 파일 경로, 파일 레벨, 업로드 날짜 등 포함
- **`Reply`** — 댓글 정보 VO 클래스 (Lombok 사용)
- **`Category`** — 카테고리 정보 VO 클래스
- **`Member`** — 회원 정보 VO 클래스 (Lombok 사용)

#### **com.kh.mybatis.common.vo 패키지**
- **`PageInfo`** — **페이지네이션 정보 VO 클래스**
  - 현재 페이지, 총 게시글 수, 페이지 제한, 게시글 제한
  - 최대 페이지, 시작 페이지, 끝 페이지 자동 계산

### **🔧 공통 유틸리티**
- **`com.kh.mybatis.common.Template`** — **MyBatis SqlSession 관리**
  - `getSqlSession(): SqlSession` — MyBatis SqlSession 생성 및 반환
  - 수동 커밋 모드로 트랜잭션 제어
- **`com.kh.mybatis.model.dao.MemberDao`** — 회원 관련 DB 접근 로직 (MyBatis)
- **`com.kh.mybatis.model.dao.BoardDao`** — 게시판 관련 DB 접근 로직 (MyBatis)
  - `selectAllBoard(SqlSession sqlSession, PageInfo pi): ArrayList<Board>` — 페이징 처리된 게시글 목록 조회
  - `selectAllBoard(SqlSession sqlSession, HashMap<String, String> searchMap, PageInfo pi): ArrayList<Board>` — 검색 조건과 페이징을 포함한 게시글 목록 조회
  - `selectSearchBoardCount(SqlSession sqlSession, HashMap<String, String> searchMap): int` — 검색 조건에 맞는 게시글 수 조회

### **🎨 뷰 페이지**

#### **공통 페이지**
- **`views/common/menubar.jsp`** — 공통 네비게이션 및 로그인 폼
- **`views/common/error.jsp`** — 에러 페이지

#### **회원 관리 페이지**
- **`views/member/enrollForm.jsp`** — 회원가입 폼
- **`views/member/myPage.jsp`** — 마이페이지

#### **일반 게시판 페이지**
- **`views/board/listView.jsp`** — 게시글 목록 (**PageInfo 기반 페이지네이션** + **검색 기능**)
- **`views/board/detailView.jsp`** — 게시글 상세보기 (첨부파일 다운로드 및 댓글 포함)
- **`views/board/enrollForm.jsp`** — 게시글 작성 폼 (**파일 업로드 기능**)
- **`views/board/updateForm.jsp`** — 게시글 수정 폼 (**기존 파일 표시 및 새 파일 업로드**)

#### **썸네일 게시판 페이지**
- **`views/board/thumbnailListView.jsp`** — 썸네일 게시글 목록 (썸네일 이미지 그리드)
- **`views/board/thumbnailDetailView.jsp`** — 썸네일 게시글 상세보기 (대표이미지 + 상세이미지)
- **`views/board/thumbnailEnrollForm.jsp`** — 썸네일 게시글 작성 폼 (**다중 이미지 업로드 기능**)

---

## 🚀 핵심 구현 기능

### **🗄️ MyBatis ORM 시스템**
- **MyBatis 3.5.19** 프레임워크 활용
- **SQL 매퍼 XML**을 통한 쿼리 관리
- **ResultMap**을 활용한 복잡한 객체 매핑
- **동적 쿼리** (`<choose>`, `<when>`, `<otherwise>`) 구현
- **별칭(Alias)** 설정으로 간편한 타입 매핑
- **커넥션 풀** 설정으로 성능 최적화

### **🔍 검색 시스템**
- **다중 조건 검색**: 제목, 내용, 작성자별 검색
- **동적 쿼리**: MyBatis의 `<choose>` 태그를 활용한 조건부 쿼리
- **페이징 연동**: 검색 결과에 대한 페이지네이션 처리
- **검색 상태 유지**: 검색 조건과 키워드를 페이지 이동 시에도 유지

### **📁 파일 업로드 시스템**
- **Apache Commons FileUpload2 라이브러리** 활용
- **multipart/form-data** 방식으로 파일 전송
- **고유 파일명 생성**: `kh_타임스탬프_랜덤값.확장자` 형식
- **파일 크기 제한**: 개별 파일 50MB, 전체 요청 60MB
- **기존 파일 관리**: 수정 시 기존 파일 자동 삭제 후 새 파일 업로드
- **에러 처리**: 실패 시 업로드된 파일 자동 정리

### **🖼️ 썸네일 게시판 시스템**
- **다중 이미지 업로드**: 대표이미지(1개) + 상세이미지(최대 3개)
- **파일 레벨 구분**: 
  - `FILE_LEVEL = 1`: 대표이미지 (썸네일)
  - `FILE_LEVEL = 2`: 상세이미지
- **이미지 미리보기**: JavaScript FileReader API를 활용한 실시간 미리보기
- **그리드 레이아웃**: 썸네일 목록을 카드 형태의 그리드로 표시
- **별도 저장 경로**: `resources/thumbnail-file/` 폴더에 썸네일 이미지 저장

### **💬 Ajax 댓글 시스템**
- **실시간 댓글**: 페이지 새로고침 없이 댓글 작성/삭제
- **JSON 통신**: Gson 라이브러리를 활용한 JSON 데이터 교환
- **비동기 처리**: Ajax를 통한 서버와의 비동기 통신
- **사용자 경험**: 즉시 반영되는 댓글 시스템으로 향상된 UX

### **📄 페이지네이션 시스템**
- **PageInfo 클래스** 기반의 체계적인 페이지네이션
- **자동 계산**: 최대 페이지, 시작 페이지, 끝 페이지 자동 계산
- **재사용성**: 다른 컨트롤러에서도 쉽게 활용 가능
- **일관성**: 모든 페이지네이션 정보를 하나의 객체로 관리

### **🔄 트랜잭션 관리**
- **MyBatis 수동 커밋** 모드 활용
- **게시글과 첨부파일**을 하나의 트랜잭션으로 처리
- **다중 이미지 처리**: 썸네일 게시글의 여러 이미지를 하나의 트랜잭션으로 처리
- **데이터 일관성** 보장
- **롤백 처리**: 실패 시 모든 변경사항 취소 및 업로드된 파일 자동 정리

---

## 🎨 UI/UX 디자인 특징

### **🏠 전체 디자인 컨셉**
- **모던한 카드 기반 레이아웃**: 각 페이지가 카드 형태로 구성되어 깔끔하고 현대적인 느낌
- **Bootstrap 5.3.3 활용**: 반응형 디자인과 일관된 UI 컴포넌트 사용
- **Noto Sans KR 폰트**: 한글 가독성을 위한 구글 웹폰트 적용
- **일관된 색상 체계**: 메인 컬러 `#4b89fc` (파란색) 기반의 통일된 디자인

### **🧭 공통 네비게이션 (menubar.jsp)**
- **상단 헤더**: "Welcome KH World" 타이틀과 하단 보더라인
- **로그인 영역**: 
  - 비로그인 시: 아이디/비밀번호 입력 폼 + 로그인/회원가입 버튼
  - 로그인 시: 환영 메시지 + 마이페이지/로그아웃 버튼
- **네비게이션 바**: 다크 테마의 수평 메뉴 (HOME, 공지사항, 일반게시판, 사진게시판)
- **호버 효과**: 메뉴 항목에 노란색(`#ffc107`) 호버 효과

### **👤 회원 관리 페이지**

#### **회원가입 폼 (enrollForm.jsp)**
- **중앙 정렬 레이아웃**: `flexbox`를 활용한 수직 중앙 정렬
- **테이블 기반 폼**: 깔끔한 2열 구조 (입력필드 + 버튼)
- **중복확인 기능**: Ajax 기반 아이디 중복확인 버튼
- **관심분야 체크박스**: 7개 항목의 다중 선택 (운동, 등산, 낚시, 요리, 게임, 영화, 기타)
- **버튼 그룹**: 회원가입/다시입력 버튼의 중앙 정렬

#### **마이페이지 (myPage.jsp)**
- **카드 디자인**: 흰색 배경에 그림자 효과가 있는 카드 레이아웃
- **정보 표시**: 읽기 전용 필드(아이디, 이름)와 수정 가능 필드 구분
- **관심분야 표시**: JavaScript로 기존 선택값 자동 체크
- **모달 팝업**: 
  - 비밀번호 변경: 현재/새 비밀번호 입력 폼
  - 회원탈퇴: 경고 메시지와 비밀번호 확인
- **버튼 색상 구분**: 정보수정(초록), 비밀번호변경(노랑), 회원탈퇴(빨강)

### **📝 게시판 관리 페이지**

#### **게시글 목록 (listView.jsp)**
- **테이블 디자인**: 
  - 헤더: 파란색 배경(`#4b89fc`)의 고정 헤더
  - 행 호버 효과: 마우스 오버 시 배경색 변경 + 살짝 위로 이동 애니메이션
- **글쓰기 버튼**: 우상단의 파란색 "글쓰기" 버튼
- **검색 기능**: 
  - 검색 조건 선택 (제목, 내용, 작성자)
  - 검색어 입력 및 검색 버튼
  - 검색 상태 유지 (선택된 조건과 입력된 키워드 표시)
- **빈 상태 처리**: 게시글이 없을 때 안내 메시지
- **페이지네이션**: 
  - 현재 페이지는 진한 파란색으로 강조
  - 이전/다음 버튼의 활성화/비활성화 상태 구분
  - 페이지 정보 표시 (총 게시글 수, 현재 페이지)

#### **게시글 작성 폼 (enrollForm.jsp)**
- **카테고리 선택**: 드롭다운으로 7개 카테고리 선택 (공통, 운동, 등산, 게임, 낚시, 요리, 기타)
- **제목/내용 입력**: 
  - 제목: 한 줄 텍스트 입력
  - 내용: 10줄 높이의 텍스트에리어 (크기 조절 불가)
- **첨부파일**: **multipart/form-data 방식의 파일 업로드 기능**
- **버튼 그룹**: 작성하기(파란색)/취소하기(회색) 버튼

#### **게시글 수정 폼 (updateForm.jsp)**
- **기존 정보 표시**: 카테고리, 제목, 내용의 기존 값 자동 입력
- **첨부파일 관리**: 
  - 기존 파일이 있는 경우: 파일명 표시 + 새 파일 업로드 옵션
  - 기존 파일이 없는 경우: 새 파일 업로드 옵션
  - 사용자 안내 메시지: "새로운 파일을 선택하면 기존 파일이 교체됩니다"
- **버튼 그룹**: 수정하기(파란색)/취소하기(회색) 버튼

#### **썸네일 게시글 작성 폼 (thumbnailEnrollForm.jsp)**
- **이미지 업로드 영역**: 
  - 대표이미지: 클릭하여 선택하는 큰 영역 (필수)
  - 상세이미지: 3개의 작은 영역 (선택사항)
- **실시간 미리보기**: JavaScript FileReader API로 선택한 이미지 즉시 표시
- **드래그 앤 드롭 스타일**: 점선 테두리와 호버 효과로 직관적인 UI
- **파일 선택 숨김**: 실제 file input은 숨기고 커스텀 UI로 대체

#### **썸네일 게시글 목록 (thumbnailListView.jsp)**
- **그리드 레이아웃**: 카드 형태의 썸네일 이미지 그리드
- **반응형 디자인**: 화면 크기에 따라 자동으로 열 개수 조정
- **호버 효과**: 마우스 오버 시 카드가 살짝 위로 이동하는 애니메이션
- **이미지 최적화**: object-fit: cover로 일관된 이미지 비율 유지

#### **썸네일 게시글 상세보기 (thumbnailDetailView.jsp)**
- **대표이미지 영역**: 큰 크기로 대표이미지 표시
- **상세이미지 영역**: 여러 상세이미지를 가로로 나열
- **이미지 확대 효과**: 호버 시 이미지가 살짝 확대되는 효과
- **일관된 디자인**: 일반 게시판과 동일한 테이블 레이아웃 유지

---

## 🗂️ MyBatis 설정 및 매퍼

### **MyBatis 설정 (mybatis-config.xml)**
- **데이터베이스 연결**: Oracle 데이터베이스 연결 정보
- **별칭 설정**: VO 클래스들의 간편한 별칭 등록
- **매퍼 등록**: member-mapper.xml, board-mapper.xml 등록
- **설정 옵션**: jdbcTypeForNull 처리 등

### **매퍼 XML 파일**
- **member-mapper.xml**: 회원 관련 SQL 쿼리
- **board-mapper.xml**: 게시판 관련 SQL 쿼리
  - **동적 쿼리**: 검색 조건에 따른 조건부 쿼리
  - **ResultMap**: 복잡한 객체 매핑 설정
  - **JOIN 쿼리**: 여러 테이블 조인을 통한 데이터 조회

---

## 🔧 라이브러리 의존성

### **WEB-INF/lib 폴더**
- **mybatis-3.5.19.jar**: MyBatis ORM 프레임워크
- **ojdbc17.jar**: Oracle JDBC 드라이버
- **commons-fileupload2-core-2.0.0-M4.jar**: 파일 업로드 핵심 라이브러리
- **commons-fileupload2-jakarta-2.0.0-M1.jar**: Jakarta Servlet 파일 업로드 라이브러리
- **commons-io-2.20.0.jar**: 파일 I/O 유틸리티
- **gson-2.10.1.jar**: JSON 직렬화/역직렬화
- **jakarta.servlet.jsp.jstl-3.0.1.jar**: JSTL 라이브러리
- **jakarta.servlet.jsp.jstl-api-3.0.2.jar**: JSTL API
- **lombok.jar**: Lombok 어노테이션 처리

---

## 🚀 배포 및 실행

### **개발 환경**
- **Java**: JDK 17 
- **IDE**: Eclipse IDE
- **서버**: Apache Tomcat 11.0 이상
- **데이터베이스**: Oracle 11g 이상

### **실행 방법**
1. Oracle 데이터베이스 실행
2. Eclipse에서 프로젝트 Import
3. Tomcat 서버 설정 및 프로젝트 배포
4. 브라우저에서 `http://localhost:8080/mybatisProject` 접속

---

## 📝 주요 특징 요약

- **MyBatis ORM**: SQL 매퍼를 통한 효율적인 데이터베이스 연동
- **MVC 패턴**: Controller, Service, DAO 계층 분리
- **검색 기능**: 제목, 내용, 작성자별 동적 검색
- **파일 업로드**: 일반 게시글 및 썸네일 게시글 파일 업로드
- **페이지네이션**: PageInfo 클래스 기반 체계적인 페이징
- **Ajax 댓글**: 실시간 댓글 시스템
- **반응형 UI**: Bootstrap 기반 모던한 사용자 인터페이스
- **트랜잭션 관리**: MyBatis 수동 커밋을 통한 데이터 일관성 보장

이 프로젝트를 통해 **MyBatis ORM 프레임워크**의 활용법과 **JSP/Servlet 기반 MVC 패턴**의 구현 방법을 학습할 수 있습니다.
