package com.kauadev.products_crud_springboot.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.kauadev.products_crud_springboot.exception.ProductNotFoundException;

// annotation de controller advice
// o Spring, ao nao encontrar um tratmaento de exceçoes na aplicação, proucra por um controllerAdvice
// onde fica concentrado a lógica de tratamento de exceções de toda a aplicação.
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    // annotation pro Spring saber que aqui trata uma exceção
    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<RestErrorMessage> productNotFoundHandler(ProductNotFoundException exception) {
        RestErrorMessage treatedResponse = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(treatedResponse);
    }
}
