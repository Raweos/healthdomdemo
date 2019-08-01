package com.healthdom.HealthdomDemo.employee.infrastructure.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "employees")
@Setter
@AllArgsConstructor
class EmployeeEntity {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private String phoneNumber;

}
