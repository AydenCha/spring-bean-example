package com.codeit.springbeanpractice.example15;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
// 설정 클래스
@Profile("prod")
// 현재 활성화된 profile이 prod일 때만 이 설정 클래스가 적용됨
public class ProdDataSourceConfig {

    @Bean("prodDataSourceInfo")
    // prod 환경에서 사용할 DataSourceInfoPrinter Bean 등록
    public DataSourceInfoPrinter dataSourceInfoPrinter() {

        // 람다 표현식으로 DataSourceInfoPrinter 구현
        // dev 설정 클래스와 동일한 인터페이스를 사용하지만
        // 실행 환경에 따라 다른 구현체가 등록됨
        return () -> System.out.println("운영환경 데이터 소스 등록");
    }
}
