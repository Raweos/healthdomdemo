package com.healthdom.healthdomdemo.employee.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class EmployeeConfig {
    @Bean
    EmployeeService employeeCreationService(EmployeeRepository employeeRepository){
        return new EmployeeService(employeeRepository);
    }
}
