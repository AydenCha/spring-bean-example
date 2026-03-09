package com.codeit.springbeanpractice.example13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
// Spring Boot 애플리케이션 진입점
@ConfigurationPropertiesScan
// @ConfigurationProperties가 붙은 클래스를 자동으로 스캔해서 Bean으로 등록
// (@Component 없이도 설정 클래스 등록 가능)
public class Main {

    public static void main(String[] args) {
        ApplicationContext context =
                SpringApplication.run(Main.class, args);

        // @ConfigurationProperties 기반으로 등록된 설정 Bean들 조회
        MyServiceProperties myServiceProperties =
                context.getBean(MyServiceProperties.class);

        StorageProperties storageProperties =
                context.getBean(StorageProperties.class);

        HostListProperties hostListProperties =
                context.getBean(HostListProperties.class);

        MySettings mySettings =
                context.getBean(MySettings.class);

        AuthProperties authProperties =
                context.getBean(AuthProperties.class);

        // 브레이크 포인트를 걸고
        // 설정 값이 정상적으로 바인딩되었는지 확인하기 위한 출력
        System.out.println(myServiceProperties);
    }
}
