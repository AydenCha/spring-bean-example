package com.codeit.springbeanpractice.example08;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication // 스프링 부트 애플리케이션 시작점
public class PokemonApplication {

    public static void main(String[] args) {

        // 스프링 애플리케이션 실행 + ApplicationContext 생성
        ApplicationContext context =
                SpringApplication.run(PokemonApplication.class, args);

        // PokemonService 빈을 가져와 포켓몬 공격 실행
        // (Pokemon 구현체가 여러 개일 경우 @Primary 또는 @Qualifier 필요)
//        PokemonService service = context.getBean(PokemonService.class);
//        service.pokemonAttack();

        // 다른 주입 방식/버전의 서비스 테스트용
//        PokemonServiceV2 serviceV2 = context.getBean(PokemonServiceV2.class);
//        serviceV2.pokemonAttack();
    }
}
