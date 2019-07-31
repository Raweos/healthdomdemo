package com.healthdom.HealthdomDemo.employee.infrastructure.persistence


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
public class EmployeeFixture {
    @Autowired
    private EmployeeMongoDao employeeDao

    public void clearEmployees() {
        employeeDao.deleteAll()
    }
}
