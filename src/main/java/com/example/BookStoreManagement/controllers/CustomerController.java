package com.example.BookStoreManagement.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.example.BookStoreManagement.data.model.Book;
import com.example.BookStoreManagement.data.model.Order;
import com.example.BookStoreManagement.data.model.OrderItem;
import com.example.BookStoreManagement.data.model.User;
import com.example.BookStoreManagement.repository.BookRepository;
import com.example.BookStoreManagement.repository.OrderRepository;
import com.example.BookStoreManagement.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private final BookRepository bookRepo;
    
    @Autowired
    private final OrderRepository orderRepo;
    
    @Autowired
    private final UserRepository userRepo;

    public CustomerController(BookRepository bookRepo, OrderRepository orderRepo, UserRepository userRepo) {
        this.bookRepo = bookRepo;
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
    }

    // Browse books
    @GetMapping("/books")
    public List<Book> browseBooks(@RequestParam(required = false) String title,
                                  @RequestParam(required = false) String author,
                                  @RequestParam(required = false) String isbn) {

        if (title != null) return bookRepo.findByTitleContainingIgnoreCase(title);
        if (author != null) return bookRepo.findByAuthor_NameContainingIgnoreCase(author);
        if (isbn != null) return bookRepo.findByIsbn(isbn);
        return bookRepo.findAll();
    }

 // Place Order
    @PostMapping("/orders")
    public Order placeOrder(@RequestBody List<OrderItemRequest> items, Authentication auth) {
        User user = userRepo.findByUsername(auth.getName()).orElseThrow();

        List<OrderItem> orderItems = new ArrayList<>();
        double total = 0;

        // Create the order object first
        Order order = new Order();
        order.setCustomer(user);
        order.setOrderDate(LocalDateTime.now());

        for (OrderItemRequest req : items) {
            // Fetch the book using the book ID
            Book book = bookRepo.findById(req.bookId()).orElseThrow();

            // Check if there is enough stock
            if (book.getStock() < req.quantity()) {
                throw new RuntimeException("Not enough stock for book: " + book.getTitle());
            }

            // Update stock
            book.setStock(book.getStock() - req.quantity());
            bookRepo.save(book);

            // Create OrderItem
            OrderItem item = new OrderItem(req.quantity(), book.getPrice() * req.quantity(), order, book);
            orderItems.add(item);

            // Accumulate the total price
            total += item.getPrice();
        }

        // Set the total price for the order
        order.setTotalPrice(total);
        order.setItems(orderItems);

        // Set the order for each order item
        for (OrderItem item : orderItems) {
            item.setOrder(order);
        }

        // Save the order and return it
        return orderRepo.save(order);
    }

    @GetMapping("/orders")
    public List<Order> getMyOrders(Authentication auth) {
        User user = userRepo.findByUsername(auth.getName()).orElseThrow();
        return orderRepo.findByCustomer(user);
    }

    // OrderItemRequest record definition
    record OrderItemRequest(Long bookId, int quantity) {}

}
