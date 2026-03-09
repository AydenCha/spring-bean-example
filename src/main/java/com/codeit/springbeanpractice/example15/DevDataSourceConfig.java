package com.codeit.springbeanpractice.example15;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
// 설정 클래스
@Profile("dev")
// 현재 활성화된 profile이 dev일 때만 이 설정 클래스가 적용됨
public class DevDataSourceConfig {

    @Bean("devDataSourceInfo")
    // dev 환경에서 사용할 DataSourceInfoPrinter Bean 등록
    public DataSourceInfoPrinter dataSourceInfoPrinter() {

        // 람다 표현식으로 DataSourceInfoPrinter 구현
        // FunctionalInterface 이기 때문에 가능
        return () -> System.out.println("개발용 데이터 소스 등록");
    }
}
