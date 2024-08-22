package com.example.posts.post_params.services;

import com.example.posts.post_params.models.Product;
import com.example.posts.post_params.respositories.ProductRepository;
import com.example.posts.post_params.specifications.ProductSpecifcation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceSpecification {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(String category, Double minPrice, Double maxPrice, String name){
        Specification<Product> spec = Specification
                .where(ProductSpecifcation.hasCategory(category))
                .and(ProductSpecifcation.hasPriceRange(minPrice,maxPrice))
                .and(ProductSpecifcation.nameContains(name));

        return productRepository.findAll(spec);
    }
}
