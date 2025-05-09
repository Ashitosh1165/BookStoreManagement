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

import javax.crypto.SecretKey;

@Component
public class JwtTokenProvider {

//	@Value("${jwt.secret}")
//	private String secret;

	private SecretKey secretKey;
	
	public JwtTokenProvider() {
		
		this.secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	}
	private Key getSigninkey() {
		return this.secretKey;
	}
	
	
	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(getSigninkey()).build().parseClaimsJws(token).getBody();
	}
	
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}


	// Extract claims
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	
	public String generateToken(Map<String,Object> extractClaims ,UserDetails userDetails) {

		long expirationInMillis = 60 * 60 *1000;
		return Jwts.builder().setClaims(extractClaims).setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + expirationInMillis))
				.signWith(getSigninkey(),SignatureAlgorithm.HS256).compact();
				
}

	public String generateToken(UserDetails userDetails) {
		return generateToken(new HashMap<>(),userDetails);
	}



}
