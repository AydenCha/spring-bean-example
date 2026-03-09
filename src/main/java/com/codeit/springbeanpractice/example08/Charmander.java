package com.codeit.springbeanpractice.example08;

import org.springframework.stereotype.Component;

@Component // 컴포넌트 스캔 대상: Charmander를 스프링 빈으로 등록
public class Charmander implements Pokemon {

    @Override
    public void attack() {
        System.out.println("파이리 불꽃화염!"); // 공격 동작 구현
    }

    @Override
    public String name() {
        return "charmander"; // 포켓몬 식별용 이름 반환
    }
}
