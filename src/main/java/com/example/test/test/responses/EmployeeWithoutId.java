package com.example.test.test.responses;

import com.example.test.test.enums.Position;
import com.example.test.test.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
public class EmployeeWithoutId
{
    private String employeeName;
    private Status status;
    private Position position;
}
