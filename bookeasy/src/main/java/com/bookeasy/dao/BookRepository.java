package com.bookeasy.dao;

import com.bookeasy.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
//    public List<Book> findAllByOrderByTitleAsc();
}
