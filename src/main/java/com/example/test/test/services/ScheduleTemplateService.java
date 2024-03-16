package com.example.test.test.services;

import com.example.test.test.entities.ScheduleTemplate;
import com.example.test.test.responses.Id;

import java.util.List;

public interface ScheduleTemplateService
{
    Id createScheduleTemplate();

    Object findScheduleTemplate(String id);

    List<ScheduleTemplate> findAllScheduleTemplates();
}
