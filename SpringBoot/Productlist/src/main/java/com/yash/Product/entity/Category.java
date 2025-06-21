package com.yash.Product.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String name ;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Product> products;
}
