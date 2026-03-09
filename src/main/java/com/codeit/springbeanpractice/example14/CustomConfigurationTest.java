package com.codeit.springbeanpractice.example14;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
// 이 클래스를 스프링 빈으로 등록
@ConfigurationProperties("custom")
// Environment에 존재하는 custom.* 설정 값을 이 클래스에 바인딩
// example14에서 ApplicationContextInitializer를 통해
// 코드로 추가한 PropertySource("custom")와 연결됨
public class CustomConfigurationTest {

    // custom.key
    // MapPropertySource에서 map.put("custom.key", "...")로 넣은 값이 여기로 들어옴
    private String key;

    public String getKey() {
        return key;
    }

    // ConfigurationProperties는 setter 기반으로 값이 주입됨
    public void setKey(String key) {
        this.key = key;
    }
}
