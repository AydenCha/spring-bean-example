package com.codeit.springbeanpractice.example05;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.Map;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
// ↑ 스프링 시큐리티 자동 설정을 제외하고 싶을 때 사용
@SpringBootApplication // 스프링 부트 애플리케이션 시작 클래스
public class SpringBeanPracticeApplication {

    public static void main(String[] args) throws JsonProcessingException {

        // 스프링 애플리케이션 실행 + ApplicationContext 생성
        ApplicationContext context =
                SpringApplication.run(SpringBeanPracticeApplication.class, args);

        // 스프링 컨테이너에 등록된 모든 빈 이름 출력
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);

        // ObjectMapper 테스트 (README 과제 3)
        ObjectMapper mapper = context.getBean(ObjectMapper.class);
        String json = mapper.writeValueAsString(Map.of("name", "홍길동", "age", 30));
        System.out.println("JSON 출력:\n" + json);
    }
}
