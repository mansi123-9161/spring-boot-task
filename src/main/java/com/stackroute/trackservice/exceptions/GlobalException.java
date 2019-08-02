package com.stackroute.trackservice.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@ControllerAdvice is an annotation provided by Spring allowing you to write global code that can be applied to a wide
// range of controllers — varying from all controllers to a chosen package or even a specific annotation.
@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler{
    //@Exception handler is used for handling specific exception
    @ExceptionHandler(value=TrackAlreadyExistException.class)
    //for handling exception of track already exist
    public ResponseEntity<String> exceptionHandler(TrackAlreadyExistException e){
        return new ResponseEntity<>("error occured"+e.getMessage(), HttpStatus.CONFLICT);
    }
}
