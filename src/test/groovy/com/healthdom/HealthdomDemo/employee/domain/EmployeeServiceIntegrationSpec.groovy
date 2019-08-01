package com.healthdom.HealthdomDemo.employee.domain

import com.healthdom.HealthdomDemo.BaseIntegrationSpec
import com.healthdom.HealthdomDemo.employee.infrastructure.persistence.EmployeeFixture
import com.healthdom.HealthdomDemo.employee.infrastructure.rest.EmployeeDetailsDto
import com.healthdom.HealthdomDemo.employee.infrastructure.rest.EmployeeDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus

class EmployeeServiceIntegrationSpec extends BaseIntegrationSpec {
    @Autowired
    private EmployeeService employeeService
    @Autowired
    private EmployeeRepository employeeRepository
    @Autowired
    private EmployeeFixture employeeFixture

    def setup() {
        employeeFixture.clearEmployees()
    }

    def "Should save not existing employee and find him by id"() {
        given: "There is employee data"
            def employeeDto = new EmployeeDetailsDto("Stefan", "Czarnecki", "5417543011")
        when: "Save employee data"
            def createdEmployee = employeeService.createEmployee(employeeDto)
        then: "Employee is saved"
            def foundEmployee = employeeService.findById(createdEmployee.getId())
            foundEmployee.employeeDetailsDto.firstName == employeeDto.firstName
            foundEmployee.employeeDetailsDto.lastName == employeeDto.lastName
            foundEmployee.employeeDetailsDto.phoneNumber == employeeDto.phoneNumber
    }

    def "Should delete existing employee"() {
        given: "There is employee data"
            def employeeDto = new EmployeeDetailsDto("Stefan", "Czarnecki", "5417543011")
            def createdEmployee = employeeService.createEmployee(employeeDto)
        when: "Delete employee"
            employeeService.deleteEmployee(createdEmployee.getId())
            employeeService.findById(createdEmployee.getId())
        then: "Employee not found"
            EmployeeNotFoundException employeeNotFoundException = thrown()
            employeeNotFoundException.errorCode == HttpStatus.NOT_FOUND.value()
    }

    def "Should get all employees"() {
        given: "Employees are created"
            def employees = [
                    new EmployeeDetailsDto("Stefan", "Czarnecki", "5417543011"),
                    new EmployeeDetailsDto("Janek", "Tomecki", "5517543011"),
                    new EmployeeDetailsDto("Marcin", "Kasztanowski", "2417543011")
            ]
            employees.forEach({ employee -> employeeService.createEmployee(employee) })
        when: "Getting all employees"
            def allEmployees = employeeService.getAll()
        then: "There are 3 employees"
            allEmployees.size() == 3
    }

    def "Should update existing employee"() {
        given: "There is an Employee"
            def employeeDetails = new EmployeeDetailsDto("Stefan", "Czarnecki", "5417543011")
            def createdEmployee = employeeService.createEmployee(employeeDetails)
        when: "Employee is updated"
            def employeeToUpdate = new EmployeeDto(createdEmployee.getId(), "Jarek", "Makaron", employeeDetails.getPhoneNumber())
            employeeService.updateEmployee(employeeToUpdate)
        then: "Employee data was updated"
            def updatedEmployee = employeeService.findById(employeeToUpdate.getId())
            updatedEmployee.employeeDetailsDto.firstName == employeeToUpdate.employeeDetailsDto.firstName
            updatedEmployee.employeeDetailsDto.lastName == employeeToUpdate.employeeDetailsDto.lastName
    }

    def "Should throw exception when updating not existing employee"() {
        when: "Employee is updated"
            def employeeToUpdate = new EmployeeDto(UUID.randomUUID().toString(), "Maciek", "Makaron", "5417543011")
            employeeService.updateEmployee(employeeToUpdate)
        then: "Exception is thrown"
            EmployeeNotFoundException employeeNotFoundException = thrown()
            employeeNotFoundException.errorCode == HttpStatus.NOT_FOUND.value()
    }


}
