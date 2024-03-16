package com.example.test.test.services;

import com.example.test.test.entities.Slot;
import com.example.test.test.responses.Id;
import com.example.test.test.responses.SlotWithAllIds;
import com.example.test.test.responses.SlotWithScheduleTemplateId;

import java.util.List;

public interface SlotService
{
    Object createSlot(SlotWithScheduleTemplateId slot);

    Object findSlot(String id);

    List<SlotWithAllIds> findAllSlots();
}
