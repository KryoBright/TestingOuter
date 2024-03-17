package com.example.test.test.services;

import com.example.test.test.responses.accepted.FilterAndSorting;
import com.example.test.test.responses.accepted.PeriodWithIds;

public interface PeriodService
{
    Object createPeriod(PeriodWithIds period, String administratorId);

    Object findPeriod(String id);

    Object findPeriods(FilterAndSorting filterAndSorting);
}
