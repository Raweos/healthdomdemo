package com.healthdom.HealthdomDemo.employee.domain;

import lombok.Getter;

import java.util.regex.Pattern;

public enum PhoneNumberType {
    US(Pattern.compile("[0-9]{3}[0-9]{3}[0-9]{4}$"));

    @Getter
    final private Pattern numberPattern;

    PhoneNumberType(Pattern numberPattern) {
        this.numberPattern = numberPattern;
    }

}
