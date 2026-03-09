package com.codeit.springbeanpractice.example19.constrant;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

// ValidName 애노테이션과 String 타입을 연결하는 검증 클래스
// <ValidName, String> 의미:
//  - ValidName : 어떤 애노테이션을 처리할 것인지
//  - String    : 어떤 타입의 값을 검증할 것인지
public class ValidNameValidator implements ConstraintValidator<ValidName, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        // 1. null 체크
        // Bean Validation에서는 null 허용 여부를 직접 결정해야 함
        // (null을 허용하고 싶으면 true 반환)
        if (value == null) return false;

        // 2. 앞뒤 공백 제거 후 빈 문자열 체크
        // "   " 같은 값 방지
        String trimmed = value.trim();
        if (trimmed.isEmpty()) return false;

        // 3. 문자열 내부에 공백이 하나라도 있으면 실패
        // 예: "abc def" → false
        if (value.chars().anyMatch(c -> Character.isWhitespace(c))) {
            return false;
        }

        // 4. 첫 글자는 반드시 문자(알파벳)여야 함
        // 숫자, 특수문자, 공백으로 시작하면 실패
        char firstChar = trimmed.charAt(0);
        if (!Character.isLetter(firstChar)) return false;

        // 모든 조건을 통과하면 유효한 값
        return true;
    }
}
