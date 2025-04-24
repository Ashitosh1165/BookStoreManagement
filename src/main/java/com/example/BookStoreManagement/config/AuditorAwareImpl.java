/**
 * 
 */
package com.example.BookStoreManagement.config;



import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.BookStoreManagement.config.UserPrincipal;
/**
 * @author Ashitosh
 *
 */
public class AuditorAwareImpl implements AuditorAware {

//  @Override
	@Override
  public Optional<Integer> getCurrentAuditor() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    if (authentication == null || !authentication.isAuthenticated()) {
      return null;
    }
    UserPrincipal userPrincipal =
        (com.example.BookStoreManagement.config.UserPrincipal) authentication.getPrincipal();

    return Optional.of(userPrincipal.getId());
    // Use below commented code when will use Spring Security.
  }
}
