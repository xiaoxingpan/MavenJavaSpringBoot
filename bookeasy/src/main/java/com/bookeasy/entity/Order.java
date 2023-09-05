package com.bookeasy.entity;

import jakarta.persistence.*;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "order_id")
    private int orderId;


    @Column(name = "username")
    private String username;

    @Column(name = "book_id")
    private int bookId;

    @Column(name = "order_number")
    private int orderNumber;

    @Column(name = "total_amount")
    private double totalAmount;

    public int getBookId() {
        return bookId;
    }

    @Column(name = "status")
    private String status;

    // Constructors, getters, setters, and other methods

    // Default constructor
    public Order() {
    }

    public Order(int id, int orderId, String username, int bookId, int orderNumber, double totalAmount,String status) {
        this.id = id;
        this.orderId = orderId;
        this.username = username;
        this.bookId = bookId;
        this.orderNumber = orderNumber;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public Order(int orderId, String username, int bookId, int orderNumber, double totalAmount,String status) {
        this.orderId = orderId;
        this.username = username;
        this.bookId = bookId;
        this.orderNumber = orderNumber;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getBook() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", username='" + username + '\'' +
                ", bookId=" + bookId +
                ", orderNumber=" + orderNumber +
                ", totalAmount=" + totalAmount +
                ", status='" + status + '\'' +
                '}';
    }
}
