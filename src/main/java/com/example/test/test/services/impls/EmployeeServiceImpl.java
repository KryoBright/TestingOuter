package com.example.test.test.services.impls;

import com.example.test.test.models.entities.Employee;
import com.example.test.test.exception.ErrorResponse;
import com.example.test.test.repositories.EmployeeRepository;
import com.example.test.test.models.responses.returned.EmployeeWithoutId;
import com.example.test.test.models.responses.returned.Id;
import com.example.test.test.services.EmployeeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Id createEmployee(Employee employee) {
        var newEmployee = employeeRepository.save(employee);
        return Id.builder().id(newEmployee.getId()).build();
    }

    @Override
    public Object findEmployee(String id) {
        return employeeRepository.findById(id)
                .map(employee -> EmployeeWithoutId.builder()
                        .employeeName(employee
                                .getEmployeeName())
                        .status(employee
                                .getStatus())
                        .position(employee
                                .getPosition())
                        .build())
                .map(i -> (Object)i)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse
                        .builder()
                        .timestamp(ZonedDateTime.now())
                        .status(404)
                        .error("Not Found")
                        .message("Сотрудник с таким идентификатором не найден")
                        .path("/employee/" + id).build()));
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }
}
