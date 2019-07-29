package com.healthdom.HealthdomDemo.employee.domain;

public class Employee {

    private final String firstName;
    private final String lastName;
    private final PhoneNumber phoneNumber;

    public Employee(String firstName, String lastName, PhoneNumber phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }


}
