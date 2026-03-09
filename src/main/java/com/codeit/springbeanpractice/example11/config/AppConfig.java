package com.codeit.springbeanpractice.example11.config;

import com.codeit.springbeanpractice.example11.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration // 이 클래스를 빈 설정 클래스(Configuration)로 사용하겠다는 의미
public class AppConfig {

    @Bean(
            initMethod = "init",        // 빈 생성 후, 스프링이 자동으로 호출하는 초기화 메서드
            destroyMethod = "cleanup"   // 빈 소멸 직전, 스프링이 자동으로 호출하는 종료 메서드
    )
//    @Scope(scopeName = "prototype") // 주석 해제 시: prototype 스코프
    // - 요청할 때마다 새 인스턴스 생성
    // - destroyMethod는 자동 호출되지 않음
    public MyBean myBean() {
        return new MyBean(); // 스프링이 관리하는 MyBean 인스턴스 생성
    }
}
