package com.codeit.springbeanpractice.example08;

import org.springframework.stereotype.Component;

@Component // Squirtle 구현체를 스프링 빈으로 등록
public class Squirtle implements Pokemon {

    @Override
    public void attack() {
        System.out.println("꼬북이 물대포!"); // 꼬북이 공격 로직
    }

    @Override
    public String name() {
        return "squirtle"; // 포켓몬 식별용 이름
    }
}
