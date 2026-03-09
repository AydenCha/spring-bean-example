package com.codeit.springbeanpractice.example07.book;

import java.util.List;
import java.util.Optional;

// 도서 데이터 접근을 위한 저장소 인터페이스
// - 구현체는 메모리/DB 등으로 확장 가능
public interface BookRepository {

    List<Book> findAll();
    // 전체 도서 목록 조회

    Optional<Book> findBySequence(int sequence);
    // sequence(순번)로 도서 조회
    // - 값이 없을 수 있으므로 Optional 사용
}
