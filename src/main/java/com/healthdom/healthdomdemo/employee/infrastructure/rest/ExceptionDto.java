package com.healthdom.healthdomdemo.employee.infrastructure.rest;

import lombok.Value;

@Value
class ExceptionDto {
    private String message;
    private int code;
}
