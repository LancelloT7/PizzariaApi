package com.pizzaria.java.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeExceptions {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity TratarException404(){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A entidade solicitada não foi encontrada.");

    }

}
