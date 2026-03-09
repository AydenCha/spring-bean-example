package com.codeit.springbeanpractice.example08;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceQualifier") // 서비스 빈 등록 + 빈 이름 지정
public class PokemonService {

    private PokemonServiceV2 pokemonServiceV2; // 다른 서비스 의존성
    private Pokemon pokemon;                   // Pokemon 인터페이스 타입 의존성

    // 생성자 주입
    // - Pokemon 구현체가 여러 개일 경우(@Component 여러 개),
    //   @Primary 또는 @Qualifier 없으면 주입 시 에러 발생 가능
    public PokemonService(PokemonServiceV2 pokemonServiceV2, Pokemon pokemon) {
        this.pokemonServiceV2 = pokemonServiceV2;
        this.pokemon = pokemon;
    }

    // @Resource(name = "pikachu")
    // setter 주입 방식
    // - 이름 기준으로 빈을 주입
    // - JSR-250 표준 애노테이션
//    public void setPokemon(Pokemon pokemon) {
//        this.pokemon = pokemon;
//    }

    // 생성자 + @Qualifier 방식
    // - 특정 구현체를 명시적으로 선택
//    public PokemonService(@Qualifier("squirtle") Pokemon pokemon) {
//        this.pokemon = pokemon;
//    }

    public void pokemonAttack() {
        pokemon.attack(); // 주입된 Pokemon 구현체의 공격 실행
    }
}
