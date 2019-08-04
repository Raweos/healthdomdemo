package com.healthdom.HealthdomDemo.employee.infrastructure.persistence


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class EmployeeFixture {
    @Autowired
    private EmployeeMongoDao employeeDao

    void clearEmployees() {
        employeeDao.deleteAll()
    }
}
