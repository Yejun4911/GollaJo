# Encore WebProject 4조_골라조
### 2021 encore playdata web project - GollaJo
  
# 소개
### 1. 소개
### 음식물 쓰레기 문제 해결을 위한 식재료 지능화 관리
  * 식재료 구매부터 폐기까지 정보 및 기능 제공
    * 검색을 통해 식재료 정보와 폐기 방법 제공
    * Google Dialogflow를 이용한 챗봇 제공
  * 식재료 보관기한 DB를 이용한 유기적인 식재료 관리
    * 식재료, 레시피, 장바구니를 유기적으로 연결하여 식재료 자동화 관리
    * Firebase를 이용한 식재료 보관기한 임박 푸시 알림
  * 레시피 추천 알고리즘(협업 필터링)
### 보통의 냉장고를 스마트 냉장고화
  * 국내 스마트 냉장고의 기술을 갖고 있는 앱 서비스
  * IOT 장비를 이용한 냉장고 원격 관리

### 2. 웹사이트
### 링크 : [GollaJo.shop](https://www.gollajo.shop/)
![Main](https://user-images.githubusercontent.com/61110132/118910003-ccdc8300-b95e-11eb-8205-0bcc43740d9f.PNG)


# 프로젝트 총평
### 피드백
  * 1
  * 2
  * 3
  * 4
  * 5
### 기대효과
  * 1

# Architecture
### MVC 패턴
이미지

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

### 2. Usecase Diagram    

  </div>
</details>

# 설계
<details>
  <summary>상세 내용 확인</summary>
  <div markdown="1">
    
### 1. S/W
![image](https://user-images.githubusercontent.com/67588446/111156860-8de62600-85d9-11eb-8c2c-d820330bb290.png)
### 2. H/W
![image](https://user-images.githubusercontent.com/67588446/111154512-a4d74900-85d6-11eb-9773-dd0cada70bfb.png)
### 3. 서비스흐름도
![image](https://user-images.githubusercontent.com/67588446/111154553-ae60b100-85d6-11eb-968f-a947ceb3ea2c.png)
### 4. ERD
![image](https://user-images.githubusercontent.com/67588446/111985595-24719480-8b50-11eb-8958-df8a0c61104a.png)

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





## [SRS](https://github.com/EncoreWebProject4/WebProject/wiki/02_SRS)


## [UseCaseDiagram](https://github.com/EncoreWebProject4/WebProject/wiki/03_Usecase-Diagram)


## [DB Modeling](https://github.com/EncoreWebProject4/WebProject/wiki/05_DB-Modeling)


## [Front UI](https://www.figma.com/file/t0e6q0jOrxtnGzL7RSpYdC/%EA%B3%A8%EB%9D%BC%EC%A1%B0_ver_0)

## [Business Logic](https://github.com/EncoreWebProject4/WebProject/wiki/04_Business-Logic)















### [회의록](https://github.com/EncoreWebProject4/WebProject/issues)



---------------

## Encore WebProject 4조_골라조

# 소개
# 주제





## [SRS](https://github.com/EncoreWebProject4/WebProject/wiki/02_SRS)


## [UseCaseDiagram](https://github.com/EncoreWebProject4/WebProject/wiki/03_Usecase-Diagram)


## [DB Modeling](https://github.com/EncoreWebProject4/WebProject/wiki/05_DB-Modeling)


## [Front UI](https://www.figma.com/file/t0e6q0jOrxtnGzL7RSpYdC/%EA%B3%A8%EB%9D%BC%EC%A1%B0_ver_0)

## [Business Logic](https://github.com/EncoreWebProject4/WebProject/wiki/04_Business-Logic)















### [회의록](https://github.com/EncoreWebProject4/WebProject/issues)
