package com.example.BookStoreManagement.controllers;


import jakarta.validation.Valid;
import lombok.Data;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.example.BookStoreManagement.config.JwtTokenProvider;
import com.example.BookStoreManagement.data.model.User;
import com.example.BookStoreManagement.payload.LoginRequest;
import com.example.BookStoreManagement.payload.RegisterRequest;
import com.example.BookStoreManagement.repository.UserRepository;
import com.example.BookStoreManagement.serviceImpl.UserDetailsServiceImpl;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
    private final AuthenticationManager authManager;
	
	@Autowired
    private  JwtTokenProvider jwtUtil;
	
	@Autowired	
    private UserRepository userRepo;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authManager, JwtTokenProvider jwtUtil, UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequest request) {
        if (userRepo.findByUsername(request.getUsername()).isPresent()) {
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
    public String login(@RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        if (authentication.isAuthenticated()) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return jwtUtil.generateToken(userDetails);
        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }



    
    
}
