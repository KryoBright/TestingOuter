package com.example.test.test.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.ZonedDateTime;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
public class SlotWithMinimumInfo
{
    @NonNull
    String id;

    @NonNull
    private ZonedDateTime beginTime;
    @NonNull
    private ZonedDateTime endTime;


}
