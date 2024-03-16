package com.example.test.test.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
public class ScheduleWithoutId
{
    private String scheduleName;
    @NonNull
    private Date creationDate;
}
