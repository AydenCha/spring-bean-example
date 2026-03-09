package com.codeit.springbeanpractice.example10;

import org.springframework.stereotype.Service;

@Service // 스프링이 이 클래스를 서비스 빈으로 등록
public class OrderService {

    private final SessionScopeBean sessionScopeBean;
    // 세션 스코프 빈
    // - HTTP 세션 단위로 생성/유지되는 빈
    // - OrderService(싱글톤)에 주입될 때는 실제 객체가 아니라 프록시가 주입됨

    public OrderService(SessionScopeBean sessionScopeBean) {
        // 생성자 주입
        // - 스프링이 OrderService 생성 시점에 SessionScopeBean을 주입
        // - session 스코프이므로 실제 인스턴스는 요청/세션 시점에 결정됨
        this.sessionScopeBean = sessionScopeBean;
    }

    public void hello() {
        // 디버깅 포인트용 메서드
        // - 이 시점에 sessionScopeBean 접근 시
        //   현재 세션에 해당하는 실제 빈이 프록시를 통해 연결됨
    }
}
