package com.codeit.springbeanpractice.example12;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component // 컴포넌트 스캔 대상: 스프링이 이 클래스를 빈으로 등록
public class InfoPrinter {

    // @Value: 설정 값 주입
    // "Server is running on port: " → 고정 문자열
    // #{${server.port}} → server.port 프로퍼티 값을 SpEL로 평가해 문자열에 삽입
    @Value("Server is running on port: #{${server.port}}")
    private String message; // 최종 결과 문자열이 주입됨

    @Value("#{${config.timeout} * 2}")
    private int doubleTimeout;

    @Value("${my.username:anonymous}")
    private String username;

    @Value("${my.isValid:0}")
    private boolean isValid;

    @Value("#{'${my.servers}'.split(',')}")
    private List<String> servers;

    // 과제 3: SpEL 조건식
    @Value("#{${config.timeout} > 3000 ? '높음' : '낮음'}")
    private String timeoutLevel;

    public void print() {
        System.out.println(message); // 주입된 메시지 출력
    }

    public void printTimeout() {
        System.out.println(doubleTimeout);
    }

    public void printUsername() {
        System.out.println(username);
    }

    public void printIsValid() {
        System.out.println(isValid);
    }

    public void printServers() {
        System.out.println(servers);
    }

    public void printTimeoutLevel() {
        System.out.println(timeoutLevel);
    }
}
