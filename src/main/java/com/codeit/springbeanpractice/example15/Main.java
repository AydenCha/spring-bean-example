package com.codeit.springbeanpractice.example15;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// example15 전체를 실행하는 Spring Boot 애플리케이션 진입점
public class Main {

    public static void main(String[] args) {

        // 스프링 부트 애플리케이션 실행
        // 활성화된 profile(dev / prod 등)에 따라
        // 등록되는 Bean과 실행되는 @PostConstruct 로직이 달라짐
        SpringApplication.run(Main.class, args);
    }
}
