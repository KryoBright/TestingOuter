package com.example.test.test.responses;

import com.example.test.test.entities.ScheduleTemplate;
import com.fasterxml.jackson.annotation.JsonFormat;
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
