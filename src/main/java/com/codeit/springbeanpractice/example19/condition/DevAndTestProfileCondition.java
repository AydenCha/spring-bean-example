package com.codeit.springbeanpractice.example19.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// @Conditional에서 실제 조건 판단을 담당하는 클래스
// → 이 클래스의 matches() 결과에 따라 Bean 등록 여부가 결정됨
public class DevAndTestProfileCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        // 현재 스프링 환경 정보 (프로파일, 프로퍼티 등 접근 가능)
        Environment environment = context.getEnvironment();

        // 현재 활성화된 프로파일 목록 조회
        String[] activeProfiles = environment.getActiveProfiles();

        // 포함 여부 체크를 쉽게 하기 위해 Set으로 변환
        Set<String> activeProfileSet = new HashSet<>(Arrays.asList(activeProfiles));

        // AND 조건
        // → dev 와 test 프로파일이 "모두" 활성화되어 있어야 true
        // 하나라도 없으면 Bean 등록 안 됨
        return activeProfileSet.contains("dev")
                && activeProfileSet.contains("test");
    }
}
