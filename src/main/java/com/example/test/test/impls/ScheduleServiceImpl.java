package com.example.test.test.impls;

import com.example.test.test.entities.Schedule;
import com.example.test.test.exception.ErrorResponse;
import com.example.test.test.repositories.ScheduleRepository;
import com.example.test.test.responses.Id;
import com.example.test.test.responses.ScheduleWithoutId;
import com.example.test.test.services.ScheduleService;
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
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    @Override
    public Id createSchedule(Schedule schedule)
    {
        if (schedule != null)
        {
            scheduleRepository.save(schedule);
            return Id.builder().id(schedule.getId()).build();
        }
        else
        {
            Schedule scheduleNew = Schedule.builder().build();
            scheduleRepository.save(scheduleNew);
            return Id.builder().id(scheduleNew.getId()).build();
        }
    }

    @Override
    public Object findSchedule(String id)
    {
        Schedule schedule = scheduleRepository.findById(id).orElse(null);

        if (schedule != null)
        {
            return ScheduleWithoutId
                    .builder()
                    .scheduleName(schedule
                            .getScheduleName())
                    .creationDate(schedule
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
                    .message("Расписание с таким идентификатором не найдено")
                    .path("/schedule/" + id)
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @Override
    public List<Schedule> findAllSchedules() {
        return scheduleRepository.findAll();
    }
}
