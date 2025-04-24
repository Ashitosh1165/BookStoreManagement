package com.example.BookStoreManagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookStoreManagement.data.model.Author;
import com.example.BookStoreManagement.data.model.Book;
import com.example.BookStoreManagement.data.model.Order;
import com.example.BookStoreManagement.repository.AuthorRepository;
import com.example.BookStoreManagement.repository.BookRepository;
import com.example.BookStoreManagement.repository.OrderRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
    private BookRepository bookRepo;
	
	
	@Autowired
    private   AuthorRepository authorRepo;
	
	@Autowired
    private  OrderRepository orderRepo;

    public AdminController(BookRepository bookRepo, AuthorRepository authorRepo, OrderRepository orderRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
        this.orderRepo = orderRepo;
    }

    // Books
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        return bookRepo.save(book);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book existing = bookRepo.findById(id).orElseThrow();
        existing.setTitle(book.getTitle());
        existing.setIsbn(book.getIsbn());
        existing.setPrice(book.getPrice());
        existing.setStock(book.getStock());
        existing.setAuthor(book.getAuthor());
        return bookRepo.save(existing);
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookRepo.deleteById(id);
        return "Book deleted";
    }

    // Authors
    @PostMapping("/authors")
    public Author addAuthor(@RequestBody Author author) {
        return authorRepo.save(author);
    }

    @PutMapping("/authors/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        Author existing = authorRepo.findById(id).orElseThrow();
        existing.setName(author.getName());
        return authorRepo.save(existing);
    }

    // Orders
    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
}

