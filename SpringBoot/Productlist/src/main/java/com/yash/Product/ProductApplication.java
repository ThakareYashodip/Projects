package com.yash.Product;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@OpenAPIDefinition(
		info = @Info(
				title = "Product Service REST API Documentation",
				description = "Product Service API",
				version = "v1",
				contact = @Contact(
						name = "Yashodip Raju Thakare",
						email = "ganuthakare99@gmail.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "sharepoint URL Product Service API",
				url = "example.com"
		)
)

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ProductApplication.class, args);
	}

}
