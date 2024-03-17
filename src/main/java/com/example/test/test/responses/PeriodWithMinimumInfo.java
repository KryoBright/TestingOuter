package com.example.test.test.responses;

import com.example.test.test.entities.Employee;
import com.example.test.test.enums.SlotType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

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

}
