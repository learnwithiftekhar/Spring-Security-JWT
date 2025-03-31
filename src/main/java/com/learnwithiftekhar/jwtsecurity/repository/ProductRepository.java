package com.learnwithiftekhar.jwtsecurity.repository;

import com.learnwithiftekhar.jwtsecurity.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
