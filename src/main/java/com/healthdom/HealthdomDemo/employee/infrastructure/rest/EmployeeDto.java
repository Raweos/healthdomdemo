package com.healthdom.HealthdomDemo.employee.infrastructure.rest;

import lombok.Value;

@Value
public class EmployeeDto {

    private String id;
    private EmployeeDetailsDto employeeDetailsDto;

    public EmployeeDto(String id, String firstName, String lastName, String phoneNumber) {
        this.id = id;
        this.employeeDetailsDto = new EmployeeDetailsDto(firstName, lastName, phoneNumber);
    }

}
