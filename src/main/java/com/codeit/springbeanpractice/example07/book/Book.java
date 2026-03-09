package com.codeit.springbeanpractice.example07.book;

// 도서 정보를 담는 도메인 객체 (VO/Entity 역할)
public class Book {

    private final int sequence;   // 도서 고유 순번
    private final String title;   // 도서 제목
    private final String author;  // 저자명

    // 생성자를 통해 모든 필드를 초기화
    // → 불변 객체 형태 (final 필드)
    public Book(int sequence, String title, String author) {
        this.sequence = sequence;
        this.title = title;
        this.author = author;
    }

    public int getSequence() {
        return sequence; // 도서 순번 반환
    }

    public String getTitle() {
        return title; // 도서 제목 반환
    }

    public String getAuthor() {
        return author; // 저자명 반환
    }

    @Override
    public String toString() {
        // 디버깅/출력용 문자열 표현
        return "Book{" +
                "sequence=" + sequence +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
