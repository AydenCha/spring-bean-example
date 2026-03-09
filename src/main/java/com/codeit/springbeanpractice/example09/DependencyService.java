package com.codeit.springbeanpractice.example09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service // 스프링이 이 클래스를 서비스 빈으로 등록
public class DependencyService {

    @Autowired
    // Optional<T> 주입
    // - NotificationService 빈이 있으면 Optional에 담겨 주입됨
    // - 없으면 Optional.empty()가 주입됨
    // - required=false, @Nullable 없이도 "선택적 의존성" 표현 가능
//    @Autowired(required = false) // (대안 1) 빈이 없어도 주입 에러 발생 안 함
//    @Nullable                   // (대안 2) null 허용 주입
    private Optional<NotificationService> notificationService;

    public void testDependency() {
        // Optional을 통해 빈 존재 여부를 명시적으로 확인
        if (notificationService.isPresent()) {
            notificationService.get().sendNotification(); // 빈이 있을 때만 사용
        } else {
            System.out.println("No notification service available"); // 빈이 없을 때 처리
        }
    }
}
