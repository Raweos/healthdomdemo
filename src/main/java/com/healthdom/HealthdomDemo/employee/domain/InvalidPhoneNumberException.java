package com.healthdom.HealthdomDemo.employee.domain;

class InvalidPhoneNumberException extends EmployeeException {

    InvalidPhoneNumberException(String message, int errorCode) {
        super(message, errorCode);
    }
}
