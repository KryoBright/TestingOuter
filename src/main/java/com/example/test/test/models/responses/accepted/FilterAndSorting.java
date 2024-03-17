package com.example.test.test.models.responses.accepted;

import com.example.test.test.models.responses.supporting.Filter;
import com.example.test.test.models.responses.supporting.Sort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
public class FilterAndSorting
{
    private Filter filter;
    private Sort sort;
    private Integer page;
    private Integer size;
}
