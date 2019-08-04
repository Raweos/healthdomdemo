package com.healthdom.healthdomdemo.employee.infrastructure.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
class EmployeeEntity {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

}
