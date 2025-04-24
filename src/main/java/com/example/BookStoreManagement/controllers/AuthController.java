package com.example.BookStoreManagement.controllers;


import jakarta.validation.Valid;
//import lombok.Data;
import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.BookStoreManagement.JWTSecurity.JwtService;
import com.example.BookStoreManagement.data.model.User;
import com.example.BookStoreManagement.repository.UserRepository;



@RestController
@RequestMapping("/auth")
public class AuthController {

	  @Autowired
	    private AuthenticationManager authManager;

	    @Autowired
	    private JwtService jwtService;

	    @Autowired
	    private UserRepository userRepo;
	
    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authManager, JwtService jwtService, UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.authManager = authManager;
        this.jwtService = jwtService;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequest request) {
        if (userRepo.findByUsername(request.getUsername()) != null) {
            throw new RuntimeException("User already exists");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        userRepo.save(user);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody LoginRequest request) {
        Authentication auth = authManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        UserDetails user = (UserDetails) auth.getPrincipal();
        String token = jwtService.generateToken(user);

        return ResponseEntity.ok(new AuthResponse(token));
    }

    @Data
    static class LoginRequest {
        private String username;
        private String password;
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
        
    }

    @Data
    static class RegisterRequest {
        private String username;
        private String password;
        private User.Role role;
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
		public User.Role getRole() {
			return role;
		}
		public void setRole(User.Role role) {
			this.role = role;
		}
        
        
    }
    
    
}
