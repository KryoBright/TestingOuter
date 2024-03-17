package com.example.test.test.repositories;

import com.example.test.test.entities.Period;
import com.example.test.test.entities.Schedule;
import com.example.test.test.entities.ScheduleTemplate;
import com.example.test.test.entities.Slot;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SlotRepository extends JpaRepository<Slot, String>
{
    List<Slot> findByScheduleTemplate(ScheduleTemplate scheduleTemplate);
}
