package com.kauadev.products_crud_springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kauadev.products_crud_springboot.domain.entities.Product;
import com.kauadev.products_crud_springboot.service.ProductService;

@RestController
@RequestMapping("/product") // localhost://product...
public class ProductController {

    @Autowired // -> injeção de dependencia.
    private ProductService productService;

    // controllers dependem dos services
    // services concentram a lógica de negócios
    // repositories dizem respeito à manipulação do banco de dados, CRUD puro.

    @GetMapping("/")
    public List<Product> products() {
        return this.productService.findProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> product(@PathVariable("id") Integer id) {
        return this.productService.findProductById(id);
    }

    @PostMapping("/create")
    public Product create(@RequestBody Product product) {
        return this.productService.createProduct(product);
    }
}
