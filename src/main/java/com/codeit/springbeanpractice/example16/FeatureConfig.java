package com.codeit.springbeanpractice.example16;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
// 기능(feature) 관련 Bean 설정 클래스
public class FeatureConfig {

    @Bean
    @Conditional(FeatureXEnabledCondition.class)
    // FeatureXEnabledCondition의 조건이 true일 때만
    // 이 FeatureService Bean이 등록됨
    public FeatureService featureService() {

        // 조건을 만족하지 않으면 이 메서드는 호출조차 되지 않음
        return new FeatureService();
    }
}
