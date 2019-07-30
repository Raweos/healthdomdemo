package com.healthdom.HealthdomDemo.employee.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Value
public class EmployeeDto {

    private final String firstName;
    private final String lastName;
    private final String phoneNumber;

}
