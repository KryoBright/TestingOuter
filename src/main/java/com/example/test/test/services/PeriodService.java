package com.example.test.test.services;

import com.example.test.test.entities.Employee;
import com.example.test.test.entities.Period;
import com.example.test.test.responses.Id;
import com.example.test.test.responses.PeriodWithIds;

public interface PeriodService
{
    Object createPeriod(PeriodWithIds period, String administratorId);
}
