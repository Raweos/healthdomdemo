package com.healthdom.HealthdomDemo.employee.domain;

public interface EmployeeRepository {
    Employee findByPhoneNumber(PhoneNumber phoneNumber);
    void save(Employee employee);
}
