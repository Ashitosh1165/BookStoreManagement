package com.example.BookStoreManagement.JWTSecurity;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

	private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

	  @Value("${app.jwtSecret}")
	  private String jwtSecret;

	  @Value("${app.jwtExpirationInMs}")
	  private int jwtExpirationInMs;
	  
//
//    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
//    private final long EXPIRATION = 86400000L;// 1 day

    public String generateToken(String username) {
    	 Date now = new Date();
    	    Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

    	    return Jwts.builder().setSubject(username)
//    	        .claim("companycode", userPrincipal.getCompanyCode())
    	        .claim("username", username).setIssuedAt(new Date())
    	        .setExpiration(new Date(jwtExpirationInMs)).signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
//        return Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
//                .signWith(key)
//                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(jwtSecret)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
//    public Claims getUserIdFromJWT(String token) {
//        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
//        return claims;
//      }

//    public boolean validateToken(String token) {
//        try {
//            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
//            return true;
//        } catch (JwtException | IllegalArgumentException e) {
//            return false;
//        }
//    }
    public boolean validateToken(String authToken) {
        try {
          Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
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
