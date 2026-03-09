package com.codeit.springbeanpractice.example19.condition;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

// 일반적인 컴포넌트 Bean
@Component

// dev 또는 test 프로파일일 때만 Bean으로 등록되도록 제한
// 내부적으로 @Conditional(DevAndTestProfileCondition.class)를 사용
@ConditionalOnDevAndTestProfile
public class DevAndTestLogger {

    // Bean 생성 + 의존성 주입이 모두 끝난 직후 실행
    // → 실제로 조건이 만족되어 Bean이 등록되었는지 확인용
    @PostConstruct
    public void log() {
        System.out.println("DevAndTestLogger");
    }
}
