package com.healthdom.HealthdomDemo.employee.infrastructure;

import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.healthdom.HealthdomDemo.employee.domain.Employee;
import com.healthdom.HealthdomDemo.employee.domain.EmployeeNotFoundException;
import com.healthdom.HealthdomDemo.employee.domain.EmployeeRepository;
import com.healthdom.HealthdomDemo.employee.domain.PhoneNumber;
import com.healthdom.HealthdomDemo.employee.domain.PhoneNumberType;

import static java.util.stream.Collectors.toList;

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

    @Override
    public List<Employee> findAll() {
        return employeeMongoDao.findAll().stream().map(this::mapToEmployee).collect(toList());
    }

    @Override
    public void update(Employee employeeToUpdate) {
        EmployeeEntity oldEmployee = employeeMongoDao.findByPhoneNumber(employeeToUpdate.getPhoneNumber()
                                                                                        .stringValue());
        EmployeeEntity employeeEntity = mapToEntity(employeeToUpdate);
        if(Objects.isNull(oldEmployee)) {
            throw new EmployeeNotFoundException("Cannot update employee, it does not exist",
                    HttpStatus.NOT_FOUND.value());
        }
        Objects.requireNonNull(employeeEntity).setId(oldEmployee.getId());
        employeeMongoDao.save(employeeEntity);
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
        return new Employee(employeeEntity.getFirstName(), employeeEntity.getLastName(),
                PhoneNumber.createUSNumber(employeeEntity.getPhoneNumber()));
    }


}
