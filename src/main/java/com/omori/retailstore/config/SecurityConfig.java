package com.omori.retailstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration

public class SecurityConfig {


    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource){

        UserDetails user = User.builder()
                .username("user2")
                .password("$2a$10$9A/khm9npWbED9.B/aq.seN261i.u9RhPGCqY2gXMtPWSlMHtWRjK")
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin2")
                .password("$2a$10$9A/khm9npWbED9.B/aq.seN261i.u9RhPGCqY2gXMtPWSlMHtWRjK")
                .roles("USER","ADMIN")
                .build();

        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.createUser(user);
        users.createUser(admin);
        return users;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
