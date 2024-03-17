package com.example.test.test.services.impls;

import com.example.test.test.models.entities.ScheduleTemplate;
import com.example.test.test.models.entities.Slot;
import com.example.test.test.exception.ErrorResponse;
import com.example.test.test.repositories.ScheduleTemplateRepository;
import com.example.test.test.repositories.SlotRepository;
import com.example.test.test.models.responses.returned.Id;
import com.example.test.test.models.responses.supporting.SlotWithAllIds;
import com.example.test.test.models.responses.returned.SlotWithScheduleTemplateId;
import com.example.test.test.services.SlotService;
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
public class SlotServiceImpl implements SlotService {

    private final SlotRepository slotRepository;
    private final ScheduleTemplateRepository scheduleTemplateRepository;
    @Override
    public Object createSlot(SlotWithScheduleTemplateId slot)
    {
        ScheduleTemplate scheduleTemplate = scheduleTemplateRepository.findById(slot.getScheduleTemplateId()).orElse(null);

        if (scheduleTemplate == null)
        {
            ErrorResponse errorResponse = ErrorResponse
                    .builder()
                    .timestamp(ZonedDateTime.now())
                    .status(404)
                    .error("Not Found")
                    .message("Указанный идентификатор шаблона расписания не относится к какому-либо шаблону расписания")
                    .path("/slot")
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);

        }
        else
        {
            if (slot.getBeginTime().isBefore(slot.getEndTime()))
            {
                if (isTimeSlotFree(slot))
                {
                    Slot slotNew = Slot.builder()
                            .scheduleTemplate(scheduleTemplate)
                            .beginTime(slot
                                    .getBeginTime())
                            .endTime(slot
                                    .getEndTime())
                            .build();

                    slotRepository.save(slotNew);
                    return Id.builder().id(slotNew.getId()).build();
                }
                else
                {
                    ErrorResponse errorResponse= ErrorResponse
                            .builder()
                            .timestamp(ZonedDateTime.now())
                            .status(400)
                            .error("Bad Request")
                            .message("Этот слот по времени перекрывает уже существующие")
                            .path("/slot")
                            .build();
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
                }
            }
            else
            {
                ErrorResponse errorResponse= ErrorResponse
                    .builder()
                    .timestamp(ZonedDateTime.now())
                    .status(400)
                    .error("Bad Request")
                    .message("Время начала слота не может быть после окончания слота")
                    .path("/slot")
                    .build();
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
            }
        }

    }

    private boolean isTimeSlotFree(SlotWithScheduleTemplateId newSlot)
    {
        List<Slot> slots = slotRepository.findAll();

        for (Slot slot : slots)
        {
            if (newSlot.getBeginTime().isBefore(slot.getEndTime()) || newSlot.getEndTime().isAfter(slot.getBeginTime()))
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object findSlot(String id)
    {
        Slot slot = slotRepository.findById(id).orElse(null);

        if (slot != null)
        {
            return SlotWithScheduleTemplateId
                    .builder()
                    .beginTime(slot.getBeginTime())
                    .endTime(slot.getEndTime())
                    .scheduleTemplateId(slot.getScheduleTemplate().getId())
                    .build();

        }
        else
        {
            ErrorResponse errorResponse = ErrorResponse
                    .builder()
                    .timestamp(ZonedDateTime.now())
                    .status(404)
                    .error("Not Found")
                    .message("Слот с таким идентификатором не найден")
                    .path("/scheduleTemplate/" + id)
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @Override
    public List<SlotWithAllIds> findAllSlots()
    {
        return slotRepository
                .findAll()
                .stream()
                .map(slot -> SlotWithAllIds
                        .builder()
                        .scheduleTemplateId(slot
                                .getScheduleTemplate()
                                .getId())
                        .beginTime(slot
                                .getBeginTime())
                        .endTime(slot
                                .getEndTime())
                        .id(slot
                                .getId())
                        .build())
                .collect(Collectors
                        .toList());
    }
}
