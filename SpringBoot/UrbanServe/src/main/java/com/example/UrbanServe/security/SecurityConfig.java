package com.example.UrbanServe.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/register").hasRole("RESIDENT")
                        .requestMatchers("/auth/login").permitAll()
                        .requestMatchers("/complaints/**").hasAnyRole("ADMIN", "RESIDENT")
                        .anyRequest().authenticated()
                )
                .httpBasic(httpBasic -> {}); // ✅ New style

        return http.build();
    }
}
