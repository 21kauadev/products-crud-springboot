package com.kauadev.products_crud_springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kauadev.products_crud_springboot.domain.entities.Product;
import com.kauadev.products_crud_springboot.repository.ProductRepository;

public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findProducts() {
        return this.productRepository.findAll();
    }
}
