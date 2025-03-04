package com.kauadev.products_crud_springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.kauadev.products_crud_springboot.domain.entities.Product;
import com.kauadev.products_crud_springboot.repository.ProductRepository;

public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findProducts() {
        return this.productRepository.findAll();
    }

    public Optional<Product> findProductById(Integer id) {
        return this.productRepository.findById(id);
    }

    public Product createProduct(Product productData) {
        return this.productRepository.save(productData);
    }
}
