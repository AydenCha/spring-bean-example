package com.codeit.springbeanpractice.example17;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
// 일반 컴포넌트 빈
@DependsOn({"secondBean", "beanC"})
// FirstBean이 생성되기 전에
// secondBean 과 beanC 가 먼저 생성되도록 강제
public class FirstBean {

    public FirstBean() {
        // FirstBean 인스턴스가 실제로 생성될 때 호출됨
        // @DependsOn에 의해, 이 출력보다
        // secondBean / beanC 생성 로그가 먼저 찍혀야 함
        System.out.println("FirstBean Constructor called");
    }
}
