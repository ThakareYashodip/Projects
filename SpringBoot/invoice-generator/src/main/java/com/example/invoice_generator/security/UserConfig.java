package com.example.invoice_generator.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfig {

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin123")) // ✅ encode password
                .roles("ADMIN") // ROLE_ADMIN
                .build();

        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder.encode("user123")) // ✅ encode password
                .roles("USER") // ROLE_USER
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
}
