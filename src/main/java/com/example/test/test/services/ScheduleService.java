package com.example.test.test.services;

import com.example.test.test.models.entities.Schedule;
import com.example.test.test.models.responses.returned.Id;

import java.util.List;

public interface ScheduleService
{
    Id createSchedule(Schedule schedule);

    Object findSchedule(String id, String name);

    List<Schedule> findAllSchedules();
}
