package com.bookeasy.entity;

import jakarta.persistence.*;

@Entity
@Table(name="books")
public class Book {

    // define fields

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="book_id")
    private int bookId;


    @Column(name="title")
    private String bookTitle;

    @Column(name="author")
    private String bookAuthor;

    @Column(name="price")
    private double bookPrice;

    @Column(name="category")
    private String bookCategory;

    @Column(name="quantity_available")
    private int quantityAvailable;

    // define constructors
    public Book() {
    }

    public Book(int bookId, String bookTitle, String bookAuthor, double bookPrice, String bookCategory, int quantityAvailable) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
        this.bookCategory = bookCategory;
        this.quantityAvailable = quantityAvailable;
    }

    public Book(String bookTitle, String bookAuthor, double bookPrice, String bookCategory, int quantityAvailable) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
        this.bookCategory = bookCategory;
        this.quantityAvailable = quantityAvailable;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setBookId(int bookId) {this.bookId = bookId; }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookCategory='" + bookCategory + '\'' +
                ", quantityAvailable=" + quantityAvailable +
                '}';
    }
}
