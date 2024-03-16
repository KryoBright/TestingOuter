package com.example.test.test.controllers;

import com.example.test.test.entities.Employee;
import com.example.test.test.exception.ErrorResponse;
import com.example.test.test.responses.Id;
import com.example.test.test.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController
{
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Id> createEmployee(
            @RequestBody Employee employee
    )
    {
        return ResponseEntity.ok(employeeService.createEmployee(employee));
    }

    @GetMapping("/{id}")
    public Object readEmployee(
            @PathVariable String id
    )
    {
        return employeeService.findEmployee(id);

    }

    @GetMapping("/all")
    public ResponseEntity<Object> readEmployees()
    {
        return ResponseEntity.ok(employeeService.findAllEmployees());
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponse
                .builder()
                .message("Не удалось создать сотрудника на основе полученных полей")
                .timestamp(ZonedDateTime.now())
                .status(400)
                .error("Bad Request")
                .path("/employee")
                .build()
        );
    }

}
