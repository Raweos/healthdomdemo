package com.healthdom.HealthdomDemo.employee.domain;

class InvalidPhoneNumberException extends EmployeeException {

    public InvalidPhoneNumberException(String message, int errorCode) {
        super(message, errorCode);
    }
}
