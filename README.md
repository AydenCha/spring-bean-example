# Spring Bean Practice (example01 ~ example19)

이 문서는 **Spring Bean / DI / 설정 / 스코프 / 생명주기 / 조건부 Bean / 프로파일 / 설정 바인딩 / 검증**을 학습하기 위한 실습 코드(example01~example19)를
학생들이 **빠르게 복습**할 수 있도록 정리한 README입니다.

---

## example01 — @Configuration + @Bean 기본 등록

### 복습 개념

* `@Configuration`, `@Bean`을 이용한 **수동 빈 등록**
* `AnnotationConfigApplicationContext`로 **스프링 컨테이너 직접 생성**
* 설정 클래스 자체도 하나의 Bean이 될 수 있음

### 핵심 포인트

* `@Bean`의 기본 Bean 이름은 **메서드 이름**
* `@Configuration("이름")`을 사용하면 설정 클래스도 해당 이름의 Bean으로 등록됨

### 학습 체크

* 스프링 부트를 사용하지 않고도 컨테이너를 직접 생성할 수 있는가?

---

## example02 — @Configuration과 CGLIB 프록시

### 복습 개념

* `@Configuration` 클래스는 **CGLIB 프록시**로 감싸짐
* `@Bean` 메서드 간 직접 호출 시에도 **싱글톤 보장**

### 핵심 포인트

* `@Bean` 메서드가 다른 `@Bean` 메서드를 호출해도 항상 같은 인스턴스 반환
* 이는 프록시가 호출을 가로채 컨테이너에서 Bean을 조회하기 때문

### 학습 체크

* `@Configuration` 대신 `@Component`를 쓰면 어떤 문제가 발생하는가?

---

## example03 — @ComponentScan 스캔 범위 지정

### 복습 개념

* `@ComponentScan(basePackages = ...)`
* 스프링이 어떤 패키지를 스캔하는지 제어

### 핵심 포인트

* basePackages는 **해당 패키지 + 하위 패키지 전체**를 포함
* import 여부는 컴포넌트 스캔과 무관

---

## example04 — ComponentScan excludeFilters

### 복습 개념

* 특정 Bean을 스캔 대상에서 제외
* `FilterType.REGEX`, `ASSIGNABLE_TYPE`

### 핵심 포인트

* REGEX는 **클래스 전체 경로(FQCN)** 기준
* `.*Member.*` → 이름에 Member가 포함된 모든 클래스 제외

---

## example05 — 설정 클래스에서 공통 Bean 등록

### 복습 개념

* ObjectMapper 같은 **공통 인프라 Bean 직접 등록**
* 자동 설정 vs 사용자 정의 Bean

### 핵심 포인트

* 동일 타입 Bean이 있으면 사용자 정의 Bean이 우선될 수 있음

---

## example06 — Controller → Service 생성자 주입

### 복습 개념

* 계층 구조: Controller → Service
* 생성자 주입 방식

### 핵심 포인트

* 생성자가 1개면 `@Autowired` 생략 가능
* final 필드 사용 가능

---

## example07 — Repository 인터페이스 + 구현체

### 복습 개념

* Repository 인터페이스로 저장소 추상화
* Service 계층에서 비즈니스 로직 처리

### 핵심 포인트

* Optional + orElseThrow 패턴
* Repository는 Service를 의존하면 안 됨

---

## example08 — 동일 타입 Bean 여러 개 주입

### 복습 개념

* 동일 인터페이스 구현체 여러 개 등록
* `@Primary`, `@Qualifier`, `@Resource`
* `Map<String, T>`, `Set<T>` 주입

### 핵심 포인트

* Map의 key는 Bean 이름
* 단일 주입 시 충돌 발생 가능

---

## example09 — Optional 의존성 주입

### 복습 개념

* 선택적 Bean 주입
* `Optional<T>`, `@Autowired(required=false)`, `@Nullable`

### 핵심 포인트

* Optional은 의도를 가장 명확하게 표현함

---

## example10 — session scope + scoped proxy

### 복습 개념

