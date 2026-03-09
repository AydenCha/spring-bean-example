package com.codeit.springbeanpractice.example19.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

// 이 애노테이션을 클래스 또는 메서드에 붙일 수 있도록 지정
@Target({ElementType.TYPE, ElementType.METHOD})

// 런타임까지 애노테이션 정보를 유지
// → Spring이 애플리케이션 실행 시 조건 판단에 사용
@Retention(RetentionPolicy.RUNTIME)

// Javadoc 및 IDE 문서에 포함되도록 설정
@Documented

// 실제 조건 판단 로직을 담고 있는 Condition 클래스 지정
// DevAndTestProfileCondition.matches(...) 결과가 true일 때만 Bean 등록
@Conditional(DevAndTestProfileCondition.class)
public @interface ConditionalOnDevAndTestProfile {
    // 별도의 속성은 없고,
    // "dev 또는 test 프로파일에서만 활성화"라는 의미를 담은 메타 애노테이션 용도
}
