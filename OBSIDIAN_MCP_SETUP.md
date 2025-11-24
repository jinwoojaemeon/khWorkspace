# 옵시디언 MCP와 Cursor 연결 가이드

## 사전 준비사항

1. **Python 설치** (옵시디언 MCP 서버 실행을 위해 필요)
   - Python 3.8 이상 버전 필요
   - [Python 공식 사이트](https://www.python.org/downloads/)에서 다운로드

2. **uv 설치** (Python 패키지 관리 도구)
   ```powershell
   pip install uv
   ```
   또는
   ```powershell
   pipx install uv
   ```

## 설정 단계

### 1단계: 옵시디언 MCP 서버 설치

PowerShell에서 다음 명령어 실행:

```powershell
# uv를 사용한 설치
uv tool run mcp-obsidian

# 또는 pip를 사용한 설치
pip install mcp-obsidian
```

### 2단계: 옵시디언 API 키 생성 및 설정

1. **옵시디언에서 API 키 생성**
   - 옵시디언 설정 → Community plugins → Remote HTTP API 플러그인 활성화
   - 또는 옵시디언의 API 키 생성 기능 사용

2. **환경 변수에 API 키 추가**
   
   **임시 설정 (현재 세션만 유효):**
   ```powershell
   $env:OBSIDIAN_API_KEY="your-api-key-here"
   ```
   
   **영구 설정 (시스템 환경 변수):**
   ```powershell
   [System.Environment]::SetEnvironmentVariable("OBSIDIAN_API_KEY", "your-api-key-here", "User")
   ```

3. **옵시디언 볼트 경로 설정**
   ```powershell
   $env:OBSIDIAN_VAULT_PATH="C:\Users\YourUsername\Documents\ObsidianVault"
   ```
   
   또는 영구 설정:
   ```powershell
   [System.Environment]::SetEnvironmentVariable("OBSIDIAN_VAULT_PATH", "C:\Users\YourUsername\Documents\ObsidianVault", "User")
   ```

### 3단계: Cursor에서 MCP 서버 설정

1. **Cursor 설정 열기**
   - Cursor 실행
   - 우측 상단의 설정(톱니바퀴) 아이콘 클릭
   - 또는 `Ctrl + ,` (설정 단축키)

2. **MCP 탭으로 이동**
   - 설정 메뉴에서 "MCP" 또는 "Model Context Protocol" 탭 선택

3. **새 MCP 서버 추가**
   - "Add MCP Server" 또는 "새로운 글로벌 MCP 서버 추가" 버튼 클릭

4. **MCP 서버 설정 입력**
   
   다음 JSON 형식으로 입력:
   
   ```json
   {
     "mcpServers": {
       "obsidian": {
         "command": "uv",
         "args": [
           "tool",
           "run",
           "mcp-obsidian"
         ],
         "env": {
           "OBSIDIAN_API_KEY": "your-api-key-here",
           "OBSIDIAN_VAULT_PATH": "C:\\Users\\YourUsername\\Documents\\ObsidianVault"
         }
       }
     }
   }
   ```
   
   또는 Python을 직접 사용하는 경우:
   
   ```json
   {
     "mcpServers": {
       "obsidian": {
         "command": "python",
         "args": [
           "-m",
           "mcp_obsidian"
         ],
         "env": {
           "OBSIDIAN_API_KEY": "your-api-key-here",
           "OBSIDIAN_VAULT_PATH": "C:\\Users\\YourUsername\\Documents\\ObsidianVault"
         }
       }
     }
   }
   ```

### 4단계: MCP 서버 활성화

1. 추가한 MCP 서버 옆의 토글을 켜서 활성화
2. Cursor를 재시작하여 설정 적용

### 5단계: 연결 확인

1. Cursor에서 MCP 서버 상태 확인
2. 옵시디언 노트를 Cursor에서 읽거나 쓸 수 있는지 테스트

## 문제 해결

### MCP 서버가 연결되지 않는 경우

1. **환경 변수 확인**
   ```powershell
   echo $env:OBSIDIAN_API_KEY
   echo $env:OBSIDIAN_VAULT_PATH
   ```

2. **옵시디언 경로 확인**
   - 경로에 백슬래시(`\`) 대신 슬래시(`/`) 사용 시도
   - 또는 이중 백슬래시(`\\`) 사용

3. **Python 경로 확인**
   ```powershell
   python --version
   where python
   ```

4. **MCP 서버 수동 실행 테스트**
   ```powershell
   uv tool run mcp-obsidian
   ```
   또는
   ```powershell
   python -m mcp_obsidian
   ```

### Cursor에서 MCP 설정 파일 위치

Windows에서 Cursor의 MCP 설정 파일은 보통 다음 위치에 있습니다:
- `%APPDATA%\Cursor\User\mcp.json`
- 또는 Cursor 설정 UI에서 직접 관리

## 참고 자료

- [Cursor MCP 문서](https://docs.cursor.com/context/mcp)
- [옵시디언 MCP 서버 GitHub](https://github.com/modelcontextprotocol/servers)

