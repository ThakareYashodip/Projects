package com.yash.Product.controller;

import com.yash.Product.dto.CategoryDTO;
import com.yash.Product.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
@Tag(
        name = "Creating Category",
        description = "Handles product operations"
)
public class CategoryController {

    private CategoryService categoryService;

    //get categories
    @GetMapping
    @Operation(
            summary = "Get all categories"
    )
    public List<CategoryDTO> getAllCatefories(){
       return categoryService.getAllCategories();
    }
    //create categories
    @PostMapping
    @Operation(
            summary = "Create Category"
    )
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
        return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }

    //get category by id
    @GetMapping("/{id}")
    @Operation(
            summary = "Fetch category by id"
    )
    public CategoryDTO getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    // delete category by id
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete category by id"
    )
    public void deleteCategory(@PathVariable long id){
        categoryService.deleteCategory(id);
    }
}
