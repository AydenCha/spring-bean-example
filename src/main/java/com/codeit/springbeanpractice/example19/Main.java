package com.codeit.springbeanpractice.example19;

import com.codeit.springbeanpractice.example19.condition.DevAndTestLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

// example19의 실행 진입점
// @Conditional + Profile 기반 Bean 등록 동작을 확인하기 위한 메인 클래스
@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        // 스프링 컨테이너 초기화
        // 이 시점에:
        // - 활성화된 profile 확인
        // - @Conditional 조건 평가
        // - 조건에 맞는 Bean만 등록됨
        ApplicationContext context =
                SpringApplication.run(Main.class, args);

        // DevAndTestLogger Bean 조회
        // → dev + test 프로파일이 모두 활성화된 경우에만
        //   Bean이 존재하므로 getBean 성공
        // → 조건이 맞지 않으면 NoSuchBeanDefinitionException 발생
        DevAndTestLogger logger = context.getBean(DevAndTestLogger.class);
    }
}
