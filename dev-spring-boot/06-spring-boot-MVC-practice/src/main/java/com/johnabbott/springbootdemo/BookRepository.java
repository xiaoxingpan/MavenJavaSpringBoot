package com.johnabbott.springbootdemo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    private final List<Book> books = new ArrayList<>();
    public List<Book> findAll() {
        return new ArrayList<>(books);
    }
    public void addBook(Book book) {
        books.add(book);
    }
}
