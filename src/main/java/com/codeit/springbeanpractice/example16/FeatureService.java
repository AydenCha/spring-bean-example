package com.codeit.springbeanpractice.example16;

// FeatureX 기능이 활성화되었을 때만 사용되는 서비스
// @Conditional 조건을 만족하면 FeatureConfig에서 Bean으로 등록됨
public class FeatureService {

    // Feature-X 활성 여부를 확인하기 위한 테스트용 메서드
    public String getMessage() {
        return "Feature-X 활성화 되었습니다.";
    }
}
