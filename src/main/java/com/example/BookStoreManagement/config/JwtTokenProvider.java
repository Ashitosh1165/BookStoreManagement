package com.example.BookStoreManagement.config;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@Component
//public class JwtTokenProvider {
//
//  private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);
//
//  @Value("${app.jwtSecret}")
//  private String jwtSecret;
//
//  @Value("${app.jwtExpirationInMs}")
//  private int jwtExpirationInMs;
//
//  public String generateToken(UserPrincipal userPrincipal) {
//
//
//    Date now = new Date();
//    Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
//
//    return Jwts.builder().setSubject(userPrincipal.getId().toString())
//        .claim("comanycode", userPrincipal.getCompanyCode())
//        .claim("username", userPrincipal.getUsername()).setIssuedAt(new Date())
//        .setExpiration(expiryDate).signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
//  }
//
//  public Claims getUserIdFromJWT(String token) {
//    Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
//
//    // return Long.parseLong(claims.getSubject());
//    return claims;
//  }
//
//  public boolean validateToken(String authToken) {
//    try {
//      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
//      return true;
//    } catch (SignatureException ex) {
//      logger.error("Invalid JWT signature");
//    } catch (MalformedJwtException ex) {
//      logger.error("Invalid JWT token");
//    } catch (ExpiredJwtException ex) {
//      logger.error("Expired JWT token");
//    } catch (UnsupportedJwtException ex) {
//      logger.error("Unsupported JWT token");
//    } catch (IllegalArgumentException ex) {
//      logger.error("JWT claims string is empty.");
//    }
//    return false;
//  }
//}
@Component
public class JwtTokenProvider {
	private String secretKey = "yourSecretKey"; // Make sure to replace with a secure key
    private long validityInMilliseconds = 3600000; // 1 hour

    // Method to generate JWT token
    public String generateToken(UserDetails userDetails) {
        Claims claims = Jwts.claims().setSubject(userDetails.getUsername()); // Set the username as the subject
        
        // You can also add custom claims like roles, etc.
        // claims.put("roles", userDetails.getAuthorities());

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        // Create the JWT token
        return Jwts.builder()
                   .setClaims(claims)
                   .setIssuedAt(now)
                   .setExpiration(validity)
                   .signWith(SignatureAlgorithm.HS256, secretKey)
                   .compact();
    }

    // Method to extract username from the JWT token
    public String getUsernameFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getSubject(); // "subject" is typically the username in the JWT token
    }

    // Helper method to extract claims
    private Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                   .setSigningKey(secretKey)
                   .parseClaimsJws(token)
                   .getBody();
    }

    // Method to validate the token
    public boolean validateToken(String token) {
        try {
            // Check if the token is expired
            return !isTokenExpired(token);
        } catch (ExpiredJwtException e) {
            // Token has expired
            return false;
        } catch (SignatureException e) {
            // Invalid signature
            return false;
        } catch (Exception e) {
            // Any other exception (invalid token)
            return false;
        }
    }

    // Helper method to check if the token has expired
    private boolean isTokenExpired(String token) {
        Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    // Helper method to get expiration date from token
    private Date getExpirationDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

}

