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
	private final String SECRET = "your_secret_key";

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
            .setSubject(userDetails.getUsername())
            .claim("roles", userDetails.getAuthorities())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
            .signWith(SignatureAlgorithm.HS256, SECRET)
            .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser().setSigningKey(SECRET)
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername());
    }

}

