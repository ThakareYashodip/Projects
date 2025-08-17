package com.example.bookmart.service;

import com.example.bookmart.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    Book createBook(Book book);
    Book getBookById(Long id);
    List<Book> getAllBooks();
    Book updateBook(Long id, Book book);
    void deleteBook(Long id);

    // Custom queries
    List<Book> searchByTitle(String title);
    List<Book> findByGenre(String genre);
    List<Book> findByPriceRange(Double minPrice, Double maxPrice);
    List<Book> findByRatingAbove(Double rating);
}
