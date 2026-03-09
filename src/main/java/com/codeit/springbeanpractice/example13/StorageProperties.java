package com.codeit.springbeanpractice.example13;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
// 이 클래스를 스프링 빈으로 등록
@ConfigurationProperties(prefix = "my.storage")
// application.yml 에서 my.storage.* 설정 값을 바인딩
public class StorageProperties {

    // my.storage.path
    // 로컬 또는 공통 저장 경로
    private String path;

    // my.storage.s3 하위 설정을 담는 중첩 객체
    // 기본 객체를 미리 생성해 두어 null 방지
    private S3 s3 = new S3();

    // 중첩 설정 객체
    // my.storage.s3.bucket
    // my.storage.s3.region
    public static class S3 {

        // S3 버킷 이름
        private String bucket;

        // S3 리전 정보
        private String region;

        public String getBucket() {
            return bucket;
        }

        public void setBucket(String bucket) {
            this.bucket = bucket;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }
    }

    public String getPath() {
        return path;
    }

    // ConfigurationProperties는 setter를 통해 값이 주입됨
    public void setPath(String path) {
        this.path = path;
    }

    // 중첩 객체 접근용 getter
    public S3 getS3() {
        return s3;
    }

    public void setS3(S3 s3) {
        this.s3 = s3;
    }
}
