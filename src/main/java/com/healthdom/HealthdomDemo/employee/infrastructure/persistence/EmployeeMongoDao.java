package com.healthdom.HealthdomDemo.employee.infrastructure.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

interface EmployeeMongoDao extends MongoRepository<EmployeeEntity, String> {

}
