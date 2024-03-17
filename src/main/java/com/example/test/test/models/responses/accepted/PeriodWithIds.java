package com.example.test.test.models.responses.accepted;

import com.example.test.test.models.enums.SlotType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
public class PeriodWithIds
{
    @NonNull
    private String slotId;
    @NonNull
    private String scheduleId;
    @NonNull
    private SlotType slotType;
    private String executorId;
}
