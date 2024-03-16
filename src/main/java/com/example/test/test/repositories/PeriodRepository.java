package com.example.test.test.repositories;

import com.example.test.test.entities.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodRepository extends JpaRepository<Period, String> {
}
