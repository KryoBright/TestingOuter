package com.example.test.test.repositories;

import com.example.test.test.entities.Period;
import com.example.test.test.enums.SlotType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.ZonedDateTime;

public interface PeriodPageRepository extends PagingAndSortingRepository<Period, String>
{
    Page<Period> findAllById(String id, Pageable pageable);
    Page<Period> findAllBySlotType(SlotType slotType, Pageable pageable);

    Page<Period> findAllBySlotId(String slotId, Pageable pageable);
    Page<Period> findAllByScheduleId(String scheduleId, Pageable pageable);

    Page<Period> findAllByAdministratorId(String administratorId, Pageable pageable);

    Page<Period> findAllByExecutorId(String executorId, Pageable pageable);

    Page<Period> findAllBySlotBeginTime(ZonedDateTime beginTime, Pageable pageable);

    Page<Period> findAllBySlotEndTime(ZonedDateTime endTime, Pageable pageable);


}
