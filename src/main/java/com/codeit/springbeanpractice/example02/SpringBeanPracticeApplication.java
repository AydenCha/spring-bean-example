package com.codeit.springbeanpractice.example02;

import com.codeit.springbeanpractice.example01.entity.Account;
import com.codeit.springbeanpractice.example02.config.ContextConfiguration;
import com.codeit.springbeanpractice.example02.dto.MemberDTO;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootApplication // 스프링 부트 설정 클래스 (이번 예제에서는 run 사용 안 함)
public class SpringBeanPracticeApplication {

    public static void main(String[] args) {

//        SpringApplication.run(SpringBeanPracticeApplication.class, args);
        // ❌ 스프링 부트 자동 실행 방식
        // → 이번 예제에서는 사용하지 않음

        // @Configuration 클래스(ContextConfiguration) 기반으로
        // 스프링 컨테이너를 직접 생성
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        // @Bean 메서드(getMember)로 등록된 MemberDTO 빈 조회
        MemberDTO member =
                context.getBean("getMember", MemberDTO.class);
        System.out.println("member = " + member);

        // @Bean 메서드(accountGenerator)로 등록된 Account 빈 조회
        Account account =
                context.getBean("accountGenerator", Account.class);
        System.out.println("account = " + account);

        // 스프링 컨테이너에 등록된 모든 빈 이름 출력
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
    }
}
