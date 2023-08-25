package com.johnabbott.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepository;
    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "books";
    }
    @GetMapping("/add")
    public String addBookForm() {
        return "addBook";
    }
    @PostMapping("/add")
    public String addBook(Book book) {
        bookRepository.addBook(book);
        return "redirect:/books";
    }
}
