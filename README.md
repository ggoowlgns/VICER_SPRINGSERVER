# VICER_SPRINGSERVER

## 소개
클라이언트가 어플을 통하여 로그인, 회원가입, 시리얼 번호를 http통신으로 확인하기 위한 Web Server

#### Web Server 기능
* 자바 플랫폼을 위한 오픈소스 애플리케이션 프레임 워크인 Spring을 사용하여 안드로이드와 연동을 통해
데이터베이스로 접근 시 보안적인 이슈를 해결 할 수 있으며 쉽게 App과 Web간의 통신이 가능하다.

## 개발환경 설정 실행환경
eclipse를 사용하여 Spring Web Server를 구현하였다.

### Eclipse
* Eclipse 설치를 위해서 홈페이지에 가보면 다양한 Eclipse를 볼 수 있다.
그것들은 마치 STS와 동일한 것들이라고 보면 된다. C/C++ 를 위한 Eclipse, PHP를 위한 Eclipse, java를 위한
Eclipse 등 많은 Eclipse 통합 제품들을 제공하는데 우리는 Java EE를 위한 Eclipse를 아래의 링크에서 다운받는다.
   * www.eclipse.org
   <img src="./img/이클립스다운.png">
* Spring 환경설정
   * Spring Tools Suite Plugin 설치
   Plugin 설치는 Marketplace를 이용해서 아주 쉽게 할 수 있다. 
   'Help'메뉴 -> Eclipse Marketplace를 클릭하면 MarketPlace가 실행된다.
   <img src="./img/STS설치.png">
   위 화면과 같이 'Spring'으로 검색해서 나오는 'Spring IDE 3.7.3.RELEASE'에 install 클릭해준다.
   * Maven 설정
