# weatherApplication

# 아이디어스 과제

## 사용 기술 스택

### 프로젝트 구성
- MVI 프레임워크
- Android Clean Architecture
### 의존성 주입
- Hilt
### 네트워크
- Retrofit2
### 비동기 처리
- Kotlin Coroutines
### 이미지 리소스
- Glide

## 프로젝트 설치 및 빌드 방법
> Android Studio 가 설치되어 있지 않다면 설치 부탁드립니다.
### 코드 확인 및 실행 시
1. 전송한 .zip 파일 압축 풀기
2. Android Studio 실행
3. Open 후 압축 풀기 된 폴더의 루트 위치 열기
4. Gradle Sync 후 Run 버튼 클릭 ( 에뮬레이터 혹은 실 기기 와 연결되어 있어야 함. )
### 코드 미확인 및 실행 시
1. 전송한 .zip 파일 압축 풀기
2. Android Studio 실행
3. Profile Or Debug 실행
4. 압축 풀기 된 폴더에서 빌드 완료된 Apk 클릭
5. 연결된 실 기기 혹은 에뮬레이터로 실행

## 프로젝트 사용법 및 기능
### 날씨 검색 페이지
1. "se" 로 검색어가 자동으로 지정된 뒤에, 그 위치의 woeid 를 이용해서 위치의 오늘과 내일 날씨를 Item 으로 반환해서 리스트로 보여줌. 

## 완료되지 않은 이슈
1. 처음 로딩이 되고 있을 때에도, SwipeRefreshLayout 이 구현되어 있음.
