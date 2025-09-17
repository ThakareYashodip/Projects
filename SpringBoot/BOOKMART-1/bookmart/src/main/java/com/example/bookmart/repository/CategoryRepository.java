package com.example.bookmart.repository;

import com.example.bookmart.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByName(String name);
    List<Category> findByNameContainingIgnoreCase(String name);
    List<Category> findByDescriptionContainingIgnoreCase(String name);

}