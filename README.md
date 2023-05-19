# Spring 프레임 워크를 적용한 HTTP Server
Java_HTTP_Server 프로젝트에서는 직접 HTTP 프로토콜을 자바코드로 구현하여 HTTP Server를 만들었다.

Spring_HTTP_Server에서는 Spring MVC 프레임 워크를 사용하여 전 프로젝트와 같은 기능의 HTTP Server를 구현한다.

이 프로젝트의 목표는 
Spring Container와 Spring MVC 그리고 MockMVC를 활용한 컨트롤러 테스트까지 전반적인 Spring HTTP Server에 대한 이해와 사용법을 익히는 것이다.
### 서버가 제공하는 동작
-   GET api/time -> 현재 시간을 json 에 담아서 알려줌(크롬 브라우저 통신 가능)
-   POST api/text/{textid} -> Body로 전달된 문자열을 서버가 저장
-   GET api/text/{textid} -> 저장된 문자열을 알려줌
-   DELETE api/text/{textid} -> 저장된 문자열을 삭제
-   GET api/image -> jpeg 이미지를 다운로드

# 블로그 포스트

[SpringBoot 설정 파일 기능 활용(Profile나누기, 환경 변수 설정, 설정 파일 분리, group하기)](https://coding-business.tistory.com/37)

&nbsp;&nbsp;&nbsp;[YAML 개념과 특징 이해](https://coding-business.tistory.com/11)

**<spring mvc에 대한 이해>**

[Spring Container와 bean에 대한 이해](https://coding-business.tistory.com/16)

[Spring MVC 구조와 기본 사용법](https://coding-business.tistory.com/19)

&nbsp;&nbsp;&nbsp;[Spring MVC 패턴에 대한 이해](https://coding-business.tistory.com/12)

&nbsp;&nbsp;&nbsp;[Spring MVC 테스트 방법](https://coding-business.tistory.com/10)

# 서버 동작
