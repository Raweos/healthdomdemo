package com.healthdom.HealthdomDemo.employee.domain

import com.healthdom.HealthdomDemo.BaseIntegrationSpec
import com.healthdom.HealthdomDemo.employee.infrastructure.EmployeeDto
import org.springframework.beans.factory.annotation.Autowired

class EmployeeCreationServiceIntegrationSpec extends BaseIntegrationSpec {
    @Autowired
    private EmployeeCreationService employeeCreationService
    @Autowired
    private EmployeeRepository employeeRepository

    def "Should save not existing employee"() {
        given: "There is employee data"
            String phoneNumber = "15417543011"
            EmployeeDto employeeDto = new EmployeeDto("Stefan", "Czarnecki", phoneNumber)
        when: "Save employee data"
            employeeCreationService.createEmployee(employeeDto)
        then: "Employee is saved"
            def foundEmployee = employeeRepository.findByPhoneNumber(new PhoneNumber(PhoneNumberType.US, phoneNumber))
            foundEmployee.firstName == employeeDto.firstName
            foundEmployee.lastName == employeeDto.lastName
    }
}
