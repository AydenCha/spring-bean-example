package com.codeit.springbeanpractice.example01.entity;

// Account 인터페이스의 개인 계좌 구현체
// - 실제 계좌 정보를 담는 도메인 객체
public class PersonalAccount implements Account {

    private String accNo;   // 계좌 번호
    private int balance;    // 잔액
    private int bankCode;   // 은행 코드

    // 생성자를 통해 계좌 정보 초기화
    public PersonalAccount(String accNo, int balance, int bankCode) {
        this.accNo = accNo;
        this.balance = balance;
        this.bankCode = bankCode;
    }
}
