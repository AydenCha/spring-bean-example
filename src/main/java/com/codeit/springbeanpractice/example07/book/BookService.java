package com.codeit.springbeanpractice.example07.book;

import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookServiceConstructor") // 서비스 빈 등록 + 빈 이름 지정
public class BookService {

    //    @Autowired // 필드 주입
//    - @Autowired 생략 불가
//    - final 사용 불가
//    - 테스트/불변성 측면에서 비권장
    private final BookRepository bookRepository;

    // 생성자 주입
    // - 생성자가 1개일 경우 @Autowired 생략 가능
    // - final 사용 가능 → 불변성 보장
    // - 가장 권장되는 주입 방식
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

//    Setter 주입 방식
//    - @Autowired 생략 불가
//    - 런타임에 의존성 변경 가능
//    - 선택적 의존성일 때 주로 사용
//    @Autowired
//    public void setBookRepository(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }

    public List<Book> selectAllBooks() {
        // 전체 도서 목록 조회
        return bookRepository.findAll();
    }

    public Book searchBookBySequence(int sequence) {
        // 순번으로 도서 조회
        // - 조회 실패 시 예외 발생
        return bookRepository.findBySequence(sequence)
                .orElseThrow(() -> new IllegalArgumentException("해당 도서를 찾을 수 없습니다."));
    }
}
