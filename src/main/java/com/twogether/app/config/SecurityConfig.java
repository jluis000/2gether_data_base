package com.twogether.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
	        .csrf(csrf -> csrf.disable())
	        .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin())) // permite H2 en iframe
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/h2-console/**").permitAll() // permite H2
	            .anyRequest().permitAll()
	        );
        return http.build();
    }
}
