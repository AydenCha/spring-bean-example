package com.codeit.springbeanpractice.example16;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class FeatureXEnabledCondition implements Condition {
    // @Conditional에서 사용할 조건 클래스
    // 이 클래스의 matches() 결과에 따라 Bean 등록 여부가 결정됨

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        // Spring Environment 객체 접근
        // application.yml, system env, JVM args 등 모든 설정 값에 접근 가능
        String property =
                context.getEnvironment().getProperty("custom.feature-x");

        // custom.feature-x 값을 boolean으로 변환
        // true  -> 조건 만족 (Bean 등록)
        // false / null -> 조건 불만족 (Bean 미등록)
        return Boolean.parseBoolean(property);
    }
}
