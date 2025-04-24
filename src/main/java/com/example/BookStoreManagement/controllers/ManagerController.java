package com.example.BookStoreManagement.controllers;




import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookStoreManagement.data.model.Book;
import com.example.BookStoreManagement.data.model.Order;
import com.example.BookStoreManagement.repository.BookRepository;
import com.example.BookStoreManagement.repository.OrderRepository;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    private final BookRepository bookRepo;
    private final OrderRepository orderRepo;

    public ManagerController(BookRepository bookRepo, OrderRepository orderRepo) {
        this.bookRepo = bookRepo;
        this.orderRepo = orderRepo;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @PutMapping("/books/{id}/stock")
    public Book updateStock(@PathVariable Long id, @RequestParam Integer stock) {
        Book book = bookRepo.findById(id).orElseThrow();
        book.setStock(stock);
        return bookRepo.save(book);
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
}

