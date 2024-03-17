package com.example.test.test.models.responses.returned;

import com.example.test.test.models.enums.SlotType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
public class PeriodWithoutIdAndMinimumInfo
{
    @NonNull
    private String slotId;
    @NonNull
    private String administratorId;
    @NonNull
    private String scheduleId;
    @NonNull
    private SlotType slotType;
    private String executorId;
}
