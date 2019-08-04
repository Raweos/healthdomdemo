# Backend app
## Features 
Simple CRUD app provides REST API for Angular frontend app.
API functions:
  - Get employee by id
  - Get all employees
  - Create employee
  - Update employee
  - Delete Employee

You can test API using swagger ui. To access swagger ui, start app locally and enter url: http://localhost:8080/swagger-ui.html

## Architecture
Architecture is inspired by the domain driven design, but app is not fully complied with DDD. There is no application layer
and domain DTOs are exposed via rest api. You shouldn't do it on production :)
DDD is a little bit overkill for CRUD app as there is no much domain logic there and DDD adds overhead in a form of mapping objects between app layers.

## Tests
For test implementation Spock was used. It is very descriptive and powerful test framework(imho).
Small number of unit tests results from lack of domain logic to test.
For architecture test ArchUnit was used. 
Adding controller tests can be considered but I have decided that it would be waste of time in this case.

## Technologies
  - Java 11
  - Spring boot 2.1.5.RELEASE
  - Lombok
  - Swagger
  - MongoDB (in memory)
  - Groovy
  - Spock
  - ArchUnit

# Frontend app

## App access
http://healthdomdemo.westeurope.cloudapp.azure.com/employees

## Features 
  - Listing employees
  - Deleting employee
  - Editing employee data

## Technologies
  - Angular 8.2.0
  - Bootstrap
  - Karma 
  - Jasmine
  
## Architecture
I'm a backend guy so I'm not very familiar with frontend project architecture patterns, so architecture is as Angular generated it.

## Tests
Unit tests was written using karma and jasmine. Each component has tests in generated test file.
