package com.yash.Product.service;

import com.yash.Product.dto.ProductDTO;
import com.yash.Product.entity.Category;
import com.yash.Product.entity.Product;
import com.yash.Product.mapper.ProductMapper;
import com.yash.Product.repository.CategoryRepository;
import com.yash.Product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    public  ProductDTO createProduct(ProductDTO productDTO){
        /*
        * id, name , description , price , categoryId
        */
        Category category =  categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(
                ()->new RuntimeException("Category not found ! ")
        );
        // DTO -> Entity
        Product product = ProductMapper.toProductEntity(productDTO,category);
        product = productRepository.save(product);
        // Entity -> DTO
        return ProductMapper.toProductDTO(product);
    }

    //get all products
    public List<ProductDTO> getAllProducts(){
        return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
    }

    // get product by id
    public ProductDTO getProductById(Long id ){
        Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found !"));
        return ProductMapper.toProductDTO(product);
    }
}
