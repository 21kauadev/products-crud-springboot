package com.kauadev.products_crud_springboot.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

// getters e setters e construtor pra todos atributos
@Getter
@Setter
@AllArgsConstructor
// indica que é uma entity pro JPA
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement
    @EqualsAndHashCode.Include
    private Long id;

    private String name;
    private String description;
    private Double price;
    private Integer quantity;
}
