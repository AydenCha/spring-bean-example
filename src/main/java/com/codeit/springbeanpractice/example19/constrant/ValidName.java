package com.codeit.springbeanpractice.example19.constrant;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

// 이 애노테이션이 "검증용 애노테이션"임을 Bean Validation에게 알림
// validatedBy에 실제 검증 로직을 가진 Validator 클래스를 지정함
@Constraint(validatedBy = ValidNameValidator.class)

// JavaDoc, 리플렉션 등에 애노테이션 정보가 노출되도록 함
@Documented

// 이 애노테이션을 어디에 붙일 수 있는지 지정
// FIELD    : DTO 필드
// PARAMETER: 메서드 파라미터
@Target({ElementType.FIELD, ElementType.PARAMETER})

// 런타임 시점까지 애노테이션 정보를 유지해야
// 검증 시점에 리플렉션으로 읽을 수 있음
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidName {

    // 검증 실패 시 기본으로 반환될 메시지
    // @ValidName(message = "...") 형태로 오버라이드 가능
    String message() default
            "값이 비어있을 수 없고, 첫 글자는 알파벳으로 시작되어야 하며, 공백을 허용하지 않습니다.";

    // 검증 그룹 지정용 (고급 기능)
    // 기본 실습 단계에서는 거의 사용하지 않지만,
    // Bean Validation 스펙상 반드시 포함해야 함
    Class<?>[] groups() default {};

    // 메타데이터 전달용 (예: 심각도, 확장 정보 등)
    // 실무에서도 거의 직접 구현하지는 않음
    Class<? extends Payload>[] payload() default {};
}
