# BookStoreManagement
Book Store 
Bookstore Management System - Spring Boot REST API

Features"
🔐 JWT Authentication for secure user sessions
🔒 Role-Based Authorization (Admin, Manager, Customer)
🌐 RESTful Endpoints to manage books, authors, orders, and users
💾 MySQL Integration using Spring Data JPA
❗ Centralized Error Handling with custom exceptions
🔍 API Testable via Postman
🧹 Clean Code Architecture following Spring Boot best practices

Technologies Used"
Java 17+
Spring Boot 3.x
Spring Security
Spring Data JPA
MySQL
JWT (io.jsonwebtoken:jjwt)
Postman (for API testing)

Prerequisites"
Java 17 or higher
Maven
MySQL
Postman (for testing)
IDE Eclipse

Project Structure
com.example.BookStoreManagement
├── config                 # Security and JWT configuration
├── controller             # REST controllers
├── data.model             # Entity classes (User, Book, etc.)
├── repository             # JPA repositories
├── service                # Service interfaces
├── serviceImpl            # Service implementations
└── util 

Clone the Repository:
git clone https://github.com/Ashitosh1165/BookStoreManagement.git
cd BookStoreManagement

Create MySQL Database:
CREATE DATABASE dbBookStore;

Run the Application
mvn clean install

Run application:
mvn spring-boot:run

Postman Collection :
https://ashitoshmagdum.postman.co/workspace/AshitoshMagdum's-Workspace~a99ae6e8-f6ad-48fc-879b-13f28141d7fe/collection/44400456-4952c5b1-c6ba-4dc4-be03-e4945564208f?action=share&creator=44400456 

Note: Authenticate first via the /login endpoint to retrieve a JWT token.
Then, include the token in your Postman request headers:
Authorization: Bearer <your_token_here>
