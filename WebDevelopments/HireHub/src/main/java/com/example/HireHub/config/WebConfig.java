// package com.example.HireHub.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.*;

// @Configuration
// public class WebConfig implements WebMvcConfigurer {

//     @Override
//     public void addCorsMappings(CorsRegistry registry) {
//         registry.addMapping("/**")
//             .allowedOrigins("http://localhost:5500", "http://127.0.0.1:5500") // or your frontend port
//             .allowedMethods("GET", "POST", "PUT", "DELETE")
//             .allowedHeaders("*")
//             .allowCredentials(true);
//     }
// }



// // @Override
// // protected void configure(HttpSecurity http) throws Exception {
// //     http
// //         .cors().and()
// //         .csrf().disable()
// //         .authorizeRequests()
// //             .antMatchers("/api/auth/**").permitAll()
// //             .anyRequest().authenticated();
// // }
