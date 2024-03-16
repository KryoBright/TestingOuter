package com.example.test.test.impls;

import com.example.test.test.entities.ScheduleTemplate;
import com.example.test.test.exception.ErrorResponse;
import com.example.test.test.repositories.ScheduleTemplateRepository;
import com.example.test.test.responses.Id;
import com.example.test.test.responses.ScheduleTemplateWithoutId;
import com.example.test.test.services.ScheduleTemplateService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class ScheduleTemplateServiceImpl implements ScheduleTemplateService {

    private final ScheduleTemplateRepository scheduleTemplateRepository;
    @Override
    public Id createScheduleTemplate() {
        ScheduleTemplate scheduleTemplate = ScheduleTemplate.builder().build();
        scheduleTemplateRepository.save(scheduleTemplate);
        return Id.builder().id(scheduleTemplate.getId()).build();
    }

    @Override
    public Object findScheduleTemplate(String id) {
        ScheduleTemplate scheduleTemplate = scheduleTemplateRepository.findById(id).orElse(null);

        if (scheduleTemplate != null)
        {
            return ScheduleTemplateWithoutId
                    .builder()
                    .creationTime(scheduleTemplate
                            .getCreationDate())
                    .build();
        }
        else
        {
            ErrorResponse errorResponse = ErrorResponse
                    .builder()
                    .timestamp(ZonedDateTime.now())
                    .status(404)
                    .error("Not Found")
                    .message("Шаблон расписания с таким идентификатором не найден")
                    .path("/scheduleTemplate/" + id)
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @Override
    public List<ScheduleTemplate> findAllScheduleTemplates() {
        return scheduleTemplateRepository.findAll();
    }
}
