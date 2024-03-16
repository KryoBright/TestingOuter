package com.example.test.test.responses;

import com.example.test.test.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder(toBuilder = true)
@AllArgsConstructor
@Data
public class Employees
{
    private List<Employee> employees;
}
