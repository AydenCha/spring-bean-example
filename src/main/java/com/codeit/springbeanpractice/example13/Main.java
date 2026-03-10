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

        DatabaseProperties databaseProperties =
                context.getBean(DatabaseProperties.class);

        // 브레이크 포인트를 걸고
        // 설정 값이 정상적으로 바인딩되었는지 확인하기 위한 출력
        System.out.println("\n=== MyServiceProperties ===");
        System.out.println("Service Name: " + myServiceProperties.getName());
        System.out.println("Service Port: " + myServiceProperties.getPort());
        System.out.println("Service Enabled: " + myServiceProperties.isEnabled());

        System.out.println("\n=== StorageProperties ===");
        System.out.println("Storage Path: " + storageProperties.getPath());
        System.out.println("S3 Bucket: " + storageProperties.getS3().getBucket());
        System.out.println("S3 Region: " + storageProperties.getS3().getRegion());

        System.out.println("\n=== AuthProperties ===");
        System.out.println("Client ID: " + authProperties.getClientId());
        System.out.println("Retry Count: " + authProperties.getRetryCount());

        System.out.println("\n=== MySettings (Map) ===");
        System.out.println("Settings: " + mySettings.getSettings());

        System.out.println("\n=== HostListProperties (List) ===");
        System.out.println("Host List: " + hostListProperties.getHosts());

        System.out.println("\n=== DatabaseProperties (과제 1, 2) ===");
        System.out.println("DB URL: " + databaseProperties.getUrl());
        System.out.println("DB Username: " + databaseProperties.getUsername());
        System.out.println("DB MaxConnections: " + databaseProperties.getMaxConnections());
        System.out.println("허용된 IP: " + databaseProperties.getAllowedIps());
    }
}
