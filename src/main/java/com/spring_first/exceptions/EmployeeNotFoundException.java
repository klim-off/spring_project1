package com.spring_first.exceptions;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(Long id) {
        super("Employee with id " + id + " not found");
    }
}
