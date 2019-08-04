package com.healthdom.healthdomdemo.employee.infrastructure.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

interface EmployeeMongoDao extends MongoRepository<EmployeeEntity, String> {

}
