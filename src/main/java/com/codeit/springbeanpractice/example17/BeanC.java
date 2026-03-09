package com.codeit.springbeanpractice.example17;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("beanC")
// 이 Bean의 이름을 명시적으로 beanC로 지정
@Profile("test")
// test 프로파일이 활성화된 경우에만 이 Bean이 컨테이너에 등록됨
public class BeanC {

    public BeanC() {
        // Bean 인스턴스가 실제로 생성될 때 호출됨
        // 어떤 프로파일에서 이 Bean이 생성되는지 확인하기 위한 출력
        System.out.println("BeanC Constructor called");
    }
}
