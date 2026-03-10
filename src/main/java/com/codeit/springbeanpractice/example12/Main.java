package com.codeit.springbeanpractice.example12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication // 스프링 부트 애플리케이션 시작점
// - @Configuration
// - @EnableAutoConfiguration
// - @ComponentScan
// 을 한 번에 포함
public class Main {

    public static void main(String[] args) {

        // 스프링 컨테이너(ApplicationContext) 생성 및 애플리케이션 시작
        ApplicationContext context =
                SpringApplication.run(Main.class, args);

        // 스프링 컨테이너에 등록된 GreetingService 빈을 조회
        context.getBean(GreetingService.class)
                .printGreeting(); // GreetingService의 메서드 호출

        context.getBean(InfoPrinter.class)
                .print();

        context.getBean(InfoPrinter.class)
                .printTimeout();

        context.getBean(InfoPrinter.class)
                .printUsername();

        context.getBean(InfoPrinter.class)
                .printIsValid();

        context.getBean(InfoPrinter.class)
                .printServers();

        context.getBean(InfoPrinter.class)
                .printTimeoutLevel();
    }
}
