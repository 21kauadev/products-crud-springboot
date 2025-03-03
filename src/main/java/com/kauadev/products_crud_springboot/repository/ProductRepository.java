package com.kauadev.products_crud_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kauadev.products_crud_springboot.domain.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
