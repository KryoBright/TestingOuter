package com.example.test.test.repositories;

import com.example.test.test.entities.ScheduleTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleTemplateRepository extends JpaRepository<ScheduleTemplate, String> {
}
