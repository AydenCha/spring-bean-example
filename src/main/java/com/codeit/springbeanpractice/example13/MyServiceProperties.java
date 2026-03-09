package com.codeit.springbeanpractice.example13;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
// 이 클래스를 스프링 빈으로 등록
@ConfigurationProperties(prefix = "my.service")
// application.yml 에서 my.service.* 값을 이 클래스 필드에 바인딩
public class MyServiceProperties {

    // my.service.name
    private String name;

    // my.service.port
    private int port;

    // my.service.enabled
    private boolean enabled;

    // ConfigurationProperties는 기본적으로 setter로 값이 주입됨
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    // boolean 타입은 관례적으로 getter가 getEnabled()가 아니라 isEnabled()가 됨
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
