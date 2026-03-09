package com.codeit.springbeanpractice.example15;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
// 일반 컴포넌트 빈
@Profile({"dev", "prod"})
// dev 또는 prod 프로파일 중 하나라도 활성화되면 이 빈이 등록됨
public class DevOrProdLogger {

    @PostConstruct
    // 빈 생성 및 의존성 주입 완료 직후 한 번 실행
    public void log() {
        System.out.println("개발 또는 운영환경에서 활성된 Logger입니다.");
    }
}
