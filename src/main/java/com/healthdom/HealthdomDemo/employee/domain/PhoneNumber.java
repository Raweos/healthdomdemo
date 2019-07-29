package com.healthdom.HealthdomDemo.employee.domain;

public class PhoneNumber {

    private final PhoneNumberType phoneNumberType;
    private final String phoneNumber;

    public PhoneNumber(PhoneNumberType phoneNumberType, String phoneNumber) {
        this.phoneNumberType = phoneNumberType;
        this.phoneNumber = phoneNumber;
    }

    public String stringValue() {
        return phoneNumber;
    }



}
