package com.example.test.test.services;

import com.example.test.test.entities.Employee;
import com.example.test.test.responses.returned.Id;

import java.util.List;

public interface EmployeeService
{
    Id createEmployee(Employee employee);

    Object findEmployee(String id);

    List<Employee> findAllEmployees();
}
