package com.yash.Product.service;

import com.yash.Product.dto.CategoryDTO;
import com.yash.Product.entity.Category;
import com.yash.Product.mapper.CategoryMapper;
import com.yash.Product.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);
    }

    /// get all categories
    public List<CategoryDTO> getAllCategories(){
        return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
    }

    //get category by id
    public CategoryDTO getCategoryById(Long id){
        Category category =  categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found!!!"));
        return CategoryMapper.toCategoryDTO(category);
    }

    //delete category by id
    public String deleteCategory(Long id){
        categoryRepository.deleteById(id);
        return "Category is deleted";
    }
}
