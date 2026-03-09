package com.codeit.springbeanpractice.example15;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// 여러 DataSourceInfoPrinter 구현체를 다루는 서비스
public class BeanService {

//    private final DataSourceInfoPrinter dataSourceInfoPrinter;
//
//    public BeanService(@Qualifier("prodDataSourceInfo") DataSourceInfoPrinter dataSourceInfoPrinter) {
//        this.dataSourceInfoPrinter = dataSourceInfoPrinter;
//    }
    // ↑ 단일 Bean만 주입받을 경우의 예시
    // @Qualifier를 사용해 어떤 Bean을 쓸지 명확히 지정해야 함

    private final List<DataSourceInfoPrinter> dataSourceInfoPrinters;
    // DataSourceInfoPrinter 타입의 Bean이 여러 개일 경우
    // 스프링이 해당 타입의 모든 Bean을 List로 한 번에 주입해 줌

    public BeanService(List<DataSourceInfoPrinter> dataSourceInfoPrinters) {
        this.dataSourceInfoPrinters = dataSourceInfoPrinters;
    }

    @PostConstruct
    // 이 메서드는 Bean 생성 + 의존성 주입이 끝난 직후 자동 실행됨
    public void init() {
        // 주입받은 모든 DataSourceInfoPrinter를 순회하며 정보 출력
        dataSourceInfoPrinters.stream()
                .forEach(printer -> printer.printDataSourceInfo());
    }

//    @PostConstruct
//    public void init() {
//        dataSourceInfoPrinter.printDataSourceInfo();
//    }
    // ↑ 단일 Bean 주입 방식일 때의 초기화 로직 예시
}
