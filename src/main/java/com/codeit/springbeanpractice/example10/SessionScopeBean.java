package com.codeit.springbeanpractice.example10;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component // 컴포넌트 스캔 대상: 스프링이 이 클래스를 빈으로 등록
@Scope(
        scopeName = "session",                 // HTTP 세션 단위로 빈 생성/유지
        proxyMode = ScopedProxyMode.TARGET_CLASS
        // 세션 스코프 빈을 싱글톤 빈에 주입하기 위해 프록시 사용
        // 실제 SessionScopeBean 인스턴스는 세션이 활성화된 시점에 결정됨
)
public class SessionScopeBean {
    // 세션마다 하나씩 생성되는 빈
}
