package com.example.taskFlow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http.
                authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/tasks/all").permitAll()
                        .requestMatchers("/api/tasks/**").hasAnyRole("User","Admin")
                        .anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable());
        return http.build();
    }

    @Bean
    public UserDetailsService users(){
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("User")
                .password("User@123")
                .roles("User")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("Admin")
                .password("Admin@123")
                .roles("Admin")
                .build();

        return new InMemoryUserDetailsManager(user,admin
        );
    }
}
