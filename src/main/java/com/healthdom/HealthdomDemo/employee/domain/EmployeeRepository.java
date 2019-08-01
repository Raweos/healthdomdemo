package com.healthdom.HealthdomDemo.employee.domain;

import java.util.List;

public interface EmployeeRepository {
    Employee findById(String id);

    void save(Employee employee);

    List<Employee> findAll();

    void deleteEmployee(String id);
}
