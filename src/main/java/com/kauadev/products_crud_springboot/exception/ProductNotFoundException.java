package com.kauadev.products_crud_springboot.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {
        super("Produto não encontrado.");
    }

    public ProductNotFoundException(String msg) {
        super(msg);
    }
}
