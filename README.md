# Spring 프레임워크를 적용한 HTTP Server
이 프로젝트의 목표는 Spring MVC기술과 Container 기술을 공부하고 적용하여 웹서버의 틀을 만들고,  
JDBC-Mysql 기술을 적용하여 영구적인 텍스트 데이터 관리를 하는 방법을 익히는 것입니다.   

### 서버가 제공하는 동작
-   GET api/time -> 현재 시간을 json 에 담아서 알려줌(크롬 브라우저 통신 가능)
-   POST api/text/{textId} -> Body로 전달된 문자열을 서버가 저장
-   GET api/text/{textId} -> 저장된 문자열을 알려줌
-   PUT api/text/{textId} -> 저장된 문자열을 수정
-   DELETE api/text/{textId} -> 저장된 문자열을 삭제
-   GET api/image -> jpeg 이미지를 보여줌

# 서버 동작
### 1. GET api/time 현재 시간을 json 에 담아서 알려줌(크롬 브라우저 통신 가능)
![gettime](https://github.com/dae0hwang/Spring_HTTP_Server/assets/103154389/2d508f71-58d4-42f6-a593-c49f53ebf0a4)
### 2. POST api/text/{textId} Body로 전달된 문자열을 서버가 저장
![postText](https://github.com/dae0hwang/Spring_HTTP_Server/assets/103154389/5fc5dd7d-629f-4123-aac2-0afa4e4867d8)
### 3. GET api/text/{textId} 저장된 문자열을 알려줌
![getText](https://github.com/dae0hwang/Spring_HTTP_Server/assets/103154389/212d7c99-609d-46b4-9fd0-9a261b2cabc5)
### 4. PUT api/text/{textId} 저장된 문자열을 수정
![putpost](https://github.com/dae0hwang/Spring_HTTP_Server/assets/103154389/d6fd566d-8510-4fb7-af36-4aae5e5ed563)
### 5. DELETE api/text/{textId} 저장된 문자열을 삭제
![delete](https://github.com/dae0hwang/Spring_HTTP_Server/assets/103154389/015faf23-abed-419e-b433-5c4205b6228b)
### 6. GET api/image jpeg 이미지를 보여줌
![getimage](https://github.com/dae0hwang/Spring_HTTP_Server/assets/103154389/01626e18-0cad-4d28-8edf-0e03561a759b)
