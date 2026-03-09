package com.codeit.springbeanpractice.example15;

@FunctionalInterface
// 추상 메서드가 하나만 존재하는 함수형 인터페이스
// 람다 표현식 또는 구현 클래스로 사용 가능
public interface DataSourceInfoPrinter {

    // 각 데이터 소스(dev, prod 등)의 정보를 출력하는 역할
    void printDataSourceInfo();
}
