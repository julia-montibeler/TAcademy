package com.example.posts.post_params.services;

import com.example.posts.post_params.models.Product;
import com.example.posts.post_params.respositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductService2 {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(String category, Double minPrice, Double maxPrice, String name){
        List<Product> products = productRepository.findAll();


        if(category != null){
            products.retainAll(products.stream().filter(product -> product.getCategory().contains(category)).collect(Collectors.toList()));
        }
        if(minPrice!= null && maxPrice != null){
            products.retainAll(products.stream()
                    .filter(product -> product.getPrice() >= minPrice && product.getPrice() <= maxPrice).collect(Collectors.toList()));
        }
        if(name != null){
            products.retainAll(products.stream().filter(product -> product.getName().contains(name)).collect(Collectors.toList()));
        }
        return products;
    }
}
