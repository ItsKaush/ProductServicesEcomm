package dev.kaushar.productservices.controllers;

import dev.kaushar.productservices.dto.ErrorResponseDto;
import dev.kaushar.productservices.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDto> notFound(Exception  exception){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setErrorMessage(exception.getMessage());

        ResponseEntity<ErrorResponseDto> response = new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
        return response;
    }
}
