package com.example.test.test.responses.returned;

import com.example.test.test.enums.Position;
import com.example.test.test.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
public class EmployeeWithoutId
{
    @NonNull
    private String employeeName;
    @NonNull
    private Status status;
    @NonNull
    private Position position;
}
