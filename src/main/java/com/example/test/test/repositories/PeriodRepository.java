package com.example.test.test.repositories;

import com.example.test.test.entities.Period;
import com.example.test.test.entities.Schedule;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeriodRepository extends JpaRepository<Period, String>
{
    List<Period> findBySchedule(Schedule schedule, Sort sort);
}
