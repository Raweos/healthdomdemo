package com.healthdom.HealthdomDemo.employee.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.http.HttpStatus;

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

    void validate(){
        Pattern pattern = Pattern.compile("[0-9]{3}[0-9]{3}[0-9]{4}$");
        Matcher matcher = pattern.matcher(phoneNumber);

        if (!matcher.matches()) {
            throw new InvalidPhoneNumberException("Wrong format of phone number", HttpStatus.NOT_ACCEPTABLE.value());
        }
    }

    public static PhoneNumber createUSNumber(String phoneNumber){
        return new PhoneNumber(PhoneNumberType.US, phoneNumber);
    }


}
