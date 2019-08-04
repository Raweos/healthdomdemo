package com.healthdom.healthdomdemo.employee.infrastructure.persistence;

import com.healthdom.healthdomdemo.employee.domain.Employee;
import com.healthdom.healthdomdemo.employee.domain.EmployeeRepository;
import com.healthdom.healthdomdemo.employee.domain.PhoneNumber;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Component
class EmployeeDao implements EmployeeRepository {

    private final EmployeeMongoDao employeeMongoDao;

    EmployeeDao(EmployeeMongoDao employeeMongoDao) {
        this.employeeMongoDao = employeeMongoDao;
    }

    @Override
    public Employee findById(String id) {
        return mapToEmployee(employeeMongoDao.findById(id).orElse(null));
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
    public void deleteEmployee(String id) {
        employeeMongoDao.deleteById(id);
    }

    private EmployeeEntity mapToEntity(Employee employee) {
        if (Objects.isNull(employee)) {
            return null;
        }
        return new EmployeeEntity(employee.getId().toString(), employee.getFirstName(), employee.getLastName(),
                employee.getPhoneNumber().stringValue());
    }

    private Employee mapToEmployee(EmployeeEntity employeeEntity) {
        if (Objects.isNull(employeeEntity)) {
            return null;
        }
        return new Employee(UUID.fromString(employeeEntity.getId()), employeeEntity.getFirstName(),
                employeeEntity.getLastName(), PhoneNumber.createUSNumber(employeeEntity.getPhoneNumber()));
    }


}
