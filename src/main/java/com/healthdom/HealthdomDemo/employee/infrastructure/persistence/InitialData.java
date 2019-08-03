package com.healthdom.HealthdomDemo.employee.infrastructure.persistence;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Service
class InitialData {

    private final EmployeeMongoDao employeeMongoDao;

    public InitialData(EmployeeMongoDao employeeMongoDao) {
        this.employeeMongoDao = employeeMongoDao;
    }

    @PostConstruct
    void init() {
        employeeMongoDao.save(new EmployeeEntity(UUID.randomUUID().toString(), "Marian", "Kasztan", "2025550167"));
        employeeMongoDao.save(new EmployeeEntity(UUID.randomUUID().toString(), "Stefan", "Markowski", "4022550464"));
        employeeMongoDao.save(new EmployeeEntity(UUID.randomUUID().toString(), "Mirosław", "Pluta", "5525540166"));
        employeeMongoDao.save(new EmployeeEntity(UUID.randomUUID().toString(), "Andrzej", "Słowacki", "4425210140"));
    }
}
