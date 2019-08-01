package com.healthdom.HealthdomDemo.employee.infrastructure.rest;

import lombok.Value;

@Value
public class EmployeeDetailsDto {
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;
}
