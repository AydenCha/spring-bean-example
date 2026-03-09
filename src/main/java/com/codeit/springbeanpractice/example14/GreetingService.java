package com.codeit.springbeanpractice.example14;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
// 일반 서비스 빈
public class GreetingService {

    // Spring Environment 객체
    // 모든 설정 값(application.yml, system env, code로 추가한 PropertySource 등)을
    // 하나로 통합해서 관리하는 인터페이스
    private final Environment environment;

    public GreetingService(Environment environment) {
        this.environment = environment;
    }

    public void printEnv() {

        // application.yml 에서 설정한 server.port 값 조회
        String port = environment.getProperty("server.port");
        System.out.println(port);

        // application.yml 에서 설정한 my.greeting 값 조회
        String greeting = environment.getProperty("my.greeting");
        System.out.println(greeting);

        // 이 방식은 @Value, @ConfigurationProperties와 달리
        // 런타임에 직접 Environment에서 값을 꺼내는 방식
    }
}
