package com.example.bookmart.repository;

import com.example.bookmart.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    List<Author> findByNameContainingIgnoreCase(String name);

    List<Author> findByNationality(String name);
    // SQL: SELECT * FROM author WHERE nationality = ?

}
