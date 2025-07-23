package com.example.taskFlow.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI apiConfig(){
        return new OpenAPI()
                .info(new Info()
                        .title("TaskFlow API")
                        .version("1.0")
                        .description("API documentation for the TaskFlow application"));
    }
}
