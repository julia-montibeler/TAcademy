package com.example.posts.post_params.controllers;

import com.example.posts.post_params.models.Product;
import com.example.posts.post_params.services.ProductService;
import com.example.posts.post_params.services.ProductServiceSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceSpecification productService;

    @GetMapping
    public List<Product> getProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) String name
    ){
    return productService.getAllProducts(category, minPrice, maxPrice, name);
    }
}
