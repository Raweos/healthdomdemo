package com.healthdom.HealthdomDemo.employee.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmployeeDto {

    private final String firstName;
    private final String lastName;
    private final String phoneNumber;

}
