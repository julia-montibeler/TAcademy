package com.tacademy.orders.controllers;

import com.tacademy.orders.models.Order;
import com.tacademy.orders.repositories.OrderRepository;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping
    public List<Order> getOrder(
            @RequestParam(value = "order_number", required = false) Long orderNumber,
            @RequestParam(value = "customer_name", required = false) String customerName,
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "min_amount", required = false) BigDecimal minAmount,
            @RequestParam(value = "max_amount", required = false) BigDecimal maxAmount,
            @RequestParam(value = "start_date", required = false) LocalDate startDate,
            @RequestParam(value = "end_date", required = false) LocalDate endDate
    ) {
        Specification<Order> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (orderNumber != null) {
                predicates.add(criteriaBuilder.equal(root.get("orderNumber"), orderNumber));
            }
            if (customerName != null) {
                predicates.add(criteriaBuilder.equal(root.get("customerName"), customerName));
            }
            if (status != null) {
                predicates.add(criteriaBuilder.equal(root.get("status"), status));
            }
            if (minAmount != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("totalAmount"), minAmount));
            }
            if (maxAmount != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("totalAmount"), maxAmount));
            }
            if (startDate != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("orderDate"), startDate));
            }
            if (endDate != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("orderDate"), endDate));
            }
            return  criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        return orderRepository.findAll(spec);
    }
}
