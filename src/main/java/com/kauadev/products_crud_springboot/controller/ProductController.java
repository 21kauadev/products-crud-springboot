package com.kauadev.products_crud_springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kauadev.products_crud_springboot.domain.entities.Product;
import com.kauadev.products_crud_springboot.repository.ProductRepository;

@RestController
@RequestMapping("/product") // localhost://product...
public class ProductController {

    @Autowired // -> injeção de dependencia.
    private ProductRepository productRepository;

    @GetMapping("/")
    public List<Product> products() {
        return this.productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> product(@PathVariable("id") Integer id) {
        return this.productRepository.findById(id);
    }
}
