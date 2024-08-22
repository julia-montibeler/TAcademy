package com.example.posts.post_params.specifications;

import com.example.posts.post_params.models.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecifcation {
    public static Specification<Product> hasCategory(String category){
        return ((root, query, criteriaBuilder) ->
                category == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("category")),"%" +category.toLowerCase()+ "%"));
    }

    public static Specification<Product> nameContains(String name){
        return ((root, query, criteriaBuilder) ->
                name == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),"%" + name.toLowerCase() + "%"));
    }

    public static Specification<Product> hasPriceRange(Double minPrice, Double maxPrice){
        return ((root, query, criteriaBuilder) -> {
            if(minPrice != null  && maxPrice != null) return criteriaBuilder.between(root.get("price"), minPrice, maxPrice);
            else if(minPrice != null)return criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
            else if(maxPrice != null) return criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
            else return null;
        });
    }

}
