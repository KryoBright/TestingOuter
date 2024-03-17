package com.example.test.test.impls;

import com.example.test.test.entities.ScheduleTemplate;
import com.example.test.test.entities.Slot;
import com.example.test.test.exception.ErrorResponse;
import com.example.test.test.repositories.ScheduleTemplateRepository;
import com.example.test.test.repositories.SlotRepository;
import com.example.test.test.responses.returned.Id;
import com.example.test.test.responses.returned.ScheduleTemplateWithoutId;
import com.example.test.test.responses.SlotWithMinimumInfo;
import com.example.test.test.services.ScheduleTemplateService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
@Service
public class ScheduleTemplateServiceImpl implements ScheduleTemplateService {

    private final ScheduleTemplateRepository scheduleTemplateRepository;
    private final SlotRepository slotRepository;
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
            List<Slot> slots = slotRepository.findByScheduleTemplate(scheduleTemplate);
            return ScheduleTemplateWithoutId
                    .builder()
                    .creationTime(scheduleTemplate
                            .getCreationDate())
                    .slotList(slots
                            .stream()
                            .map(slot -> SlotWithMinimumInfo
                                    .builder()
                                    .id(slot
                                            .getId())
                                    .beginTime(slot
                                            .getBeginTime())
                                    .endTime(slot
                                            .getEndTime())
                                    .build())
                            .collect(Collectors
                            .toList()))
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
