package com.example.test.test.services;

import com.example.test.test.models.responses.supporting.SlotWithAllIds;
import com.example.test.test.models.responses.returned.SlotWithScheduleTemplateId;

import java.util.List;

public interface SlotService
{
    Object createSlot(SlotWithScheduleTemplateId slot);

    Object findSlot(String id);

    List<SlotWithAllIds> findAllSlots();
}
