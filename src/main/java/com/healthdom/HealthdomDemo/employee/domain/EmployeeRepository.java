package com.healthdom.HealthdomDemo.employee.domain;

import java.util.List;

public interface EmployeeRepository {
    Employee findByPhoneNumber(PhoneNumber phoneNumber);
    void save(Employee employee);

    List<Employee> findAll();

    void update(Employee employeeToUpdate);
}
