package com.codeit.springbeanpractice.example07;

import com.codeit.springbeanpractice.example07.book.Book;
import com.codeit.springbeanpractice.example07.book.BookService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication // 스프링 부트 설정 클래스 (여기서는 자동 실행은 사용 안 함)
public class Application {

    public static void main(String[] args) {

//        SpringApplication.run(Application.class, args);
        // ❌ 스프링 부트 자동 실행 방식
        // → 이번 예제에서는 사용하지 않음

        // 컴포넌트 스캔 기반으로 스프링 컨테이너 수동 생성
        // - 지정한 패키지 하위의 @Component / @Service / @Repository 스캔
        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        "com.codeit.springbeanpractice.example07"
                );

        // 생성자 주입 방식으로 등록된 BookService 빈 조회
        BookService bookService =
                context.getBean("bookServiceConstructor", BookService.class);

        // 전체 도서 목록 조회 후 출력
        bookService.selectAllBooks()
                .forEach(book -> System.out.println(book));

        // 특정 sequence의 도서 조회
        Book findBook = bookService.searchBookBySequence(1);
        System.out.println(findBook);
    }
}
