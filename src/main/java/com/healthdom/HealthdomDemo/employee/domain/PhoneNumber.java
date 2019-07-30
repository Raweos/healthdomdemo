package com.healthdom.HealthdomDemo.employee.domain;

public class PhoneNumber {

    private final PhoneNumberType phoneNumberType;
    private final String phoneNumber;

    private PhoneNumber(PhoneNumberType phoneNumberType, String phoneNumber) {
        this.phoneNumberType = phoneNumberType;
        this.phoneNumber = phoneNumber;
    }

    public String stringValue() {
        return phoneNumber;
    }

    public static PhoneNumber createUSNumber(String phoneNumber){
        return new PhoneNumber(PhoneNumberType.US, phoneNumber);
    }


}
