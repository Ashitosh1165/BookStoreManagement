package com.example.BookStoreManagement.data.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
//    private String loginName;

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        ADMIN, MANAGER, CUSTOMER
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

//	public String getLoginName() {
//		return loginName;
//	}
//
//	public void setLoginName(String loginName) {
//		this.loginName = loginName;
//	}
//    
}
