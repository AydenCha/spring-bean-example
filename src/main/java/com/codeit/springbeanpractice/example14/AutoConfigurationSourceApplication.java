package com.codeit.springbeanpractice.example14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
// 스프링 부트 애플리케이션 진입점
public class AutoConfigurationSourceApplication
        implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    // ApplicationContextInitializer
    // → 스프링 컨테이너가 완전히 초기화되기 "직전"에 실행되는 훅(hook)
    // → 이 단계에서 Environment(PropertySource)를 조작할 수 있음

    public static void main(String[] args) {

        // SpringApplication.run() 대신 SpringApplicationBuilder 사용
        // - initializers()로 초기화 로직(ApplicationContextInitializer)을 등록하기 위함
        ApplicationContext context = new SpringApplicationBuilder(AutoConfigurationSourceApplication.class)
                .initializers(new AutoConfigurationSourceApplication())
                // 위에서 현재 클래스(Initializer 구현체)를 초기화 로직으로 등록
                .run(args);

        // 초기화 이후 컨테이너가 완성되면, 일반 빈 조회 가능
        CustomConfigurationTest customConfigurationTest =
                context.getBean(CustomConfigurationTest.class);

        GreetingService greetingService =
                context.getBean(GreetingService.class);

        // Environment 값이 어떻게 들어갔는지 확인(디버깅용)
        greetingService.printEnv();

//        System.out.println(customConfigurationTest);
        // 필요 시 디버깅 출력
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

        // 스프링 Environment(설정 값 소스 전체를 관리하는 객체) 가져오기
        ConfigurableEnvironment env = applicationContext.getEnvironment();
        System.out.println("현재 환경변수 = " + env);

        // 코드로 property(key-value)를 직접 만들어서 추가할 맵
        Map<String, Object> map = new HashMap<>();
        map.put("custom.key", "value-from-code");
        // custom.key라는 설정을 코드에서 주입
        // → @Value("${custom.key}") 같은 곳에서 사용 가능

        // Map 기반 PropertySource 생성
        PropertySource<Map<String, Object>> propertySource =
                new MapPropertySource("custom", map);
        // "custom"은 이 PropertySource의 이름(식별자)

        // PropertySource 우선순위 최상단에 추가
        env.getPropertySources().addFirst(propertySource);
        // addFirst → 같은 key가 다른 곳(application.yml, 시스템 환경변수 등)에 있어도
        // 여기서 넣은 값이 "우선" 적용됨(덮어씀)
    }
}
