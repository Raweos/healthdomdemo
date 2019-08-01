package com.healthdom.HealthdomDemo.employee.domain;

class EmployeeNotFoundException extends EmployeeException {

    EmployeeNotFoundException(String message, int errorCode) {
        super(message, errorCode);
    }
}
