package com.example.test.test.responses.supporting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.ZonedDateTime;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
public class SlotWithAllIds
{
    @NonNull
    String id;
    @NonNull
    private String scheduleTemplateId;
    @NonNull
    private ZonedDateTime beginTime;
    @NonNull
    private ZonedDateTime endTime;

}
