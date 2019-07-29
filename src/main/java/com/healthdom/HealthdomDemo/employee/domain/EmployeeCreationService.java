package com.healthdom.HealthdomDemo.employee.domain;

import java.util.Objects;

import com.healthdom.HealthdomDemo.employee.infrastructure.EmployeeDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class EmployeeCreationService {

    private final EmployeeRepository employeeRepository;

    EmployeeCreationService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    void createEmployee(EmployeeDto employeeDto) {
        PhoneNumber phoneNumber = new PhoneNumber(PhoneNumberType.US, employeeDto.getPhoneNumber());
        Employee employee = employeeRepository.findByPhoneNumber(phoneNumber);
        if(!Objects.isNull(employee)) {
            throw new EmployeeAlreadyExistsException("Cannot save employee, already exists");
        }
        Employee employeeToSave = new Employee(employeeDto.getFirstName(), employeeDto.getLastName(), phoneNumber);
        employeeRepository.save(employeeToSave);
    }

}
