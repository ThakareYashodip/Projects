package com.example.bookmart.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(max = 150, message = "Title cannot exceed 150 characters")
    private String title;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than 0")
    private Double price;

    @NotBlank(message = "Genre is required")
    private String genre;

    @NotBlank(message = "Cover URL is required")
    @Size(max = 255, message = "Cover URL too long")
    private String coverUrl;

    @Min(value = 0, message = "Stock cannot be negative")
    private int stock;

    @DecimalMin(value = "0.0", inclusive = true, message = "Rating must be 0 or higher")
    @DecimalMax(value = "5.0", inclusive = true, message = "Rating cannot be more than 5")
    private double rating;

    @PastOrPresent(message = "Publish date cannot be in the future")
    private LocalDate publishDate;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @NotNull(message = "Author is required")
    @JsonIgnore
    private Author author;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    @NotNull(message = "Publisher is required")
    @JsonIgnore
    private Publisher publisher;

    @ManyToMany
    @JoinTable(
            name = "book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @NotEmpty(message = "At least one category is required")
    @JsonIgnore
    private List<Category> categories;
}
