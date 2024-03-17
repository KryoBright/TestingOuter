package com.example.test.test.responses.returned;

import com.example.test.test.responses.SlotWithMinimumInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;
import java.util.List;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
public class ScheduleTemplateWithoutId
{
    @NonNull
    private Date creationTime;

    @NonNull List<SlotWithMinimumInfo> slotList;
}
