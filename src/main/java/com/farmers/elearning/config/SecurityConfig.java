// package com.farmers.elearning.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         // Disable all security for now
//         http
//             .authorizeRequests()
//             .anyRequest()
//             .permitAll() // Allow all requests without authentication
//             .and()
//             .csrf()
//             .disable(); // Disable CSRF protection (optional, depends on your use case)
        
//         return http.build(); // Return the configured HttpSecurity
//     }
// }
