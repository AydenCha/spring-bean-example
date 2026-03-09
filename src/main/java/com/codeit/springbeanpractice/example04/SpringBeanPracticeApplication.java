package com.codeit.springbeanpractice.example04;

// import를 다른 패키지(상위의)있는 객체를 불러온다면, excludeFilters에서 제대로 제외하기 어려움.
// 확인 필요!
// ✅ 참고: import는 excludeFilters랑 상관 없음 (스캔은 클래스패스에서 애노테이션/필터로 결정됨)
import com.codeit.springbeanpractice.example04.repository.ChannelRepository;
import com.codeit.springbeanpractice.example04.repository.MemberRepository;
import com.codeit.springbeanpractice.example04.service.ChannelService;
import com.codeit.springbeanpractice.example04.service.MemberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.util.Arrays;

@SpringBootApplication
// @SpringBootApplication 자체가 기본적으로 @ComponentScan을 포함함
// - 기본 스캔 범위: 이 클래스가 있는 패키지(com.codeit.springbeanpractice.example04) 하위 전체

//@ComponentScan(basePackages = "com.codeit.springbeanpractice.example04",
//        excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
//        classes = ChannelRepository.class)
//})
// 위 설정: 특정 타입(ChannelRepository.class)만 스캔 제외하는 방식

@ComponentScan(
        basePackages = "com.codeit.springbeanpractice.example04", // 스캔 시작 패키지
        excludeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.REGEX,                 // 정규식 기반 제외
                        pattern = ".*Member.*"                   // 클래스 전체 이름(FQCN)에 "Member"가 포함되면 제외
                        // 예: ...MemberService, ...MemberRepository 등이 제외 대상
                )
        }
)
//@ComponentScan(basePackages = "com.codeit.springbeanpractice.example04",
//                useDefaultFilters = false,
//                includeFilters = {@ComponentScan.Filter(
//                        type = FilterType.ASSIGNABLE_TYPE, classes = {
//                                MemberService.class, ChannelService.class, MemberRepository.class, ChannelRepository.class
//                })})
// 위 설정: 기본 스캔을 끄고(useDefaultFilters=false) include로 지정한 애들만 포함시키는 방식
public class SpringBeanPracticeApplication {

    public static void main(String[] args) {

        // 스프링 부트 실행 + ApplicationContext(스프링 컨테이너) 생성
        ApplicationContext context =
                SpringApplication.run(SpringBeanPracticeApplication.class, args);

//        context.getBean("memberService");   // MemberService는 pattern에 걸리면 제외되어 조회 실패 가능
        context.getBean("channelService");    // ChannelService 조회
        context.getBean("channelRepository"); // ChannelRepository 조회

        context.getBean("memberRepository");  // ⚠️ MemberRepository는 pattern에 걸리면 제외되어 조회 실패해야 정상

//        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        // 등록된 빈 이름 전체 출력(디버깅용)
    }
}
