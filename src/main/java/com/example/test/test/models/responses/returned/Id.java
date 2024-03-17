package com.example.test.test.models.responses.returned;

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
