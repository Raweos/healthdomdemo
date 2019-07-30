package com.healthdom.HealthdomDemo.employee.domain;

public class EmployeeNotFoundException extends EmployeeException {

    public EmployeeNotFoundException(String message, int errorCode) {
        super(message, errorCode);
    }
}
