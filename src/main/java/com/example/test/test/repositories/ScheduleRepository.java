package com.example.test.test.repositories;

import com.example.test.test.models.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, String>
{
    Optional<Schedule> findByScheduleName(String scheduleName);

}
