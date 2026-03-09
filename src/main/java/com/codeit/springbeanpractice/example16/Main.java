package com.codeit.springbeanpractice.example16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
// example16 실행 진입점
public class Main {

    public static void main(String[] args) {

        // 스프링 컨테이너 실행
        ApplicationContext context =
                SpringApplication.run(Main.class, args);

        // FeatureService Bean 조회
        // custom.feature-x=true 인 경우에만 정상적으로 조회 가능
        FeatureService featureService =
                context.getBean(FeatureService.class);

        // FeatureService가 등록된 경우 메시지 출력
        System.out.println(featureService.getMessage());
    }
}
