package com.pharmacy.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /* Constraint Violation Exception (1L)*/
    @ExceptionHandler(DataIntegrityViolationException.class)
    public final ResponseEntity<Object> handleSQLIntegrityConstraintViolationException(DataIntegrityViolationException ex){
        CustomErrorDetails details = new CustomErrorDetails(1L , "Entity Already Exist" ,
                HttpStatus.BAD_REQUEST , ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(details , HttpStatus.BAD_REQUEST);
    }

    /* Nothing Found Exception (2L)*/
    @ExceptionHandler(NothingFoundException.class)
    public final ResponseEntity<Object> handleNothingFoundException(NothingFoundException ex){
        CustomErrorDetails details = new CustomErrorDetails(2L , ex.getMessage() ,
                HttpStatus.NOT_FOUND , ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(details , HttpStatus.NOT_FOUND);
    }
}
