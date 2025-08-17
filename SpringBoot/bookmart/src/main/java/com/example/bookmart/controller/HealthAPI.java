package com.example.bookmart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthAPI {

    @GetMapping("/health")
    public String headlthApi(){
        return "BookMart is running 😊!";
    }

}
