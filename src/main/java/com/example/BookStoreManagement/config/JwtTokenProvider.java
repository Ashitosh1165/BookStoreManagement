package com.example.BookStoreManagement.config;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


@Component
public class JwtTokenProvider {

private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

//	 @Value("${app.jwtSecret}")
//	    private String jwtSecret;
//
//	    @Value("${app.jwtExpirationInMs}")
//	    private int jwtExpirationInMs;
//
//	    private Date now = new Date();
//	    private Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
	    // Generate token
	    public String generateToken(String username) {
	    	 return Jwts.builder()
	    	            .setSubject(username)
	    	            .setIssuedAt(new Date())
	    	            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
	    	            .signWith(getSignKey(),SignatureAlgorithm.HS256)  // Use the same key used for validation
	    	            .compact();
	    }

	    // Create token with claims
//	    private String createToken(Map<String, Object> claims, String username) {
//	        return Jwts.builder()
//	                .setClaims(claims)
//	                .setSubject(username)
//	                .setIssuedAt(new Date())
//	                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
//	                .signWith(getSignKey(), SignatureAlgorithm.HS256) // Use the correct signing key here
//	                .compact();
//	    }

	    private Key getSignKey() {
	        return Keys.secretKeyFor(SignatureAlgorithm.HS256);  // Guarantees a strong key
	    }
	
	    // Extract claims
	    public String extractUsername(String token) {
	        return extractClaim(token, Claims::getSubject);
	    }

	    // Extract expiration date
	    public Date extractExpiration(String token) {
	        return extractClaim(token, Claims::getExpiration);
	    }

	    // Extract claim by providing a function (e.g., Claims::getSubject)
	    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
	        final Claims claims = extractAllClaims(token);
	        return claimsResolver.apply(claims);
	    }

	    // Extract all claims from the token
	    private Claims extractAllClaims(String token) {
//	        return Jwts.parserBuilder()
//	                .setSigningKey(getSignKey()) // Use getSignKey for validation
//	                .build()
//	                .parseClaimsJws(token)
//	                .getBody();
	    	 try {
	    	        System.out.println("Token: " + token); // Log token for debugging
	    	        return Jwts.parserBuilder()
	    	                .setSigningKey(getSignKey())
	    	                .build()
	    	                .parseClaimsJws(token)
	    	                .getBody();
	    	    } catch (Exception e) {
	    	        System.out.println("Error extracting claims: " + e.getMessage());
	    	        throw e;
	    	    }
	    }

	    // Check if the token has expired
	    private Boolean isTokenExpired(String token) {
	        return extractExpiration(token).before(new Date());
	    }

	    // Validate the token against the username and expiration
//	    public Boolean validateToken(String token, UserDetails userDetails) {
//	        final String username = extractUsername(token);
//	        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//	    }
	    public boolean validateToken(String authToken) {
	        try {
	            Jwts.parserBuilder()
	                .setSigningKey(getSignKey()) // Use the correct signing key
	                .build()
	                .parseClaimsJws(authToken); // Validate JWT
	            return true;
	        } catch (MalformedJwtException ex) {
	            logger.error("Invalid JWT token");
	        } catch (ExpiredJwtException ex) {
	            logger.error("Expired JWT token");
	        } catch (UnsupportedJwtException ex) {
	            logger.error("Unsupported JWT token");
	        } catch (IllegalArgumentException ex) {
	            logger.error("JWT claims string is empty.");
	        }
	        return false;
	    }

}

