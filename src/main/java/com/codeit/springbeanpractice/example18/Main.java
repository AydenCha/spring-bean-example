package com.codeit.springbeanpractice.example18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// example18 실행을 위한 Spring Boot 애플리케이션 진입점
public class Main {

    public static void main(String[] args) {

        // 스프링 부트 애플리케이션 실행
        // 컨테이너 초기화 및 모든 Bean 생성이 완료된 후
        // CommandLineRunner 구현체들이 Order 기준으로 실행됨
        SpringApplication.run(Main.class, args);
    }
}
