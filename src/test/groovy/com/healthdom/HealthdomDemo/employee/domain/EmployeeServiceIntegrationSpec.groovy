package com.healthdom.HealthdomDemo.employee.domain

import com.healthdom.HealthdomDemo.BaseIntegrationSpec
import com.healthdom.HealthdomDemo.employee.infrastructure.EmployeeDto
import com.healthdom.HealthdomDemo.employee.infrastructure.EmployeeFixture
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

    def "Should save not existing employee and find him by his phone number"() {
        given: "There is employee data"
            String phoneNumber = "15417543011"
            EmployeeDto employeeDto = new EmployeeDto("Stefan", "Czarnecki", phoneNumber)
        when: "Save employee data"
            employeeService.createEmployee(employeeDto)
        then: "Employee is saved"
            def foundEmployee = employeeService.findByPhoneNumber(phoneNumber)
            foundEmployee.firstName == employeeDto.firstName
            foundEmployee.lastName == employeeDto.lastName
    }

    def "Should get all employees"() {
        given: "Employees are created"
            def employees = [
                    new EmployeeDto("Stefan", "Czarnecki", "15417543011"),
                    new EmployeeDto("Janek", "Tomecki", "15517543011"),
                    new EmployeeDto("Marcin", "Kasztanowski", "12417543011")
            ]
            employees.forEach({ employee -> employeeService.createEmployee(employee) })
        when: "Getting all employees"
            def allEmployees = employeeService.getAll()
        then: "There are 3 employees"
            allEmployees.size() == 3
    }

    def "Should update existing employee"() {
        given: "There is an Employee"
            def employee = new EmployeeDto("Stefan", "Czarnecki", "15417543011")
            employeeService.createEmployee(employee)
        when: "Employee is updated"
            def employeeToUpdate = new EmployeeDto("Jarek", "Makaron", employee.getPhoneNumber())
            employeeService.updateEmployee(employeeToUpdate)
        then: "Employee data was updated"
            def updatedEmployee = employeeService.findByPhoneNumber(employeeToUpdate.getPhoneNumber())
            updatedEmployee.firstName == employeeToUpdate.firstName
            updatedEmployee.lastName == employeeToUpdate.lastName
    }

    def "Should throw exception when updating not existing employee"() {
        when: "Employee is updated"
            def employeeToUpdate = new EmployeeDto("Maciek", "Makaron", "15417543011")
            employeeService.updateEmployee(employeeToUpdate)
        then: "Exception is thrown"
            EmployeeNotFoundException employeeNotFoundException = thrown()
            employeeNotFoundException.errorCode == HttpStatus.NOT_FOUND.value()
    }


}
