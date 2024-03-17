package com.example.test.test.models.responses.returned;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.ZonedDateTime;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
public class SlotWithScheduleTemplateId
{
    @NonNull
    private String scheduleTemplateId;
    @NonNull
    private ZonedDateTime beginTime;
    @NonNull
    private ZonedDateTime endTime;
}
