package com.example.BookStoreManagement.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.example.BookStoreManagement.repository.UserRepository;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
    private  UserRepository userRepo;

   
	 @Autowired
	    public UserDetailsServiceImpl(UserRepository userRepo) {
	        this.userRepo = userRepo;
	    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Load user from the repository (make sure the repository method exists)
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Mapping the User entity to Spring Security's User
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole())) // Adding the role to the authorities
        );
    }
}
