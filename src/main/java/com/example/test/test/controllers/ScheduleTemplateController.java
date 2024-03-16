package com.example.test.test.controllers;

import com.example.test.test.entities.ScheduleTemplate;
import com.example.test.test.responses.Id;
import com.example.test.test.services.ScheduleTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/scheduleTemplate")
public class ScheduleTemplateController
{
    private final ScheduleTemplateService scheduleTemplateService;

    @PostMapping
    public ResponseEntity<Id> createScheduleTemplate()
    {
        return ResponseEntity.ok(scheduleTemplateService.createScheduleTemplate());
    }

    @GetMapping("/{id}")
    public Object readScheduleTemplate(
            @PathVariable String id
    )
    {
        return scheduleTemplateService.findScheduleTemplate(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ScheduleTemplate>> readScheduleTemplates()
    {
        return ResponseEntity.ok(scheduleTemplateService.findAllScheduleTemplates());
    }

}
