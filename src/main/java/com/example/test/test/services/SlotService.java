package com.example.test.test.services;

import com.example.test.test.responses.supporting.SlotWithAllIds;
import com.example.test.test.responses.returned.SlotWithScheduleTemplateId;

import java.util.List;

public interface SlotService
{
    Object createSlot(SlotWithScheduleTemplateId slot);

    Object findSlot(String id);

    List<SlotWithAllIds> findAllSlots();
}
