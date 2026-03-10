package com.codeit.springbeanpractice.example05.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 스프링 설정 클래스: @Bean 정의용
public class CustomWebConfig {

    @Value("${spring.jackson.serialization.indent-output:false}")
    private boolean indentOutput;

    @Bean // ObjectMapper를 스프링 빈으로 등록
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper mapper = builder.build();
        if (indentOutput) {
            // JSON 직렬화 시 보기 좋게 들여쓰기 적용
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
        } else {
            // 들여쓰기 disable
            mapper.disable(SerializationFeature.INDENT_OUTPUT);
        }
        return mapper; // 이후 컨트롤러/서비스에서 공통 ObjectMapper로 사용
    }

}
