package com.codeit.springbeanpractice.example02.dto;

import com.codeit.springbeanpractice.example01.entity.Account;

// 회원 정보를 담는 DTO(Data Transfer Object)
public class MemberDTO {

    private Account personalAccount; // 회원의 계좌 정보
    private int sequence;            // 회원 식별 번호
    private String phone;            // 전화번호
    private String email;            // 이메일
    private String name;             // 이름

    // 모든 필드를 생성자로 주입
    // → DTO는 보통 불변에 가깝게 생성자 기반으로 초기화
    public MemberDTO(int sequence,
                     String phone,
                     String email,
                     String name,
                     Account account) {
        this.sequence = sequence;
        this.phone = phone;
        this.email = email;
        this.name = name;
        this.personalAccount = account;
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

    public Account getPersonalAccount() {
        return personalAccount; // 계좌 정보 반환
    }

    @Override
    public String toString() {
        // 디버깅/출력용 문자열 표현
        return "MemberDTO{" +
                "sequence=" + sequence +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
