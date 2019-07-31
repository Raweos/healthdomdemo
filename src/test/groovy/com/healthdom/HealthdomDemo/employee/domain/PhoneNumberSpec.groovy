package com.healthdom.HealthdomDemo.employee.domain

import org.springframework.http.HttpStatus
import spock.lang.Specification


class PhoneNumberSpec extends Specification {

    def "Should create correct number"() {
        when: "Creating number"
            def number = PhoneNumber.createUSNumber(numberString)
        then: "Number is not null"
            number != null
        where:
            numberString << ["5417543010", "2025550183", "2025550160"]
    }

    def "Should throw exception when creating wrong number"() {
        when: "Creating number"
            PhoneNumber.createUSNumber(numberString)
        then: "Exception is thrown"
            InvalidPhoneNumberException invalidPhoneNumberException = thrown()
            invalidPhoneNumberException.errorCode == HttpStatus.NOT_ACCEPTABLE.value()
        where:
            numberString << ["123-456-7890", "12345678901", "123456789"]
    }
}
