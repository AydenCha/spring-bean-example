package com.codeit.springbeanpractice.example01.dto;

// 회원 정보를 담는 DTO(Data Transfer Object)
public class MemberDTO {

    private int sequence;   // 회원 식별 번호
    private String phone;   // 전화번호
    private String email;   // 이메일
    private String name;    // 이름

    // 생성자를 통해 모든 필드 초기화
    public MemberDTO(int sequence, String phone, String email, String name) {
        this.sequence = sequence;
        this.phone = phone;
        this.email = email;
        this.name = name;
    }

    public String getPhone() {
        return phone; // 전화번호 반환
    }

    public String getEmail() {
        return email; // 이메일 반환
    }

    public String getName() {
        return name; // 이름 반환
    }

    public int getSequence() {
        return sequence; // 회원 식별 번호 반환
    }

    @Override
    public String toString() {
        // 객체 출력/디버깅용 문자열
        return "MemberDTO{" +
                "sequence=" + sequence +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
