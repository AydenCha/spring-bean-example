package com.codeit.springbeanpractice.example18;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
// 애플리케이션 시작 후 자동 실행되는 CommandLineRunner Bean
//@Order(1)
// @Order 애노테이션을 사용해도 실행 순서 지정 가능
public class SecondRunner implements CommandLineRunner, Ordered {

    @Override
    public void run(String... args) throws Exception {
        // Spring Boot 애플리케이션 기동 완료 후 실행
        System.out.println("SecondRunner 실행");
    }

    @Override
    public int getOrder() {
        // Ordered 인터페이스를 통해 실행 순서를 지정
        // 숫자가 작을수록 먼저 실행됨
        // FirstRunner(getOrder=2)보다 먼저 실행됨
        return 1;
    }
}
