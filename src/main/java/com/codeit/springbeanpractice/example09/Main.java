package com.codeit.springbeanpractice.example09;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication // 스프링 부트 애플리케이션 시작 클래스
public class Main {

    public static void main(String[] args) {

        // 스프링 애플리케이션 실행 + ApplicationContext(스프링 컨테이너) 생성
        ApplicationContext context =
                SpringApplication.run(Main.class, args);

        // 스프링 컨테이너에서 DependencyService 빈 조회
        DependencyService dependencyService =
                context.getBean(DependencyService.class);

        // 선택적 의존성(NotificationService) 테스트 실행
        dependencyService.testDependency();
    }
}
