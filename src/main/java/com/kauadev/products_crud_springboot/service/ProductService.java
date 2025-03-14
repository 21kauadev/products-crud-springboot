package com.kauadev.products_crud_springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kauadev.products_crud_springboot.domain.entities.Product;
import com.kauadev.products_crud_springboot.exception.ProductNotFoundException;
import com.kauadev.products_crud_springboot.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findProducts() {
        return this.productRepository.findAll();
    }

    public Optional<Product> findProductById(Integer id) {

        Optional<Product> product = this.productRepository.findById(id);

        if (!product.isPresent())
            throw new ProductNotFoundException();

        return product;
    }

    public Product createProduct(Product newProduct) {
        return this.productRepository.save(newProduct);
    }

    public Product updateProduct(Integer id, Product updatedProduct) {
        Optional<Product> product = this.productRepository.findById(id);

        if (!product.isPresent())
            throw new ProductNotFoundException();

        System.out.println("get name: " + updatedProduct);

        product.get().setName(updatedProduct.getName());
        product.get().setPrice(updatedProduct.getPrice());
        product.get().setDescription(updatedProduct.getDescription());
        product.get().setQuantity(updatedProduct.getQuantity());

        return this.productRepository.save(product.get());
    }

    public ResponseEntity<String> deleteProduct(Integer id) {
        Optional<Product> product = this.productRepository.findById(id);

        if (!product.isPresent())
            throw new ProductNotFoundException();

        this.productRepository.delete(product.get());
        return ResponseEntity.ok().body("Product deleted.");
    }

}
