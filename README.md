# Encore WebProject 4조_골라조
### 2021 encore playdata web project - GollaJo
  
# 소개
### 1. 소개
### 의사 결정 도구
  * 현대 사회에는 수 많은 선택지가 존재한다. 많은 선택지들은 각자의 장점 및 단점을 가진다. 
이러한 이유로 선택의 기로에 놓였을 때 어려움을 겪는 사람들이 증가하고있다. 
결정을 해야하는 순간 이용자가 조금이라도 빠르고 편하게 결정을 할 수 있도록 돕고자 해당 프로젝트를 진행하게되었다.
언제나 고민인 음식 메뉴 선택, 약속 장소를 정하기 위한 중간 지점 선택, 그리고 단순히 예, 아니오의 문제를 속 시원히 해결해 주기위한
의사 결정 버튼으로 구성했다. 여기에 투표 기능을 담은 간단한 게시판을 추가했다
### 주제
  * 메뉴 선택, 중간 지점 선택, 의사 결정 버튼을 활용하여 이용자의 의사 결정을 돕는다.

### 2. 웹사이트
### 링크 : [GollaJo.shop](https://www.gollajo.shop/)
![image](https://user-images.githubusercontent.com/67588446/118912629-057e5b80-b963-11eb-836a-9e2b096cb051.png)


# 프로젝트 총평
### 1. 피드백
  *  음식을 취향으로 추천받을 경우 DB내부에 음식 종류가 약 150개 정도이므로 추천이 포괄적일 수 밖에 없었음. 
     추후에 DB와 구체적이고 추가적인 선택지를 추가, 보강하여 업데이트 한다면 더욱 확실한 결과 도출이 가능할 것으로 예상됨.
  *  중간지점 길찾기 할때 알고리즘과 프로젝트 전반적인 디테일이 부족함.
  *  가끔 몇 개의 페이지에서 내용이 많지 않은데도 불구하고 스크롤이 생성되는 등 약간의 허점이 발견됨.
  *  완벽한 프론트와 벡엔드 구현을 위해 실력을 필요
  *  프론트 작업 시 원하는 방향대로 되지 않아 약간의 현실적인 타협이 불가피했었던 점.
### 2. 기대효과
  *  추후 완벽하게 배포하였을 경우 결정을 어려워하는 사람들에게 식사 메뉴 선택, 친구와 만날 장소 선택, 실행 유무 결정, 커뮤니티 공간 등 다양한 방면으로 널리 활용될 것으로 기대됨.

# 개요
### 1. 개발환경

| 개발환경 | 버전  |
|----|----------|
|jQuery|3.6|
|Java(JDK)|1.8|
|Tomcat|8.5|
|MySQL|8.0|

### 2. Architecture
![image](https://user-images.githubusercontent.com/67588446/118913073-bedd3100-b963-11eb-9737-8d6cbad749f4.png)

# 분석
<details>
  <summary>상세 내용 확인</summary>
  <div markdown="1">
    
### 1. SRS
    
M : Main <br>
CF : ChoiceFood <br>
CR : ChoiceRoad <br>
CB : ChoiceButton<br>
B : Board <br>
    
| ID | 요구사항명  | 요구사항 내용 |
|----|----------|---------------|
| M-001| 메뉴 선택 | 중간 지점, 음식추천, 의사결정버튼 선택 | 
| M-002| 로그인| 로그인한다.|
| M-003| 로그아웃| 로그아웃한다.|
| M-004| 회원가입| 회원가입한다.|
| CF-001| 방법 선택 | 사용자가 취향과 상황 중 어떤 방법을 사용할지 선택한다. |
| CF-002| 메인으로 | 메인 화면으로 돌아간다. |
| CF-101| 취향 선택 | 취향을 선택하여 음식의 범위를 설정한다. | 
| CF-102| 취향 결과 | 선택한 범위내에 음식을 랜덤으로 화면에 출력한다. | 
| CF-103| 음식 재선택 | 결과 값이 마음에 들지 않는 경우 범위 내 다시 랜덤 |
| CF-104| 음식 재선택 결과 | 마음에 들지 않는 음식을 제외한 범위 내에서 음식을 랜덤으로 화면에 출력한다. |
| CF-105| 음식 선택 | 사용자가 결과값을 확정한여 결과 및 차트를 출력한다. |
| CF-106| 메인으로 | 메인 화면으로 돌아간다. |
| CF-201| 상황 선택 | 상황을 선택하여 음식의 범위를 화면에 출력한다. |
| CF-202| 상황 결과 | 선택한 범위내에 음식을 랜덤으로 선택한다. |
| CF-203| 음식 재선택 | 결과 값이 마음에 들지 않는 경우 범위내 다시 랜덤 | 
| CF-204| 음식 재선택 결과 | 마음에 들지 않는 음식을 제외한 범위 내에서 음식을 랜덤으로 화면에 출력한다. |
| CF-205| 음식 선택 | 사용자가 결과값을 확정한여 결과 및 차트를 출력한다. |
| CF-206| 메인으로 | 메인 화면으로 돌아간다. |
| CR-001| 위치 입력 | 각 사용자의 위치를 입력한다. | 
| CR-002| 중간 지점 출력 | 사용자들의 중간 지점을 결과를 화면에 출력한다. | 
| CR-003| 메인으로 | 메인 화면으로 돌아간다. |
| CB-001| 의사 결정 버튼 | 의사 결정 버튼을 누른다. |
| CB-002| 의사 결정 버튼 결과 출력 | 랜덤으로 YES or NO를 화면에 출력한다. |
| CB-003| 메인으로 | 메인 화면으로 돌아간다. |
| B-001| 게시글 목록| 게시판에서 목록을 확인한다.|
| B-002| 게시글 상세| 게시글을 상세히 확인한다.|
| B-003| 게시글 작성| 게시판에서 투표기능이 포함된 게시글을 작성한다.|
| B-004| 메인으로 | 메인 화면으로 돌아간다. |
| B-101| 게시글 수정| 게시판에서 글 수정한다.|
| B-102| 게시글 삭제| 게시판에서 글 삭제한다.|
| B-103| 댓글 조회| 게시글의 댓글을 확인한다.|
| B-104| 댓글 작성| 게시글에 댓글을 작성한다.|
| B-105| 댓글 수정| 댓글을 수정한다.|
| B-106| 댓글 삭제| 댓글을 삭제한다.|
| B-106| 댓글 좋아요| 댓글을 좋아요한다.|

### 2. Usecase
    * [UseCaseScenerio](https://github.com/EncoreWebProject4/WebProject/wiki/01_Usecase-Scenerio)
    * [UseCaseDiagram](https://github.com/EncoreWebProject4/WebProject/wiki/03_Usecase-Diagram)

  </div>
</details>

# 설계
<details>
  <summary>상세 내용 확인</summary>
  <div markdown="1">
    
### 1. DB Modeling
![image](https://user-images.githubusercontent.com/67588446/118913309-28f5d600-b964-11eb-9154-c55936aa3fdf.png)

### 2. Front UI
링크 : [Front UI](https://www.figma.com/file/t0e6q0jOrxtnGzL7RSpYdC/%EA%B3%A8%EB%9D%BC%EC%A1%B0_ver_0)
    
### 3. Logic
링크 : [Business Logic](https://github.com/EncoreWebProject4/WebProject/wiki/04_Business-Logic)


  </div>
</details>

# 개발환경
<details>
  <summary>상세 내용 확인</summary>
  <div markdown="1">
       
### BE
| 구분 | 개발환경 | 개발도구 | 개발언어 |
| ----- | --------- | --------- | --------- |
|Server|VSCode|Node.js|JavaScript|
|DB|HeidiSQL|MySQL|SQL|
|\*CF|Pycharm|-|Python|

\*CF : Collaborative Filtering  
  
### INFRA-AWS
| 구분 | 서비스 |
| --------- | ------------- |
|Computing|EC2 CentOS7|
|Storage|S3|
|CDN|CloudFront|
  
### FE
|구분|개발환경|개발도구|개발언어|
|--|--| -- |--|
|Front|Android Studio| - | Java |
  
  </div>
</details>

### [회의록](https://github.com/EncoreWebProject4/WebProject/issues)

