package com.example.bookmart.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "UserName Required !")
    @Size(min = 3,max = 50,message = "Username must be between 3 and 50 characters")
    private String name;

    @Column(length = 2000)
    private String bio;

    @Past
    private LocalDate birthDate;
    private String nationality;

    @OneToMany(mappedBy = "author" , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Book> books;

}
