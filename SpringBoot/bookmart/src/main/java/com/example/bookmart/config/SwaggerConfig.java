package com.example.bookmart.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI bookMartOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("📚 BookMart API")
                        .description("API documentation for the BookMart application")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("BookMart Support")
                                .url("https://example.com")
                                .email("support@example.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("Project GitHub Repository")
                        .url("https://github.com/your-repo/bookmart"));
    }
}
