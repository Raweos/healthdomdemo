package com.healthdom.healthdomdemo.employee.domain;

import com.healthdom.healthdomdemo.employee.domain.dto.EmployeeDetailsDto;
import com.healthdom.healthdomdemo.employee.domain.dto.EmployeeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDto createEmployee(EmployeeDetailsDto employeeDetailsDto) {
        PhoneNumber phoneNumber = PhoneNumber.createUSNumber(employeeDetailsDto.getPhoneNumber());
        Employee employeeToSave = new Employee(employeeDetailsDto.getFirstName(), employeeDetailsDto.getLastName(), phoneNumber);
        employeeRepository.save(employeeToSave);
        log.info(format("Created employee with id %s", employeeToSave.getId()));
        return mapEmployeeToDto(employeeToSave);
    }

    public List<EmployeeDto> getAll() {
        return employeeRepository.findAll().stream().map(this::mapEmployeeToDto).collect(Collectors.toList());
    }

    public EmployeeDto findById(String id) {
        Employee employee = Optional.ofNullable(employeeRepository.findById(id))
                .orElseThrow(() -> new EmployeeNotFoundException("No such employee", HttpStatus.NOT_FOUND.value()));
        return mapEmployeeToDto(employee);
    }

    public void deleteEmployee(String id) {
        employeeRepository.deleteEmployee(id);
        log.info(format("Deleted employee with id %s", id));
    }

    public EmployeeDto updateEmployee(EmployeeDto employeeToUpdateDto) {
        PhoneNumber phoneNumber = PhoneNumber.createUSNumber(employeeToUpdateDto.getEmployeeDetailsDto().getPhoneNumber());
        Employee employee = Optional.ofNullable(employeeRepository.findById(employeeToUpdateDto.getId()))
                .orElseThrow(() -> new EmployeeNotFoundException("Cannot update employee, it does not exist",
                        HttpStatus.NOT_FOUND.value()));
        Employee employeeToUpdate = new Employee(employee.getId(), employeeToUpdateDto.getEmployeeDetailsDto().getFirstName(),
                employeeToUpdateDto.getEmployeeDetailsDto().getLastName(), phoneNumber);
        employeeRepository.save(employeeToUpdate);
        log.info(format("Updated employee with id %s", employeeToUpdate.getId()));
        return mapEmployeeToDto(employeeToUpdate);
    }

    private EmployeeDto mapEmployeeToDto(Employee employee) {
        return new EmployeeDto(employee.getId().toString(), employee.getFirstName(),
                employee.getLastName(), employee.getPhoneNumber().stringValue());
    }


}
