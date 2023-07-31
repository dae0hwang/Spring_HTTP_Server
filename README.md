## 프로젝트 목표
이 프로젝트의 목표는 Spring MVC기술과 Container 기술을 공부하고 적용하여 웹서버의 틀을 만들고,  

JDBC-Mysql 기술을 적용하여 영구적인 텍스트 데이터 관리를 하는 방법을 익히는 것입니다.   
## 기술 스택
언어 : Java11  
DB : MySQL 8.0  
라이브러리 : SpringBoot 2.7.3, JDBC
## 프로젝트 동작
-   GET api/time -> 현재 시간을 json 에 담아서 알려줌(크롬 브라우저 통신 가능)
-   POST api/text/{textId} -> Body로 전달된 문자열을 서버가 저장
-   GET api/text/{textId} -> 저장된 문자열을 알려줌
-   PUT api/text/{textId} -> 저장된 문자열을 수정
-   DELETE api/text/{textId} -> 저장된 문자열을 삭제
-   GET api/image -> jpeg 이미지를 보여줌
