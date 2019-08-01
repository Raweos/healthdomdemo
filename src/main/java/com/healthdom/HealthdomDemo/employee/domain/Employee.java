package com.healthdom.HealthdomDemo.employee.domain;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Employee {

    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final PhoneNumber phoneNumber;

    Employee(String firstName, String lastName, PhoneNumber phoneNumber) {
        this(UUID.randomUUID(), firstName, lastName, phoneNumber);
    }

    public Employee(UUID id, String firstName, String lastName, PhoneNumber phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
}
