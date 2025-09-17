package com.example.bookmart.service;

import com.example.bookmart.entity.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    Author createAuthor(Author author);
    Author getAuthorById(Long id);
    List<Author> getAllAuthors();
    Author updateAuthor(Long id, Author author);
    void deleteAuthor(Long id);

    // Custom queries
    List<Author> searchByName(String name);
    List<Author> findByNationality(String nationality);
}
