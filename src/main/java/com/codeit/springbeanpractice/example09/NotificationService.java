package com.codeit.springbeanpractice.example09;

import org.springframework.stereotype.Service;

@Service // 스프링이 이 클래스를 NotificationService 빈으로 등록
public class NotificationService {

    public void sendNotification() {
        System.out.println("알람을 전송합니다."); // 알림 전송 동작을 흉내 낸 메서드
    }
}
