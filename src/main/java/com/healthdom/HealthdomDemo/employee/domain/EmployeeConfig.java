package com.healthdom.HealthdomDemo.employee.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class EmployeeConfig {
    @Bean
    EmployeeCreationService employeeCreationService(EmployeeRepository employeeRepository){
        return new EmployeeCreationService(employeeRepository);
    }
}
