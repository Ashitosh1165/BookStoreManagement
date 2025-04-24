package com.example.BookStoreManagement.data.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "orderitem")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;
    private double price;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Book book;

    public OrderItem() {
        // Default constructor for JPA
    }

    // Constructor with arguments
    public OrderItem(int quantity, double price, Order order, Book book) {
        this.quantity = quantity;
        this.price = price;
        this.order = order;
        this.book = book;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
