package com.healthdom.HealthdomDemo.employee.domain;

import org.springframework.http.HttpStatus;

import java.util.regex.Matcher;

public class PhoneNumber {

    private final PhoneNumberType phoneNumberType;
    private final String phoneNumber;

    private PhoneNumber(PhoneNumberType phoneNumberType, String phoneNumber) {
        this.phoneNumberType = phoneNumberType;
        this.phoneNumber = phoneNumber;
        validate();
    }

    public String stringValue() {
        return phoneNumber;
    }

    private void validate() {
        Matcher matcher = phoneNumberType.getNumberPattern().matcher(phoneNumber);
        if (!matcher.matches()) {
            throw new InvalidPhoneNumberException("Wrong format of phone number", HttpStatus.NOT_ACCEPTABLE.value());
        }
    }

    public static PhoneNumber createUSNumber(String phoneNumber) {
        return new PhoneNumber(PhoneNumberType.US, phoneNumber);
    }


}
