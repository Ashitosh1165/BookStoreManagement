package com.example.BookStoreManagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookStoreManagement.data.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}

