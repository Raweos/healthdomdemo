package com.healthdom.HealthdomDemo.employee.domain;

import org.springframework.http.HttpStatus;

class EmployeeAlreadyExistsException extends EmployeeException {

    EmployeeAlreadyExistsException(String message) {
        super(message, HttpStatus.CONFLICT.value());
    }
}
