package com.kauadev.products_crud_springboot.infra;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// classe criada só pra padronizar o retorno
@Getter
@Setter
@AllArgsConstructor
public class RestErrorMessage {

    private HttpStatus status;
    private String message;

}
