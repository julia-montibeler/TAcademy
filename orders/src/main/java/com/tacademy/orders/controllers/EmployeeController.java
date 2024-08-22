package com.tacademy.orders.controllers;

import com.tacademy.orders.models.Employee;
import com.tacademy.orders.models.Order;
import com.tacademy.orders.repositories.EmployeeRepository;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getEmployee(
            @RequestParam(value = "first_name", required = false) String firstName,
            @RequestParam(value = "department", required = false) String department,
            @RequestParam(value = "active", required = false) Boolean active,
            @RequestParam(value = "min_salary", required = false) BigDecimal minSalary,
            @RequestParam(value = "hired_after", required = false) LocalDate hiredAfter,
            @RequestParam(value = "hired_before", required = false) LocalDate hiredBefore
    ) {
        Specification<Employee> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (firstName != null) {
                predicates.add(criteriaBuilder.equal(root.get("firstName"), firstName));
            }
            if (department != null) {
                predicates.add(criteriaBuilder.equal(root.get("departtment"), department));
            }
            if (active != null) {
                predicates.add(criteriaBuilder.equal(root.get("active"), active));
            }
            if (minSalary != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("salary"), minSalary));
            }
            if (hiredAfter != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("hireDate"), hiredAfter));
            }
            if (hiredBefore != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("hireDate"), hiredBefore));
            }
            return  criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        return employeeRepository.findAll(spec);
    }
}
