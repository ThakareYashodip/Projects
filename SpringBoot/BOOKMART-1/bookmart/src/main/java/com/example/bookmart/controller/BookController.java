package com.example.bookmart.controller;

import com.example.bookmart.entity.Book;
import com.example.bookmart.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // ✅ Create
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.createBook(book));
    }

    // ✅ Read one
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    // ✅ Read all
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    // ✅ Update
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }

    // ✅ Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ Custom Queries

    // Search by title
    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchByTitle(@RequestParam String title) {
        return ResponseEntity.ok(bookService.searchByTitle(title));
    }

    // Find by genre
    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Book>> findByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(bookService.findByGenre(genre));
    }

    // Find by price range
    @GetMapping("/price")
    public ResponseEntity<List<Book>> findByPriceRange(@RequestParam Double min, @RequestParam Double max) {
        return ResponseEntity.ok(bookService.findByPriceRange(min, max));
    }

    // Find by rating
    @GetMapping("/rating")
    public ResponseEntity<List<Book>> findByRatingAbove(@RequestParam Double rating) {
        return ResponseEntity.ok(bookService.findByRatingAbove(rating));
    }
}
