package com.codeit.springbeanpractice.example19.constrant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

// 설정 파일(application.yml 등)의 값을 바인딩받는 설정 클래스
// 일반 DTO가 아니라 "환경 설정 전용 Bean" 역할
@Component
@ConfigurationProperties("my.valid")
// @ValidName 같은 Bean Validation 애노테이션을
// ConfigurationProperties 바인딩 시점에 적용하기 위해 필요
@Validated
public class ValidTest {

    // 커스텀 검증 애노테이션
    // → ValidNameValidator가 실행되어 name 값을 검증함
    @ValidName
    private String name;

    // ConfigurationProperties는 Setter를 통해 값이 주입됨
    // (그래서 Setter가 반드시 필요)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
