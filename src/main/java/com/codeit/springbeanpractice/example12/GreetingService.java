package com.codeit.springbeanpractice.example12;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service // 스프링이 이 클래스를 서비스 빈으로 등록한다
public class GreetingService {

    @Value("${my.number}") // application.properties에 있는 my.number 값을 주입
    private double greeting;

    public void printGreeting() {
        System.out.println(greeting); // 주입된 값 출력
    }
}

