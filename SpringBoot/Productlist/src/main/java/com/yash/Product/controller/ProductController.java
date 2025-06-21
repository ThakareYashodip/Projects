package com.yash.Product.controller;

import com.yash.Product.dto.ProductDTO;
import com.yash.Product.repository.ProductRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    //get product
    //create product
    @PostMapping
    public static ProductDTO createProducts(@RequestBody ProductDTO productDTO){

    }
    //update product
    //delete product
}
