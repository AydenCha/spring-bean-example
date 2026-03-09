package com.codeit.springbeanpractice.example08;

// 포켓몬 공통 기능을 정의한 인터페이스
// - 여러 구현체(Charmander, Pikachu 등)를 만들기 위한 기준 역할
public interface Pokemon {

    void attack();   // 포켓몬의 공격 동작

    String name();   // 포켓몬 이름 반환 (식별 용도)
}
