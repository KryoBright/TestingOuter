package com.example.test.test.impls;

import com.example.test.test.entities.Period;
import com.example.test.test.entities.Schedule;
import com.example.test.test.exception.ErrorResponse;
import com.example.test.test.repositories.PeriodRepository;
import com.example.test.test.repositories.ScheduleRepository;
import com.example.test.test.responses.*;
import com.example.test.test.services.ScheduleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final PeriodRepository periodRepository;
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
    public Object findSchedule(String id, String name)
    {
        Schedule schedule = null;
        Schedule schedule1 = null;

        if (id != null)
        {
            schedule = scheduleRepository.findById(id).orElse(null);
        }

        if (name != null)
        {
            schedule1 = scheduleRepository.findByScheduleName(name).orElse(null);
        }

        if (schedule != schedule1 && name != null && id != null)
        {
            ErrorResponse errorResponse = ErrorResponse
                    .builder()
                    .timestamp(ZonedDateTime.now())
                    .status(400)
                    .error("Bad Request")
                    .message("Расписание с таким именем не совпадает с расписанием с таким идентификатором")
                    .path("/schedule")
                    .build();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
        else if (schedule != null)
        {
            List<Period> periodList = periodRepository.findBySchedule(schedule, Sort.by(Sort.Direction.ASC, "slot.beginTime"));

            return ScheduleWithPeriods
                    .builder()
                    .scheduleName(schedule
                            .getScheduleName())
                    .creationDate(schedule
                            .getCreationDate())
                    .periodList(periodList.stream()
                            .map(period -> {
                                String executorId = period.getExecutor() != null ? period.getExecutor().getId() : null;
                                return PeriodWithMinimumInfo
                                        .builder()
                                        .scheduleId(period.getSchedule()
                                                .getId())
                                        .slotType(period
                                                .getSlotType())
                                        .executorId(executorId)
                                        .administratorId(period
                                                .getAdministrator()
                                                .getId())
                                        .id(period
                                                .getId())
                                        .build();})
                            .collect(Collectors
                                    .toList()))
                    .build();
        }
        else if (schedule1 != null)
        {
            List<Period> periodList = periodRepository.findBySchedule(schedule1, Sort.by(Sort.Direction.ASC, "slot.beginTime"));
            return ScheduleWithPeriods
                    .builder()
                    .scheduleName(schedule1
                            .getScheduleName())
                    .creationDate(schedule1
                            .getCreationDate())
                    .periodList(periodList.stream()
                            .map(period -> {
                                String executorId = period.getExecutor() != null ? period.getExecutor().getId() : null;
                                return PeriodWithMinimumInfo
                                        .builder()
                                        .scheduleId(period.getSchedule()
                                                .getId())
                                        .slotType(period
                                                .getSlotType())
                                        .executorId(executorId)
                                        .administratorId(period
                                                .getAdministrator()
                                                .getId())
                                        .id(period
                                                .getId())
                                        .build();})
                            .collect(Collectors
                                    .toList()))
                    .build();
        }
        else if (schedule == null && schedule1 == null && name != null && id != null)
        {
            ErrorResponse errorResponse = ErrorResponse
                    .builder()
                    .timestamp(ZonedDateTime.now())
                    .status(404)
                    .error("Not Found")
                    .message("Расписание с таким идентификаторомо или с таким именем не найдено")
                    .path("/schedule")
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);

        }
        else if (schedule == null && schedule1 == null)
        {
            ErrorResponse errorResponse = ErrorResponse
                    .builder()
                    .timestamp(ZonedDateTime.now())
                    .status(400)
                    .error("Bad Request")
                    .message("Вы не указали не имени, ни идентификатора")
                    .path("/schedule")
                    .build();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
        else if (schedule == null)
        {
            ErrorResponse errorResponse = ErrorResponse
                    .builder()
                    .timestamp(ZonedDateTime.now())
                    .status(404)
                    .error("Not Found")
                    .message("Расписание с таким идентификатором не найдено")
                    .path("/schedule")
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        else
        {
            ErrorResponse errorResponse = ErrorResponse
                    .builder()
                    .timestamp(ZonedDateTime.now())
                    .status(404)
                    .error("Not Found")
                    .message("Расписание с таким именем не найдено")
                    .path("/schedule")
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @Override
    public List<Schedule> findAllSchedules() {
        return scheduleRepository.findAll();
    }
}
