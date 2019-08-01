package com.healthdom.HealthdomDemo.employee.infrastructure.rest;

import lombok.Value;

@Value
class ExceptionDto {
    private String message;
    private int code;
}
