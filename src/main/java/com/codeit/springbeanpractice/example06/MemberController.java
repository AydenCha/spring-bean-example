package com.codeit.springbeanpractice.example06;

import org.springframework.stereotype.Controller;

@Controller // 웹 계층 컨트롤러 빈으로 등록 (요청 처리 역할)
public class MemberController {

    private final MemberService memberService;
    // 서비스 계층 의존성
    // - 비즈니스 로직은 Service에 위임

    public MemberController(MemberService memberService) {
        // 생성자 주입
        // - 생성자가 1개라 @Autowired 생략 가능
        // - final 필드 사용 → 불변성 보장
        this.memberService = memberService;
    }
}
