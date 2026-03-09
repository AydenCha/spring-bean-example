package com.codeit.springbeanpractice.example02.config;

import com.codeit.springbeanpractice.example01.entity.Account;
import com.codeit.springbeanpractice.example01.entity.PersonalAccount;
import com.codeit.springbeanpractice.example02.dto.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 이 클래스는 "빈 정의 전용 설정 클래스"
public class ContextConfiguration {

    @Bean
    public Account accountGenerator() {
        // Account 타입의 스프링 빈 생성
        return new PersonalAccount(
                "101-111-2222",
                1000000,
                302
        );
    }

    @Bean
    public MemberDTO getMember() {
        // MemberDTO 빈 생성
        // accountGenerator()를 직접 호출하지만
        // 실제로는 "새 객체 생성"이 아니라
        // 스프링 컨테이너에 등록된 Account 빈을 반환받음
        return new MemberDTO(
                1,
                "010-1234-5678",
                "jungmin@google.com",
                "이정민",
                accountGenerator()
        );
    }
}
