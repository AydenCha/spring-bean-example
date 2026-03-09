//package com.codeit.springbeanpractice.example07.book;
//
//import org.springframework.stereotype.Repository;
//
//import java.util.*;
//
//@Repository("bookRepository") // BookRepository 인터페이스의 구현체를 스프링 빈으로 등록
//                              // 빈 이름을 "bookRepository"로 지정
//public class MapBookRepository implements BookRepository {
//
//    // 메모리 기반 저장소
//    // - key   : 도서 sequence
//    // - value : Book 객체
//    private final Map<Integer, Book> books = new HashMap<>();
//
//    // 기본 생성자
//    // - 애플리케이션 시작 시 더미 데이터 초기화
//    public MapBookRepository() {
//        books.put(1, new Book(1, "스프링 코어", "김진우"));
//        books.put(2, new Book(2, "Jpa 뿌개기", "김러키"));
//        books.put(3, new Book(3, "클린코드 아키텍처", "박나경"));
//    }
//
//    @Override
//    public List<Book> findAll() {
//        // Map에 저장된 모든 Book을 List로 변환하여 반환
//        List<Book> bookList = new ArrayList<>();
//        bookList.addAll(books.values());
//        return bookList;
//    }
//
//    @Override
//    public Optional<Book> findBySequence(int sequence) {
//        // sequence에 해당하는 Book 조회
//        // - 값이 없을 수 있으므로 Optional로 감싸서 반환
//        return Optional.of(books.get(sequence));
//    }
//}
