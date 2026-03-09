package com.codeit.springbeanpractice.example17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// example17 실행을 위한 Spring Boot 애플리케이션 진입점
public class Main {

    public static void main(String[] args) {

        // 스프링 컨테이너 실행
        // 활성화된 profile(test 등)에 따라
        // BeanC 생성 여부가 달라지고
        // @DependsOn에 의해 Bean 생성 순서가 결정됨
        SpringApplication.run(Main.class, args);
    }
}
