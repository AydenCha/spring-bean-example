package com.codeit.springbeanpractice.example11;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component // 컴포넌트 스캔 대상: 스프링이 이 클래스를 빈으로 등록
public class MyComponent implements InitializingBean, DisposableBean {

    public void sayHello() {
        System.out.println("Hello Spring Container Component World"); // 빈 사용 확인용 메서드
    }

    // @PostConstruct
    // 빈 생성 + 의존성 주입 완료 후 자동 호출되는 초기화 메서드 (표준 방식)
    // public void init() {
    //     System.out.println("MyComponent 빈을 초기화했습니다.");
    // }

    // @PreDestroy
    // 컨테이너 종료 시 자동 호출되는 소멸 메서드 (표준 방식)
    public void destroy() {
        System.out.println("바이바이 MyComponent Bean...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // InitializingBean 인터페이스 구현 시
        // 의존성 주입이 끝난 뒤 스프링이 자동으로 호출
        System.out.println("MyComponent 빈을 초기화했습니다.");
    }
}
