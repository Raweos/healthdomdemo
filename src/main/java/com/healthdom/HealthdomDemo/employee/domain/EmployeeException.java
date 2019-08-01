package com.healthdom.HealthdomDemo.employee.domain;

public class EmployeeException extends RuntimeException {

    private final int errorCode;

    EmployeeException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
