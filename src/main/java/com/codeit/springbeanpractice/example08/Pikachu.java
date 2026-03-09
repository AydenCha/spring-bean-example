package com.codeit.springbeanpractice.example08;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component // Pikachu 구현체를 스프링 빈으로 등록
//@Primary // 여러 Pokemon 구현체가 있을 때 기본으로 선택되게 함 (현재는 비활성화)
public class Pikachu implements Pokemon {

    @Override
    public void attack() {
        System.out.println("백만볼트!"); // 피카츄 공격 로직
    }

    @Override
    public String name() {
        return "pikachu"; // 포켓몬 식별용 이름
    }
}
