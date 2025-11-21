# 🎮 JDBC 인생게임 프로젝트 Controller 분석 - MVC 패턴으로 구현한 콘솔 게임

## 📝 프로젝트 개요

이번에 분석한 프로젝트는 **JDBC를 활용한 콘솔 기반 인생 시뮬레이션 게임**입니다. 사용자가 가상의 인생을 살면서 주식 투자, 부동산 구매, 업적 달성 등의 요소를 경험할 수 있는 게임으로, **MVC(Model-View-Controller) 패턴**을 적용하여 체계적으로 구현되었습니다.

## 🏗️ 아키텍처 구조

```
Controller Layer
├── LifeCharacterController  (캐릭터 관리)
├── StockController         (주식 거래)
├── AchievementController   (업적 시스템)
└── UserController         (사용자 인증)
```

## 🔍 Controller별 상세 분석

### 1. 🎭 LifeCharacterController - 게임의 핵심

**역할**: 게임 캐릭터의 모든 핵심 기능을 관리

```java
public class LifeCharacterController {
    private LifeCharacterService lcs = new LifeCharacterService();
    
    // 새 캐릭터 생성 및 게임 시작
    public void createNewCharacter(String characterName, String accessId) {
        LifeCharacter life = new LifeCharacter(characterName, accessId);
        int result = lcs.createNewCharacter(life);
        if(result > 0) {
            displaySuccess("인생게임을 시작합니다.");
            new LifegameMenu(life).gameMain();
        } else {
            displayFail("게임 시작에 실패하였습니다.");
        }
    }
}
```

**주요 기능**:
- ✅ **캐릭터 생성**: 새 캐릭터 생성 후 게임 메뉴로 이동
- ✅ **캐릭터 업데이트**: 일하기/자기개발 후 상태 업데이트
- ✅ **주식 거래**: 주식 매매 처리
- ✅ **부동산 구매**: 부동산 투자 기능
- ✅ **쇼핑**: 아이템 구매 기능
- ✅ **랭킹 조회**: 전체 플레이어 순위 확인

### 2. 📈 StockController - 주식 투자 시스템

**역할**: 주식 거래의 모든 기능을 담당

```java
public class StockController {
    // 주식 구매
    public void buyStock(int characterId, int stockId, int count, int price) {
        int result = ss.buyStock(characterId, stockId, count, price);
        if(result > 0) {
            displaySuccess("주식 구매가 완료되었습니다.");
        } else {
            displayFail("주식 구매에 실패했습니다.");
        }
    }
}
```

**주요 기능**:
- 📊 **가격 관리**: 모든 주식 가격 실시간 업데이트
- 💰 **거래 처리**: 주식 매수/매도 기능
- 📋 **정보 조회**: 주식 목록 및 현재 가격 조회
- 💎 **포트폴리오**: 총 주식 가치 계산

**특징**:
- `@Deprecated` 어노테이션으로 하위 호환성 유지
- 주식 ID별 개별 관리 가능
- 실시간 가격 변동 시스템

### 3. 🏆 AchievementController - 업적 시스템

**역할**: 게임의 재미 요소인 업적 시스템 관리

```java
public class AchievementController {
    public void checkAchievements(LifeCharacter life, String endReason) {
        List<Integer> newAchievements = checkAllAchievements(life, endReason);
        
        int actualNewAchievements = 0;
        for(Integer achievementId : newAchievements) {
            if (!as.isAlreadyAchieved(life.getUserId(), achievementId)) {
                as.updateAchievement(life.getUserId(), achievementId);
                actualNewAchievements++;
            }
        }
        
        if(actualNewAchievements > 0) {
            System.out.println("✨✨✨✨  달성된 업적이 있습니다!");
        }
    }
}
```

**주요 기능**:
- 🎯 **업적 달성**: 게임 진행에 따른 업적 자동 체크
- 📜 **업적 목록**: 달성한 업적 조회
- 🔄 **초기화**: 신규 사용자 업적 시스템 초기화
- ⭐ **중복 방지**: 이미 달성한 업적 재달성 방지

### 4. 👤 UserController - 사용자 인증

**역할**: 사용자 계정 관리 및 인증 처리

```java
public class UserController {
    public void loginUser(String userId, String userPw) {
        User u = new User(userId, userPw);
        boolean result = us.loginUser(u);
        
        if(result) {
            displaySuccess(userId + "님 환영합니다!");
            new MainMenu(userId).gameLobby();
        } else {
            displayFail("로그인에 실패하였습니다.");
        }
    }
}
```

**주요 기능**:
- 🔐 **로그인**: 사용자 인증 및 메인 메뉴 이동
- 📝 **회원가입**: 신규 사용자 등록 및 업적 시스템 초기화
- 🎮 **게임 연동**: 인증 성공 시 게임 로비로 자동 이동

## 🎯 설계 패턴의 장점

### 1. **책임 분리 (Separation of Concerns)**
- 각 Controller가 명확한 도메인을 담당
- 코드의 가독성과 유지보수성 향상

### 2. **MVC 패턴 적용**
```
Controller → Service → DAO → Database
```
- 비즈니스 로직과 데이터 접근 로직 분리
- 확장성과 테스트 용이성 확보

### 3. **사용자 경험 고려**
- 모든 작업에 성공/실패 피드백 제공
- 직관적인 메시지 시스템

### 4. **확장성**
- 각 기능이 독립적으로 구현
- 새로운 기능 추가 시 기존 코드 영향 최소화

## 💡 학습 포인트

### 1. **JDBC 활용**
- 데이터베이스 연동을 통한 영속성 관리
- 트랜잭션 처리 및 데이터 무결성 보장

### 2. **객체지향 설계**
- 캡슐화, 상속, 다형성 원칙 적용
- 인터페이스와 구현체 분리

### 3. **게임 로직 구현**
- 복잡한 게임 시스템을 체계적으로 구조화
- 사용자 인터랙션과 데이터 처리의 분리

## 🚀 개선 제안

### 1. **예외 처리 강화**
```java
try {
    int result = lcs.createNewCharacter(life);
    // 성공 처리
} catch (SQLException e) {
    displayFail("데이터베이스 오류가 발생했습니다.");
} catch (Exception e) {
    displayFail("예상치 못한 오류가 발생했습니다.");
}
```

### 2. **로깅 시스템 도입**
- 게임 진행 상황 추적
- 디버깅 및 모니터링 용이성

### 3. **설정 파일 분리**
- 데이터베이스 연결 정보 외부화
- 게임 설정값 관리

## 📊 결론

이 JDBC 인생게임 프로젝트는 **MVC 패턴을 활용한 콘솔 게임의 훌륭한 예시**입니다. 

**장점**:
- ✅ 체계적인 아키텍처 설계
- ✅ 명확한 책임 분리
- ✅ 확장 가능한 구조
- ✅ 사용자 친화적 인터페이스

**학습 가치**:
- 🎓 JDBC를 활용한 데이터베이스 연동
- 🎓 MVC 패턴의 실제 적용
- 🎓 객체지향 설계 원칙
- 🎓 게임 개발의 기본 구조

이런 프로젝트를 통해 **실무에서 사용되는 설계 패턴과 개발 방법론**을 체험할 수 있어, 개발자로서의 역량 향상에 큰 도움이 될 것입니다.

---

*이 분석을 통해 MVC 패턴의 실제 적용 사례와 JDBC를 활용한 데이터 관리 방법을 학습할 수 있습니다. 더 자세한 코드 분석이나 특정 부분에 대한 질문이 있으시면 언제든 댓글로 남겨주세요!* 🚀












