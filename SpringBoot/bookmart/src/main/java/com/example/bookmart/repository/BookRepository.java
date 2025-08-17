package com.example.bookmart.repository;

import com.example.bookmart.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findByTitleContainingIgnoreCase(String title);
    List<Book> findByGenre(String genre);
    List<Book> findByPriceBetween(Double minPrice,Double maxPrice); // SQL: SELECT * FROM book WHERE price BETWEEN ? AND ?
    List<Book> findByRatingGreaterThanEqual(Double rating);
    List<Book> findByPublishDateAfter(LocalDate date);
}
