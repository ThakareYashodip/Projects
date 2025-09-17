package com.example.invoice_generator.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI(){

        Contact contact = new Contact();
        contact.setName("Yashodip Raju Thakare");
        contact.setEmail("ganuthakare99@gmail.com");
        contact.setUrl("www.google.com");

        return new OpenAPI()
                .info(new Info()
                        .title("Invoice Generator Api")
                        .description("Api documentation for Invoice Generator Project")
                        .version("1.0")
                        .contact(contact)
                );
    }

}
