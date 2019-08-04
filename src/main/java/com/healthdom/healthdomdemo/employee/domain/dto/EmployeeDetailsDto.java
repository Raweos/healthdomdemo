package com.healthdom.healthdomdemo.employee.domain.dto;

import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class EmployeeDetailsDto {
    @NotNull
    private final String firstName;
    @NotNull
    private final String lastName;
    @NotNull
    private final String phoneNumber;
}
