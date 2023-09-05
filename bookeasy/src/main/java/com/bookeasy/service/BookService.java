package com.bookeasy.service;

import com.bookeasy.entity.Book;

import java.util.List;

public interface BookService{

    List<Book> findAll();

    void save(Book theBook);

    Book findById(int theBookId);

    void deleteById(int theBookId);

}
