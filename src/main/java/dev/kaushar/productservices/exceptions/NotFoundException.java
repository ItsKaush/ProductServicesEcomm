package dev.kaushar.productservices.exceptions;

import lombok.experimental.StandardException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@StandardException
public class NotFoundException extends Exception{
    public  NotFoundException(String message){
        super(message);
    }

}
