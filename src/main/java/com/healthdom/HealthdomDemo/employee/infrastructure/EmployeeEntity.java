package com.healthdom.HealthdomDemo.employee.infrastructure;

import org.springframework.data.annotation.Id;

import lombok.Getter;

@Getter
class EmployeeEntity {

    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    EmployeeEntity(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
}
