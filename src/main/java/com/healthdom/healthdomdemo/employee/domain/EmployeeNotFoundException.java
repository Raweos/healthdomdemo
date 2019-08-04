package com.healthdom.healthdomdemo.employee.domain;

class EmployeeNotFoundException extends EmployeeException {

    EmployeeNotFoundException(String message, int errorCode) {
        super(message, errorCode);
    }
}
