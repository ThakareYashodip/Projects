package com.yash.Productlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

public class MyComponent {

    public MyComponent(){
        System.out.println("Hello SpringBoot");
    }

    @GetMapping
    public String hello(){
        return  "Hello Yash !!!";
    }
}
