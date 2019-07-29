package com.healthdom.HealthdomDemo.employee.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;

interface EmployeeMongoDao extends MongoRepository<EmployeeEntity, Long> {
    EmployeeEntity findByPhoneNumber(String phoneNumber);
}
