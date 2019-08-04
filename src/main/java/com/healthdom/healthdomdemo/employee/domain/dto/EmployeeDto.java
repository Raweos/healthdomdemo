package com.healthdom.healthdomdemo.employee.domain.dto;

import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class EmployeeDto {

    @NotNull
    private String id;
    @NotNull
    private EmployeeDetailsDto employeeDetailsDto;

    public EmployeeDto(String id, String firstName, String lastName, String phoneNumber) {
        this.id = id;
        this.employeeDetailsDto = new EmployeeDetailsDto(firstName, lastName, phoneNumber);
    }

}
