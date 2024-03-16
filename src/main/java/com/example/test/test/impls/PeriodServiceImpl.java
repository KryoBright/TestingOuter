package com.example.test.test.impls;

import com.example.test.test.entities.Employee;
import com.example.test.test.entities.Period;
import com.example.test.test.entities.Schedule;
import com.example.test.test.entities.Slot;
import com.example.test.test.exception.ErrorResponse;
import com.example.test.test.repositories.EmployeeRepository;
import com.example.test.test.repositories.PeriodRepository;
import com.example.test.test.repositories.ScheduleRepository;
import com.example.test.test.repositories.SlotRepository;
import com.example.test.test.responses.Id;
import com.example.test.test.responses.PeriodWithIds;
import com.example.test.test.services.PeriodService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Objects;

@Transactional
@RequiredArgsConstructor
@Service
public class PeriodServiceImpl implements PeriodService {

    private final PeriodRepository periodRepository;
    private final SlotRepository slotRepository;
    private final ScheduleRepository scheduleRepository;
    private final EmployeeRepository employeeRepository;
    @Override
    public Object createPeriod(PeriodWithIds period, String administratorId)
    {
        Slot slot = slotRepository.findById(period.getSlotId()).orElse(null);
        Schedule schedule = scheduleRepository.findById(period.getScheduleId()).orElse(null);
        Employee employee = employeeRepository.findById(administratorId).orElse(null);
        Employee executor = null;

        String message = "";

        if (slot == null)
        {
            message += "Слота с таким идентификатором не существует.";
        }

        if (schedule == null)
        {
            message += "Расписания с таким идентификатором не существует.";
        }

        if (employee == null)
        {
            message += "Владельца слота с таким идентификатором не существует.";
        }

        if (period.getExecutorId() != null)
        {
            executor = employeeRepository.findById(period.getExecutorId()).orElse(null);

            if (executor == null)
            {
                message += "Исполнителя слота с таким идентификатором не существует.";
            }

            if (Objects.equals(executor.getId(), administratorId))
            {
                executor = null;
            }
        }

        if (!message.isEmpty())
        {
            ErrorResponse errorResponse = ErrorResponse
                    .builder()
                    .timestamp(ZonedDateTime.now())
                    .status(400)
                    .error("Bad Request")
                    .message(message)
                    .path("/period").build();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
        else
        {
            Period periodNew = Period
                    .builder()
                    .slot(slot)
                    .schedule(schedule)
                    .slotType(period
                            .getSlotType())
                    .administrator(employee)
                    .executor(executor)
                    .build();
            periodRepository.save(periodNew);
            return Id.builder().id(periodNew.getId()).build();
        }
    }
}
