package com.example.test.test.responses;

import com.example.test.test.entities.Employee;
import com.example.test.test.enums.SlotType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
public class PeriodWithMinimumInfo
{
    @NonNull
    private String administratorId;
    @NonNull
    private String id;
    @NonNull
    private String scheduleId;
    @NonNull
    private SlotType slotType;
    private String executorId;

    @Builder(toBuilder = true)
    @AllArgsConstructor
    @Data
    public static class Employees
    {
        private List<Employee> employees;
    }
}
