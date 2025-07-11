package com.example.BookStoreManagement.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.BookStoreManagement.repository.UserRepository;
import com.example.BookStoreManagement.data.model.User;
import com.example.BookStoreManagement.payload.UserInfoDetails;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	 private final UserRepository userRepo;
	    private final PasswordEncoder passwordEncoder;

	    @Autowired
	    public UserDetailsServiceImpl(UserRepository userRepository, @Lazy PasswordEncoder encoder) {
	        this.userRepo = userRepository;
	        this.passwordEncoder = encoder;
	    }
	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Optional<User> userDetail = userRepo.findByUsername(username); // Assuming 'email' is used as username

	        // Converting UserInfo to UserDetails
	        return userDetail.map(UserInfoDetails::new)
	                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
	    }

	    public String addUser(User userInfo) {
	        // Encode password before saving the user
	        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
	        userRepo.save(userInfo);
	        return "User Added Successfully";
	    }
	
}
