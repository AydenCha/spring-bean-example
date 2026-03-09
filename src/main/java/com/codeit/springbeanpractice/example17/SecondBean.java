package com.codeit.springbeanpractice.example17;

import org.springframework.stereotype.Component;

@Component("secondBean")
// Bean 이름을 명시적으로 secondBean으로 지정
// @DependsOn에서 이름으로 참조됨
public class SecondBean {

    public SecondBean() {
        // SecondBean 인스턴스가 실제로 생성될 때 호출됨
        // @DependsOn에 의해 FirstBean보다 먼저 생성되는지 확인용 출력
        System.out.println("SecondBean Constructor called");
    }
}
