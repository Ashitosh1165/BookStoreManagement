package com.example.BookStoreManagement.config;
/*  @author Ashitosh* */
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.BeanIds;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//  @Bean(BeanIds.AUTHENTICATION_MANAGER)
//  @Override
//  public AuthenticationManager authenticationManagerBean() throws Exception {
//    return super.authenticationManagerBean();
//  }
//
//  @Bean
//  public JwtAuthenticationFilter jwtAuthenticationFilter() {
//    return new JwtAuthenticationFilter();
//  }
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.cors().and().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//				.and().authorizeRequests()
//				.antMatchers("/", "/favicon.ico", "/**/*.png", "/**/*.gif", "/**/*.svg", "/**/*.jpg", "/**/*.html",
//						"/**/*.css", "/**/*.js")
//				.permitAll().antMatchers("/api/auth/signin")
//				.permitAll().antMatchers("/api/menu/getmodulelst")
//				.permitAll().antMatchers("/api/menu/menubyuser")
//				.permitAll().antMatchers("/api/menu/menubymenname")
//				.permitAll().antMatchers("/api/menu/savemenubyuser")
//				.permitAll().antMatchers("/api/master/getallActiveuser").permitAll()
//				.antMatchers("/api/menu/getAllgroup")
//				.permitAll().antMatchers("/api/task/saveAlltaskEntry")
//                 .permitAll().antMatchers("/api/auth/changePassword")
//
//				
//				
//				
//				.permitAll().antMatchers("/api/transaction/getProjectReportData1")
//				.permitAll().antMatchers("/api/transaction/getProjectData")
//				.permitAll().antMatchers("/api/transaction/getKPIDetailsbyID")
//				.permitAll().antMatchers("/api/transaction/getPerformanceData")
//				.permitAll().antMatchers("/api/master/getunitofmeasure")
//				.permitAll().antMatchers("/api/master/getempmasterfroEmp")
//				.permitAll().antMatchers("/api/menu/SaveUserGroup")
//				.permitAll().antMatchers("/api/menu/health")
////				.permitAll().antMatchers("/api/transaction/getNewAppointmentOnchangeDetails")
////				.permitAll().antMatchers("/api/master/getcontacts")
////				.permitAll().antMatchers("/api/master/getcontactbyids")
//				
//				.permitAll().anyRequest().authenticated();
//		http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
////  protected void configure(HttpSecurity http) throws Exception {
////    http.cors().and().csrf().disable().sessionManagement()
////        .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
////        .antMatchers("/", "/favicon.ico", "/**/*.png", "/**/*.gif", "/**/*.svg", "/**/*.jpg",
////            "/**/*.html", "/**/*.css", "/**/*.js")
////        .permitAll().antMatchers("/api/auth/signin")
//
////        .permitAll().antMatchers("/api/menu/health")
////
////        .permitAll().antMatchers("/api/master/getcluster")
////
////        .permitAll().antMatchers("/api/master/getunit")
////        .permitAll().antMatchers("/api/master/saveband")
////        .permitAll().antMatchers("/api/master/getband")
////
////        
////        .permitAll().anyRequest().authenticated();
////    http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
////    
//	}
//  /*
//   * @Bean CorsConfigurationSource corsConfigurationSource() { CorsConfiguration configuration = new
//   * CorsConfiguration(); configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
//   * configuration.setAllowedMethods(Arrays.asList("HEAD", "OPTIONS", "GET", "POST", "PUT", "PATCH",
//   * "DELETE")); UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//   * source.registerCorsConfiguration("/**", configuration); return source; }
//   */
//}


//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .cors().and().csrf().disable()
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            .and()
//            .authorizeHttpRequests()
//                .requestMatchers("/", "/favicon.ico", "/**/*.png", "/**/*.gif", "/**/*.svg", "/**/*.jpg", 
//                                 "/**/*.html", "/**/*.css", "/**/*.js")
//                .permitAll()
//                .requestMatchers("/api/auth/signin",
//                                 "/api/menu/getmodulelst",
//                                 "/api/menu/menubyuser",
//                                 "/api/menu/menubymenname",
//                                 "/api/menu/savemenubyuser",
//                                 "/api/master/getallActiveuser",
//                                 "/api/menu/getAllgroup",
//                                 "/api/task/saveAlltaskEntry",
//                                 "/api/auth/changePassword",
//                                 "/api/transaction/getProjectReportData1",
//                                 "/api/transaction/getProjectData",
//                                 "/api/transaction/getKPIDetailsbyID",
//                                 "/api/transaction/getPerformanceData",
//                                 "/api/master/getunitofmeasure",
//                                 "/api/master/getempmasterfroEmp",
//                                 "/api/menu/SaveUserGroup",
//                                 "/api/menu/health")
//                .permitAll()
//                .anyRequest().authenticated();
//        
//        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
//        
//        return http.build();
//    }
//
//    @Bean
//    public JwtAuthenticationFilter jwtAuthenticationFilter() {
//        return new JwtAuthenticationFilter();
//    }
//}
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public AuthenticationManager authManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http
      .cors().and().csrf().disable()
      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      .and()
      .authorizeHttpRequests()
      .requestMatchers("/", "/favicon.ico", "/**", "*.png", "*.gif", "*.svg", "*.jpg", 
              "*.html", "*.css", "*.js")
          .permitAll()
          .requestMatchers("/api/auth/signin",
                           "/api/menu/getmodulelst",
                           "/api/menu/menubyuser",
                           "/api/menu/menubymenname",
                           "/api/menu/savemenubyuser",
                           "/api/master/getallActiveuser",
                           "/api/menu/getAllgroup",
                           "/api/task/saveAlltaskEntry",
                           "/api/auth/changePassword",
                           "/api/transaction/getProjectReportData1",
                        
                           "/api/transaction/getProjectData",
                           "/api/transaction/getKPIDetailsbyID",
                           "/api/transaction/getPerformanceData",
                           "/api/master/getunitofmeasure",
                           "/api/master/getempmasterfroEmp",
                           "/api/menu/SaveUserGroup",
                           "/api/menu/health"
                           ).permitAll().anyRequest().authenticated();
  
//  http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
  
  return http.build();
    }
}


