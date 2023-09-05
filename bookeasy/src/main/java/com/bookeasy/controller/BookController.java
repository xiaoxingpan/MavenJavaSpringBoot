package com.bookeasy.controller;

import com.bookeasy.entity.Book;
import com.bookeasy.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
//    private List<Book> theBooks;
//    // load book data
//    @PostConstruct
//    private void loadData() {
//
//        // create employees
//        Book book1 = new Book();
//        book1.setBookTitle("Book Title 1");
//        book1.setBookAuthor("Author 1");
//        book1.setBookPrice(35.0);  // Use a double value
//        book1.setBookCategory("Fiction");
//        book1.setQuantityAvailable(50);
//        Book book2 = new Book();
//        book2.setBookTitle("Book Title 2");
//        book2.setBookAuthor("Author 2");
//        book2.setBookPrice(35.0);  // Use a double value
//        book2.setBookCategory("Fiction");
//        book2.setQuantityAvailable(50);
//        Book book3 = new Book();
//        book3.setBookTitle("Book Title 3");
//        book3.setBookAuthor("Author 3");
//        book3.setBookPrice(35.0);  // Use a double value
//        book3.setBookCategory("Fiction");
//        book3.setQuantityAvailable(50);
//        Book book4 = new Book();
//        book4.setBookTitle("Book Title 3");
//        book4.setBookAuthor("Author 3");
//        book4.setBookPrice(35.0);  // Use a double value
//        book4.setBookCategory("Fiction");
//        book4.setQuantityAvailable(50);
//        Book book5 = new Book();
//        book5.setBookTitle("Book Title 3");
//        book5.setBookAuthor("Author 3");
//        book5.setBookPrice(35.0);  // Use a double value
//        book5.setBookCategory("Fiction");
//        book5.setQuantityAvailable(50);
//        Book book6 = new Book();
//        book6.setBookTitle("Book Title 3");
//        book6.setBookAuthor("Author 3");
//        book6.setBookPrice(35.0);  // Use a double value
//        book6.setBookCategory("Fiction");
//        book6.setQuantityAvailable(50);
//
//        // create the list
//        theBooks = new ArrayList<>();
//
//        // add to the list
//        theBooks.add(book1);
//        theBooks.add(book2);
//        theBooks.add(book3);
//        theBooks.add(book4);
//        theBooks.add(book5);
//        theBooks.add(book6);
//
//    }
//
//    // add mapping for "/list"
//    @GetMapping("/list")
//    public String listBooks(Model theModel) {
//
//        // add to the spring model
//        theModel.addAttribute("books", theBooks);
//
//        return "allProducts";
//    }

    private BookService bookService;
    private static final Logger log =
            LoggerFactory.getLogger(BookController.class);

    @Autowired
    public BookController(BookService theBookService) {
        this.bookService = theBookService;
    }

    @GetMapping("/list")
    public String listAllBooks(Model theModel) {
        // Get the book data from db
        List<Book> theBook = bookService.findAll();
        // add db data to the spring model, present data from db
        theModel.addAttribute("books", theBook);
        return "allProducts";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book theBook) {
        log.info(String.valueOf(theBook));
        bookService.save(theBook);

        return "redirect:/books/list";
    }

    @PostMapping("/update")
    public String updateBook(@ModelAttribute("book") Book theBook) {
        log.info(String.valueOf(theBook.getBookId()));
        return "redirect:/books/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("bookId") int theBookId) {
        bookService.deleteById(theBookId);
        return "redirect:/books/list";
    }

}
