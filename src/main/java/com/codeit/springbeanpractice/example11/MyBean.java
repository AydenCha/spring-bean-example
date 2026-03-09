package com.codeit.springbeanpractice.example11;

public class MyBean {

    public void sayHello() {
        System.out.println("Hello Spring Container World"); // 빈 메서드 호출 확인용 출력
    }

    public void init() {
        System.out.println("MyBean을 생성했습니다."); // @Bean의 initMethod로 지정된 초기화 메서드
    }

    public void cleanup() {
        System.out.println("MyBean을 정리합니다."); // @Bean의 destroyMethod로 지정된 소멸 메서드
    }
}
