# Spring 학습용 프로젝트 (2021.04.13 ~ )
## 학습 목표
* Spring의 MVC, AOP, JPA, Security, Unit Test, Log 등의 개념을 단계적으로 적용해 전반적인 Spring의 구조 이해를 위함.
* 위와 같은 개념들을 적용하여 SNS 웹 사이트 개발을 하고자 함.
* 1일 1커밋 운동을 지향하며 실천하기 위함.
<br/><br/>

## 주요 기능
1. 로그인 (추후 소셜 로그인 기능 추가)
2. 피드 작성
3. 댓글 작성
4. 팔로우/팔로잉/차단
5. 좋아요
6. 

## 핵심 개념
1. 커맨드 객체(DTO, VO)에 대한 값 검증 <br/>
  1-1. Validator 인터페이스를 활용한 값 검증 및 에러 코드 설정 (Errors) <br/>
  1-2. MessageSource를 통한 에러 코드 -> 에러 메시지 매핑 <br/>
  1-3. @Valid, @InitBinder 어노테이션 적용을 통한 커맨드 객체 값 검증 <br/><br/>
2. 세션 값 관리 <br/>
  2-1. @SessionAttributes, @ModelAttribute를 사용한 세션 객체 설정, SessionStatus.setComplete()를 통한 세션 객체 제거 <br/><br/>
3. Interceptor를 통한 요청 처리 중재 <br/>
  3-1. AuthInterceptor: 로그인 여부 확인 <br/>
  3-2. MeasuringInterceptor: 요청 처리 시간 출력 (추후 AOP 적용시 제거) <br/><br/>
  
4. JPA

<br/>

## Tech Stack
### Frontend
1. jsp
2. html
3. css

### Backend
1. Java
2. Spring Framework
3. AOP
4. [JPA](https://chungdk.tistory.com/33)
5. MySQL
6. Spring Batch
7. Spring Security
8. log4j
9. Unit Test

## Dev Environment
1. Java 8
2. STS 3 (3.9.12.RELEASE)
3. Tomcat 8.5
