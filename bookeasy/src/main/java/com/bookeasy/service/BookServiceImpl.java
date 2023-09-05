package com.bookeasy.service;

import com.bookeasy.dao.BookRepository;
import com.bookeasy.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository theBookRepository) {
        this.bookRepository = theBookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }


    @Override
    public void save(Book theBook) {
////        Optional<Book> result = bookRepository.findById(theBook.getBookId());
//
//        if (exist.isPresent()) {
//            bookRepository.update(theBook);
//        }
//        else {
//            // Save the book to the database
            bookRepository.save(theBook);
//        }
    }

    @Override
    public Book findById(int theBookId) {
        Optional<Book> result = bookRepository.findById(theBookId);

        Book theBook = null;

        if (result.isPresent()) {
            theBook = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find book id - " + theBookId);
        }

        return theBook;
    }

    @Override
    public void deleteById(int theBookId) {
        bookRepository.deleteById(theBookId);
    }
}
