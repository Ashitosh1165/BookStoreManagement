package com.example.BookStoreManagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookStoreManagement.data.model.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingIgnoreCase(String title);
    List<Book> findByIsbn(String isbn);
    List<Book> findByAuthor_NameContainingIgnoreCase(String authorName);
}
