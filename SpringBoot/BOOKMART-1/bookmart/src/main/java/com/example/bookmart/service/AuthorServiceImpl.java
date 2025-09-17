package com.example.bookmart.service;

import com.example.bookmart.entity.Author;
import com.example.bookmart.repository.AuthorRepository;
import com.example.bookmart.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author updateAuthor(Long id, Author author) {
        Author existing = getAuthorById(id);
        existing.setName(author.getName());
        existing.setBio(author.getBio());
        existing.setBirthDate(author.getBirthDate());
        existing.setNationality(author.getNationality());
        return authorRepository.save(existing);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<Author> searchByName(String name) {
        return authorRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Author> findByNationality(String nationality) {
        return authorRepository.findByNationality(nationality);
    }
}
