package com.example.test.test.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@AllArgsConstructor
@Data
public class Id
{
    private String id;

}
