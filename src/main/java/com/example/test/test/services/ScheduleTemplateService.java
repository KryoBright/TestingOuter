package com.example.test.test.services;

import com.example.test.test.models.entities.ScheduleTemplate;
import com.example.test.test.models.responses.returned.Id;

import java.util.List;

public interface ScheduleTemplateService
{
    Id createScheduleTemplate();

    Object findScheduleTemplate(String id);

    List<ScheduleTemplate> findAllScheduleTemplates();
}
