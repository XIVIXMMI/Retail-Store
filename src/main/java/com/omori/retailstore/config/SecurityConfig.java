package com.omori.retailstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration

public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails user = User.builder()
                .username("user1")
                .password(passwordEncoder().encode("password123"))
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin1")
                .password(passwordEncoder().encode("password123"))
                .roles("USER","ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user,admin);
    }
}
