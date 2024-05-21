package com.riwi.StockSync.api.error_handler;

import com.riwi.StockSync.api.dto.errors.BaseErrorResponse;
import com.riwi.StockSync.api.dto.errors.ErrorResponse;
import com.riwi.StockSync.util.exceptions.BadRequestExeption;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseErrorResponse handerBadRequest(MethodArgumentNotValidException exception){

        List<String> errors = new ArrayList<String>();

        exception.getAllErrors().forEach(error->errors.add(error.getDefaultMessage()));
        return ErrorResponse.builder()
        .code(HttpStatus.BAD_REQUEST.value())
        .status(HttpStatus.BAD_REQUEST.name())
        .errors(errors)
        .build();

    }

    @ExceptionHandler(BadRequestExeption.class)
    //esta es una exeption creada por nosotros 
    public BaseErrorResponse badRequest (BadRequestExeption exeption){
        List<String> errors = new ArrayList<String>();
        errors.add(exeption.getMessage());

        return ErrorResponse.builder()
        .code(HttpStatus.BAD_REQUEST.value())
        .status(HttpStatus.BAD_REQUEST.name())
        .errors(errors)
        .build();
    }
    
}