* singleton vs session scope
* scoped proxy의 필요성

### 핵심 포인트

* 싱글톤 Bean에 세션 스코프 Bean을 주입하려면 프록시 필요
* 실제 객체는 요청/세션 시점에 결정됨

---

## example11 — Bean 생명주기

### 복습 개념

* Bean 초기화 / 소멸 콜백

### 방식 비교

* `@Bean(initMethod, destroyMethod)`
* `@PostConstruct`, `@PreDestroy`
* `InitializingBean`, `DisposableBean`

---

## example12 — @Value와 SpEL

### 복습 개념

* 외부 설정 값 주입
* `${}` vs `#{}` 차이

### 핵심 포인트

* `${}` → 프로퍼티 치환
* `#{}` → SpEL 평가

---

## example13 — @ConfigurationProperties 설정 바인딩

### 복습 개념

* `@ConfigurationProperties`를 이용한 설정 객체 바인딩
* 계층 구조, List, Map 바인딩

### 핵심 포인트

* Setter 기반 바인딩
* 설정 전용 Bean 패턴

---

## example14 — Environment & PropertySource

### 복습 개념

* `Environment`를 통한 설정 값 조회
* `ApplicationContextInitializer`

### 핵심 포인트

* 코드 기반으로 PropertySource 추가 가능
* 설정 우선순위 개념 이해

---

## example15 — @Profile 기반 Bean 분기

### 복습 개념

* `@Profile`로 환경별 Bean 등록
* 동일 인터페이스 구현체 다중 등록

### 핵심 포인트

* List 주입으로 활성 Bean 전부 수집 가능
* dev / prod 환경 분기 패턴

---

## example16 — @Conditional 커스텀 조건

### 복습 개념

* `Condition` 인터페이스 구현
* 설정 값 기반 Bean 등록 여부 결정

### 핵심 포인트

* 조건이 false면 Bean 자체가 생성되지 않음
* 기능 플래그(feature toggle) 패턴

---

## example17 — @DependsOn + Profile

### 복습 개념

* Bean 생성 순서 제어
* Profile에 따른 Bean 존재 여부

### 핵심 포인트

* 의존 Bean이 없으면 컨테이너 초기화 실패 가능

---

## example18 — CommandLineRunner 실행 순서

### 복습 개념

* 애플리케이션 시작 직후 실행 로직
* `Ordered`, `@Order`

### 핵심 포인트

* 숫자가 작을수록 먼저 실행

---

## example19 — 조건부 Bean + 커스텀 검증

### 복습 개념

* `@Conditional` + 커스텀 애노테이션
* Profile AND 조건 구현
* Bean Validation 커스텀 제약
* `@ConfigurationProperties` + `@Validated`

### 핵심 포인트

* 조건이 맞지 않으면 Bean은 **아예 존재하지 않음**
* 설정 값 검증 실패 시 **애플리케이션 기동 실패**

---

## 전체 학습 흐름 요약

* example01~02: 수동 Bean 등록 + 프록시
* example03~04: 컴포넌트 스캔 제어
* example05: 공통 인프라 Bean
* example06~07: 계층 구조 + 추상화
* example08~09: 복수/선택적 Bean 주입
* example10: 스코프와 프록시
* example11: 생명주기
* example12: 설정 주입
* example13~14: 설정 바인딩 & 환경
* example15~16: 조건부 Bean
* example17~18: 실행 순서 제어
* example19: 조건 + 검증 통합 패턴

---

## 복습시 확인해야 하는 체크리스트

* 빈은 어떤 방식으로 등록되는가?
* 스캔 범위는 어디인가?
* 동일 타입 Bean 충돌 시 어떻게 해결하는가?
* 조건부 Bean은 언제 제외되는가?
* 스코프가 다를 때 프록시는 왜 필요한가?
* init / destroy는 언제 실행되는가?
* `${}`와 `#{}`의 차이는 무엇인가?
* 설정 값은 언제 검증되는가?
* Profile과 Condition의 차이는 무엇인가?
* 검증 실패는 런타임인가, 기동 시점인가?