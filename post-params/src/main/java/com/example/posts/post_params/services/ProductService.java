package com.example.posts.post_params.services;

import com.example.posts.post_params.models.Product;
import com.example.posts.post_params.respositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(String category){
        return productRepository.findByCategoryIgnoreCase(category);
    }
    public List<Product> getProductsByPriceRange(Double minPrice, Double maxPrice){
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public List<Product> getProductsByName(String name){
        return productRepository.findByNameContainingIgnoreCase(name);
    }
    public List<Product> filterProducts(String category,Double minPrice, Double maxPrice, String name){
        List<Product> products = getAllProducts();

        if(category != null){
            products.retainAll(getProductsByCategory(category));
        }
        if(minPrice!= null && maxPrice != null){
            products.retainAll(getProductsByPriceRange(minPrice, maxPrice));
        }
        if(name != null){
            products.retainAll(getProductsByName(name));
        }
        return products;
    }

}
