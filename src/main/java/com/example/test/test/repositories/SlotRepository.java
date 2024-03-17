package com.example.test.test.repositories;

import com.example.test.test.models.entities.ScheduleTemplate;
import com.example.test.test.models.entities.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SlotRepository extends JpaRepository<Slot, String>
{
    List<Slot> findByScheduleTemplate(ScheduleTemplate scheduleTemplate);
}
