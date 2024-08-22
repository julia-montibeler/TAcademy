package com.example.posts.post_params.respositories;

import com.example.posts.post_params.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    List<Product> findByCategoryIgnoreCase (String category);
    List<Product> findByPriceBetween (Double minPrice, Double maxPrice);
    List<Product> findByNameContainingIgnoreCase (String name);
}
