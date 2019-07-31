package com.healthdom.HealthdomDemo.employee.domain;

import java.util.List;
import java.util.Objects;

import com.healthdom.HealthdomDemo.employee.infrastructure.persistence.EmployeeDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class EmployeeService {

    private final EmployeeRepository employeeRepository;

    EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    void createEmployee(EmployeeDto employeeDto) {
        PhoneNumber phoneNumber = PhoneNumber.createUSNumber(employeeDto.getPhoneNumber());
        Employee employee = employeeRepository.findByPhoneNumber(phoneNumber);
        if(!Objects.isNull(employee)) {
            throw new EmployeeAlreadyExistsException("Cannot save employee, already exists");
        }
        Employee employeeToSave = new Employee(employeeDto.getFirstName(), employeeDto.getLastName(), phoneNumber);
        employeeRepository.save(employeeToSave);
    }

    List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    Employee findByPhoneNumber(String phoneNumber) {
        return employeeRepository.findByPhoneNumber(PhoneNumber.createUSNumber(phoneNumber));
    }

    void updateEmployee(EmployeeDto employeeToUpdateDto) {
        PhoneNumber phoneNumber = PhoneNumber.createUSNumber(employeeToUpdateDto.getPhoneNumber());
        employeeRepository.update(new Employee(employeeToUpdateDto.getFirstName(),
                employeeToUpdateDto.getLastName(), phoneNumber));
    }

}
