package com.example.test.test.services.impls;

import com.example.test.test.models.entities.Employee;
import com.example.test.test.models.entities.Period;
import com.example.test.test.repositories.EmployeeRepository;
import com.example.test.test.services.EmployeeService;
import org.instancio.Instancio;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceImplTest {

    private EmployeeService service;
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        employeeRepository = mock(EmployeeRepository.class);
        service = new EmployeeServiceImpl(
                employeeRepository
        );
    }

    @Test
    void createEmployee() {
    }

    @Test
    void findEmployee() {
        //Дано
        when(employeeRepository.findById("test_id")).thenReturn(Optional.of(
                Instancio.create(Employee.class)
        ));
        //Когда
        var actual = service.findEmployee("test_id");
        //Тогда
        verify(employeeRepository, atLeastOnce()).findById("test_id");
        System.out.println(actual);
    }

    @Test
    void findAllEmployees() {
    }
}