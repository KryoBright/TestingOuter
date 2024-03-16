package com.example.test.test.responses;

import com.example.test.test.entities.ScheduleTemplate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
public class SlotWithoutId
{
    private ScheduleTemplate scheduleTemplate;
    private ZonedDateTime beginTime;
    private ZonedDateTime endTime;
}
