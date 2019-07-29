package com.healthdom.HealthdomDemo.employee.infrastructure;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.healthdom.HealthdomDemo.employee.domain.Employee;
import com.healthdom.HealthdomDemo.employee.domain.EmployeeRepository;
import com.healthdom.HealthdomDemo.employee.domain.PhoneNumber;
import com.healthdom.HealthdomDemo.employee.domain.PhoneNumberType;

@Component
class EmployeeDao implements EmployeeRepository {

    private final EmployeeMongoDao employeeMongoDao;

    EmployeeDao(EmployeeMongoDao employeeMongoDao) {
        this.employeeMongoDao = employeeMongoDao;
    }

    @Override
    public Employee findByPhoneNumber(PhoneNumber phoneNumber) {
        return mapToEmployee(employeeMongoDao.findByPhoneNumber(phoneNumber.stringValue()));
    }

    @Override
    public void save(Employee employee) {
        employeeMongoDao.save(mapToEntity(employee));
    }

    private EmployeeEntity mapToEntity(Employee employee) {
        if(Objects.isNull(employee)) {
            return null;
        }
        return new EmployeeEntity(employee.getFirstName(), employee.getLastName(),
                employee.getPhoneNumber().stringValue());
    }

    private Employee mapToEmployee(EmployeeEntity employeeEntity) {
        if(Objects.isNull(employeeEntity)) {
            return null;
        }
        return new Employee(employeeEntity.getFirstName(), employeeEntity.getLastName(), new PhoneNumber(PhoneNumberType.US,
                employeeEntity.getPhoneNumber()));
    }


}
