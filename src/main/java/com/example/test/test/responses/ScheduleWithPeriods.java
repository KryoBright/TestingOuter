package com.example.test.test.responses;

import com.example.test.test.entities.Period;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;
import java.util.List;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
public class ScheduleWithPeriods
{
    private String scheduleName;
    @NonNull
    private Date creationDate;

    private List<PeriodWithMinimumInfo> periodList;
}
