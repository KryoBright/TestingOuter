package com.example.test.test.services;

import com.example.test.test.entities.Employee;
import com.example.test.test.entities.Period;
import com.example.test.test.responses.FilterAndSorting;
import com.example.test.test.responses.Id;
import com.example.test.test.responses.PeriodWithIds;
import com.example.test.test.responses.PeriodsWithPageAndSize;

public interface PeriodService
{
    Object createPeriod(PeriodWithIds period, String administratorId);

    Object findPeriod(String id);

    Object findPeriods(FilterAndSorting filterAndSorting);
}
