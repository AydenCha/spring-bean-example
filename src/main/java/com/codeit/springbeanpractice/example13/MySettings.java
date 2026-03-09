package com.codeit.springbeanpractice.example13;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
// 이 클래스를 스프링 빈으로 등록
@ConfigurationProperties(prefix = "my")
// application.yml 에서 my 하위 설정 값을 Map 형태로 바인딩
public class MySettings {

    // my.settings 아래에 있는 key-value 설정들을 Map으로 받음
    // key: 설정 이름, value: 설정 값
    private Map<String, String> settings;

    // settings 전체 맵 조회
    public Map<String, String> getSettings() {
        return settings;
    }

    // ConfigurationProperties는 setter를 통해 값이 주입됨
    public void setSettings(Map<String, String> settings) {
        this.settings = settings;
    }
}
