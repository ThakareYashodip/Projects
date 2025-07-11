package com.example.UrbanServe.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                       // .requestMatchers("/auth/register").hasRole("RESIDENT")
                        .requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/complaints/**").hasAnyRole("ADMIN", "RESIDENT")
                        .anyRequest().authenticated()
                )
                .httpBasic(httpBasic -> {}); // ✅ New style

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails user = User
                .withUsername("admin")
                .password("{noop}admin123")
                .roles("ADMIN")
                .build();

        UserDetails resident = User
                .withUsername("resident")
                .password("{noop}resident123")
                .roles("RESIDENT")
                .build();

        return new InMemoryUserDetailsManager(user,resident);
    }
}
