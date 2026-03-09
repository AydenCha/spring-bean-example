package com.codeit.springbeanpractice.example13;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
// 이 클래스 자체를 스프링 빈으로 등록
@ConfigurationProperties(prefix = "my.auth")
// application.yml 에서 my.auth 로 시작하는 설정 값을 이 클래스에 바인딩
@Validated
// 설정 값 바인딩 시점에 Bean Validation을 적용
public class AuthProperties {

    @NotBlank
    // my.auth.client-id 값이 반드시 존재해야 함
    // null 이거나 빈 문자열이면 애플리케이션 시작 시 오류 발생
    private String clientId;

    @Min(1)
    // my.auth.retry-count 값은 최소 1 이상이어야 함
    // 0 또는 음수면 애플리케이션 기동 실패
    private int retryCount;

    // ConfigurationProperties는 기본적으로 setter를 통해 값이 주입됨
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }
}
