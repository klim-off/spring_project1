package com.spring_first.controller;


import com.spring_first.exceptions.EmployeeNotFoundException;
import com.spring_first.model.ReturnedError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmployeeControllerAdvice {
    @ResponseBody
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ReturnedError employeeNotFound(EmployeeNotFoundException e){
        return ReturnedError.builder()
                .message(e.getMessage())
                .httpCode(HttpStatus.NOT_FOUND.value())
                .build();
    }

}
