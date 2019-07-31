package com.healthdom.HealthdomDemo.employee.infrastructure.persistence;

import lombok.Value;

@Value
public class EmployeeDto {

    private final String firstName;
    private final String lastName;
    private final String phoneNumber;

}
