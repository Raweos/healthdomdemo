package com.healthdom.HealthdomDemo.employee.domain;

class EmployeeException extends RuntimeException {

    protected final int errorCode;

    public EmployeeException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
