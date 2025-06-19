package com.yash.Productlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProductlistApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ProductlistApplication.class, args);
		MyComponent mc = context.getBean(MyComponent.class);

	}

}
