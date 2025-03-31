package com.learnwithiftekhar.jwtsecurity.service;

import com.learnwithiftekhar.jwtsecurity.model.Product;
import com.learnwithiftekhar.jwtsecurity.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    // Get all the product
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    // Get product by id
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Save/Update product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Delete product
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
