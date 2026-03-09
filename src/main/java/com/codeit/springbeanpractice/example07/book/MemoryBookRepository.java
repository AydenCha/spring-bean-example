package com.codeit.springbeanpractice.example07.book;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository // BookRepository 구현체를 스프링 빈으로 등록
public class MemoryBookRepository implements BookRepository {

//    private final BookService bookService;
    // ❌ Repository가 Service를 의존하면 순환 참조/역할 침범
    // → 주석 처리된 게 맞는 방향

    private final List<Book> books = new ArrayList<>();
    // 메모리 기반 도서 저장소

    public MemoryBookRepository() {
        // 애플리케이션 시작 시 더미 데이터 초기화
        books.add(new Book(1, "스프링 코어", "김진우"));
        books.add(new Book(2, "Jpa 뿌개기", "김러키"));
        books.add(new Book(3, "클린코드 아키텍처", "박나경"));
    }

//    ❌ Service 주입 예제 (비권장)
//    - Repository → Service 의존은 계층 구조 위반
//    public MemoryBookRepository(BookService bookService) {
//        this.bookService = bookService;
//    }

    @Override
    public List<Book> findAll() {
        // 내부 리스트 보호를 위해 복사본 반환
        return List.copyOf(books);
    }

    @Override
    public Optional<Book> findBySequence(int sequence) {
        // sequence로 도서 검색
        // - 없을 수 있으므로 Optional 반환
        return books.stream()
                .filter(b -> b.getSequence() == sequence)
                .findFirst();
    }
}
