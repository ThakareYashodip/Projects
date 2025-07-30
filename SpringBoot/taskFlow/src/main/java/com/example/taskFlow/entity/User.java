package com.example.taskFlow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Username",nullable = false)
    private String username;

    @Column(name = "Email",nullable = false)
    private String email;

    @Column(nullable = false,name = "Pass")
    private String password;


    private String Role;

}
