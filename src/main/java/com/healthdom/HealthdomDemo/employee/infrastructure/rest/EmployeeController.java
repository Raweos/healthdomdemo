package com.healthdom.HealthdomDemo.employee.infrastructure.rest;

import com.healthdom.HealthdomDemo.employee.domain.EmployeeException;
import com.healthdom.HealthdomDemo.employee.domain.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAll();
    }

    @GetMapping("/employees/{id}")
    public EmployeeDto getEmployeeById(@PathVariable(value = "id") String employeeId) {
        return employeeService.findById(employeeId);
    }

    @PostMapping("/employees")
    @ResponseStatus(value = HttpStatus.CREATED)
    public EmployeeDto createEmployee(@Valid @RequestBody EmployeeDetailsDto employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public EmployeeDto updateEmployee(@PathVariable(value = "id") String employeeId,
                                      @Valid @RequestBody EmployeeDetailsDto employeeDetailsDto) {

        return employeeService.updateEmployee(new EmployeeDto(employeeId, employeeDetailsDto.getFirstName(),
                employeeDetailsDto.getLastName(), employeeDetailsDto.getPhoneNumber()));
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable(value = "id") String employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

    @ExceptionHandler(value = EmployeeException.class)
    public ResponseEntity<ExceptionDto> handleError(EmployeeException exception) {
        log.error("Error occurred: " + exception.getMessage());
        return ResponseEntity.status(exception.getErrorCode()).body(new ExceptionDto(exception.getMessage(),
                exception.getErrorCode()));
    }
}
